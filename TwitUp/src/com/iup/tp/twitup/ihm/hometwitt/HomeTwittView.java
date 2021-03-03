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
    this.initContent();
  }

  protected void initContent()
  {
    this.setLayout(new GridBagLayout());
    this.contentPane = new JPanel(new GridBagLayout());

    this.showHomeTwittView();

    this.add(contentPane);
  }

  public void showHomeTwittView()
  {
    this.contentPane.removeAll();
    // Ajout de la vue du twitt
    this.contentPane.add(this.homeTwittComponent.getTwittView(), new GridBagConstraints(0, 0, 1, 1, 1, 1,
        GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    // Ajout de la vue de la liste des twitts
    this.contentPane.add(this.homeTwittComponent.getTwittListView(), new GridBagConstraints(0, 1, 1, 1, 1, 1,
        GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    this.contentPane.repaint();
    this.contentPane.revalidate();
  }

  public void showProfileView()
  {

  }

}
