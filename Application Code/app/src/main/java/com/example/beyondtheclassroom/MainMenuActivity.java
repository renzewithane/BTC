package com.example.beyondtheclassroom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


import com.example.beyondtheclassroom.levelboard.LevelBoardActivity;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button buttonOperations = findViewById(R.id.button_operations);
        buttonOperations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, OperationsActivity.class);
                startActivity(intent);
            }
        });

        Button buttonLevelBoard = findViewById(R.id.button_level_board);
        buttonLevelBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, LevelBoardActivity.class);
                startActivity(intent);
            }
        });

        Button buttonUserAvatar = findViewById(R.id.button_user_avatar);
        buttonUserAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, UserAvatarActivity.class);
                startActivity(intent);
            }
        });

        Button buttonStories = findViewById(R.id.button_stories);
        buttonStories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, StoriesActivity.class);
                startActivity(intent);
            }
        });

        Button buttonAssessments = findViewById(R.id.button_assessments);
        buttonAssessments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, AssessmentsActivity.class);
                startActivity(intent);
            }
        });
    }
}
