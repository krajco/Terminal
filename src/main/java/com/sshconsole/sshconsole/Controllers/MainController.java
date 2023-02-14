package com.sshconsole.sshconsole.Controllers;

import com.sshconsole.sshconsole.SSHConsole;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.KeyEvent;

public class MainController {
    @FXML
    private TabPane tabPane;

    @FXML
    private Tab newTabButton;

    @FXML
    public void initialize() {
//        newTabButton.setOnSelectionChanged(new EventHandler<Event>() {
//            @Override
//            public void handle(Event event) {
//                if (newTabButton.isSelected()) {
//                    TabManager.createTab(tabPane);
//                    tabPane.getSelectionModel().selectPrevious();
//                }
//            }
//        });

        System.out.println(SSHConsole.getStage().getScene());
    }
}