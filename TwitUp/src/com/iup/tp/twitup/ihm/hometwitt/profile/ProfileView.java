package com.iup.tp.twitup.ihm.hometwitt.profile;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iup.tp.twitup.configuration.ConstantLoader;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.ImagePanel;
import com.iup.tp.twitup.ihm.hometwitt.follow.SwitchFollowButtonComponent;
import com.iup.tp.twitup.ihm.hometwitt.follow.SwitchFollowButtonModel;

/**
 * La vue du composant Profile.
 * 
 * @author EPE
 *
 */
public class ProfileView extends JPanel
{

  private static final long serialVersionUID = -955525150669306640L;

  /**
   * Panneau du composant
   */
  protected JPanel contentPane;

  /**
   * Utilisateur connecté.
   */
  protected User user;

  /**
   * Label pour le nom d'utilisateur.
   */
  protected static final String KEY_NAME_LABEL = "KEY_NAME_LABEL";

  /**
   * Label pour le tag de l'utilisateur.
   */
  protected static final String KEY_TAG_LABEL = "KEY_TAG_LABEL";

  /**
   * Couleur de fond bleu
   */
  protected static final String KEY_BACKGROUND_BUTTON_HOME_COLOR = "KEY_BACKGROUND_BUTTON_HOME_COLOR";

  protected static final String KEY_IMAGE_VORTEX = "KEY_IMAGE_VORTEX";

  /**
   * Clé pour le tooltip switch ON.
   */
  protected static final String KEY_USER_AUTOMATIC_SYNC_TOOLTIP_FOLLOW = "KEY_USER_AUTOMATIC_SYNC_TOOLTIP_FOLLOW";

  /**
   * Clé pour le tooltip switch OFF.
   */
  protected static final String KEY_USER_AUTOMATIC_SYNC_TOOLTIP_UNFOLLOW = "KEY_USER_AUTOMATIC_SYNC_TOOLTIP_UNFOLLOW";

  /**
   * Widget qui permet la modification du statut de la synchronisation automatique.
   */
  protected SwitchFollowButtonComponent switchFollowButtonComponent;

  protected ProfileController profileController;

  /**
   * Instanciation de la Vue.
   * 
   * @throws IOException
   */
  public ProfileView(User user, ProfileController profileController)
  {
    this.user = user;
    this.profileController = profileController;
    this.initContent();
  }

  /**
   * Mise en place de la vue pour le composant Profile.
   * 
   * @throws IOException
   */
  protected void initContent()
  {
    this.setLayout(new GridBagLayout());

    this.contentPane = new JPanel(new GridBagLayout());
    this.initSwitchButtonComponent();
    this.contentPane.setBackground(ConstantLoader.getInstance().getColor(KEY_BACKGROUND_BUTTON_HOME_COLOR));
    // Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
//    this.contentPane.setPreferredSize(new Dimension(screensize.width / 3, screensize.height / 15));
//    this.contentPane.setMinimumSize(new Dimension(screensize.width / 3, screensize.height / 15));
    // Affichage de l'avatar
    try
    {
      this.contentPane.add(this.createAvatarPanel(), new GridBagConstraints(0, 0, 1, 2, 1, 1, GridBagConstraints.CENTER,
          GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    }
    catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    // Affichage du nom
    this.contentPane.add(this.createTagPanel(), new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

    // Affichage du tag
    this.contentPane.add(this.createNamePanel(), new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

    this.contentPane.add(switchFollowButtonComponent.getSwitchFollowButtonView(), new GridBagConstraints(2, 0, 1, 1, 1,
        1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    this.add(this.contentPane, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
  }

  protected JPanel createAvatarPanel() throws IOException
  {
    JPanel panel = new JPanel();
    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_BACKGROUND_BUTTON_HOME_COLOR));
//    panel.setBorder(BorderFactory.createLineBorder(Color.black));
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JPanel homePacman;

    if (this.user.getAvatarPath() == null)
    {
      homePacman = new ImagePanel(ConstantLoader.getInstance().getImage(KEY_IMAGE_VORTEX),
          new Dimension(screenSize.width / 10, screenSize.height / 10));
    }
    else
    {
      File pathToFile = new File(this.user.getAvatarPath());
      Image image = ImageIO.read(pathToFile);
      homePacman = new ImagePanel(image, new Dimension(screenSize.width / 10, screenSize.height / 10));
    }

//    homePacman.setMinimumSize(new Dimension(screenSize.width / 8, screenSize.height / 8));
    panel.add(homePacman, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 0, 0), 0, 0));

    return panel;
  }

  protected JPanel createNamePanel()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_BACKGROUND_BUTTON_HOME_COLOR));

    JLabel label = new JLabel(ConstantLoader.getInstance().getText(KEY_NAME_LABEL));
    label.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));

    JLabel nom = new JLabel(this.user.getName());
    label.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));

    panel.add(label, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE,
        new Insets(0, 70, 0, 0), 0, 0));
    panel.add(nom, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE,
        new Insets(0, 0, 0, 350), 0, 0));

    return panel;
  }

  protected JPanel createTagPanel()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_BACKGROUND_BUTTON_HOME_COLOR));

    JLabel label = new JLabel(ConstantLoader.getInstance().getText(KEY_TAG_LABEL));
    label.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));

    JLabel nom = new JLabel(this.user.getUserTag());
    label.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));

    panel.add(label, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE,
        new Insets(0, 70, 0, 0), 0, 0));
    panel.add(nom, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE,
        new Insets(0, 0, 0, 350), 0, 0));

    return panel;
  }

  /**
   * Initialisation du composant bouton switch lié au follow ou unfollow d'un user
   */
  protected void initSwitchButtonComponent()
  {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    SwitchFollowButtonModel switchButtonModel = new SwitchFollowButtonModel(this.user.isFollowActivated());

    String tooltipON = ConstantLoader.getInstance().getText(KEY_USER_AUTOMATIC_SYNC_TOOLTIP_FOLLOW);
    String tooltipOFF = ConstantLoader.getInstance().getText(KEY_USER_AUTOMATIC_SYNC_TOOLTIP_UNFOLLOW);

    this.switchFollowButtonComponent = new SwitchFollowButtonComponent(switchButtonModel,
        new Dimension(screenSize.width * 2 / 100, screenSize.width * 2 / 100), tooltipON, tooltipOFF);
    this.profileController.addSwitchButton(user, switchButtonModel);
    user.addObserver(this.profileController);
    this.switchFollowButtonComponent.addObserver(this.profileController);
  }

}
