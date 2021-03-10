package com.iup.tp.twitup.datamodel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Classe du modèle représentant un utilisateur.
 * 
 * @author S.Lucas
 */
public class User
{
  /**
   * Identifiant unique de l'utilisateur.
   */
  protected final UUID mUuid;

  /**
   * Tag non modifiable correspondant à l'utilisateur. <br/>
   * <i>Doit être unique dans le système</i>
   */
  protected final String mUserTag;

  /**
   * Mot de passe de l'utilisateur.
   */
  protected char[] mUserPassword;

  /**
   * Nom de l'utilisateur.
   */
  protected String mName;

  /**
   * Liste des tags suivis par l'utilisateur.
   */
  protected final Set<String> mFollows;

  /**
   * Chemin d'accès à l'image de l'avatar de l'utilisateur.
   */
  protected String mAvatarPath;

  /**
   * Liste des observers d'un user
   */
  protected List<IUserObserver> observers;

  /**
   * Définit si le user est follow pour la current user.<br>
   * Un user est activé si le current user l'a follow. <br>
   * Un user est desactivé si le current user ne l'a pas encore follow l'a unfollow.<br>
   * <br>
   * Pour activé ce booléen, il faut follow un user.
   */
  protected boolean changeFollow;

  /**
   * Constructeur.
   * 
   * @param uuid
   *          , Identifiant unique de l'utilisateur.
   * @param userTag
   *          , Tag correspondant à l'utilisateur.
   * @param name
   *          , Nom de l'utilisateur.
   * @param follows
   *          , Liste des tags suivis.
   * @param avatarPath
   *          , Chemin d'accès à l'image de l'avatar.
   */
  public User(UUID uuid, String userTag, char[] userPassword, String name, Set<String> follows, String avatarPath)
  {
    mUuid = uuid;
    mUserTag = userTag;
    mUserPassword = userPassword;
    mName = name;
    mFollows = follows;
    mAvatarPath = avatarPath;
    this.observers = new ArrayList<IUserObserver>();
  }

  /**
   * Ajoute l'observeur en paramètre dans la liste des observeurs.
   * 
   * @param observer
   *          Observeur à ajouter.
   */
  public void addObserver(IUserObserver observer)
  {
    if (observer != null)
    {
      this.observers.add(observer);
    }
  }

  /**
   * Enlève l'observeur en paramètre de la liste des observeurs.
   * 
   * @param observer
   *          Observeur à enlever.
   */
  public void removeObserver(IUserObserver observer)
  {
    if (observer != null)
    {
      this.observers.remove(observer);
    }
  }

  /**
   * Notifie les observeurs qu'il faut changer l'état d'activation du bouton switch.
   * 
   * @param model
   *          Modèle du switch.
   */
  public void notifyFollowActivationChanged()
  {
    List<IUserObserver> copyObservers = new ArrayList<>(this.observers);

    for (IUserObserver observer : copyObservers)
    {
      observer.changeFollowActivation();
    }
  }

  /**
   * Retourne l'identifiant unique de l'utilisateur.
   */
  public UUID getUuid()
  {
    return this.mUuid;
  }

  /**
   * Retourne le nom de l'utilisateur.
   */
  public String getName()
  {
    return mName;
  }

  /**
   * Assigne le nom de l'utilisateur.
   * 
   * @param name
   */
  public void setName(String name)
  {
    this.mName = name;
  }

  /**
   * Retourne le tag correspondant à l'utilisateur.
   */
  public String getUserTag()
  {
    return this.mUserTag;
  }

  /**
   * Retourne le mot de passe de l'utilisateur.
   */
  public char[] getUserPassword()
  {
    return this.mUserPassword;
  }

  /**
   * Assigne le mot de passe de l'utilisateur.
   * 
   * @param userPassword
   */
  public void setUserPassword(char[] userPassword)
  {
    this.mUserPassword = userPassword;
  }

  /**
   * Retourne la liste clonée des tag suivis par l'utilsateur.
   */
  public Set<String> getFollows()
  {
    // Clonage pour éviter les modifications exterieures
    return new HashSet<String>(this.mFollows);
  }

  /**
   * Retire un tag de la liste des tags suivis.
   * 
   * @param tagToRemove
   *          , tag à retirer.
   */
  public void removeFollowing(String tagToRemove)
  {
    this.mFollows.remove(tagToRemove);
    this.notifyFollowActivationChanged();
  }

  /**
   * Ajout un tag de la liste des tags suivis.
   * 
   * @param tagToFollow
   *          , tag à ajouter.
   */
  public void addFollowing(String tagToFollow)
  {
    this.mFollows.add(tagToFollow);
    this.notifyFollowActivationChanged();
  }

  /**
   * Retourne le chemin d'accès au fichier de l'avatar de l'utilisateur.
   */
  public String getAvatarPath()
  {
    return this.mAvatarPath;
  }

  /**
   * Assigne le chemin d'accès au fichier de l'avatar de l'utilisateur.
   * 
   * @param avatarPath
   */
  public void setAvatarPath(String avatarPath)
  {
    this.mAvatarPath = avatarPath;
  }

  /**
   * Indique si l'utilisateur suit l'utilisateur donné.
   */
  public boolean isFollowing(User userToCheck)
  {
    return this.getFollows().contains(userToCheck.getUserTag());
  }

  /**
   * {@inheritDoc}
   */
  // pour redéfinir le hashCode car on à modifier le equals et qu'on utilise un hashSet
  @Override
  public int hashCode()
  {
    int hashCode = 0;

    if (this.mUuid != null)
    {
      hashCode = this.mUuid.hashCode();
    }

    return hashCode;
  }

//  public void setFollowActivated(boolean followActivated)
//  {
//    this.notifyFollowActivationChanged(followActivated);
//  }

  /**
   * @{inheritDoc
   */
  @Override
  public boolean equals(Object other)
  {
    boolean equals = false;

    if (other != null)
    {
      if (other instanceof User)
      {
        User otherUser = (User) other;
        equals = (this.getUuid().equals(otherUser.getUuid()));
      }
    }

    return equals;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString()
  {
    StringBuffer sb = new StringBuffer();

    sb.append("[");
    sb.append(this.getClass().getName());
    sb.append("] : ");
    sb.append(this.getUuid());
    sb.append(" {@");
    sb.append(this.getUserTag());
    sb.append(" / ");
    sb.append(this.getName());
    sb.append("}");

    return sb.toString();
  }
}
