package com.zero1c03.mobile.requestmanager.network;

/**
 * Created by zero1 on 2018/1/7.
 */

public interface ApiCallback<T> {
    void onSuccess(T result);

    void onError(String errorMsg);
}
