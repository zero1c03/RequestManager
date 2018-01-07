package com.zero1c03.mobile.requestmanager.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by zero1 on 2018/1/7.
 */

public class GsonUtil {
    public static Gson getGson() {
        return new GsonBuilder().disableHtmlEscaping().create();
    }
}
