package com.example.beyondtheclassroom.mainmenu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.content.Intent;

import com.example.beyondtheclassroom.R;
import com.example.beyondtheclassroom.LevelBoardActivity;


public class avatar_selection extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mainmenu_avatar_selection, container, false);

        ImageView buttonIntroContinue = view.findViewById(R.id.arrowButton);
        buttonIntroContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the TargetActivity
                Intent intent = new Intent(getActivity(), LevelBoardActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}