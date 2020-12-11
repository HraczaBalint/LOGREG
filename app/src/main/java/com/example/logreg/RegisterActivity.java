package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText etEmail, etFelhasznaloNev, etJelszo, etTeljesNev;
    private Button btnRegisztracio, btnVissza;
    private DBhelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();

        btnVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vissza = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(vissza);
                finish();
            }
        });

        btnRegisztracio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regisztracio();
            }
        });
    }

    private void regisztracio() {
        String email = etEmail.getText().toString().trim();
        String felhasznaloNev = etFelhasznaloNev.getText().toString().trim();
        String jelszo = etJelszo.getText().toString().trim();
        String teljesNev = etTeljesNev.getText().toString().trim();

        if (email.isEmpty()) {
            Toast.makeText(this, "E-mail kitöltése kötelező!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (felhasznaloNev.isEmpty()) {
            Toast.makeText(this, "Felhasználónév kitöltése kötelező!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (jelszo.isEmpty()) {
            Toast.makeText(this, "Jelszó kitöltése kötelező!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (teljesNev.isEmpty()) {
            Toast.makeText(this, "Teljes név kitöltése kötelező!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (adatbazis.regisztracio(email, felhasznaloNev, jelszo, teljesNev)) {
            Toast.makeText(this, "Sikeres regisztració!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Sikertelen regisztráció!", Toast.LENGTH_SHORT).show();
        }
    }

    private void init() {
        etEmail = findViewById(R.id.et_register_email);
        etFelhasznaloNev = findViewById(R.id.et_register_felhasznalonev);
        etJelszo = findViewById(R.id.et_register_jelszo);
        etTeljesNev = findViewById(R.id.et_register_teljes_nev);

        btnRegisztracio = findViewById(R.id.btn_register_regisztracio);
        btnVissza = findViewById(R.id.btn_register_vissza);

        adatbazis = new DBhelper(RegisterActivity.this);
    }
}