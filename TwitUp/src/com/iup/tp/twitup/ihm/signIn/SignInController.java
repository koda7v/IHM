package com.iup.tp.twitup.ihm.signIn;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;

public class SignInController implements IObserverSignView
{
  protected IDatabase base;
  protected SignInModel model;

  public SignInController(IDatabase base, SignInModel model)
  {
    this.base = base;
    this.model = model;
  }

  @Override
  public void notifyValidateButtonPressed(String pseudo, String mdp)
  {
    model.setPseudo(pseudo);
    model.setMdp(mdp);
    System.out.println("J'ai cliqué sur le bonton Valider!");
    if (formValid())
    {
      System.out.println("J'ai cliqué sur le bonton Valider et c'est valide !!!");
    }

  }

  @Override
  public void notifyCancelButtonPressed()
  {
    // TODO Auto-generated method stub

  }

  protected boolean formValid()
  {
    for (User user : base.getUsers())
    {
      if (user.getUserPassword() == model.getPseudo() || user.getUserTag() == model.getMdp())
      {
        return true;
      }
    }

    return false;
  }
}
