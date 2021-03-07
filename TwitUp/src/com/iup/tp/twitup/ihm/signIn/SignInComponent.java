package com.iup.tp.twitup.ihm.signIn;

import com.iup.tp.twitup.datamodel.IDatabase;

public class SignInComponent
{
  protected SignInModel model;
  protected SignInView view;
  protected SignInController controller;

  public SignInComponent(IDatabase mDatabase)
  {
    this.model = new SignInModel();
    this.view = new SignInView();
    this.controller = new SignInController(mDatabase, model, this.view);

    this.view.addObserver(controller);

  }

  public void addSignInControllerObserver(ISignInControllerObserver observer)
  {
    this.controller.addObserver(observer);
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
