package com.iup.tp.twitup.utils;

import java.text.Collator;
import java.util.Comparator;

import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.ihm.hometwitt.twitt.TwittComponent;

public class TwittComponentComparator implements Comparator<TwittComponent>
{

  protected Comparator<Twit> comparator = new TwittDateComparator(Collator.TERTIARY);

  /**
   * Lance la comparaison des vues contenus par les deux composants.
   */
  @Override
  public int compare(TwittComponent t1, TwittComponent t2)
  {
    return comparator.compare(t1.getModel(), t2.getModel());
  }

}
