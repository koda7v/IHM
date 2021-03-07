package com.iup.tp.twitup.core;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.iup.tp.twitup.datamodel.Database;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.events.file.IWatchableDirectory;
import com.iup.tp.twitup.events.file.WatchableDirectory;
import com.iup.tp.twitup.ihm.TwitupMainView;
import com.iup.tp.twitup.ihm.TwitupMock;
import com.iup.tp.twitup.ihm.home.HomeComponent;
import com.iup.tp.twitup.ihm.home.observer.IHomeObserver;
import com.iup.tp.twitup.ihm.hometwitt.HomeTwittComponent;
import com.iup.tp.twitup.ihm.hometwitt.IHomeTwittControllerObserver;
import com.iup.tp.twitup.ihm.signIn.ISignInControllerObserver;
import com.iup.tp.twitup.ihm.signIn.SignInComponent;
import com.iup.tp.twitup.ihm.signup.SignUpComponent;
import com.iup.tp.twitup.ihm.signup.observer.ISignUpControllerObserver;
import com.iup.tp.twitup.printer.Printer;

/**
 * Classe principale l'application.
 * 
 * @author S.Lucas
 */
public class Twitup
    implements IHomeObserver, ISignInControllerObserver, ISignUpControllerObserver, IHomeTwittControllerObserver
{
  /**
   * Base de données.
   */
  protected IDatabase mDatabase;

  /**
   * Gestionnaire des entités contenu de la base de données.
   */
  protected EntityManager mEntityManager;

  /**
   * Vue principale de l'application.
   */
  protected TwitupMainView mMainView;

  /**
   * Classe de surveillance de répertoire
   */
  protected IWatchableDirectory mWatchableDirectory;

  /**
   * Répertoire d'échange de l'application.
   */
  protected String mExchangeDirectoryPath;

  /**
   * Idnique si le mode bouchoné est activé.
   */
  protected boolean mIsMockEnabled = false;

  /**
   * Nom de la classe de l'UI.
   */
  protected String mUiClassName;

  /**
   * File chooser
   */
  protected JFileChooser chooser;

  protected HomeComponent homeComponent;

  protected SignInComponent signInComponent;

  protected SignUpComponent signUpComponent;

  protected HomeTwittComponent homeTwittComponent;

  protected User userConnected;

  /**
   * Constructeur.
   */
  public Twitup()
  {
    // Init du look and feel de l'application
    this.initLookAndFeel();

    // Initialisation de la base de données
    this.initDatabase();

    if (this.mIsMockEnabled)
    {
      // Initialisation du bouchon de travail
      this.initMock();
    }

    // Initialisation de l'IHM
    this.initGui();

    // Initialisation du répertoire d'échange
    this.initDirectory();
  }

  /**
   * Initialisation du look and feel de l'application.
   */
  protected void initLookAndFeel()
  {
    try
    {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e)
    {
      // handle exception
    }
  }

  /**
   * Initialisation de l'interface graphique.
   */
  protected void initGui()
  {
    Printer printer = new Printer();
    this.mDatabase.addObserver(printer);
    this.mMainView = new TwitupMainView();
    this.showHomeComponent();
  }

  /**
   * Initialisation du répertoire d'échange (depuis la conf ou depuis un file chooser). <br/>
   * <b>Le chemin doit obligatoirement avoir été saisi et être valide avant de pouvoir utiliser l'application</b>
   */
  protected void initDirectory()
  {
    String path = this.mMainView.getDirectoryPath();
    if (path != null)
    {
      File file = new File(this.mMainView.getDirectoryPath());
      if (isValideExchangeDirectory(file))
      {
        this.initDirectory(this.mMainView.getDirectoryPath());
      }
    }
  }

  /**
   * Indique si le fichier donné est valide pour servire de répertoire d'échange
   * 
   * @param directory
   *          , Répertoire à tester.
   */
  protected boolean isValideExchangeDirectory(File directory)
  {
    // Valide si répertoire disponible en lecture et écriture
    return directory != null && directory.exists() && directory.isDirectory() && directory.canRead()
        && directory.canWrite();
  }

  /**
   * Initialisation du mode bouchoné de l'application
   */
  protected void initMock()
  {
    TwitupMock mock = new TwitupMock(this.mDatabase, this.mEntityManager);
    mock.showGUI();
  }

  /**
   * Initialisation de la base de données
   */
  protected void initDatabase()
  {
    mDatabase = new Database();
    mEntityManager = new EntityManager(mDatabase);
  }

  /**
   * Initialisation du répertoire d'échange.
   * 
   * @param directoryPath
   */
  public void initDirectory(String directoryPath)
  {
    mExchangeDirectoryPath = directoryPath;
    mWatchableDirectory = new WatchableDirectory(directoryPath);
    mEntityManager.setExchangeDirectory(directoryPath);

    mWatchableDirectory.initWatching();
    mWatchableDirectory.addObserver(mEntityManager);
  }

  protected void setUserConnected(String tag)
  {
    for (User currentUser : this.mDatabase.getUsers())
    {
      if (currentUser.getUserTag().equals(tag))
      {
        this.userConnected = currentUser;
      }
    }
  }

  public void show()
  {
    this.mMainView.showView();
  }

  public void showHomeComponent()
  {
    this.homeComponent = new HomeComponent();
    this.homeComponent.addObserver(this);
    this.mMainView.showPanel(this.homeComponent.getHomeView());
  }

  public void showSignUpViews()
  {
    this.signUpComponent = new SignUpComponent(this.mDatabase);
    this.mMainView.showPanel(this.signUpComponent.getSignUpView());
    this.signUpComponent.addSignUpControllerObserver(this);
  }

  public void showSignInViews()
  {
    this.signInComponent = new SignInComponent(this.mDatabase);
    this.mMainView.showPanel(this.signInComponent.getSignInView());
    this.signInComponent.addSignInControllerObserver(this);
  }

  public void showHomeTwittViews()
  {
    this.homeTwittComponent = new HomeTwittComponent(this.mDatabase, this.userConnected);
    this.mMainView.showPanel(this.homeTwittComponent.getHomeTwittView());
    this.homeTwittComponent.addIHomeTwittControllerObserver(this);
  }

  @Override
  public void notificationSwapView(Integer value)
  {
    // 1 : Sign up
    // 2 : Sign in
    switch (value)
    {
      case 1:
        this.showSignUpViews();
        break;
      case 2:
        this.showSignInViews();
        break;

      default:
        System.out.println("La vue ne sait pas quoi afficher");
        break;
    }

  }

  @Override
  public void notifyCancelButtonPressed()
  {
    this.showHomeComponent();

  }

  @Override
  public void notifyCancelButton()
  {
    this.showHomeComponent();

  }

  @Override
  public void swapViewToHomeTwitt(String tag)
  {
    this.setUserConnected(tag);
    this.showHomeTwittViews();

  }

  @Override
  public void logOut()
  {
    this.userConnected = null;
    this.showHomeComponent();

  }

  @Override
  public void notifyValidateButtonPressed(String tag)
  {
    this.setUserConnected(tag);
    this.showHomeTwittViews();

  }

}
