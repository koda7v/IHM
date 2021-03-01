package com.iup.tp.twitup.configuration;

public class ConstantLoader extends Loader
{
  /**
   * Contient les informations sur la configuration de l'application.
   */
  protected static ConstantLoader instance;

  /**
   * Singleton qui charge les éléments qui sont contenus dans le fichier de configuration de l'application, afin de les
   * rendre manipulables dans la classe.
   */
  private ConstantLoader()
  {
    this.loadProperties(Constant.CONSTANT_FILE);
  }

  /**
   * LazyLoading, il va permettre de charger la classe ConfigurationLoader et la créer si nécessaire.
   * 
   * @return L'instance qui va permettre la manipulation des informations liées à la configuration de l'application.
   */
  public static ConstantLoader getInstance()
  {
    if (instance == null)
    {
      instance = new ConstantLoader();
    }
    return instance;
  }

}
