package com.iup.tp.twitup.ihm.signup;

import javax.swing.JPasswordField;

public class SignUpModel
{

  protected String nom;

  protected String tag;

  protected String compteUtilisateur;

  protected JPasswordField mdp;

  protected String pathAvatar;

  public SignUpModel()
  {
    this.nom = "";
    this.tag = "";
    this.compteUtilisateur = "";
    this.mdp = null;
    this.pathAvatar = null;
  }

  public String getNom()
  {
    return nom;
  }

  public void setNom(String nom)
  {
    this.nom = nom;
  }

  public String getTag()
  {
    return tag;
  }

  public void setTag(String tag)
  {
    this.tag = tag;
  }

  public String getCompteUtilisateur()
  {
    return compteUtilisateur;
  }

  public void setCompteUtilisateur(String compteUtilisateur)
  {
    this.compteUtilisateur = compteUtilisateur;
  }

  public JPasswordField getMdp()
  {
    return mdp;
  }

  public void setMdp(JPasswordField mdp)
  {
    this.mdp = mdp;
  }

  public String getPathAvatar()
  {
    return pathAvatar;
  }

  public void setPathAvatar(String pathAvatar)
  {
    this.pathAvatar = pathAvatar;
  }

}
