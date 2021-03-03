package com.iup.tp.twitup.ihm.hometwitt.twittlist;

public class TwittComponentList
{
  TwittControllerList controllerList;
  TwittModelList modelList;
  TwittViewList viewList;

  public TwittComponentList()
  {
    this.modelList = new TwittModelList();
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
