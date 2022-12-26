package com.example.tpc04ex03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    int nombreAleatoire;
    public static int min = 10,
            max = 30;
    EditText etNombre;
    TextView tvMessage;
    Button btnOK, btnConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        nombreAleatoire = new Random().nextInt((max - min) + 1) + min;

        etNombre = findViewById(R.id.etNombre);
        tvMessage = findViewById(R.id.tvMessage);
        btnOK = findViewById(R.id.btnOK);
        btnConfiguration = findViewById(R.id.btnConfiguration);

        tvMessage.setText(String.format("Deviner un entier entre %d et %d", min, max));

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int nombreDonne = Integer.parseInt(etNombre.getText().toString());

                    if (nombreDonne == nombreAleatoire) {
                        Toast.makeText(GameActivity.this, "BRAVO", Toast.LENGTH_LONG).show();
                        nombreAleatoire = new Random().nextInt((max - min) + 1) + min;
                    } else {
                        if (nombreDonne < nombreAleatoire)
                            Toast.makeText(GameActivity.this, "PLUS GRAND", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(GameActivity.this, "PLUS PETIT", Toast.LENGTH_LONG).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(GameActivity.this, "Vous devez saisir un entier !!!", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnConfiguration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameActivity.this, ConfigurationActivity.class);

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        tvMessage.setText(String.format("Deviner un entier entre %d et %d", min, max));

        nombreAleatoire = new Random().nextInt((max - min) + 1) + min;
    }
}