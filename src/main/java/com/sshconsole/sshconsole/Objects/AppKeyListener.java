package com.sshconsole.sshconsole.Objects;

import com.sshconsole.sshconsole.SSHConsole;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AppKeyListener {

    public static void keyRegister(String code, Runnable function) {
        Scene scene = SSHConsole.getStage().getScene();
        scene.getAccelerators().put(KeyCombination.keyCombination(code), function::run);
    }
}
