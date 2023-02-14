package com.sshconsole.sshconsole.Objects;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.sshconsole.sshconsole.SSHConsole;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.HashMap;
import java.util.Map;

public class KeyBindingsEvents {
    private static Map<String, Integer> nativeKeyMap;

    static {
        nativeKeyMap = new HashMap<>();
        nativeKeyMap.put("F12", NativeKeyEvent.VC_F12);
    }

    public static void showAndHideWindow(String code, Runnable function) {
        System.out.println("SHOW");
//        SSHConsole.changeVisibility();
    }

    public static void getLeftTerminal() {
        System.out.println("LEFT");
    }

    public static void getRightTerminal() {
        System.out.println("RIGHT");
    }

}
