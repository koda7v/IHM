package com.iup.tp.twitup.ihm.hometwitt;

import javax.swing.JPanel;

import com.iup.tp.twitup.ihm.hometwitt.creationtwitt.CreationTwittComponent;
import com.iup.tp.twitup.ihm.hometwitt.twittlist.TwittComponentList;

public class HomeTwittComponent
{

  protected HomeTwittController homeTwittController;

  protected HomeTwittModel homeTwittModel;

  protected HomeTwittView homeTwittView;

  protected CreationTwittComponent twittComponent;

  protected TwittComponentList twittComponentList;

  public HomeTwittComponent()
  {
    this.initTwittComponent();
    this.initTwittListComponent();

    this.homeTwittController = new HomeTwittController();
    this.homeTwittModel = new HomeTwittModel();
    this.homeTwittView = new HomeTwittView(this);

  }

  public void initTwittComponent()
  {
    this.twittComponent = new CreationTwittComponent();
  }

  public void initTwittListComponent()
  {
    this.twittComponentList = new TwittComponentList();
  }

  public JPanel getTwittView()
  {
    return this.twittComponent.getTwittView();
  }

  public JPanel getTwittListView()
  {
    return this.twittComponentList.getViewList();
  }

  public HomeTwittView getHomeTwittView()
  {
    return homeTwittView;
  }

}
