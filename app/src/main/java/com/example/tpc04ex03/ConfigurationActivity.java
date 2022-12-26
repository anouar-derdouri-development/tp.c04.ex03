package com.example.tpc04ex03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConfigurationActivity extends AppCompatActivity {
    EditText etMin, etMax;
    Button btnConfOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        etMin = findViewById(R.id.etMin);
        etMax = findViewById(R.id.etMax);
        btnConfOK = findViewById(R.id.btnConfOK);

        etMin.setText(String.valueOf(GameActivity.min));
        etMax.setText(String.valueOf(GameActivity.max));

        btnConfOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int minDonne = Integer.parseInt(etMin.getText().toString());
                    int maxDonne = Integer.parseInt(etMax.getText().toString());

                    if (minDonne == maxDonne)
                        Toast.makeText(ConfigurationActivity.this, "min et max doivent être différente !!!", Toast.LENGTH_LONG).show();
                    else if (minDonne > maxDonne)
                        Toast.makeText(ConfigurationActivity.this, "min doit être inf. strictement à max !!!", Toast.LENGTH_LONG).show();
                    else {
                        GameActivity.min = minDonne;
                        GameActivity.max = maxDonne;

                        finish();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(ConfigurationActivity.this, "Il faut saisir des entiers !!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}