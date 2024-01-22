package com.koyomiji.reflect.setup;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

public class JsonLanguageMap {
  public static Map<String, String> parse(String string) {
    Map<String, String> map = new HashMap<>();
    Gson gson = new Gson();
    return (Map<String, String>)gson.fromJson(string, map.getClass());
  }
}
