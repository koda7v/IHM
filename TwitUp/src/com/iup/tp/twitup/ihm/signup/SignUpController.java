package com.iup.tp.twitup.ihm.signup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import javax.swing.JPasswordField;

import com.iup.tp.twitup.configuration.ConstantLoader;
import com.iup.tp.twitup.core.EntityManager;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.signup.observer.ISignUpControllerObserver;
import com.iup.tp.twitup.ihm.signup.observer.ISignUpViewObserver;

public class SignUpController implements ISignUpViewObserver
{
  protected IDatabase base;

  protected SignUpModel signUpModel;

  protected List<ISignUpControllerObserver> observers;

  protected static final String KEY_ERROR_SIGN_ERROR_TITLE = "KEY_ERROR_SIGN_ERROR_TITLE";

  protected static final String KEY_SIGNUP_NAME_MESSAGE_ERROR = "KEY_SIGNUP_NAME_MESSAGE_ERROR";

  protected static final String KEY_ERROR_FORM_MESSAGE = "KEY_ERROR_FORM_MESSAGE";

  protected SignUpView signUpView;

  protected EntityManager manager;

  public SignUpController(IDatabase base, SignUpModel signUpModel, EntityManager manager)
  {
    this.base = base;
    this.signUpModel = signUpModel;
    this.observers = new ArrayList<>();
    this.manager = manager;
  }

  public User createUser()
  {
    User user = new User(UUID.randomUUID(), this.signUpModel.getTag(),
        this.signUpModel.getMdp().getPassword().toString(), this.signUpModel.getNom(), new HashSet<>(), null);
    this.manager.sendUser(user);
    return user;
  }

  public void addObserver(ISignUpControllerObserver observer)
  {
    if (observer != null)
    {
      this.observers.add(observer);
    }
  }

  public void removeObserver(ISignUpControllerObserver observer)
  {
    if (observer != null)
    {
      this.observers.remove(observer);
    }
  }

  @Override
  public void notifyCancelButton()
  {
    for (ISignUpControllerObserver currentObserver : observers)
    {
      currentObserver.notifyCancelButton();
    }

  }

  @Override
  public void notifyValidateButton(String nom, String tag, String compteUtilisateur, JPasswordField mdp)
  {
    this.signUpModel.setNom(nom);
    this.signUpModel.setTag(tag);
    this.signUpModel.setCompteUtilisateur(compteUtilisateur);
    this.signUpModel.setMdp(mdp);

    if (!this.isFormValid())
    {
      String warningTitle = ConstantLoader.getInstance().getText(KEY_ERROR_SIGN_ERROR_TITLE);
      String warningDescription = ConstantLoader.getInstance().getText(KEY_ERROR_FORM_MESSAGE);
      this.signUpView.showWarningMessage(warningTitle, warningDescription);
      return;
    }

    // Un utilisateur avec le même username est déjà présent dans l'application
    if (this.userAlreadyExist())
    {
      String warningTitle = ConstantLoader.getInstance().getText(KEY_ERROR_SIGN_ERROR_TITLE);
      String warningDescription = ConstantLoader.getInstance().getText(KEY_SIGNUP_NAME_MESSAGE_ERROR);
      this.signUpView.showWarningMessage(warningTitle, warningDescription);
      return;
    }

    this.base.addUser(this.createUser());
    this.notifySwapViewToHomeTwitt();

  }

  protected boolean isFormValid()
  {
    String name = this.signUpModel.getNom();
    String tag = this.signUpModel.getTag();
    String password = this.signUpModel.getMdp().getPassword().toString();

    String account = this.signUpModel.getCompteUtilisateur();

    return !(name.isEmpty() || tag.isEmpty() || password.isEmpty() || account.isEmpty());
  }

  protected boolean userAlreadyExist()
  {
    for (User user : base.getUsers())
    {
      if (user.getUserTag().equals(this.signUpModel.getTag()))
      {
        return true;
      }
    }

    return false;

  }

  public void notifySwapViewToHomeTwitt()
  {
    for (ISignUpControllerObserver currentObserver : observers)
    {
      currentObserver.swapViewToHomeTwitt(this.signUpModel.getTag());
    }
  }

  public void setSignUpView(SignUpView signUpView)
  {
    this.signUpView = signUpView;
  }

}
