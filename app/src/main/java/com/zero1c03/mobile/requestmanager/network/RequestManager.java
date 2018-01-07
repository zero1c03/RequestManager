package com.zero1c03.mobile.requestmanager.network;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.zero1c03.mobile.requestmanager.ApplicationController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zero1 on 2018/1/7.
 */

public class RequestManager {
    private RequestQueue queue;
    private static volatile RequestManager instance;

    private RequestManager() {
        queue = Volley.newRequestQueue(ApplicationController.getInstance());
    }

    public static RequestManager getInstance() {
        if (instance == null) {
            synchronized (RequestManager.class) {
                if (instance == null) {
                    instance = new RequestManager();
                }
            }
        }
        return instance;
    }

    public RequestQueue getRequwstQueue() {
        return queue;
    }

    public <T> void sendGet(String url, Class<T> clazz, final ApiCallback<T> listener) {
        ApiRequest<T> request = new ApiRequest<T>(url, clazz, new Response.Listener<T>() {
            @Override
            public void onResponse(T response) {
                listener.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError(error.getMessage());
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                // Put header params here.
                Map<String, String> params = new HashMap<>();
                //params.put("Authorization", getAuthorizationToken());
                return params;
            }
        };
        addToRequestQueue(request);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setRetryPolicy((new DefaultRetryPolicy(1500, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)));
        getRequwstQueue().add(req);
    }

}
