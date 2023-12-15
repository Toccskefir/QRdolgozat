package com.example.qrdolgozat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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
    private List<Person> people = new ArrayList<>();
    private String helper;

    private class PersonAdapter extends ArrayAdapter<Person> {
        public PersonAdapter() { super(ListaAdatok.this, R.layout.person_list_adapter, people); }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.person_list_adapter, null, false);
            Person actualPerson = people.get(position);
            TextView textViewName = view.findViewById(R.id.textViewName);
            TextView textViewGrade = view.findViewById(R.id.textViewGrade);
            TextView textViewModify = view.findViewById(R.id.textViewModify);

            textViewName.setText(actualPerson.getName());
            textViewGrade.setText(actualPerson.getGrade());

            textViewModify.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    linearLayoutForm.setVisibility(View.VISIBLE);
                    editTextId.setText(String.valueOf(actualPerson.getId()));
                    editTextName.setText(actualPerson.getName());
                    editTextGrade.setText(actualPerson.getGrade());
                }
            });

            return view;
        }
    }

    public void init() {
        progressBar = findViewById(R.id.progressBar);
        linearLayoutForm = findViewById(R.id.linearLayoutForm);
        linearLayoutForm.setVisibility(View.GONE);
        editTextId = findViewById(R.id.editTextId);
        editTextName = findViewById(R.id.editTextName);
        editTextGrade = findViewById(R.id.editTextGrade);
        buttonModify = findViewById(R.id.buttonModify);
        buttonBack = findViewById(R.id.buttonBack);
        listViewData = findViewById(R.id.listViewData);
        listViewData.setAdapter(new PersonAdapter());

        sharedPreferences = getSharedPreferences("Data",
                Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        helper = sharedPreferences.getString("adat", "Üres");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_adatok);
        init();
    }
}