package com.iup.tp.twitup.ihm.home;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iup.tp.twitup.configuration.ConstantLoader;
import com.iup.tp.twitup.ihm.ImagePanel;
import com.iup.tp.twitup.ihm.home.observer.IHomeViewObserver;
import com.iup.tp.twitup.ihm.widget.TwitButton;

public class HomeView extends JPanel
{

  /**
   * 
   */
  private static final long serialVersionUID = 7299905704615566015L;

  protected JPanel contentPane;

  protected static final String KEY_IMAGE_HOME = "KEY_IMAGE_HOME";

  protected static final String KEY_APPLICATION_TITLE = "KEY_APPLICATION_TITLE";

  protected static final String KEY_COLOR_HOME_LEFT = "KEY_COLOR_HOME_LEFT";

  protected static final String KEY_COLOR_HOME_RIGHT = "KEY_COLOR_HOME_RIGHT";

  protected static final String KEY_SIGNUP_BUTTON_TITLE = "KEY_SIGNUP_BUTTON_TITLE";

  protected static final String KEY_SIGNIN_BUTTON_TITLE = "KEY_SIGNIN_BUTTON_TITLE";

  protected TwitButton buttonSignUp;

  protected TwitButton buttonSigngIn;

  protected List<IHomeViewObserver> observers;

  public HomeView()
  {
    this.initContent();
    this.observers = new ArrayList<>();
  }

  protected void initContent()
  {
    this.setLayout(new GridBagLayout());

    this.contentPane = new JPanel(new GridBagLayout());

    this.contentPane.add(this.createPanelOverview(), new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    this.contentPane.add(this.createPanelConnexion(), new GridBagConstraints(1, 0, 1, 1, 1, 1,
        GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    this.add(contentPane, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 0, 0), 0, 0));

  }

  public void addIHomeViewObserver(IHomeViewObserver observer)
  {
    if (observer != null)
    {
      this.observers.add(observer);
    }
  }

  protected JPanel createPanelOverview()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_COLOR_HOME_LEFT));

    JLabel label = new JLabel(ConstantLoader.getInstance().getText(KEY_APPLICATION_TITLE));
    label.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
    label.setForeground(Color.blue);

    panel.add(label, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
        new Insets(0, 0, 0, 0), 0, 0));

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JPanel homeImage = new ImagePanel(ConstantLoader.getInstance().getImage(KEY_IMAGE_HOME),
        new Dimension(screenSize.height / 3, screenSize.height / 3));

    panel.add(homeImage, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
        new Insets(0, 0, 0, 0), 0, 0));

    return panel;
  }

  protected JPanel createPanelConnexion()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_COLOR_HOME_RIGHT));

    TwitButton buttonSignUp = new TwitButton(ConstantLoader.getInstance().getText(KEY_SIGNUP_BUTTON_TITLE));
    buttonSignUp.addActionListener(new ActionListener()
    {

      @Override
      public void actionPerformed(ActionEvent e)
      {
        HomeView.this.selectChoice(ConstantLoader.getInstance().getText(KEY_SIGNUP_BUTTON_TITLE));

      }
    });
    TwitButton buttonSignIn = new TwitButton(ConstantLoader.getInstance().getText(KEY_SIGNIN_BUTTON_TITLE));
    buttonSignIn.addActionListener(new ActionListener()
    {

      @Override
      public void actionPerformed(ActionEvent e)
      {
        HomeView.this.selectChoice(ConstantLoader.getInstance().getText(KEY_SIGNIN_BUTTON_TITLE));

      }
    });
    panel.add(buttonSignUp, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
        new Insets(0, 0, 40, 0), 0, 0));

    panel.add(buttonSignIn, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
        new Insets(40, 0, 0, 0), 0, 0));

    return panel;
  }

  public void selectChoice(String choice)
  {
    this.notifyChoiceMainView(choice);
  }

  public void notifyChoiceMainView(String choice)
  {
    for (IHomeViewObserver currentObserver : observers)
    {
      currentObserver.notificationChoiceView(choice);
    }
  }

}
