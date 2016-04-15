package com.example.tommy.beginneriak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button benarButton;
    private Button salahButton;
    private Button mTextPertanyaan;

    private Question[] mQuestionsBank = new Question[]{
            new Question(R.string.pertannyaan_jakarta, true),
            new Question(R.string.pertannyaan_surabaya, true),
            new Question(R.string.pertannyaan_salah, false),
            new Question(R.string.pertannyaan_salah1, false),
    };
    private int mIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
