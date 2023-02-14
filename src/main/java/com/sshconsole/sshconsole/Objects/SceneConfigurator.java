package com.sshconsole.sshconsole.Objects;

import com.sshconsole.sshconsole.SSHConsole;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class SceneConfigurator {
    private int width, height, marginRight, marginTop;

    private Scene scene;
    private static Stage stage;

    public SceneConfigurator () {

    }



    private void horizontalCentering() {
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        marginRight = ((int)screenDimension.getWidth() - width) >> 1;
        stage.setX(marginRight);
    }

    private void verticaltalCentering() {
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        marginTop = ((int)screenDimension.getHeight() - height) >> 1;
//        frame.setLocation(marginRight, marginTop);
    }

}
