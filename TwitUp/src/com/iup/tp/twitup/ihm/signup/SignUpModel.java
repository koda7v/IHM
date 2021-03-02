package com.iup.tp.twitup.ihm.signup;

public class SignUpModel
{

  protected String nom;

  protected String tag;

  protected String compteUtilisateur;

  protected String mdp;

  public SignUpModel()
  {
    this.nom = "";
    this.tag = "";
    this.compteUtilisateur = "";
    this.mdp = "";
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

  public String getMdp()
  {
    return mdp;
  }

  public void setMdp(String mdp)
  {
    this.mdp = mdp;
  }

}
