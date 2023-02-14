package com.sshconsole.sshconsole.Objects;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AppKeyManager extends KeyManager {
    protected Map<String, Runnable> keyMap;
    public AppKeyManager() {
        super();
        setKeyType("app");
        createKeyMap();
    }

    @Override
    protected void createKeyMap() {
        JSONObject keysJson = getJSONObject();
        keyMap = new HashMap<String, Runnable>();

        Iterator<String> iterator = keysJson.keys();
        String elementName;

        while(iterator.hasNext()) {
            elementName = iterator.next();
            keyMap.put(keysJson.get(elementName).toString(), keyToFunction.get(elementName));
        }
    }

    @Override
    public void registerKeyBindings() {
        for (Map.Entry<String, Runnable> entry : keyMap.entrySet()) {
            AppKeyListener.keyRegister(entry.getKey(), entry.getValue());
        }
    }

    @Override
    protected void initKeysToKeyCode() {

    }
}
