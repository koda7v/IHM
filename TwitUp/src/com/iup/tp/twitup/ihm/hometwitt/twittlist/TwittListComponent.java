package com.iup.tp.twitup.ihm.hometwitt.twittlist;

import com.iup.tp.twitup.datamodel.IDatabase;

public class TwittListComponent
{
  TwittListController controllerList;
  TwittListModel modelList;
  TwittListView viewList;

  public TwittListComponent(IDatabase base)
  {
    this.modelList = new TwittListModel(base);
    this.viewList = new TwittListView(modelList);
    this.controllerList = new TwittListController(modelList, viewList);

    this.modelList.addObserver(this.viewList);
  }

  public TwittListView getViewList()
  {
    return viewList;
  }

  public TwittListController getControllerList()
  {
    return controllerList;
  }

}
