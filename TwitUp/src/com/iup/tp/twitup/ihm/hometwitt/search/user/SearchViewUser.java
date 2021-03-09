package com.iup.tp.twitup.ihm.hometwitt.search.user;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxEditor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

import com.iup.tp.twitup.configuration.ConstantLoader;
import com.iup.tp.twitup.ihm.hometwitt.search.observer.ISearchViewObserver;

public class SearchViewUser extends JPanel
{

  /**
   * 
   */
  private static final long serialVersionUID = -8050642275952263798L;

  /**
   * Panneau principal
   */
  protected JPanel contentPane;

  /**
   * champs de recherche
   */
  protected JTextField searchField;

  protected static final String KEY_IMAGE_LOUPE = "KEY_IMAGE_LOUPE";

  protected ComboBoxEditor comboBox;

  /**
   * Couleur de fond bleu
   */
  protected static final String KEY_COLOR_HOME_LEFT = "KEY_COLOR_HOME_LEFT";

  /**
   * Couleur de fond blanc
   */
  protected static final String KEY_COLOR_HOME_RIGHT = "KEY_COLOR_HOME_RIGHT";

  protected List<ISearchViewObserver> observers;

  protected JTextField editorComponent;

  public SearchViewUser()
  {
    this.observers = new ArrayList<>();
    this.initContent();
  }

  public void addISearchViewObserver(ISearchViewObserver observer)
  {
    if (observer != null)
    {
      this.observers.add(observer);
    }
  }

  public void removeISearchViewObserver(ISearchViewObserver observer)
  {
    if (observer != null)
    {
      this.observers.remove(observer);
    }
  }

  public void initContent()
  {
    this.setLayout(new GridBagLayout());
    this.contentPane = new JPanel(new GridBagLayout());

    this.contentPane.add(this.searchBar(), new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    this.add(contentPane, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 0, 0), 0, 0));
  }

  private JPanel searchBar()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_COLOR_HOME_RIGHT));
    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

//    this.searchField = new JTextField();
//    this.searchField.setBackground(ConstantLoader.getInstance().getColor(KEY_COLOR_HOME_RIGHT));
//    this.searchField.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
//    this.searchField.setBorder(BorderFactory.createLineBorder(Color.PINK));

    JComboBox<String> jcbx = new JComboBox<>();
    editorComponent = (JTextField) jcbx.getEditor().getEditorComponent();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    editorComponent.setMinimumSize(new Dimension(screenSize.width / 20, screenSize.height / 50));
    editorComponent.setMaximumSize(new Dimension(screenSize.width / 20, screenSize.height / 50));
    editorComponent.addKeyListener(new KeyListener()
    {

      @Override
      public void keyTyped(KeyEvent e)
      {
        // TODO Auto-generated method stub

      }

      @Override
      public void keyReleased(KeyEvent e)
      {
        // TODO Auto-generated method stub

      }

      @Override
      public void keyPressed(KeyEvent e)
      {
        SearchViewUser.this.search(e);

      }
    });
    jcbx.setEditable(true);

    Border outer = editorComponent.getBorder();
    Border search = new MatteBorder(0, 16, 0, 0, new ImageIcon(ConstantLoader.getInstance().getImage(KEY_IMAGE_LOUPE)));
    editorComponent.setBorder(new CompoundBorder(outer, search));

//    panel.add(searchField, new GridBagConstraints(0, 0, 0, 0, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH,
//        new Insets(0, 0, 0, 0), 0, 0));

    panel.add(editorComponent, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    return panel;
  }

  public void search(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_ENTER)
    {
      for (ISearchViewObserver currentObserver : observers)
      {
        currentObserver.notifySearch(this.editorComponent.getText());
      }
    }
  }

}
