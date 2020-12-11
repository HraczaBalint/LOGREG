package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etFelhasznaloNev, etJelszo;
    private Button btnBejelentkezes, btnRegisztracio;
    private DBhelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnRegisztracio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regisztracio = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(regisztracio);
                finish();
            }
        });

        btnBejelentkezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bejelentkezes();
            }
        });
    }

    private void bejelentkezes() {
        String felhasznalonev = etFelhasznaloNev.getText().toString().trim();
        String jelszo = etJelszo.getText().toString().trim();

        if (felhasznalonev.isEmpty()) {
            Toast.makeText(this, "Felhasználónév kitöltése kötelező!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (jelszo.isEmpty()) {
            Toast.makeText(this, "Jelszo kitöltése kötelező!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!adatbazis.bejeletkezes(felhasznalonev, jelszo)) {
            Toast.makeText(this, "Sikertelen bejeletnkezés!", Toast.LENGTH_SHORT).show();
        }
    }

    private void init() {
        etFelhasznaloNev = findViewById(R.id.et_main_felhnev);
        etJelszo = findViewById(R.id.et_main_jelszo);

        btnBejelentkezes = findViewById(R.id.btn_main_bejelentkezes);
        btnRegisztracio = findViewById(R.id.btn_main_regisztracio);

        adatbazis = new DBhelper(MainActivity.this);
    }
}