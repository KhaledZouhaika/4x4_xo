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

public class GeneralQ extends AppCompatActivity {

    private String currentPlayer = "X";
    private Button[][] buttons = new Button[4][4];
    private TextView playerTurn, timerTextView;
    private List<GeneralQ.Question> questionList;
    private Random random;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);


        playerTurn = findViewById(R.id.playerTurn);
        timerTextView = findViewById(R.id.timerTextView);
        GridLayout gridLayout = findViewById(R.id.gridLayout);

        random = new Random();
        questionList = new ArrayList<>();
        questionList.add(new Question("What is the capital of France?", new String[]{"Berlin", "Madrid", "Paris", "Rome"}, "Paris"));
        questionList.add(new Question("Which planet is known as the Red Planet?", new String[]{"Earth", "Venus", "Mars", "Jupiter"}, "Mars"));
        questionList.add(new Question("Who wrote 'Hamlet'?", new String[]{"Charles Dickens", "William Shakespeare", "Mark Twain", "Jane Austen"}, "William Shakespeare"));
        questionList.add(new Question("What is the largest ocean on Earth?", new String[]{"Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"}, "Pacific Ocean"));
        questionList.add(new Question("How many continents are there?", new String[]{"5", "6", "7", "8"}, "7"));
        questionList.add(new Question("Which animal is known as the 'King of the Jungle'?", new String[]{"Tiger", "Elephant", "Lion", "Leopard"}, "Lion"));
        questionList.add(new Question("Who painted the Mona Lisa?", new String[]{"Pablo Picasso", "Leonardo da Vinci", "Vincent van Gogh", "Claude Monet"}, "Leonardo da Vinci"));
        questionList.add(new Question("What is the boiling point of water in Celsius?", new String[]{"90°C", "100°C", "110°C", "120°C"}, "100°C"));
        questionList.add(new Question("Which country is famous for the Great Wall?", new String[]{"India", "China", "Japan", "Korea"}, "China"));
        questionList.add(new Question("Who was the first person to walk on the moon?", new String[]{"Neil Armstrong", "Buzz Aldrin", "Yuri Gagarin", "Michael Collins"}, "Neil Armstrong"));
        questionList.add(new Question("What is the smallest planet in our solar system?", new String[]{"Mars", "Venus", "Mercury", "Pluto"}, "Mercury"));
        questionList.add(new Question("Which gas do humans need to breathe?", new String[]{"Hydrogen", "Carbon Dioxide", "Oxygen", "Nitrogen"}, "Oxygen"));
        questionList.add(new Question("Which sport is known as 'the beautiful game'?", new String[]{"Basketball", "Tennis", "Soccer", "Cricket"}, "Soccer"));
        questionList.add(new Question("What is the tallest mountain in the world?", new String[]{"K2", "Mount Everest", "Kilimanjaro", "Denali"}, "Mount Everest"));
        questionList.add(new Question("Which continent is known as the Land Down Under?", new String[]{"Africa", "Europe", "Australia", "South America"}, "Australia"));
        questionList.add(new Question("What is the longest river in the world?", new String[]{"Amazon River", "Nile River", "Yangtze River", "Mississippi River"}, "Nile River"));
        questionList.add(new Question("Which element has the chemical symbol 'O'?", new String[]{"Gold", "Oxygen", "Osmium", "Iron"}, "Oxygen"));
        questionList.add(new Question("What is the national flower of Japan?", new String[]{"Rose", "Tulip", "Cherry Blossom", "Lotus"}, "Cherry Blossom"));
        questionList.add(new Question("How many bones are in the adult human body?", new String[]{"206", "208", "210", "212"}, "206"));
        questionList.add(new Question("Which famous scientist developed the theory of relativity?", new String[]{"Isaac Newton", "Nikola Tesla", "Albert Einstein", "Galileo Galilei"}, "Albert Einstein"));
        questionList.add(new Question("What is the hardest natural substance on Earth?", new String[]{"Gold", "Iron", "Diamond", "Platinum"}, "Diamond"));
        questionList.add(new Question("Which country gifted the Statue of Liberty to the United States?", new String[]{"France", "Germany", "United Kingdom", "Canada"}, "France"));
        questionList.add(new Question("Who discovered penicillin?", new String[]{"Alexander Fleming", "Marie Curie", "Louis Pasteur", "Joseph Lister"}, "Alexander Fleming"));
        questionList.add(new Question("Which desert is the largest in the world?", new String[]{"Sahara", "Gobi", "Antarctic", "Arabian"}, "Antarctic"));
        questionList.add(new Question("How many hearts does an octopus have?", new String[]{"1", "2", "3", "4"}, "3"));
        questionList.add(new Question("What is the capital of Japan?", new String[]{"Seoul", "Beijing", "Tokyo", "Bangkok"}, "Tokyo"));
        questionList.add(new Question("Who invented the telephone?", new String[]{"Alexander Graham Bell", "Thomas Edison", "Nikola Tesla", "Benjamin Franklin"}, "Alexander Graham Bell"));
        questionList.add(new Question("What is the closest star to Earth?", new String[]{"Sirius", "Alpha Centauri", "Betelgeuse", "The Sun"}, "The Sun"));
        questionList.add(new Question("What is the chemical symbol for gold?", new String[]{"Ag", "Au", "Pb", "Pt"}, "Au"));
        questionList.add(new Question("Which is the fastest land animal?", new String[]{"Cheetah", "Lion", "Horse", "Greyhound"}, "Cheetah"));
        questionList.add(new Question("What is the capital of Italy?", new String[]{"Milan", "Venice", "Rome", "Naples"}, "Rome"));
        questionList.add(new Question("What year did World War II end?", new String[]{"1943", "1944", "1945", "1946"}, "1945"));
        questionList.add(new Question("Which planet has the most moons?", new String[]{"Mars", "Jupiter", "Saturn", "Neptune"}, "Saturn"));
        questionList.add(new Question("What is the national animal of the United States?", new String[]{"Bald Eagle", "Bear", "Bison", "Wolf"}, "Bald Eagle"));
        questionList.add(new Question("What is the currency of the United Kingdom?", new String[]{"Euro", "Dollar", "Pound Sterling", "Yen"}, "Pound Sterling"));
        questionList.add(new Question("Which instrument has 88 keys?", new String[]{"Guitar", "Violin", "Piano", "Saxophone"}, "Piano"));
        questionList.add(new Question("Which language has the most native speakers?", new String[]{"English", "Mandarin Chinese", "Spanish", "Hindi"}, "Mandarin Chinese"));
        questionList.add(new Question("Who is known as the 'Father of Computers'?", new String[]{"Alan Turing", "Charles Babbage", "Bill Gates", "Steve Jobs"}, "Charles Babbage"));
        questionList.add(new Question("Which gas makes up the majority of Earth's atmosphere?", new String[]{"Oxygen", "Nitrogen", "Carbon Dioxide", "Hydrogen"}, "Nitrogen"));
        questionList.add(new Question("Which country is home to the Great Pyramid of Giza?", new String[]{"Greece", "Egypt", "Mexico", "India"}, "Egypt"));
        questionList.add(new Question("Which fictional detective lives at 221B Baker Street?", new String[]{"Hercule Poirot", "Sherlock Holmes", "Miss Marple", "Columbo"}, "Sherlock Holmes"));
        questionList.add(new Question("What does the 'E' stand for in 'E=mc²'?", new String[]{"Energy", "Electrons", "Efficiency", "Elasticity"}, "Energy"));
        questionList.add(new Question("Which U.S. state is known as the 'Sunshine State'?", new String[]{"California", "Florida", "Texas", "Arizona"}, "Florida"));
        questionList.add(new Question("What does DNA stand for?", new String[]{"Deoxyribonucleic Acid", "Dynamic Neural Algorithm", "Double Nuclear Acid", "Deep Nerve Activation"}, "Deoxyribonucleic Acid"));
        questionList.add(new Question("Which fruit has its seeds on the outside?", new String[]{"Banana", "Apple", "Strawberry", "Mango"}, "Strawberry"));
        questionList.add(new Question("What is the largest land animal?", new String[]{"Elephant", "Hippopotamus", "Rhinoceros", "Giraffe"}, "Elephant"));
        questionList.add(new Question("Who was the first President of the United States?", new String[]{"Thomas Jefferson", "Abraham Lincoln", "George Washington", "John Adams"}, "George Washington"));
        questionList.add(new Question("How many legs does a spider have?", new String[]{"6", "8", "10", "12"}, "8"));
        questionList.add(new Question("Which country is known as the Land of the Rising Sun?", new String[]{"China", "Japan", "South Korea", "Thailand"}, "Japan"));
        questionList.add(new Question("What is the name of the fairy in Peter Pan?", new String[]{"Tinker Bell", "Cinderella", "Ariel", "Belle"}, "Tinker Bell"));
        questionList.add(new Question("How many players are on a soccer team?", new String[]{"9", "10", "11", "12"}, "11"));
        questionList.add(new Question("What is the capital of Canada?", new String[]{"Toronto", "Vancouver", "Ottawa", "Montreal"}, "Ottawa"));
        questionList.add(new Question("Which is the smallest country in the world?", new String[]{"Vatican City", "Monaco", "Liechtenstein", "San Marino"}, "Vatican City"));
        questionList.add(new Question("What year did the Titanic sink?", new String[]{"1905", "1912", "1920", "1931"}, "1912"));
        questionList.add(new Question("What is the name of Batman's butler?", new String[]{"Jarvis", "Alfred", "Higgins", "Jeeves"}, "Alfred"));
        questionList.add(new Question("What is the capital of Germany?", new String[]{"Frankfurt", "Munich", "Berlin", "Hamburg"}, "Berlin"));
        questionList.add(new Question("Which Disney movie features a talking snowman named Olaf?", new String[]{"Frozen", "Tangled", "Moana", "The Little Mermaid"}, "Frozen"));
        questionList.add(new Question("Who wrote 'The Great Gatsby'?", new String[]{"Ernest Hemingway", "F. Scott Fitzgerald", "Mark Twain", "John Steinbeck"}, "F. Scott Fitzgerald"));
        questionList.add(new Question("What is the speed of light?", new String[]{"186,000 miles per second", "100,000 miles per second", "250,000 miles per second", "500,000 miles per second"}, "186,000 miles per second"));
        questionList.add(new Question("Which planet is known as the Red Planet?", new String[]{"Earth", "Mars", "Jupiter", "Venus"}, "Mars"));
        questionList.add(new Question("What is the largest ocean on Earth?", new String[]{"Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"}, "Pacific Ocean"));
        questionList.add(new Question("What is the capital of Australia?", new String[]{"Sydney", "Melbourne", "Canberra", "Brisbane"}, "Canberra"));
        questionList.add(new Question("Which famous ship sank after hitting an iceberg?", new String[]{"Titanic", "Lusitania", "Britannic", "Queen Mary"}, "Titanic"));
        questionList.add(new Question("Which gas do plants absorb from the atmosphere?", new String[]{"Oxygen", "Carbon Dioxide", "Nitrogen", "Hydrogen"}, "Carbon Dioxide"));
        questionList.add(new Question("Which is the longest bone in the human body?", new String[]{"Femur", "Tibia", "Humerus", "Fibula"}, "Femur"));
        questionList.add(new Question("How many continents are there on Earth?", new String[]{"5", "6", "7", "8"}, "7"));
        questionList.add(new Question("Who painted the Mona Lisa?", new String[]{"Vincent van Gogh", "Leonardo da Vinci", "Pablo Picasso", "Michelangelo"}, "Leonardo da Vinci"));
        questionList.add(new Question("What is the boiling point of water in Celsius?", new String[]{"90°C", "100°C", "110°C", "120°C"}, "100°C"));
        questionList.add(new Question("What is the tallest mountain in the world?", new String[]{"Mount Kilimanjaro", "K2", "Mount Everest", "Denali"}, "Mount Everest"));
        questionList.add(new Question("Which famous scientist formulated the laws of motion?", new String[]{"Isaac Newton", "Albert Einstein", "Galileo Galilei", "Nikola Tesla"}, "Isaac Newton"));
        questionList.add(new Question("Which is the smallest planet in our solar system?", new String[]{"Mercury", "Venus", "Mars", "Pluto"}, "Mercury"));
        questionList.add(new Question("How many wings does a bee have?", new String[]{"2", "4", "6", "8"}, "4"));
        questionList.add(new Question("What is the capital of Spain?", new String[]{"Barcelona", "Seville", "Madrid", "Valencia"}, "Madrid"));
        questionList.add(new Question("Which U.S. state is famous for Hollywood?", new String[]{"Texas", "California", "New York", "Florida"}, "California"));
        questionList.add(new Question("Which bird is known for its ability to mimic human speech?", new String[]{"Eagle", "Sparrow", "Parrot", "Crow"}, "Parrot"));
        questionList.add(new Question("Which country is famous for the Great Wall?", new String[]{"India", "Japan", "China", "Russia"}, "China"));
        questionList.add(new Question("Which metal is liquid at room temperature?", new String[]{"Mercury", "Iron", "Gold", "Silver"}, "Mercury"));
        questionList.add(new Question("Which planet is the largest in the solar system?", new String[]{"Earth", "Saturn", "Jupiter", "Neptune"}, "Jupiter"));
        questionList.add(new Question("Who was the first man to walk on the moon?", new String[]{"Buzz Aldrin", "Neil Armstrong", "Yuri Gagarin", "Michael Collins"}, "Neil Armstrong"));
        questionList.add(new Question("What is the square root of 64?", new String[]{"6", "7", "8", "9"}, "8"));
        questionList.add(new Question("Which city is known as the Big Apple?", new String[]{"Los Angeles", "New York", "Chicago", "San Francisco"}, "New York"));
        questionList.add(new Question("What is the name of the Roman god of war?", new String[]{"Zeus", "Ares", "Mars", "Apollo"}, "Mars"));
        questionList.add(new Question("What is the freezing point of water in Fahrenheit?", new String[]{"0°F", "32°F", "100°F", "212°F"}, "32°F"));
        questionList.add(new Question("Which country has the most volcanoes?", new String[]{"Japan", "Indonesia", "United States", "Italy"}, "Indonesia"));
        questionList.add(new Question("What color is a ruby?", new String[]{"Blue", "Green", "Red", "Yellow"}, "Red"));
        questionList.add(new Question("What is the largest island in the world?", new String[]{"Greenland", "Madagascar", "Australia", "Iceland"}, "Greenland"));
        questionList.add(new Question("How many planets are in our solar system?", new String[]{"7", "8", "9", "10"}, "8"));
        questionList.add(new Question("Who discovered gravity?", new String[]{"Albert Einstein", "Galileo Galilei", "Isaac Newton", "Nikola Tesla"}, "Isaac Newton"));
        questionList.add(new Question("Which country is known for the Eiffel Tower?", new String[]{"Italy", "France", "Spain", "Germany"}, "France"));
        questionList.add(new Question("Which mammal can fly?", new String[]{"Eagle", "Flying Squirrel", "Bat", "Owl"}, "Bat"));
        questionList.add(new Question("Which superhero is known as the 'Man of Steel'?", new String[]{"Batman", "Iron Man", "Superman", "Spider-Man"}, "Superman"));
        questionList.add(new Question("Which is the longest-running animated TV show?", new String[]{"Family Guy", "The Simpsons", "South Park", "SpongeBob SquarePants"}, "The Simpsons"));
        questionList.add(new Question("What type of animal is a Komodo dragon?", new String[]{"Snake", "Lizard", "Crocodile", "Frog"}, "Lizard"));
        questionList.add(new Question("Which country has the most people?", new String[]{"USA", "India", "China", "Brazil"}, "China"));
        questionList.add(new Question("What is the largest type of bear?", new String[]{"Grizzly Bear", "Panda", "Polar Bear", "Black Bear"}, "Polar Bear"));
        questionList.add(new Question("How many arms does a starfish have?", new String[]{"4", "5", "6", "8"}, "5"));
        questionList.add(new Question("What is the main gas in the air we breathe?", new String[]{"Oxygen", "Carbon Dioxide", "Nitrogen", "Helium"}, "Nitrogen"));
        questionList.add(new Question("Which planet is closest to the Sun?", new String[]{"Venus", "Mars", "Mercury", "Jupiter"}, "Mercury"));
        questionList.add(new Question("What color is the 'M' in McDonald's logo?", new String[]{"Red", "Yellow", "Blue", "Green"}, "Yellow"));
        questionList.add(new Question("Which animal is known as the 'King of the Jungle'?", new String[]{"Tiger", "Lion", "Elephant", "Cheetah"}, "Lion"));
        questionList.add(new Question("What is the national sport of Canada?", new String[]{"Soccer", "Basketball", "Lacrosse", "Hockey"}, "Lacrosse"));
        questionList.add(new Question("Which continent has the most countries?", new String[]{"Asia", "Europe", "Africa", "South America"}, "Africa"));
        questionList.add(new Question("What is the capital of Brazil?", new String[]{"São Paulo", "Rio de Janeiro", "Brasília", "Salvador"}, "Brasília"));
        questionList.add(new Question("Which musical instrument has six strings?", new String[]{"Piano", "Guitar", "Violin", "Flute"}, "Guitar"));
        questionList.add(new Question("How many chambers does the human heart have?", new String[]{"2", "3", "4", "5"}, "4"));
        questionList.add(new Question("Which is the only metal that is a liquid at room temperature?", new String[]{"Gold", "Silver", "Mercury", "Copper"}, "Mercury"));


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
                            Toast.makeText(GeneralQ.this, "This spot is already taken!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }

    }

    private void showQuizDialog(Button button) {
        GeneralQ.Question question = questionList.get(random.nextInt(questionList.size()));

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
                Toast.makeText(GeneralQ.this, "Time's up! Turn skipped.", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(GeneralQ.this, "Incorrect! Turn skipped.", Toast.LENGTH_SHORT).show();
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
