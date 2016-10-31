package com.jollytris.rxbussample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.label);

        RxBus.get().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister(this);
    }

    public void click1(View v) {
        RxBus.get().post("TAG1", "HaHaHa!");
    }

    public void click2(View v) {
        startActivity(new Intent(this, Main2Activity.class));
    }

    @Subscribe(tags = @Tag("TAG1"))
    public void subscribe1(String post) {
        textView.setText(post);
    }

    @Subscribe(tags = @Tag("PostFromMain2"))
    public void subscribe3(String post) {
        textView.setText(post);
    }
}
