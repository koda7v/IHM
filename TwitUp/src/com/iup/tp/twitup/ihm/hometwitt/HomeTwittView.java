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

    this.showHomeTwittView();

  }

  public void showHomeTwittView()
  {
    this.contentPane.removeAll();

    this.contentPane.add(this.homeTwittComponent.getTwittButtonsView(), new GridBagConstraints(0, 0, 1, 1, 1, 1,
        GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    this.contentPane.add(this.wrapPanelTwitt(), new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    this.contentPane.add(this.homeTwittComponent.getVortexView(), new GridBagConstraints(2, 0, 1, 1, 1, 1,
        GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    this.add(contentPane, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 0, 0), 0, 0));

    this.contentPane.revalidate();
    this.contentPane.repaint();

  }

  protected JPanel wrapPanelTwitt()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    // Ajout de la vue du twitt
    panel.add(this.homeTwittComponent.getTwittView(), new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.NORTH,
        GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    // Ajout de la vue de la liste des twitts
    panel.add(this.homeTwittComponent.getTwittListView(), new GridBagConstraints(0, 1, 1, 1, 0, 1,
        GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

    return panel;
  }

  public void showProfileView()
  {
    this.contentPane.removeAll();

    this.contentPane.add(this.homeTwittComponent.getTwittButtonsView(), new GridBagConstraints(0, 0, 1, 2, 1, 1,
        GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    this.contentPane.add(this.homeTwittComponent.getProfileView(), new GridBagConstraints(1, 0, 1, 1, 1, 1,
        GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    this.contentPane.add(this.homeTwittComponent.getBottomProfileView(), new GridBagConstraints(1, 1, 1, 1, 1, 1,
        GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    this.contentPane.add(this.homeTwittComponent.getVortexView(), new GridBagConstraints(2, 0, 1, 2, 1, 1,
        GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    this.contentPane.revalidate();
    this.contentPane.repaint();
  }

}
