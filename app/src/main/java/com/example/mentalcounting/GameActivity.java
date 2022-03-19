package com.example.mentalcounting;
import com.example.mentalcounting.Operation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameActivity extends AppCompatActivity {

    Operation compute ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        associateOpenActivityToButton(R.id.main,MainActivity.class);
        ColorDrawable colorDrawable
                = new ColorDrawable(getResources().getColor(R.color.TitleColor));

        // Set BackgroundDrawable
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        showOperation();
        Button Submit = findViewById(R.id.validate);
        Submit.setOnClickListener(view -> verifyAnswer());
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
        menuInflater.inflate(R.menu.gamemenu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.ResetScore:
                //Reset scores
                break;
            case R.id.Score:
                Intent intent = new Intent(this, ScoreActivity.class);
                startActivity(intent);
                break;
            case R.id.Previous:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }



    public void showOperation (){
        TextView operationText = findViewById(R.id.operation);
        compute = new Operation();
        operationText.setText(compute.toString());
    }

    public void verifyAnswer() {
        String answer = Integer.toString(compute.getAnswer());
        TextView answerText = findViewById(R.id.userAnswer);
        String userAnswer = (answerText.getText().toString()); //.getText().toString()
        if (answer.equals(userAnswer)) {
            findViewById(R.id.answerGood).setVisibility(View.VISIBLE);
            findViewById(R.id.answerBad).setVisibility(View.GONE);
                                  }
        else{
            findViewById(R.id.answerBad).setVisibility(View.VISIBLE);
            findViewById(R.id.answerGood).setVisibility(View.GONE);
            }
        answerText.setText(null);
        showOperation();
    }
}