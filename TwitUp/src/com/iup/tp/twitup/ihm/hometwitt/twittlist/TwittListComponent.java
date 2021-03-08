package com.iup.tp.twitup.ihm.hometwitt.twittlist;

import com.iup.tp.twitup.datamodel.IDatabase;

public class TwittListComponent
{
  TwittControllerList controllerList;
  TwittListModel modelList;
  TwittListView viewList;

  public TwittListComponent(IDatabase base)
  {
    this.modelList = new TwittListModel(base);
    this.viewList = new TwittListView(modelList);
    this.controllerList = new TwittControllerList(modelList, viewList);

    this.modelList.addObserver(this.viewList);
  }

  public TwittListView getViewList()
  {
    return viewList;
  }

  public TwittControllerList getControllerList()
  {
    return controllerList;
  }

}
