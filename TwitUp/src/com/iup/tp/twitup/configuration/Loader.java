package com.iup.tp.twitup.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * Les différentes méthodes permettant l'utilisation des loaders.
 * 
 * @author Edispa2020
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
      System.out.println("Problème sur le chargement de la clef pour un text");
      text = key;
    }

    return text;
  }

}
