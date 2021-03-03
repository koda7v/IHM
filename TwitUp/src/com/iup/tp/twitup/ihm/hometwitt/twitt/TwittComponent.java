package com.iup.tp.twitup.ihm.hometwitt.twitt;

public class TwittComponent
{
  protected TwittController controller;
  protected TwittModel model;
  protected TwittView view;

  public TwittComponent()
  {
    this.controller = new TwittController();
    this.model = new TwittModel();
    this.view = new TwittView();
  }

  public TwittView getView()
  {
    return view;
  }

  public void setView(TwittView view)
  {
    this.view = view;
  }

}
