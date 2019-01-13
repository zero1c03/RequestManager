package com.zero1c03.mobile.requestmanager.api;

import com.zero1c03.mobile.requestmanager.model.TimeModel;
import com.zero1c03.mobile.requestmanager.network.ApiCallback;
import com.zero1c03.mobile.requestmanager.network.RequestManager;

public class GetTimeAPI {
    public static void getTime(ApiCallback<TimeModel> apiCallback) {
        String apiUrl = "http://worldclockapi.com/api/json/utc/now";
        RequestManager.getInstance().sendGet(apiUrl, TimeModel.class, apiCallback);
    }
}
