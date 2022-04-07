package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView5;
    private EditText editTextTextEmailAddress;
    private EditText editTextNumberPassword;
    private TextToSpeech tts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView5 = findViewById(R.id.textView5);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextNumberPassword = findViewById(R.id.editTextNumberPassword);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s1 = editTextTextEmailAddress.getText().toString();
                String s2 = editTextNumberPassword.getText().toString();
                String s3 = "Log In Successful";
                String s4 = "Log In Failed";
                tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if(i==TextToSpeech.SUCCESS){
                            tts.setLanguage(Locale.US);
                            tts.setSpeechRate(1.0f);
                            if(s1.contentEquals("abc@gmail.com") && s2.contentEquals("1234")){
                                tts.speak(s3,TextToSpeech.QUEUE_ADD,null);
                                textView5.setText("Log In Successful");
                            }
                            else{
                                tts.speak(s4,TextToSpeech.QUEUE_ADD,null);
                                textView5.setText("Log In Failed");
                            }
                        }
                    }
                });
            }
        });

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Toast.makeText(MainActivity.this, "App Opened", Toast.LENGTH_SHORT).show();
//                String s1 = editTextTextEmailAddress.getText().toString();
//                String s2 = editTextNumberPassword.getText().toString();
//
//                if(s1.contentEquals("abc@gmail.com") && s2.contentEquals("1234")){
//                    textView5.setText("Log In Successful");
//                }
//                else{
//                    textView5.setText("Log In Failed");
//                }
//            }
//        });
    }
}