package com.minixplore.firebase.a8x8ledmatrixapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText DisplayText;
    private Button SendButton;
    //private ImageView im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayText = (EditText) findViewById(R.id.displayText);
        SendButton = (Button) findViewById(R.id.displayButton);
        FirebaseDatabase dataBase = FirebaseDatabase.getInstance();
        final DatabaseReference displaytext = dataBase.getReference("Scrolling_Text");

        SendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String baseValue = DisplayText.getText().toString();
                displaytext.setValue(baseValue);
            }
        });
    }
}
