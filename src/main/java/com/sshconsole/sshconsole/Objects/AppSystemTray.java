package com.sshconsole.sshconsole.Objects;

import com.sshconsole.sshconsole.SSHConsole;
import javafx.application.Platform;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

public class AppSystemTray {
    private static PopupMenu trayMenu;

    public AppSystemTray() {
    }

    public static void createSystemTray() throws IOException {
        if(!SystemTray.isSupported()) {
            return;
        }

        trayMenu = new PopupMenu();
        SystemTray systemTray = SystemTray.getSystemTray();

        Image sysImage = ImageIO.read(Objects.requireNonNull(AppSystemTray.class.getClassLoader().getResource("ssh.png")));
        TrayIcon trayIcon = new TrayIcon(sysImage);

        trayIcon.addActionListener(e -> Platform.runLater(new Runnable() {
            @Override
            public void run() {
                SSHConsole.changeVisibility();
            }
        }));

        trayIcon.setPopupMenu(trayMenu);

        try {
            systemTray.add(trayIcon);
        }catch (AWTException e) {
            e.printStackTrace();
        }

        addMenuItem("Exit", () -> System.exit(0));
    }

    public static void addMenuItem(String label, Runnable action) {
        MenuItem item = new MenuItem(label);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.run();
            }
        });

        trayMenu.add(item);
    }

}
