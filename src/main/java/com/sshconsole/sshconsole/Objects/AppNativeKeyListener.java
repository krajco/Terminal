package com.sshconsole.sshconsole.Objects;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import javafx.application.Platform;

import java.util.HashMap;

public class AppNativeKeyListener implements NativeKeyListener {
    private static HashMap<Integer, Runnable> commands = new HashMap<>();

    public void nativeKeyPressed(NativeKeyEvent e) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if(commands.containsKey(e.getKeyCode()))
                    commands.get(e.getKeyCode()).run();
            }
        });

    }

    public static void keyRegister(int code, Runnable function) {
        Integer keyCode = code;
        commands.put(keyCode, function);
    }
}
