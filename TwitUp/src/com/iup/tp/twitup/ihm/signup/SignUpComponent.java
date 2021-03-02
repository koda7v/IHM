package com.iup.tp.twitup.ihm.signup;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.ihm.signup.observer.ISignUpControllerObserver;

public class SignUpComponent
{
  protected SignUpModel signUpModel;

  protected SignUpView signUpView;

  protected SignUpController signUpController;

  public SignUpComponent(IDatabase base)
  {
    this.signUpModel = new SignUpModel();
    this.signUpView = new SignUpView();
    this.signUpController = new SignUpController(base, this.signUpModel);

    this.signUpView.addSignUpViewObserver(this.signUpController);
  }

  public void addSignUpControllerObserver(ISignUpControllerObserver observer)
  {
    this.signUpController.addObserver(observer);
  }

  public SignUpView getSignUpView()
  {
    return signUpView;
  }
}
