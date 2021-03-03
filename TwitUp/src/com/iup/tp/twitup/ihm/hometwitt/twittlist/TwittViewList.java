package com.iup.tp.twitup.ihm.hometwitt.twittlist;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.iup.tp.twitup.ihm.hometwitt.creationtwitt.CreationTwittComponent;
import com.iup.tp.twitup.ihm.hometwitt.creationtwitt.CreationTwittView;
import com.iup.tp.twitup.ihm.hometwitt.twittlist.observer.ITwittListModelObserver;

public class TwittViewList extends JPanel implements ITwittListModelObserver
{

  private static final long serialVersionUID = 4067578516539010749L;

  /**
   * Panneau principal de la vue.
   */
  protected JPanel contentPane;

  /**
   * Modèle du composant de la liste des twitt.
   */
  protected TwittModelList twittListModel;

  public TwittViewList(TwittModelList twittListModel)
  {
    this.twittListModel = twittListModel;
  }

  @Override
  public void twittComponentAdded(CreationTwittComponent twittComponent)
  {
    this.repaintContentPane();
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

    scrollContent.add(contentPane, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
        GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

    this.add(scrollPane, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 0, 0), 0, 0));
  }

  /**
   * Place les composants dans le panneau principal.
   */
  protected void placeComponents()
  {
    List<CreationTwittComponent> twittComponentList = twittListModel.getTwittComponentList();
    for (int i = 0; i < twittComponentList.size(); i++)
    {

      CreationTwittView twittView = twittComponentList.get(i).getTwittView();

      this.contentPane.add(twittView, new GridBagConstraints(0, i, 1, 1, 1, 0, GridBagConstraints.CENTER,
          GridBagConstraints.HORIZONTAL, new Insets(5, 5, 0, 5), 0, 0));
    }
  }

  /**
   * Rafraîchi le panneau principal.
   */
  protected void repaintContentPane()
  {
    contentPane.removeAll();

    this.placeComponents();

    this.revalidate();
    this.repaint();
  }
}
