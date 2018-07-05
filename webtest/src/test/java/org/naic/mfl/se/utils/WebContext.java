package org.naic.mfl.se.utils;

import java.util.HashMap;
import java.util.Map;

public class WebContext {

    private static Map<String, Object> map = new HashMap<String, Object>();

    public static void setValue(String key, Object value){
        map.put(key, value);
    }

    public static Object getValue(String key){
        return map.get(key);
    }
}
