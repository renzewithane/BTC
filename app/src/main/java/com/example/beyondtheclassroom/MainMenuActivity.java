package com.example.beyondtheclassroom;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.beyondtheclassroom.mainmenu.splash_screen;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        if (savedInstanceState == null) {
            splash_screen SplashScreen = new splash_screen();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_menu_container, SplashScreen)
                    .commit();
        }




    }
}
