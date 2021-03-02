package com.iup.tp.twitup.ihm.signup.observer;

public interface ISignUpViewObserver
{
  public void notifyCancelButton();

  public void notifyValidateButton(String nom, String tag, String compteUtilisateur, String mdp);
}
