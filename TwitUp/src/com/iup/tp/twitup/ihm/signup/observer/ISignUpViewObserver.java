package com.iup.tp.twitup.ihm.signup.observer;

import javax.swing.JPasswordField;

public interface ISignUpViewObserver
{
  public void notifyCancelButton();

  public void notifyValidateButton(String nom, String tag, String compteUtilisateur, JPasswordField mdp);
}
