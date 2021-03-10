package com.iup.tp.twitup.configuration;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import javax.imageio.ImageIO;

/**
 * 
 * Les différentes méthodes permettant l'utilisation des loaders.
 * 
 * @author EPE
 *
 */
public abstract class Loader
{
  /**
   * Attribut dans lequel se charge les informations pour le fichier de configuration.
   */
  protected Properties fileProperties;

  /**
   * Chargement des différentes informations.
   * 
   * @param file
   */
  protected void loadProperties(String file)
  {
    fileProperties = new Properties();
    try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(file))
    {
      if (inputStream != null)
      {
        fileProperties.load(inputStream);
      }
      else
      {
        System.out.println("Problème lors du chargement de fichier");
      }

    }
    catch (IOException e)
    {
      System.out.println("Chargement du fichier impossible");
    }
  }

  /**
   * Récupération d'un texte à partir d'une clef.
   * 
   * @param key
   *          Une chaîne de caractères qui va permettre la récupération d'une configuration précise.
   * @return Une chaîne de caractères correspond à une configuration nécessaire à l'application.
   */
  public String getText(String key)
  {

    String text = null;
    if (fileProperties.containsKey(key))
    {
      text = fileProperties.getProperty(key);
    }
    else
    {
      System.out.println("Problème sur le chargement de la clef pour un text " + key);
      text = key;
    }

    return text;
  }

  /**
   * Récupération d'une image à partir d'une clef. Une image par défaut est choisie si l'image demandée n'est pas
   * accessible.
   * 
   * @param key
   *          Une chaîne de caractères qui va permettre la récupération d'une image précise dépendant du paramètre.
   * @return Une image.
   */
  public Image getImage(String key)
  {
    Image result = null;

    if (fileProperties.containsKey(key))
    {
      try
      {
        String imagePath = fileProperties.getProperty(key);
        URL imageUrl = getClass().getClassLoader().getResource(imagePath).toURI().toURL();
        result = ImageIO.read(imageUrl);

      }
      catch (Exception e)
      {
        result = null;
      }
    }
    return result;
  }

  /**
   * Récupération d'une couleur à partir d'une clef. La couleur rouge de JavaSwing est choisie par défault si la couleur
   * demandée n'est pas accessible ou n'est dans un format acceptable.
   * 
   * @param key
   *          Clé définissant la couleur a sélectionner.
   * @return La couleur associée à la clé si possible, couleur rouge de JavaSwing sinon.
   */
  public Color getColor(String key)
  {
    Color result = Color.RED;

    if (fileProperties.containsKey(key))
    {
      try
      {
        result = Color.decode(fileProperties.getProperty(key));
      }
      catch (NumberFormatException e)
      {
        System.out.println("Problème couleur");
      }
    }
    else
    {
      System.out.println("Problème couleur");
    }

    return result;
  }

}
