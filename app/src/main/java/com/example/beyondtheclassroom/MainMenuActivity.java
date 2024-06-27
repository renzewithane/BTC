package com.example.beyondtheclassroom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.beyondtheclassroom.mainmenu.dev_navigation;
import com.example.beyondtheclassroom.mainmenu.splash_screen;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        if (savedInstanceState == null) {
            dev_navigation DevNav = new dev_navigation();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_menu_container, DevNav)
                    .commit();
        }


    }
}
