package com.iup.tp.twitup.ihm.signIn;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPasswordField;

import com.iup.tp.twitup.configuration.ConstantLoader;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;

public class SignInController implements IObserverSignView
{
  protected IDatabase base;
  protected SignInModel model;
  protected List<ISignInControllerObserver> observers;
  protected SignInView signInView;

  protected static final String KEY_ERROR_SIGNIN_ERROR_TITLE = "KEY_ERROR_SIGNIN_ERROR_TITLE";

  protected static final String KEY_SIGNIN_NAME_MESSAGE_ERROR = "KEY_SIGNIN_NAME_MESSAGE_ERROR";

  protected static final String KEY_ERROR_FORM_MESSAGE = "KEY_ERROR_FORM_MESSAGE";

  protected static final String KEY_FORM_BACKGROUND_COLOR = "KEY_FORM_BACKGROUND_COLOR";

  public SignInController(IDatabase base, SignInModel model, SignInView signInView)
  {
    this.signInView = signInView;
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
  public void notifyValidateButtonPressed(String pseudo, JPasswordField mdp)
  {
    model.setPseudo(pseudo);
    model.setMdp(mdp);

    if (!this.isFormValid())
    {
      String warningTitle = ConstantLoader.getInstance().getText(KEY_ERROR_SIGNIN_ERROR_TITLE);
      String warningDescription = ConstantLoader.getInstance().getText(KEY_ERROR_FORM_MESSAGE);
      this.signInView.showWarningMessage(warningTitle, warningDescription);
      return;
    }

    // Un utilisateur avec le même username est déjà présent dans l'application
    if (this.isValidUser())
    {
      String warningTitle = ConstantLoader.getInstance().getText(KEY_ERROR_SIGNIN_ERROR_TITLE);
      String warningDescription = ConstantLoader.getInstance().getText(KEY_SIGNIN_NAME_MESSAGE_ERROR);
      this.signInView.showWarningMessage(warningTitle, warningDescription);
      return;
    }
    for (ISignInControllerObserver currentObserver : observers)
    {
      currentObserver.notifyValidateButtonPressed(model.getPseudo());
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

  protected boolean isValidUser()
  {
    for (User user : base.getUsers())
    {
      if (user.getUserTag().equals(model.getPseudo()) && user.getUserPassword() == model.getMdp())
      {
        return true;
      }
    }

    return false;
  }

  protected boolean isFormValid()
  {
    String pseudo = this.model.getPseudo();
    JPasswordField password = this.model.getMdp();

    return !(pseudo.isEmpty() || password == null);
  }

}
