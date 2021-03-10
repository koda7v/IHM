package com.iup.tp.twitup.ihm.widget;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

public class RoundedBorder implements Border
{

  private int radius;

  protected Color backgroundColor;

  RoundedBorder(int radius, Color backgroundColor)
  {
    this.radius = radius;
    this.backgroundColor = backgroundColor;
  }

  @Override
  public Insets getBorderInsets(Component c)
  {
    return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
  }

  @Override
  public boolean isBorderOpaque()
  {
    return false;
  }

  @Override
  public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
  {

    g.setColor(backgroundColor);
    g.fillRoundRect(x, y, width - 1, height - 1, radius, radius);
  }
}