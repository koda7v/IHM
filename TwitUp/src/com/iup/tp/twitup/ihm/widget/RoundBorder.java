package com.iup.tp.twitup.ihm.widget;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.border.Border;

/**
 * Création d'une bordure arrondie.
 * 
 * @author Edispa2020
 *
 */
public class RoundBorder implements Border
{

  /**
   * Couleur de la bordure.
   */
  protected Color borderColor;

  /**
   * Couleur de l'arrière plan.
   */
  protected Color backgroundColor;

  /**
   * Créer une bordure arrondie.
   * 
   * @param borderColor
   *          Couleur de la bordure.
   * @param backgroundColor
   *          Couleur de fond.
   */
  public RoundBorder(Color borderColor, Color backgroundColor)
  {
    this.borderColor = borderColor;
    this.backgroundColor = backgroundColor;
  }

  @Override
  public Insets getBorderInsets(Component c)
  {
    return new Insets(0, 0, 0, 0);
  }

  @Override
  public boolean isBorderOpaque()
  {
    return false;
  }

  @Override
  public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
  {
    int arc = 25;
    int adjustXY = 1;
    int adjustWH = 2;

    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    g2.setColor(backgroundColor);
    g2.fillRoundRect(x + adjustXY, y + adjustXY, width - adjustWH, height - adjustWH, arc, arc);
    g2.drawString("This is gona be awesome", 200, 200);
    g2.setColor(borderColor);
    g2.drawRoundRect(x + adjustXY, y + adjustXY, width - adjustWH, height - adjustWH, arc, arc);
  }
}