package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoggedInActivity extends AppCompatActivity {

    private TextView tvTeljesNev;
    private Button btnKijelentkezes;
    private DBhelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        init();

        //TODO
        //tvTeljesNev.setText();

        btnKijelentkezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kijelentkezes = new Intent(LoggedInActivity.this, MainActivity.class);
                startActivity(kijelentkezes);
                finish();
            }
        });

    }

    private void init() {
        tvTeljesNev = findViewById(R.id.tv_logged_in_teljes_nev);

        btnKijelentkezes = findViewById(R.id.btn_logged_in_kijeletkezes);

        adatbazis = new DBhelper(LoggedInActivity.this);
    }
}