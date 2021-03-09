package com.iup.tp.twitup.ihm.widget;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.iup.tp.twitup.configuration.ConstantLoader;

public class TrayNotification
{

  protected String msg;

  protected String path;

  protected String user;

  protected String title = "Nouveau twit de : ";

  protected TrayIcon trayIcon;

  protected static final String KEY_IMAGE_VORTEX = "KEY_IMAGE_VORTEX";

  public TrayNotification(String msg, String user, String path)
  {
    this.msg = msg;
    this.user = user;
    this.path = path;

  }

  public void displayTray() throws AWTException
  {
    SystemTray tray = SystemTray.getSystemTray();

    Image image = ConstantLoader.getInstance().getImage(KEY_IMAGE_VORTEX);

    if (path != null)
    {
      File pathToFile = new File(this.path);

      try
      {
        image = ImageIO.read(pathToFile);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }

    this.trayIcon = new TrayIcon(image, "Tray Demo");
    trayIcon.setImageAutoSize(true);
    trayIcon.setToolTip("Notification TwitUp");

    tray.add(trayIcon);
    trayIcon.displayMessage(this.title + " " + this.user, this.msg, MessageType.INFO);
    tray.remove(trayIcon);

  }

  public void clickTray()
  {
    trayIcon.displayMessage(this.title + " " + this.user, this.msg, MessageType.INFO);
  }
}
