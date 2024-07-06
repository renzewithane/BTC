package com.example.beyondtheclassroom;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.beyondtheclassroom.mainmenu.splash_screen;

public class DevNavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_mainmenu_dev_navigation);

        Button buttonMainMenu = findViewById(R.id.button_main_menu);
        buttonMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevNavigationActivity.this, MainMenuActivity.class);
                startActivity(intent);
            }
        });

        Button buttonOperations = findViewById(R.id.button_operations);
        buttonOperations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevNavigationActivity.this, OperationsActivity.class);
                startActivity(intent);
            }
        });

        Button buttonLevelBoard = findViewById(R.id.button_level_board);
        buttonLevelBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevNavigationActivity.this, LevelBoardActivity.class);
                startActivity(intent);
            }
        });

        Button buttonUserAvatar = findViewById(R.id.button_user_avatar);
        buttonUserAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevNavigationActivity.this, UserAvatarActivity.class);
                startActivity(intent);
            }
        });

        Button buttonStories = findViewById(R.id.button_stories);
        buttonStories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevNavigationActivity.this, StoriesActivity.class);
                startActivity(intent);
            }
        });

        Button buttonAssessments = findViewById(R.id.button_assessments);
        buttonAssessments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevNavigationActivity.this, AssessmentsActivity.class);
                startActivity(intent);
            }
        });
    }
}