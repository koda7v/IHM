package com.iup.tp.twitup.ihm.hometwitt.creationtwitt;

public class CreationTwittComponent
{
  protected CreationTwittController controller;
  protected CreationTwittModel model;
  protected CreationTwittView view;

  public CreationTwittComponent()
  {
    this.controller = new CreationTwittController();
    this.model = new CreationTwittModel();
    this.view = new CreationTwittView();
  }

  public CreationTwittView getTwittView()
  {
    return view;
  }

}
