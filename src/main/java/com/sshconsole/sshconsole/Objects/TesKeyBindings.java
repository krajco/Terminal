package com.sshconsole.sshconsole.Objects;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.time.format.TextStyle;

public class TesKeyBindings {
    private JSONObject appJSON;
    private JSONObject nativeJSON;

    private String filename;

    public TesKeyBindings() {
        this.filename = "keyBindings.json";
        getJSONObject();
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

    protected void getJSONObject() {
        String jsonString = loadKeyBindingsFileAsString();
        nativeJSON = new JSONObject(jsonString).getJSONObject("native");
        appJSON = new JSONObject(jsonString).getJSONObject("app");
    }

    public void registerKeyBindings() {
        Method[] methods = KeyBindingsEvents.class.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            try {
                methods[i].invoke(new Object());
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
        System.exit(0);
    }
}
