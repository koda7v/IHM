package com.iup.tp.twitup.ihm.signIn;

import javax.swing.JPasswordField;

public class SignInModel
{
  protected String pseudo;
  protected JPasswordField mdp;

  public SignInModel()
  {}

  public String getPseudo()
  {
    return pseudo;
  }

  public void setPseudo(String pseudo)
  {
    this.pseudo = pseudo;
  }

  public JPasswordField getMdp()
  {
    return mdp;
  }

  public void setMdp(JPasswordField mdp)
  {
    this.mdp = mdp;
  }

}
