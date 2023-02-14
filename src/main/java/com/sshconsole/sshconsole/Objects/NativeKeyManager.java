package com.sshconsole.sshconsole.Objects;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.dispatcher.DefaultDispatchService;
import com.github.kwhat.jnativehook.dispatcher.SwingDispatchService;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static java.lang.System.*;

public class NativeKeyManager extends KeyManager {
    protected Map<Integer, Runnable> keyMap;

    public NativeKeyManager() {
        super();
        setKeyType("native");
        createKeyMap();
    }

    @Override
    protected void createKeyMap() {
        JSONObject keysJson = getJSONObject();
        keyMap = new HashMap<Integer, Runnable>();

        Iterator<String> iterator = keysJson.keys();
        String elementName;

        while(iterator.hasNext()) {
            elementName = iterator.next();
            keyMap.put(keyToKeyCode.get(keysJson.get(elementName)), keyToFunction.get(elementName));
        }
    }

    public NativeKeyManager(String filename) {
        super(filename);
        setKeyType("native");
        createKeyMap();
    }


    @Override
    public void registerKeyBindings() {
        GlobalScreen.setEventDispatcher(new SwingDispatchService());
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            throw new RuntimeException(e);
        }

        for (Map.Entry<Integer, Runnable> entry : keyMap.entrySet()) {
            AppNativeKeyListener.keyRegister(entry.getKey(), entry.getValue()::run);
        }

        GlobalScreen.addNativeKeyListener(new AppNativeKeyListener());
    }

    protected void initKeysToKeyCode() {
        keyToKeyCode = new HashMap<String, Integer>();
        keyToKeyCode.put(NativeKeyEvent.getKeyText(NativeKeyEvent.VC_F12), NativeKeyEvent.VC_F12);
        keyToKeyCode.put(NativeKeyEvent.getKeyText(NativeKeyEvent.VC_F11), NativeKeyEvent.VC_F11);
    }

}
