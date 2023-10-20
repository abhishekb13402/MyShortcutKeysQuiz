package com.example.myshortcutkeysquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }

    public void displaylist(View view) {
        Intent intent = new Intent(MainActivity.this,displaylist.class);
        startActivity(intent);
    }

    public void quizbasic(View view) {
        Toast.makeText(this, "Basic Quiz", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,quizbasic.class);
        startActivity(intent);
    }

    public void quizmicrosoft(View view) {
        Toast.makeText(this, "Microsoft Quiz", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,quizmicrosoft.class);
        startActivity(intent);
    }

    public void quizwinkey(View view) {
        Toast.makeText(this, "Coming Soon Winkey Quiz", Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(MainActivity.this,quizwinkey.class);
//        startActivity(intent);
    }

    public void quizword(View view) {
        Toast.makeText(this, "Coming Soon Word Quiz", Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(MainActivity.this,quizword.class);
//        startActivity(intent);
    }

    public void quizexcel(View view) {
        Toast.makeText(this, "Coming Soon Excel Quiz", Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(MainActivity.this,quizexcel.class);
//        startActivity(intent);
    }

    public void quizoutlook(View view) {
        Toast.makeText(this, "Coming Soon Outlook Quiz", Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(MainActivity.this,quizoutlook.class);
//        startActivity(intent);
    }
}