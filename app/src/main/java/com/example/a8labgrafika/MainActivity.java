package com.example.a8labgrafika;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeFrag(View view) {
        EditText text = findViewById(R.id.input_number);
        String txt = String.valueOf(text.getText());
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, DrawFragment.newInstance(txt)).commit();
    }
}