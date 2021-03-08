package com.iup.tp.twitup.ihm.signup;

import com.iup.tp.twitup.core.EntityManager;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.ihm.signup.observer.ISignUpControllerObserver;
import com.iup.tp.twitup.ihm.widget.FileChooser.FileChooserComponent;

public class SignUpComponent
{
  protected SignUpModel signUpModel;

  protected SignUpView signUpView;

  protected SignUpController signUpController;

  protected FileChooserComponent fileChooserComponent;

  protected EntityManager manager;

  public SignUpComponent(IDatabase base, EntityManager manager)
  {
    this.manager = manager;
    this.fileChooserComponent = new FileChooserComponent();
    this.signUpModel = new SignUpModel();
    this.signUpView = new SignUpView(this.fileChooserComponent.getFileChooserView());
    this.signUpController = new SignUpController(base, this.signUpModel, this.manager);
    this.signUpController.setSignUpView(this.signUpView);
    this.signUpView.addSignUpViewObserver(this.signUpController);
    this.fileChooserComponent.addObserverModel(signUpController);
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
