package com.iup.tp.twitup.ihm.signIn;

import java.util.ArrayList;
import java.util.List;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;

public class SignInController implements IObserverSignView
{
  protected IDatabase base;
  protected SignInModel model;
  protected List<ISignInControllerObserver> observers;

  public SignInController(IDatabase base, SignInModel model)
  {
    this.base = base;
    this.model = model;
    this.observers = new ArrayList<ISignInControllerObserver>();
  }

  /**
   * Ajoute l'observeur en paramètre dans la liste des observeurs.
   * 
   * @param observer
   *          Observeur à ajouter.
   */
  public void addObserver(ISignInControllerObserver observer)
  {
    if (observer != null)
    {
      observers.add(observer);
    }
  }

  /**
   * Enlève l'observeur en paramètre de la liste des observeurs.
   * 
   * @param observer
   *          Observeur à enlever.
   */
  public void removeObserver(ISignInControllerObserver observer)
  {
    if (observer != null)
    {
      observers.remove(observer);
    }
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

    else
    {
      System.out.println("Mince c'est pas valide :(");
    }

  }

  @Override
  public void notifyCancelButtonPressed()
  {
    List<ISignInControllerObserver> copyObservers = new ArrayList<>(this.observers);

    for (ISignInControllerObserver observer : copyObservers)
    {
      observer.notifyCancelButtonPressed();
    }

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
