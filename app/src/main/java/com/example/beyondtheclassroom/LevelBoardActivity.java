package com.example.beyondtheclassroom;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import android.widget.ImageView;

import com.example.beyondtheclassroom.levelboard.background;
import com.example.beyondtheclassroom.stories.library;

public class LevelBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levelboard);

        if (savedInstanceState == null) {
            background Background = new background();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.levelboard_container, Background)
                    .commit();
        }

        ImageView PlayButton = findViewById(R.id.play_button);
        PlayButton.setOnClickListener(view -> {
            Intent intent = new Intent(LevelBoardActivity.this, StoriesActivity.class);
            startActivity(intent);
        });

        ImageView LibraryButton = findViewById(R.id.library_tab);
        LibraryButton.setOnClickListener(view -> {
            Intent intent = new Intent(LevelBoardActivity.this, StoriesActivity.class);
            intent.putExtra("library", "com.example.beyondtheclassroom.stories.library");
            startActivity(intent);
        });


    }

}
