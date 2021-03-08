package com.iup.tp.twitup.ihm.hometwitt.buttons;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iup.tp.twitup.configuration.ConstantLoader;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.hometwitt.buttons.observer.ITwittButtonsViewObserver;
import com.iup.tp.twitup.ihm.widget.TwitButton;

public class TwittButtonsView extends JPanel
{

  /**
   * 
   */
  private static final long serialVersionUID = 8729396110787758304L;

  protected JPanel contentPane;

  protected static final String KEY_BUTTON_HOME_TITLE_LABEL = "KEY_BUTTON_HOME_TITLE_LABEL";

  protected static final String KEY_BUTTON_PROFILE_TITLE_LABEL = "KEY_BUTTON_PROFILE_TITLE_LABEL";

  protected static final String KEY_BUTTON_LOGOUT_TITLE_LABEL = "KEY_BUTTON_LOGOUT_TITLE_LABEL";

  protected static final String KEY_BACKGROUND_BUTTON_HOME_COLOR = "KEY_BACKGROUND_BUTTON_HOME_COLOR";

  protected static final String KEY_BUTTON_HOME_TITLE_USER_LABEL = "KEY_BUTTON_HOME_TITLE_USER_LABEL";

  protected User user;

  protected List<ITwittButtonsViewObserver> observers;

  public TwittButtonsView(User user)
  {
    this.user = user;
    this.observers = new ArrayList<>();
    this.initContent();
  }

  protected void addObserver(ITwittButtonsViewObserver observer)
  {
    if (observer != null)
    {
      this.observers.add(observer);
    }
  }

  protected void removeObserver(ITwittButtonsViewObserver observer)
  {
    if (observer != null)
    {
      this.observers.remove(observer);
    }
  }

  public void notifyHomeSwap()
  {
    for (ITwittButtonsViewObserver currentObserver : observers)
    {
      currentObserver.notifyHome();
    }
  }

  public void notifyProfileSwap()
  {
    for (ITwittButtonsViewObserver currentObserver : observers)
    {
      currentObserver.notifyProfile();
    }
  }

  public void notifyLogOut()
  {
    for (ITwittButtonsViewObserver currentObserver : observers)
    {
      currentObserver.notififyLogout();
    }
  }

  protected void initContent()
  {
    this.setLayout(new GridBagLayout());

    this.contentPane = new JPanel(new GridBagLayout());
    this.contentPane.setBackground(ConstantLoader.getInstance().getColor(KEY_BACKGROUND_BUTTON_HOME_COLOR));

    this.contentPane.add(this.createPanelTitle(), new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.NORTH,
        GridBagConstraints.HORIZONTAL, new Insets(40, 0, 0, 0), 0, 0));
    this.contentPane.add(this.createPanelHome(), new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    this.add(this.contentPane, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
  }

  protected JPanel createPanelHome()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_BACKGROUND_BUTTON_HOME_COLOR));

    TwitButton buttonHome = new TwitButton(ConstantLoader.getInstance().getText(KEY_BUTTON_HOME_TITLE_LABEL));
    buttonHome.addActionListener(new ActionListener()
    {

      @Override
      public void actionPerformed(ActionEvent e)
      {
        TwittButtonsView.this.notifyHomeSwap();
      }
    });

    TwitButton buttonProfile = new TwitButton(ConstantLoader.getInstance().getText(KEY_BUTTON_PROFILE_TITLE_LABEL));
    buttonProfile.addActionListener(new ActionListener()
    {

      @Override
      public void actionPerformed(ActionEvent e)
      {
        TwittButtonsView.this.notifyProfileSwap();
      }
    });

    TwitButton buttonLogOut = new TwitButton(ConstantLoader.getInstance().getText(KEY_BUTTON_LOGOUT_TITLE_LABEL));
    buttonLogOut.addActionListener(new ActionListener()
    {

      @Override
      public void actionPerformed(ActionEvent e)
      {
        TwittButtonsView.this.notifyLogOut();
      }
    });

    panel.add(buttonHome, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.SOUTH, GridBagConstraints.NONE,
        new Insets(0, 0, 0, 0), 0, 0));
    panel.add(buttonProfile, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    panel.add(buttonLogOut, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.NONE,
        new Insets(0, 0, 0, 0), 0, 0));

    return panel;
  }

  protected JPanel createPanelTitle()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_BACKGROUND_BUTTON_HOME_COLOR));

    JLabel labelName = new JLabel(ConstantLoader.getInstance().getText(KEY_BUTTON_HOME_TITLE_USER_LABEL));
    labelName.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
    JLabel nameUser = new JLabel(this.user.getName());
    nameUser.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));

    panel.add(labelName, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE,
        new Insets(0, 0, 0, 0), 0, 0));
    panel.add(nameUser, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE,
        new Insets(0, 0, 0, 0), 0, 0));

    return panel;
  }
}
