package com.example.beyondtheclassroom;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.beyondtheclassroom.stories.read_layout;

public class StoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories);

        if (savedInstanceState == null) {
            read_layout ReadLayout = new read_layout();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.stories_container, ReadLayout)
                    .commit();
        }

    }
}
