package com.zero1c03.mobile.requestmanager.network;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.google.gson.Gson;
import com.zero1c03.mobile.requestmanager.utils.GsonUtil;

import java.io.UnsupportedEncodingException;

/**
 * Created by zero1 on 2018/1/7.
 */

public class JsonApiRequest<T> extends JsonRequest<T> {

    private Gson mGson;
    private Class<T> mClass;
    private Response.Listener<T> mListener;

    public JsonApiRequest(int method, String url, String jsonString, Class<T> clazz, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(method, url, jsonString, listener, errorListener);
        mGson = GsonUtil.getGson();
        mClass = clazz;
        mListener = listener;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            return Response.success(mGson.fromJson(json, mClass), HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(response);
    }
}
