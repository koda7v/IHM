package com.iup.tp.twitup.ihm.signIn;

public class SignInComponent
{
  protected SignInModel model;
  protected SignInView view;
  protected SignInController controller;

  public SignInComponent()
  {
    this.model = new SignInModel();
    this.view = new SignInView();
    this.controller = new SignInController();
  }

  public SignInView getSignInView()
  {
    return view;
  }

  public void setSignInView(SignInView view)
  {
    this.view = view;
  }

}
