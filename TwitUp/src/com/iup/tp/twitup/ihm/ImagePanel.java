package com.iup.tp.twitup.ihm;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 * Gestion de l'affichage d'une image.
 * 
 * @author Edispa2020
 *
 */
public class ImagePanel extends JPanel
{

  private static final long serialVersionUID = 666L;

  /**
   * L'image que l'on veut afficher.
   */
  protected Image image;

  /**
   * Attribut contenant les différents paramètres de l'image.
   */
  protected BufferedImage mImage;

  /**
   * Message d'erreur lorsque l'image ne se redimensionne pas.
   */
  protected static final String KEY_LOAD_IMAGE_ERROR_MESSAGE = "KEY_LOAD_IMAGE_ERROR_MESSAGE";

  /**
   * Instanciation de l'image ainsi que la dimension.
   * 
   * @param image
   * @param dimension
   */
  public ImagePanel(Image image, Dimension dimension)
  {
    this.image = image;

    try
    {
      this.load(dimension);
    }
    catch (Throwable t)
    {
      mImage = new BufferedImage(1, 1, 1);
    }
  }

  /**
   * Chargement de l'image.
   * 
   * @param dimension
   */
  protected void load(Dimension dimension)
  {

    mImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);

    // Resize de l'image
    if (mImage.getWidth() != dimension.getWidth() || mImage.getHeight() != dimension.getHeight())
    {
      mImage = this.resizeImage(mImage, dimension);
    }
    this.setOpaque(false);
    this.setSize(new Dimension(mImage.getWidth(), mImage.getHeight()));
    this.setPreferredSize(new Dimension(mImage.getWidth(), mImage.getHeight()));

  }

  @Override
  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    g.drawImage(mImage, 0, 0, mImage.getWidth(), mImage.getHeight(), null);
  }

  /**
   * Redimensionnement de l'image.
   * 
   * @param original
   * @param dimension
   * @return
   */
  public BufferedImage resizeImage(BufferedImage original, Dimension dimension)
  {

    double widthFactor = dimension.getWidth() / original.getWidth();
    double heightFactor = dimension.getHeight() / original.getHeight();

    double factor = Math.min(widthFactor, heightFactor);
    int newWidth = (int) (factor * original.getWidth());
    int newHeight = (int) (factor * original.getHeight());

    BufferedImage newImage = new BufferedImage(newWidth, newHeight, original.getType());

    Graphics2D g = newImage.createGraphics();

    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
    g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    g.drawImage(image, 0, 0, newWidth, newHeight, null);
    g.dispose();

    return newImage;
  }
}
