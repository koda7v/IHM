package com.iup.tp.twitup.ihm.signup;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.signup.observer.ISignUpControllerObserver;
import com.iup.tp.twitup.ihm.signup.observer.ISignUpViewObserver;

public class SignUpController implements ISignUpViewObserver
{
  protected IDatabase base;

  protected SignUpModel signUpModel;

  protected List<ISignUpControllerObserver> observers;

  protected SignUpView signUpView;

  public SignUpController(IDatabase base, SignUpModel signUpModel)
  {
    this.base = base;
    this.signUpModel = signUpModel;
    this.observers = new ArrayList<>();
  }

  public User createUser()
  {
    return new User(UUID.randomUUID(), this.signUpModel.getTag(), this.signUpModel.getMdp(), this.signUpModel.getNom(),
        null, null);
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
  public void notifyValidateButton(String nom, String tag, String compteUtilisateur, String mdp)
  {
    this.signUpModel.setNom(nom);
    this.signUpModel.setTag(tag);
    this.signUpModel.setCompteUtilisateur(compteUtilisateur);
    this.signUpModel.setMdp(mdp);

    if (!this.isFormValid())
    {
      // String warningTitle = LanguageLoader.getInstance().getText(KEY_ERROR_ADD_CORRESPONDENCE_TITLE);
      // String warningDescription = LanguageLoader.getInstance().getText(KEY_ERROR_ADD_CORRESPONDENCE_MESSAGE);
      String warningTitle = "Formulaire invalide";
      String warningDescription = "votre formulaire est incomplet";
      this.signUpView.showWarningMessage(warningTitle, warningDescription);
      return;
    }

    // Un utilisateur avec le même username est déjà présent dans l'application
    if (this.userAlreadyExist())
    {
      // String warningTitle = LanguageLoader.getInstance().getText(KEY_ERROR_ADD_CORRESPONDENCE_TITLE);
      // String warningDescription = LanguageLoader.getInstance()
      // .getText(KEY_CORRESPONDENCE_NAME_INVALID_EXISTING_MESSAGE);
      String warningTitle = "Utlisateur existant";
      String warningDescription = "Ce username est déjà pris";
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
    String password = this.signUpModel.getMdp();
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
