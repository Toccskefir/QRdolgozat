package com.example.qrdolgozat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button buttonScan;
    private Button buttonList;
    private TextView textView;

    public void init() {
        buttonScan = findViewById(R.id.buttonScan);
        buttonList = findViewById(R.id.buttonList);
        textView = findViewById(R.id.textView);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
}