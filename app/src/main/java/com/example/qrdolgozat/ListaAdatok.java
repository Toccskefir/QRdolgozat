package com.example.qrdolgozat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;

public class ListaAdatok extends AppCompatActivity {
    private ProgressBar progressBar;
    private LinearLayout linearLayoutForm;
    private EditText editTextId;
    private EditText editTextName;
    private EditText editTextGrade;
    private Button buttonModify;
    private Button buttonBack;
    private ListView listViewData;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public void init() {
        progressBar = findViewById(R.id.progressBar);
        linearLayoutForm = findViewById(R.id.linearLayoutForm);
        editTextId = findViewById(R.id.editTextId);
        editTextName = findViewById(R.id.editTextName);
        editTextGrade = findViewById(R.id.editTextGrade);
        buttonModify = findViewById(R.id.buttonModify);
        buttonBack = findViewById(R.id.buttonBack);
        listViewData = findViewById(R.id.listViewData);

        sharedPreferences = getSharedPreferences("Data",
                Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_adatok);
        init();
    }
}