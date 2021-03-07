package com.iup.tp.twitup.ihm.signIn;

import javax.swing.JPasswordField;

public interface IObserverSignView
{
  public void notifyValidateButtonPressed(String pseudo, JPasswordField mdp);

  public void notifyCancelButtonPressed();

}
