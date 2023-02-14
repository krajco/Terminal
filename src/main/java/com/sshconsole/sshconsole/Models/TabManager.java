package com.sshconsole.sshconsole.Models;

import com.sshconsole.sshconsole.SSHConsole;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.io.IOException;
import java.util.Objects;

public class TabManager {
    private static Integer tabCounter = 1;
    private static final String tabName  = "Terminal ";
    private static final String tabIndex = "Terminal_";

    public TabManager() {

    }

    public static void createTab(TabPane tabPane) {
        Tab tab = new Tab(tabName + (++tabCounter).toString());
        try {
            tab.setContent((Node) FXMLLoader.load(Objects.requireNonNull(SSHConsole.class.getResource("tab.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        tabPane.getTabs().add(tabCounter - 1, tab);
    }
}
