package com.example.a4x4xo;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ModeSelectionActivity extends AppCompatActivity {

    private String currentPlayer = "X";
    private Button[][] buttons = new Button[4][4];
    private TextView playerTurn, timerTextView;
    private List<Question> questionList;
    private Random random;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }else {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_selection);


        playerTurn = findViewById(R.id.playerTurn);
        timerTextView = findViewById(R.id.timerTextView);
        GridLayout gridLayout = findViewById(R.id.gridLayout);

        random = new Random();
        questionList = new ArrayList<>();
        questionList.add(new Question("What is 5 + 3?", new String[]{"7", "8", "6", "9"}, "8"));
        questionList.add(new Question("What is 10 + 4?", new String[]{"14", "13", "15", "12"}, "14"));
        questionList.add(new Question("What is 7 + 6?", new String[]{"12", "11", "13", "10"}, "13"));
        questionList.add(new Question("What is 3 + 9?", new String[]{"11", "12", "10", "9"}, "12"));
        questionList.add(new Question("What is 15 + 3?", new String[]{"16", "18", "17", "19"}, "18"));
        questionList.add(new Question("What is 2 + 8?", new String[]{"9", "10", "8", "11"}, "10"));
        questionList.add(new Question("What is 12 + 5?", new String[]{"16", "17", "18", "15"}, "17"));
        questionList.add(new Question("What is 6 + 7?", new String[]{"13", "14", "12", "15"}, "13"));
        questionList.add(new Question("What is 11 + 9?", new String[]{"19", "18", "20", "21"}, "20"));
        questionList.add(new Question("What is 14 + 6?", new String[]{"21", "20", "18", "22"}, "20"));
        questionList.add(new Question("What is 9 - 4?", new String[]{"4", "5", "6", "3"}, "5"));
        questionList.add(new Question("What is 15 - 7?", new String[]{"8", "7", "9", "6"}, "8"));
        questionList.add(new Question("What is 10 - 3?", new String[]{"7", "6", "8", "9"}, "7"));
        questionList.add(new Question("What is 18 - 9?", new String[]{"9", "10", "8", "11"}, "9"));
        questionList.add(new Question("What is 12 - 6?", new String[]{"5", "7", "6", "8"}, "6"));
        questionList.add(new Question("What is 20 - 8?", new String[]{"12", "13", "14", "11"}, "12"));
        questionList.add(new Question("What is 16 - 4?", new String[]{"12", "11", "13", "15"}, "12"));
        questionList.add(new Question("What is 14 - 5?", new String[]{"9", "8", "10", "7"}, "9"));
        questionList.add(new Question("What is 11 - 7?", new String[]{"4", "3", "5", "6"}, "4"));
        questionList.add(new Question("What is 13 - 8?", new String[]{"4", "5", "6", "3"}, "5"));
        questionList.add(new Question("What is 2 × 3?", new String[]{"5", "6", "7", "4"}, "6"));
        questionList.add(new Question("What is 4 × 2?", new String[]{"7", "6", "8", "9"}, "8"));
        questionList.add(new Question("What is 5 × 5?", new String[]{"10", "25", "20", "15"}, "25"));
        questionList.add(new Question("What is 7 × 3?", new String[]{"20", "24", "21", "22"}, "21"));
        questionList.add(new Question("What is 8 × 2?", new String[]{"16", "18", "20", "15"}, "16"));
        questionList.add(new Question("What is 3 × 3?", new String[]{"6", "8", "9", "7"}, "9"));
        questionList.add(new Question("What is 9 × 2?", new String[]{"16", "18", "20", "15"}, "18"));
        questionList.add(new Question("What is 6 × 5?", new String[]{"28", "30", "25", "32"}, "30"));
        questionList.add(new Question("What is 4 × 4?", new String[]{"12", "14", "16", "18"}, "16"));
        questionList.add(new Question("What is 10 × 3?", new String[]{"28", "30", "32", "25"}, "30"));
        questionList.add(new Question("What is 10 ÷ 2?", new String[]{"4", "5", "6", "7"}, "5"));
        questionList.add(new Question("What is 15 ÷ 3?", new String[]{"4", "5", "6", "7"}, "5"));
        questionList.add(new Question("What is 18 ÷ 6?", new String[]{"2", "3", "4", "5"}, "3"));
        questionList.add(new Question("What is 12 ÷ 4?", new String[]{"2", "3", "4", "5"}, "3"));
        questionList.add(new Question("What is 20 ÷ 5?", new String[]{"3", "4", "5", "6"}, "5"));
        questionList.add(new Question("What is 16 ÷ 4?", new String[]{"3", "4", "5", "6"}, "4"));
        questionList.add(new Question("What is 8 ÷ 2?", new String[]{"3", "4", "5", "6"}, "4"));
        questionList.add(new Question("What is 9 ÷ 3?", new String[]{"2", "3", "4", "5"}, "3"));
        questionList.add(new Question("What is 14 ÷ 2?", new String[]{"5", "6", "7", "8"}, "7"));
        questionList.add(new Question("What is 6 ÷ 1?", new String[]{"4", "5", "6", "7"}, "6"));
        questionList.add(new Question("What is 7 + 8?", new String[]{"13", "14", "15", "16"}, "15"));
        questionList.add(new Question("What is 20 - 5?", new String[]{"13", "14", "15", "16"}, "15"));
        questionList.add(new Question("What is 3 × 6?", new String[]{"18", "16", "20", "24"}, "18"));
        questionList.add(new Question("What is 30 ÷ 6?", new String[]{"4", "5", "6", "7"}, "5"));
        questionList.add(new Question("What is 13 + 4?", new String[]{"17", "16", "18", "19"}, "17"));
        questionList.add(new Question("What is 15 - 3?", new String[]{"13", "12", "10", "11"}, "12"));
        questionList.add(new Question("What is 6 × 4?", new String[]{"20", "24", "26", "22"}, "24"));
        questionList.add(new Question("What is 25 ÷ 5?", new String[]{"5", "6", "7", "4"}, "5"));
        questionList.add(new Question("What is 9 + 8?", new String[]{"15", "16", "17", "18"}, "17"));
        questionList.add(new Question("What is 19 - 7?", new String[]{"13", "12", "11", "10"}, "12"));
        questionList.add(new Question("What is 4 × 7?", new String[]{"26", "28", "25", "30"}, "28"));
        questionList.add(new Question("What is 18 ÷ 2?", new String[]{"8", "9", "7", "6"}, "9"));
        questionList.add(new Question("What is 12 + 9?", new String[]{"21", "20", "19", "18"}, "21"));
        questionList.add(new Question("What is 17 - 8?", new String[]{"8", "9", "10", "7"}, "9"));
        questionList.add(new Question("What is 5 × 6?", new String[]{"30", "28", "32", "35"}, "30"));
        questionList.add(new Question("What is 24 ÷ 4?", new String[]{"5", "6", "7", "8"}, "6"));
        questionList.add(new Question("What is 6 + 15?", new String[]{"19", "20", "21", "22"}, "21"));
        questionList.add(new Question("What is 22 - 11?", new String[]{"9", "10", "11", "12"}, "11"));
        questionList.add(new Question("What is 3 × 8?", new String[]{"23", "24", "25", "26"}, "24"));
        questionList.add(new Question("What is 27 ÷ 9?", new String[]{"2", "3", "4", "5"}, "3"));
        questionList.add(new Question("What is the square of 5?", new String[]{"20", "25", "30", "15"}, "25"));
        questionList.add(new Question("What is the square of 4?", new String[]{"12", "16", "14", "18"}, "16"));
        questionList.add(new Question("What is the square root of 49?", new String[]{"6", "7", "8", "9"}, "7"));
        questionList.add(new Question("What is the square of 3?", new String[]{"6", "8", "9", "7"}, "9"));
        questionList.add(new Question("What is the square root of 64?", new String[]{"6", "7", "8", "9"}, "8"));
        questionList.add(new Question("What is the square of 6?", new String[]{"35", "36", "32", "30"}, "36"));
        questionList.add(new Question("What is the square root of 25?", new String[]{"3", "4", "5", "6"}, "5"));
        questionList.add(new Question("What is the square of 2?", new String[]{"2", "4", "3", "5"}, "4"));
        questionList.add(new Question("What is the square root of 81?", new String[]{"8", "9", "10", "7"}, "9"));
        questionList.add(new Question("What is the square of 7?", new String[]{"48", "49", "50", "52"}, "49"));
        questionList.add(new Question("What is 1/2 of 10?", new String[]{"4", "5", "6", "7"}, "5"));
        questionList.add(new Question("What is 1/3 of 9?", new String[]{"2", "3", "4", "3"}, "3"));
        questionList.add(new Question("What is 1/4 of 20?", new String[]{"4", "5", "6", "8"}, "5"));
        questionList.add(new Question("What is 3/4 of 12?", new String[]{"6", "7", "8", "9"}, "8"));
        questionList.add(new Question("What is 1/5 of 25?", new String[]{"5", "6", "4", "7"}, "5"));
        questionList.add(new Question("What is 1/2 of 8?", new String[]{"2", "3", "4", "5"}, "4"));
        questionList.add(new Question("What is 1/3 of 6?", new String[]{"1", "2", "3", "4"}, "2"));
        questionList.add(new Question("What is 2/5 of 10?", new String[]{"3", "4", "5", "6"}, "5"));
        questionList.add(new Question("What is 3/4 of 8?", new String[]{"5", "6", "7", "6"}, "6"));
        questionList.add(new Question("What is 1/2 of 16?", new String[]{"6", "8", "10", "12"}, "8"));
        questionList.add(new Question("What is 100 - 30?", new String[]{"60", "70", "80", "70"}, "70"));
        questionList.add(new Question("What is 40 + 30?", new String[]{"60", "70", "80", "70"}, "70"));
        questionList.add(new Question("What is 2 × 0?", new String[]{"0", "1", "2", "4"}, "0"));
        questionList.add(new Question("What is 10 ÷ 10?", new String[]{"0", "1", "2", "10"}, "1"));
        questionList.add(new Question("What is 5 - 3 + 2?", new String[]{"4", "5", "6", "7"}, "5"));
        questionList.add(new Question("What is 3 × 3 + 4?", new String[]{"10", "13", "14", "15"}, "13"));
        questionList.add(new Question("What is 12 ÷ 2 + 6?", new String[]{"9", "8", "7", "6"}, "9"));
        questionList.add(new Question("What is 8 × 1 - 2?", new String[]{"5", "6", "8", "6"}, "6"));
        questionList.add(new Question("What is 20 ÷ 5 + 2?", new String[]{"6", "5", "4", "8"}, "6"));
        questionList.add(new Question("What is 15 + 15 - 10?", new String[]{"15", "20", "25", "10"}, "15"));
        questionList.add(new Question("What is 2 × 10 - 5?", new String[]{"15", "20", "25", "10"}, "15"));
        questionList.add(new Question("What is 18 ÷ 6 + 4?", new String[]{"6", "8", "9", "10"}, "6"));
        questionList.add(new Question("What is 20 - 3 × 3?", new String[]{"11", "13", "14", "17"}, "11"));
        questionList.add(new Question("What is 8 + 6 - 4?", new String[]{"10", "11", "9", "8"}, "10"));
        questionList.add(new Question("What is 4 × 4 - 6?", new String[]{"10", "11", "12", "9"}, "10"));
        questionList.add(new Question("What is 2 × 4 + 3?", new String[]{"10", "11", "9", "12"}, "10"));
        questionList.add(new Question("What is 15 ÷ 3 + 5?", new String[]{"10", "11", "12", "9"}, "10"));
        questionList.add(new Question("What is 10 × 2 ÷ 5?", new String[]{"3", "4", "5", "6"}, "5"));
        questionList.add(new Question("What is 18 + 2 × 3?", new String[]{"24", "22", "20", "26"}, "24"));
        questionList.add(new Question("What is 8 × 3 ÷ 4?", new String[]{"4", "5", "6", "7"}, "4"));

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String buttonID = "button" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (((Button) v).getText().toString().equals("")) { // Check if button is empty
                            showQuizDialog((Button) v);
                        } else {
                            Toast.makeText(ModeSelectionActivity.this, "This spot is already taken!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }

    }

    private void showQuizDialog(Button button) {
        Question question = questionList.get(random.nextInt(questionList.size()));

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Answer to Play");
        builder.setMessage(question.getQuestionText());

        final RadioGroup radioGroup = new RadioGroup(this);
        for (String answer : question.getAnswers()) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(answer);
            radioGroup.addView(radioButton);
        }
        builder.setView(radioGroup);

        final CountDownTimer timer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText("Time left: " + millisUntilFinished / 1000 + "s");
            }

            @Override
            public void onFinish() {
                Toast.makeText(ModeSelectionActivity.this, "Time's up! Turn skipped.", Toast.LENGTH_SHORT).show();
                togglePlayer();
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
                timerTextView.setText("");
            }
        };

        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                timer.cancel();

                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId != -1) {
                    RadioButton selectedRadioButton = radioGroup.findViewById(selectedId);
                    String selectedAnswer = selectedRadioButton.getText().toString();

                    if (selectedAnswer.equals(question.getCorrectAnswer())) {
                        placeMarker(button);
                    } else {
                        Toast.makeText(ModeSelectionActivity.this, "Incorrect! Turn skipped.", Toast.LENGTH_SHORT).show();
                        togglePlayer();
                    }
                }
                timerTextView.setText("");
            }
        });

        builder.setCancelable(false);
        dialog = builder.create();
        dialog.show();

        final Button submitButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        submitButton.setEnabled(false);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                submitButton.setEnabled(true);
            }
        });

        timer.start();
    }
    private void togglePlayer() {
        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
        playerTurn.setText("Player " + currentPlayer + "'s Turn");
    }

    private void placeMarker(Button button) {
        button.setText(currentPlayer);
        if (checkWin()) {
            Toast.makeText(this, currentPlayer + " wins!", Toast.LENGTH_SHORT).show();
            resetBoard();
        } else {
            togglePlayer();
        }
    }

    private boolean checkWin() {
        for (int i = 0; i < 4; i++) {
            if (buttons[i][0].getText().equals(currentPlayer) &&
                    buttons[i][1].getText().equals(currentPlayer) &&
                    buttons[i][2].getText().equals(currentPlayer) &&
                    buttons[i][3].getText().equals(currentPlayer)) {
                return true;
            }
            if (buttons[0][i].getText().equals(currentPlayer) &&
                    buttons[1][i].getText().equals(currentPlayer) &&
                    buttons[2][i].getText().equals(currentPlayer) &&
                    buttons[3][i].getText().equals(currentPlayer)) {
                return true;
            }
        }

        if (buttons[0][0].getText().equals(currentPlayer) &&
                buttons[1][1].getText().equals(currentPlayer) &&
                buttons[2][2].getText().equals(currentPlayer) &&
                buttons[3][3].getText().equals(currentPlayer)) {
            return true;
        }
        if (buttons[0][3].getText().equals(currentPlayer) &&
                buttons[1][2].getText().equals(currentPlayer) &&
                buttons[2][1].getText().equals(currentPlayer) &&
                buttons[3][0].getText().equals(currentPlayer)) {
            return true;
        }

        return false;
    }

    private void resetBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                buttons[i][j].setText("");
            }
        }
        currentPlayer = "X";
        playerTurn.setText("Player X's Turn");
    }

    private class Question {
        private String questionText;
        private String[] answers;
        private String correctAnswer;

        public Question(String questionText, String[] answers, String correctAnswer) {
            this.questionText = questionText;
            this.answers = answers;
            this.correctAnswer = correctAnswer;
        }

        public String getQuestionText() {
            return questionText;
        }

        public String[] getAnswers() {
            return answers;
        }

        public String getCorrectAnswer() {
            return correctAnswer;
        }
    }
}