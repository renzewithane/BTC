package com.example.beyondtheclassroom.levelboard;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import com.example.beyondtheclassroom.R;

public class LevelBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_board);

        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            Display displayFragment = new Display();
            transaction.replace(R.id.fragment_container, displayFragment);
            transaction.commit();
        }
    }
}
