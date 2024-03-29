package com.iup.tp.twitup.ihm.hometwitt;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

public class HomeTwittView extends JPanel
{
  /**
   * 
   */
  private static final long serialVersionUID = -5076442726951518910L;

  protected JPanel contentPane;

  protected HomeTwittComponent homeTwittComponent;

  public HomeTwittView(HomeTwittComponent homeTwittComponent)
  {
    this.homeTwittComponent = homeTwittComponent;
  }

  public void initContent()
  {
    this.setLayout(new GridBagLayout());
    this.contentPane = new JPanel(new GridBagLayout());
    this.add(contentPane, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 0, 0), 0, 0));

    this.showHomeTwittView();

  }

  public void showHomeTwittView()
  {
    this.contentPane.removeAll();

    this.contentPane.add(this.homeTwittComponent.getTwittButtonsView(), new GridBagConstraints(0, 0, 1, 1, 1, 0,
        GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    this.contentPane.add(this.wrapPanelTwitt(), new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    this.contentPane.add(rightPanelList(), new GridBagConstraints(2, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    this.contentPane.revalidate();
    this.contentPane.repaint();

  }

  public void showProfileView()
  {
    this.contentPane.removeAll();

    this.contentPane.add(this.homeTwittComponent.getTwittButtonsView(), new GridBagConstraints(0, 0, 1, 1, 1, 0,
        GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    this.contentPane.add(this.wrapPanelUser(), new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    this.contentPane.revalidate();
    this.contentPane.repaint();
  }

  public void showListUserView()
  {
    this.contentPane.removeAll();

    this.contentPane.add(this.homeTwittComponent.getTwittButtonsView(), new GridBagConstraints(0, 0, 1, 1, 0, 0,
        GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    this.contentPane.add(this.homeTwittComponent.getUserViewList(), new GridBagConstraints(1, 0, 1, 1, 1, 1,
        GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    this.contentPane.add(rightPanelUser(), new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    this.contentPane.revalidate();
    this.contentPane.repaint();
  }

  protected JPanel wrapPanelTwitt()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    // Ajout de la vue du twitt
    panel.add(this.homeTwittComponent.getCreationTwittView(), new GridBagConstraints(0, 0, 1, 1, 1, 0,
        GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    // Ajout de la vue de la liste des twitts
    panel.add(this.homeTwittComponent.getTwittListView(), new GridBagConstraints(0, 1, 1, 1, 1, 1,
        GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    return panel;
  }

  protected JPanel wrapPanelUser()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.add(this.homeTwittComponent.getProfileView(), new GridBagConstraints(0, 0, 1, 1, 1, 0,
        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

    panel.add(this.homeTwittComponent.getUserTwittViewList(), new GridBagConstraints(0, 1, 1, 1, 1, 1,
        GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    return panel;
  }

  protected JPanel rightPanelList()
  {

    JPanel panel = new JPanel(new GridBagLayout());
    panel.add(this.homeTwittComponent.getSearchListTwitView(), new GridBagConstraints(0, 0, 1, 1, 1, 0,
        GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    panel.add(this.homeTwittComponent.getVortexView(), new GridBagConstraints(0, 1, 1, 1, 1, 1,
        GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    return panel;
  }

  protected JPanel rightPanelUser()
  {

    JPanel panel = new JPanel(new GridBagLayout());
    panel.add(this.homeTwittComponent.getSearchListUserView(), new GridBagConstraints(0, 0, 1, 1, 1, 0,
        GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    panel.add(this.homeTwittComponent.getVortexView(), new GridBagConstraints(0, 1, 1, 1, 1, 1,
        GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    return panel;
  }

}
