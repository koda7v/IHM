package com.iup.tp.twitup.ihm.signup;

public class SignUpComponent
{
  protected SignUpModel signUpModel;

  protected SignUpView signUpView;

  protected SignUpController signUpController;

  public SignUpComponent()
  {
    this.signUpModel = new SignUpModel();
    this.signUpView = new SignUpView();
    this.signUpController = new SignUpController();
  }

  public SignUpView getSignUpView()
  {
    return signUpView;
  }
}
