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
    this.controllerList = new TwittControllerList(viewList);
  }

  public TwittViewList getViewList()
  {
    return viewList;
  }

  public void setViewList(TwittViewList viewList)
  {
    this.viewList = viewList;
  }

}
