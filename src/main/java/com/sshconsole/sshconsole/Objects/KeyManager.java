package com.sshconsole.sshconsole.Objects;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.sshconsole.sshconsole.Enums.KeyBindingsActionsName;
import org.json.JSONObject;

import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public abstract class KeyManager {
    private String filename;

    private String keyType;

    protected HashMap<String, Integer> keyToKeyCode;
    protected HashMap<String, Runnable> keyToFunction;

    public KeyManager(String filename) {
        this.filename = filename;
        initKeysToKeyCode();
        initKeysToFunction();
    }

    public KeyManager() {
        this.filename = "keyBindings.json";
        initKeysToKeyCode();
        initKeysToFunction();
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    private String loadKeyBindingsFileAsString() {
        InputStream is = getClass().getClassLoader().getResourceAsStream(this.filename);
        String jsonString = "";
        try {
            assert is != null;
            byte[] bytes = new byte[(int)is.available()];
            is.read(bytes);

            jsonString = new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return jsonString;
    }

    protected JSONObject getJSONObject() {
        String jsonString = loadKeyBindingsFileAsString();
        JSONObject keysJson = new JSONObject(jsonString).getJSONObject(keyType);
        return keysJson;
    }

    private void initKeysToFunction() {
        keyToFunction = new HashMap<String, Runnable>();
//        keyToFunction.put(KeyBindingsActionsName.OPEN_CONSOLE, KeyBindingsEvents::showAndHideWindow);
//        keyToFunction.put(KeyBindingsActionsName.TERMINAL_LEFT, KeyBindingsEvents::getLeftTerminal);
//        keyToFunction.put(KeyBindingsActionsName.TERMINAL_RIGHT, KeyBindingsEvents::getRightTerminal);
    }

    public abstract void registerKeyBindings();
    protected abstract void initKeysToKeyCode();
    protected abstract void createKeyMap();

}
