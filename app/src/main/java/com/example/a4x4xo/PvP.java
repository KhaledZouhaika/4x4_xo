package com.example.a4x4xo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PvP extends AppCompatActivity {

    private Button[][] buttons = new Button[4][4];
    private boolean playerTurn = true; // Player starts first
    private Difficulty difficultyLevel = Difficulty.MEDIUM; // Default to Medium
    private TextView statusTextView;

    private enum Difficulty {
        EASY,
        MEDIUM,
        HARD
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvp);

        // Get difficulty level from intent
        String difficulty = getIntent().getStringExtra("DIFFICULTY_LEVEL");
        statusTextView = findViewById(R.id.statusTextView);
        switch (difficulty) {
            case "EASY":
                difficultyLevel = Difficulty.EASY;
                break;
            case "MEDIUM":
                difficultyLevel = Difficulty.MEDIUM;
                break;
            case "HARD":
                difficultyLevel = Difficulty.HARD;
                break;
        }

        statusTextView.setText("Difficulty: " + difficulty);

        GridLayout gridLayout = findViewById(R.id.gridLayout);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String buttonID = "button" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this::onCellClick);
            }
        }

        Button restartButton = findViewById(R.id.restartButton);
        restartButton.setOnClickListener(v -> resetBoard());
    }

    private void onCellClick(View v) {
        if (!((Button) v).getText().toString().equals("") || !playerTurn) return;

        ((Button) v).setText("X");
        if (checkForWin("X")) {
            statusTextView.setText("You Win!");
            disableBoard();
            return;
        }

        if (isBoardFull()) {
            statusTextView.setText("Draw!");
            return;
        }

        playerTurn = false;
        aiMove();
    }

    private void aiMove() {
        switch (difficultyLevel) {
            case EASY:
                makeRandomMove(); // Random moves for Easy mode
                break;
            case MEDIUM:
                if (!blockPlayer()) { // Try to block the player, otherwise make a random move
                    makeRandomMove();
                }
                break;
            case HARD:
                if (new Random().nextInt(10) == 0) { // 10% chance for random move in Hard mode
                    makeRandomMove();
                } else {
                    if (!blockPlayer()) { // Block the player if needed, otherwise make a random move
                        makeRandomMove();
                    }
                }
                break;
        }

        if (checkForWin("O")) {
            statusTextView.setText("AI Wins!");
            disableBoard();
        } else if (isBoardFull()) {
            statusTextView.setText("Draw!");
        } else {
            playerTurn = true;
        }
    }

    private void makeRandomMove() {
        List<Button> availableButtons = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (buttons[i][j].getText().toString().equals("")) {
                    availableButtons.add(buttons[i][j]);
                }
            }
        }
        if (!availableButtons.isEmpty()) {
            Button randomButton = availableButtons.get(new Random().nextInt(availableButtons.size()));
            randomButton.setText("O");
        }
    }

    private boolean blockPlayer() {
        // The AI will block the player when they are one move away from winning
        // It checks each row, column, and diagonal for a winning move and blocks it

        // Check each row
        for (int i = 0; i < 4; i++) {
            int playerCount = 0, emptyCount = 0;
            Button emptyButton = null;
            for (int j = 0; j < 4; j++) {
                if (buttons[i][j].getText().toString().equals("X")) playerCount++;
                if (buttons[i][j].getText().toString().equals("")) {
                    emptyCount++;
                    emptyButton = buttons[i][j];
                }
            }
            if (playerCount == 3 && emptyCount == 1) {
                emptyButton.setText("O");
                return true;
            }
        }

        // Check each column
        for (int j = 0; j < 4; j++) {
            int playerCount = 0, emptyCount = 0;
            Button emptyButton = null;
            for (int i = 0; i < 4; i++) {
                if (buttons[i][j].getText().toString().equals("X")) playerCount++;
                if (buttons[i][j].getText().toString().equals("")) {
                    emptyCount++;
                    emptyButton = buttons[i][j];
                }
            }
            if (playerCount == 3 && emptyCount == 1) {
                emptyButton.setText("O");
                return true;
            }
        }

        // Check diagonals
        if (buttons[0][0].getText().toString().equals("X") && buttons[1][1].getText().toString().equals("X") &&
                buttons[2][2].getText().toString().equals("X") && buttons[3][3].getText().toString().equals("")) {
            buttons[3][3].setText("O");
            return true;
        }
        if (buttons[0][3].getText().toString().equals("X") && buttons[1][2].getText().toString().equals("X") &&
                buttons[2][1].getText().toString().equals("X") && buttons[3][0].getText().toString().equals("")) {
            buttons[3][0].setText("O");
            return true;
        }

        return false; // No need to block if no winning move is available for player
    }

    private boolean checkForWin(String symbol) {
        // Check rows
        for (int i = 0; i < 4; i++) {
            if (buttons[i][0].getText().toString().equals(symbol) &&
                    buttons[i][1].getText().toString().equals(symbol) &&
                    buttons[i][2].getText().toString().equals(symbol) &&
                    buttons[i][3].getText().toString().equals(symbol)) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 4; j++) {
            if (buttons[0][j].getText().toString().equals(symbol) &&
                    buttons[1][j].getText().toString().equals(symbol) &&
                    buttons[2][j].getText().toString().equals(symbol) &&
                    buttons[3][j].getText().toString().equals(symbol)) {
                return true;
            }
        }

        // Check diagonals
        if (buttons[0][0].getText().toString().equals(symbol) &&
                buttons[1][1].getText().toString().equals(symbol) &&
                buttons[2][2].getText().toString().equals(symbol) &&
                buttons[3][3].getText().toString().equals(symbol)) {
            return true;
        }

        if (buttons[0][3].getText().toString().equals(symbol) &&
                buttons[1][2].getText().toString().equals(symbol) &&
                buttons[2][1].getText().toString().equals(symbol) &&
                buttons[3][0].getText().toString().equals(symbol)) {
            return true;
        }

        return false;
    }

    private boolean isBoardFull() {
        for (Button[] row : buttons) {
            for (Button button : row) {
                if (button.getText().toString().equals("")) return false;
            }
        }
        return true;
    }

    private void disableBoard() {
        for (Button[] row : buttons) {
            for (Button button : row) {
                button.setEnabled(false);
            }
        }
    }

    private void resetBoard() {
        for (Button[] row : buttons) {
            for (Button button : row) {
                button.setText("");
                button.setEnabled(true);
            }
        }
        playerTurn = true;
        statusTextView.setText("Tic-Tac-Toe Game");
    }
}