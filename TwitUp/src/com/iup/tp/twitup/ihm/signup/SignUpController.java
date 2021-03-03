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
  public void notifyValidateButton(String nom, String tag, String compteutilisateur, String mdp)
  {
    this.signUpModel.setNom(nom);
    this.signUpModel.setTag(tag);
    this.signUpModel.setCompteUtilisateur(compteutilisateur);
    this.signUpModel.setMdp(mdp);

    this.base.addUser(this.createUser());
    this.notifySwapViewToHomeTwitt();

  }

  public void notifySwapViewToHomeTwitt()
  {
    for (ISignUpControllerObserver currentObserver : observers)
    {
      currentObserver.swapViewToHomeTwitt(this.signUpModel.getTag());
    }
  }

}
