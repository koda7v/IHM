package com.iup.tp.twitup.ihm.hometwitt.twitt;

import com.iup.tp.twitup.datamodel.Twit;

public class TwittComponent
{
  protected TwittController controller;
  protected TwittView view;
  protected Twit model;

  public TwittComponent(Twit model)
  {
    this.controller = new TwittController();
    this.model = model;
    this.view = new TwittView(model);
  }

  public TwittView getTwittView()
  {
    return view;
  }

  public void setTwittView(TwittView view)
  {
    this.view = view;
  }

}
