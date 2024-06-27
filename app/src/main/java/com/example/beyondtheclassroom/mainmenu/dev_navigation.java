package com.example.beyondtheclassroom.mainmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.beyondtheclassroom.R;
import com.example.beyondtheclassroom.OperationsActivity;
import com.example.beyondtheclassroom.LevelBoardActivity;
import com.example.beyondtheclassroom.UserAvatarActivity;
import com.example.beyondtheclassroom.StoriesActivity;
import com.example.beyondtheclassroom.AssessmentsActivity;

public class dev_navigation extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mainmenu_dev_navigation, container, false);

        Button buttonMainMenu = view.findViewById(R.id.button_main_menu);
        buttonMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                splash_screen SplashScreen = new splash_screen();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_menu_container, SplashScreen);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        Button buttonOperations = view.findViewById(R.id.button_operations);
        buttonOperations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OperationsActivity.class);
                startActivity(intent);
            }
        });

        Button buttonLevelBoard = view.findViewById(R.id.button_level_board);
        buttonLevelBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LevelBoardActivity.class);
                startActivity(intent);
            }
        });

        Button buttonUserAvatar = view.findViewById(R.id.button_user_avatar);
        buttonUserAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserAvatarActivity.class);
                startActivity(intent);
            }
        });

        Button buttonStories = view.findViewById(R.id.button_stories);
        buttonStories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), StoriesActivity.class);
                startActivity(intent);
            }
        });

        Button buttonAssessments = view.findViewById(R.id.button_assessments);
        buttonAssessments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AssessmentsActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
