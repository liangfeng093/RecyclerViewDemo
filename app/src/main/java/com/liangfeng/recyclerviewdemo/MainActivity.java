package com.liangfeng.recyclerviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1= (Button) findViewById(R.id.btn_1);
        Button btn2= (Button) findViewById(R.id.btn_2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_1:
                Intent intent = new Intent(MainActivity.this, DemoActivity1.class);
                startActivity(intent);
                break;
             case R.id.btn_2:
                Intent intent1 = new Intent(MainActivity.this, DemoActivity2.class);
                startActivity(intent1);

                break;

        }
    }
}
