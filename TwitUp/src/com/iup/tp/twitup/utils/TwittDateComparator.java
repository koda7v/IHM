package com.iup.tp.twitup.utils;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

import com.iup.tp.twitup.datamodel.Twit;

public class TwittDateComparator implements Comparator<Twit>
{

  /**
   * Collator permettant la comparaison de deux chaines de caractères en se basant sur la localité de l'utilisateur.
   */
  private final Collator collator;

  /**
   * Constructeur qui instancie le collator.
   * 
   * @param strength
   *          Niveau de comparaison à appliquer au collator.
   */
  public TwittDateComparator(final int strength)
  {
    this.collator = Collator.getInstance(Locale.FRANCE);
    this.collator.setStrength(strength);
  }

  /**
   * Compare les deux twitts par leur date.
   */

  @Override
  public int compare(Twit t1, Twit t2)
  {
    return this.collator.compare(Long.toString(t2.getEmissionDate()), Long.toString(t1.getEmissionDate()));
  }

}
