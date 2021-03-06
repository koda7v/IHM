package com.iup.tp.twitup.ihm.hometwitt;

import javax.swing.JPanel;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.hometwitt.buttons.TwittButtonsComponent;
import com.iup.tp.twitup.ihm.hometwitt.buttons.TwittButtonsView;
import com.iup.tp.twitup.ihm.hometwitt.creationtwitt.CreationTwittComponent;
import com.iup.tp.twitup.ihm.hometwitt.twittlist.TwittComponentList;

public class HomeTwittComponent
{

  protected HomeTwittController homeTwittController;

  protected HomeTwittModel homeTwittModel;

  protected HomeTwittView homeTwittView;

  protected CreationTwittComponent twittComponent;

  protected TwittComponentList twittComponentList;

  protected TwittButtonsComponent twittButtonsComponent;

  protected IDatabase base;

  protected User user;

  public HomeTwittComponent(IDatabase base, User user)
  {
    this.base = base;
    this.user = user;

    this.initTwittComponent();
    this.initTwittListComponent();
    this.initTwittButtonsComponent();

    this.homeTwittController = new HomeTwittController();
    this.homeTwittModel = new HomeTwittModel();
    this.homeTwittView = new HomeTwittView(this);

  }

  public void initTwittComponent()
  {
    this.twittComponent = new CreationTwittComponent(this.base, this.user);
  }

  public void initTwittListComponent()
  {
    this.twittComponentList = new TwittComponentList();
    this.base.addObserver(this.twittComponentList.getControllerList());

  }

  protected void initTwittButtonsComponent()
  {
    this.twittButtonsComponent = new TwittButtonsComponent();
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

  public TwittButtonsView getTwittButtonsView()
  {
    return twittButtonsComponent.getTwittButtonsView();
  }

}
