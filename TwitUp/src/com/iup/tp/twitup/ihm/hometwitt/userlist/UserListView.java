package com.iup.tp.twitup.ihm.hometwitt.userlist;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.iup.tp.twitup.configuration.ConstantLoader;
import com.iup.tp.twitup.ihm.hometwitt.profile.ProfileComponent;
import com.iup.tp.twitup.ihm.hometwitt.profile.ProfileFollowView;

public class UserListView extends JPanel
{

  private static final long serialVersionUID = 4067578516539010749L;

  /**
   * Panneau principal de la vue.
   */
  protected JPanel contentPane;

  /**
   * Modèle du composant de la liste des twitt.
   */
  protected UserListModel userListModel;

  /**
   * Couleur de fond bleu
   */
  protected static final String KEY_COLOR_HOME_LEFT = "KEY_COLOR_HOME_LEFT";

  protected static final String KEY_LIST_USER_TITLE_LABEL = "KEY_LIST_USER_TITLE_LABEL";

  public UserListView(UserListModel userListModel)
  {
    this.userListModel = userListModel;
    this.initContent();
    this.placeComponents();
  }

  /**
   * Initialise le composant graphique, création du JScrollPane contenant la liste des twitts.
   * 
   * @param dimension
   *          Dimension du composant.
   */
  protected void initContent()
  {
    this.setLayout(new GridBagLayout());

    JPanel scrollContent = new JPanel(new GridBagLayout());
    JScrollPane scrollPane = new JScrollPane(scrollContent);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    scrollPane.getVerticalScrollBar().setUnitIncrement(screenSize.height / 60);
    this.contentPane = new JPanel(new GridBagLayout());
    this.contentPane.setOpaque(false);
    scrollContent.add(this.createPanelTitle(), new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
        GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 10, 10));

    scrollContent.add(contentPane, new GridBagConstraints(0, 1, 1, 1, 0, 1, GridBagConstraints.NORTH,
        GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

    JPanel panel = new JPanel(new GridBagLayout());
    panel.add(scrollPane, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 0, 0), 0, 0));

    this.add(panel, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 0, 0), 0, 0));
  }

  /**
   * Place les composants dans le panneau principal.
   */
  protected void placeComponents()
  {
    this.contentPane.removeAll();
    List<ProfileComponent> userComponentList = userListModel.getUserListComponent();
    for (int i = 0; i < userComponentList.size(); i++)
    {

      ProfileFollowView userView = userComponentList.get(i).getProfileFollowView();

      this.contentPane.add(userView, new GridBagConstraints(0, i, 1, 1, 1, 1, GridBagConstraints.NORTH,
          GridBagConstraints.HORIZONTAL, new Insets(5, 5, 0, 5), 0, 0));

      this.contentPane.revalidate();
      this.contentPane.repaint();
    }
  }

  protected JPanel createPanelTitle()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_COLOR_HOME_LEFT));

    JLabel label = new JLabel(ConstantLoader.getInstance().getText(KEY_LIST_USER_TITLE_LABEL));
    label.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
    panel.add(label, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE,
        new Insets(0, 0, 0, 0), 0, 0));

    return panel;
  }

  protected void repaintContentPane()
  {
    this.contentPane.removeAll();

    this.placeComponents();

    this.contentPane.revalidate();
    this.contentPane.repaint();
  }

}
