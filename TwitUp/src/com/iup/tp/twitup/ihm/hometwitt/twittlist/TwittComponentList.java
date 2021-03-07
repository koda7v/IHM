package com.iup.tp.twitup.ihm.hometwitt.twittlist;

import com.iup.tp.twitup.datamodel.IDatabase;

public class TwittComponentList
{
  TwittControllerList controllerList;
  TwittModelList modelList;
  TwittViewList viewList;

  public TwittComponentList(IDatabase base)
  {
    this.modelList = new TwittModelList(base);
    this.viewList = new TwittViewList(modelList);
    this.controllerList = new TwittControllerList(modelList, viewList);

    this.modelList.addObserver(this.viewList);
  }

  public TwittViewList getViewList()
  {
    return viewList;
  }

  public TwittControllerList getControllerList()
  {
    return controllerList;
  }

}
