package com.zero1c03.mobile.requestmanager.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zero1c03.mobile.requestmanager.R;

public class BasePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_page);
    }
}
