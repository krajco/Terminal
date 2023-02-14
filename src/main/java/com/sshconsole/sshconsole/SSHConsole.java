package com.sshconsole.sshconsole;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.sshconsole.sshconsole.Objects.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SSHConsole extends Application {
    private static Scene scene;
    private static Stage stage;

    private int width, height, marginRight, marginTop;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(SSHConsole.class.getResource("main.fxml"));

        Platform.setImplicitExit(false);

        scene = new Scene(fxmlLoader.load(), 320, 480);

//     0   sceneEventFilter();

        stage.initStyle(StageStyle.UNDECORATED);
        stage.setAlwaysOnTop(true);
        stage.setScene(scene);
        stage.setY(0);

        setSceneSize(1, 0.4);

        TesKeyBindings tesKeyBindings = new TesKeyBindings();
        tesKeyBindings.registerKeyBindings();

        KeyManager nativeKeyManager = new NativeKeyManager();
        nativeKeyManager.registerKeyBindings();

        KeyManager appKeyManager = new AppKeyManager();
        appKeyManager.registerKeyBindings();

        AppSystemTray.createSystemTray();
    }

    private void sceneEventFilter() {
        scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode().isArrowKey() ){
                    System.out.println("EVENT FILTER");
                }
            }
        });
    }

    public static void setSceneSize(double scaleX, double scaleY) {
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)Math.round(screenDimension.getWidth() * scaleX);
        int height = (int)Math.round(screenDimension.getHeight() * scaleY);
        stage.setWidth(width);
        stage.setHeight(height);

        int marginRight = ((int)screenDimension.getWidth() - width) >> 1;
        stage.setX(marginRight);
    }

    public static void changeVisibility() {
        if(stage.isShowing()){
            stage.hide();
        }else{
            stage.show();
        }
    }

    public static Stage getStage() {
        return stage;
    }

    public static void main(String[] args) {
        launch();
    }
}