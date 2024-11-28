package com.example.a4x4xo;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a4x4xo.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPlayWithAI = findViewById(R.id.btnPlayWithAI);
        Button btnmathedi = findViewById(R.id.mathedi);
        Button btngeneraledi = findViewById(R.id.generaledi);

        // Play with AI - Navigate to Difficulty Selection
        btnPlayWithAI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DifficultySelectionActivity.class);
                startActivity(intent);
            }
        });

        // Play with Friend
        btnmathedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ModeSelectionActivity.class);
                startActivity(intent);
            }
        });
        btngeneraledi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GeneralQ.class);
                startActivity(intent);
            }
        });
    }
}