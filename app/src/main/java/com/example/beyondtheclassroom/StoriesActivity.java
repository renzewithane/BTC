package com.example.beyondtheclassroom;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.beyondtheclassroom.stories.read_layout;
import com.example.beyondtheclassroom.stories.library;

public class StoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories);

        if (savedInstanceState == null) {
            String fragmentToLoad = getIntent().getStringExtra("fragment_to_load");

            Fragment selectedFragment;
            if ("library".equals(fragmentToLoad)) {
                selectedFragment = new library();
            } else {
                selectedFragment = new read_layout();
            }

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.stories_container, selectedFragment)
                    .commit();
        }
    }

}
