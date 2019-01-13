package com.zero1c03.mobile.requestmanager.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.zero1c03.mobile.requestmanager.R;
import com.zero1c03.mobile.requestmanager.api.GetTimeAPI;
import com.zero1c03.mobile.requestmanager.model.TimeModel;
import com.zero1c03.mobile.requestmanager.network.ApiCallback;
import com.zero1c03.mobile.requestmanager.network.RequestManager;

public class BasePageActivity extends AppCompatActivity {

    private TextView nowTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_page);
        initUI();
        getNowTime();
    }

    private void initUI() {
        nowTime = findViewById(R.id.now_time);
    }

    private void getNowTime() {
        GetTimeAPI.getTime(new ApiCallback<TimeModel>() {
            @Override
            public void onSuccess(TimeModel result) {
                Logger.d(result.getCurrentDateTime());
                nowTime.setText(result.getCurrentDateTime());
            }

            @Override
            public void onError(String errorMsg) {
                Logger.d(errorMsg);
            }
        });
    }
}
