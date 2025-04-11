package com.example.a4x4xo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class DifficultySelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_selection);

        Button btnEasy = findViewById(R.id.btnEasy);
        Button btnMedium = findViewById(R.id.btnMedium);
        Button btnHard = findViewById(R.id.btnHard);

        btnEasy.setOnClickListener(v -> startGame("EASY"));
        btnMedium.setOnClickListener(v -> startGame("MEDIUM"));
        btnHard.setOnClickListener(v -> startGame("HARD"));
    }

    private void startGame(String difficulty) {
        Intent intent = new Intent(DifficultySelectionActivity.this, PvP.class);
        intent.putExtra("DIFFICULTY_LEVEL", difficulty);
        startActivity(intent);
    }
}