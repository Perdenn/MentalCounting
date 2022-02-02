package com.example.mentalcounting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        associateOpenActivityToButton(R.id.ButtonScore,Score.class);
        associateOpenActivityToButton(R.id.ButtonJeu,Jeu.class);
    }

    private void associateOpenActivityToButton(int id, Class activity){
        Button resultButton = findViewById(id);
        resultButton.setOnClickListener(view -> openActivity(activity));

    }

    private void openActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menuprin, menu);

        return super.onCreateOptionsMenu(menu);
    }

}