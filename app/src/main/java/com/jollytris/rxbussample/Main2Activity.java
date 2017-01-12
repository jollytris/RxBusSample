package com.jollytris.rxbussample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hwangjr.rxbus.RxBus;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void refreshText(View v) {
        RxBus.get().post("PostFromMain2", "Text from Main2Activity");
        // Feature 02
    }
}
