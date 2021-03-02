package com.iup.tp.twitup.ihm.signup;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.iup.tp.twitup.configuration.ConstantLoader;

public class SignUpView extends JPanel
{

  /**
   * 
   */
  private static final long serialVersionUID = -7596176480159761223L;

  protected static final String KEY_COLOR_HOME_LEFT = "KEY_COLOR_HOME_LEFT";

  protected static final String KEY_NOM_LABEL = "KEY_NOM_LABEL";

  protected JPanel contentPane;

  protected JLabel nomLabel;

  protected JTextField nomText;

  public SignUpView()
  {
    this.initContent();
  }

  public void initContent()
  {
    this.setLayout(new GridBagLayout());

    this.contentPane = new JPanel(new GridBagLayout());
    this.contentPane.setBackground(ConstantLoader.getInstance().getColor(KEY_COLOR_HOME_LEFT));

    this.contentPane.add(this.createPanelNom(), new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    this.add(this.contentPane, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

  }

  protected JPanel createPanelNom()
  {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(ConstantLoader.getInstance().getColor(KEY_COLOR_HOME_LEFT));

    this.nomLabel = new JLabel(ConstantLoader.getInstance().getText(KEY_NOM_LABEL));
    this.nomText = new JTextField();

    panel.add(this.nomLabel, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE,
        new Insets(0, 0, 0, 0), 0, 0));
    panel.add(this.nomText, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH,
        new Insets(0, 0, 0, 0), 0, 0));

    return panel;
  }

}
