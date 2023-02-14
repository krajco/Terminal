package com.sshconsole.sshconsole.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class TabController {
    @FXML
    private Button testujem;

    public void initialize() {
    }

    public void changeName() {
        testujem.setText("AHOJ");
    }
}
