package com.iup.tp.twitup.ihm.hometwitt;

import javax.swing.JPanel;

import com.iup.tp.twitup.core.EntityManager;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.hometwitt.bottomprofile.BottomProfileComponent;
import com.iup.tp.twitup.ihm.hometwitt.bottomprofile.BottomProfileView;
import com.iup.tp.twitup.ihm.hometwitt.buttons.TwittButtonsComponent;
import com.iup.tp.twitup.ihm.hometwitt.buttons.TwittButtonsView;
import com.iup.tp.twitup.ihm.hometwitt.creationtwitt.CreationTwittComponent;
import com.iup.tp.twitup.ihm.hometwitt.profile.ProfileComponent;
import com.iup.tp.twitup.ihm.hometwitt.profile.ProfileView;
import com.iup.tp.twitup.ihm.hometwitt.search.twit.SearchComponentTwit;
import com.iup.tp.twitup.ihm.hometwitt.search.twit.SearchViewTwit;
import com.iup.tp.twitup.ihm.hometwitt.search.user.SearchComponentUser;
import com.iup.tp.twitup.ihm.hometwitt.search.user.SearchViewUser;
import com.iup.tp.twitup.ihm.hometwitt.twittlist.TwittListComponent;
import com.iup.tp.twitup.ihm.hometwitt.userlist.UserListComponent;
import com.iup.tp.twitup.ihm.hometwitt.usertwittlist.UserTwittListComponent;
import com.iup.tp.twitup.ihm.hometwitt.vortex.VortexComponent;
import com.iup.tp.twitup.ihm.hometwitt.vortex.VortexView;

public class HomeTwittComponent
{

  protected HomeTwittController homeTwittController;

  protected HomeTwittModel homeTwittModel;

  protected HomeTwittView homeTwittView;

  protected CreationTwittComponent twittComponent;

  protected TwittListComponent twittComponentList;

  protected TwittButtonsComponent twittButtonsComponent;

  protected ProfileComponent profileComponent;

  protected VortexComponent vortexComponent;

  protected BottomProfileComponent bottomProfileComponent;

  protected IDatabase base;

  protected User user;

  protected SearchComponentTwit searchComponentList;

  protected SearchComponentUser searchComponentUser;

  protected EntityManager manager;

  protected UserListComponent userListComponent;

  protected UserTwittListComponent userTwittListComponent;

  public HomeTwittComponent(IDatabase base, User user, EntityManager manager)
  {
    this.base = base;
    this.user = user;
    this.manager = manager;
    this.homeTwittView = new HomeTwittView(this);
    this.homeTwittController = new HomeTwittController(this.homeTwittView);
    this.homeTwittModel = new HomeTwittModel();

    this.initTwittButtonsComponent();

    this.homeTwittView.initContent();
  }

  public void addIHomeTwittControllerObserver(IHomeTwittControllerObserver observer)
  {
    this.homeTwittController.addObserver(observer);
  }

  public void removeIHomeTwittControllerObserver(IHomeTwittControllerObserver observer)
  {
    this.homeTwittController.removeObserver(observer);
  }

  public void initTwittComponent()
  {
    this.twittComponent = new CreationTwittComponent(this.base, this.user, this.manager);
  }

  public void initTwittListComponent()
  {
    this.twittComponentList = new TwittListComponent(this.base);
    this.homeTwittController.addObserver(twittComponentList.getControllerList());
    this.base.addObserver(this.twittComponentList.getControllerList());
  }

  protected void initTwittButtonsComponent()
  {
    this.twittButtonsComponent = new TwittButtonsComponent(this.user);
    this.twittButtonsComponent.addITwittButtonsControllerObserver(this.homeTwittController);
  }

  public JPanel getCreationTwittView()
  {
    this.initTwittComponent();
    return this.twittComponent.getCreationTwittView();
  }

  public JPanel getTwittListView()
  {
    this.initTwittListComponent();

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

  public ProfileView getProfileView()
  {
    this.profileComponent = new ProfileComponent(this.user);
    return profileComponent.getProfileView();
  }

  public VortexView getVortexView()
  {
    this.vortexComponent = new VortexComponent();
    return vortexComponent.getVortexView();
  }

  public BottomProfileView getBottomProfileView()
  {
    this.bottomProfileComponent = new BottomProfileComponent();
    return bottomProfileComponent.getBottomProfileView();
  }

  public SearchViewTwit getSearchListTwitView()
  {
    this.searchComponentList = new SearchComponentTwit();
    this.searchComponentList.addObserverController(homeTwittController);
    return searchComponentList.getSearchView();
  }

  public SearchViewUser getSearchListUserView()
  {
    this.searchComponentUser = new SearchComponentUser();
    this.searchComponentUser.addObserverController(homeTwittController);
    return searchComponentUser.getSearchViewUser();
  }

  public void initUserListComponent()
  {
    this.userListComponent = new UserListComponent(this.base);
    this.homeTwittController.addObserver(userListComponent.getUserListController());
  }

  public JPanel getUserViewList()
  {
    this.initUserListComponent();
    return this.userListComponent.getUserListView();
  }

  public void initUserTwittListComponent()
  {
    this.userTwittListComponent = new UserTwittListComponent(this.base, this.user);
  }

  public JPanel getUserTwittViewList()
  {
    this.initUserTwittListComponent();
    return this.userTwittListComponent.getUserTwittListView();
  }

}
