package com.iup.tp.twitup.ihm.hometwitt;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
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
    this.initContent();
  }

  protected void initContent()
  {
    this.setLayout(new GridBagLayout());
    this.contentPane = new JPanel(new GridBagLayout());

    this.showHomeTwittView();

    this.add(contentPane, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 0, 0), 0, 0));
  }

  public void showHomeTwittView()
  {
    this.contentPane.removeAll();

    JPanel panel1 = new JPanel(new GridBagLayout());
    panel1.add(new JLabel("test"), new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
//    this.contentPane.add(this.homeTwittComponent.getTwittButtonsView(), new GridBagConstraints(0, 0, 1, 2, 1, 1,
//        GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    this.contentPane.add(panel1, new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.WEST,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    this.contentPane.add(this.wrapPanelTwitt(), new GridBagConstraints(1, 0, 2, 1, 1, 1, GridBagConstraints.NORTH,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    JPanel panel = new JPanel(new GridBagLayout());
    panel.add(new JLabel("test"), new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    this.contentPane.add(panel, new GridBagConstraints(3, 0, 1, 1, 1, 1, GridBagConstraints.EAST,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    this.contentPane.revalidate();
    this.contentPane.repaint();

  }

  protected JPanel wrapPanelTwitt()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBorder(BorderFactory.createLineBorder(Color.blue));
    // Ajout de la vue du twitt
    panel.add(this.homeTwittComponent.getTwittView(), new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.NORTH,
        GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    // Ajout de la vue de la liste des twitts
    panel.add(this.homeTwittComponent.getTwittListView(), new GridBagConstraints(0, 1, 1, 1, 1, 1,
        GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    return panel;
  }

  public void showProfileView()
  {

  }

}
