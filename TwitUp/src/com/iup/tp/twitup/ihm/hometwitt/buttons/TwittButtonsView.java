package com.iup.tp.twitup.ihm.hometwitt.buttons;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.iup.tp.twitup.configuration.ConstantLoader;
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

  public TwittButtonsView()
  {
    this.initContent();
  }

  protected void initContent()
  {
    this.setLayout(new GridBagLayout());
    this.setBorder(BorderFactory.createLineBorder(Color.red));

    this.contentPane = new JPanel(new GridBagLayout());

    this.contentPane.add(this.createPanelHome(), new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    this.add(this.contentPane, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
  }

  protected JPanel createPanelHome()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_BACKGROUND_BUTTON_HOME_COLOR));

    TwitButton twitButton = new TwitButton(ConstantLoader.getInstance().getText(KEY_BUTTON_HOME_TITLE_LABEL));
    panel.add(twitButton, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE,
        new Insets(0, 0, 0, 0), 0, 0));

    return panel;
  }
}
