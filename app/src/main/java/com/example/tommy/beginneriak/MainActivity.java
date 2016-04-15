package com.example.tommy.beginneriak;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button benarButton;
    private Button salahButton;
    private Button selanjutnyaButton;
    private TextView mTextPertanyaan;

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
        benarButton = (Button)findViewById(R.id.button_benar);
        salahButton=(Button)findViewById(R.id.buttom_salah);
        selanjutnyaButton = (Button)findViewById(R.id.button_selanjutnya);
        mTextPertanyaan =(TextView)findViewById(R.id.text_pertanyaan);
        int pertanyaan = mQuestionsBank[mIndex].getTextResId();
        mTextPertanyaan.setText(pertanyaan);

        selanjutnyaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIndex = mIndex+1;
                if (mIndex>= mQuestionsBank.length){
                    mIndex=0;
                }
                int pertanyaan = mQuestionsBank[mIndex].getTextResId();
                mTextPertanyaan.setText(pertanyaan);
            }
        });

        benarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkJawaban(true);

            }
        });

        salahButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkJawaban(false);

            }
        });



    }
    private void checkJawaban(boolean userPressed){
        boolean jawabanBenar = mQuestionsBank[mIndex].isAnswerTrue();
        int jawabanResId = 0;
        if (userPressed == jawabanBenar){
            jawabanResId = R.string.toast_benar;
        }else{
            jawabanResId = R.string.toast_salah;
        }
        Toast.makeText(getApplicationContext(), jawabanResId, Toast.LENGTH_SHORT).show();
    }
}
