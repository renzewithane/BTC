package com.example.beyondtheclassroom.mainmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;

import com.example.beyondtheclassroom.R;

import com.example.beyondtheclassroom.OperationsActivity;
import com.example.beyondtheclassroom.LevelBoardActivity;
import com.example.beyondtheclassroom.UserAvatarActivity;
import com.example.beyondtheclassroom.StoriesActivity;
import com.example.beyondtheclassroom.AssessmentsActivity;

public class dev_navigation extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public dev_navigation() {
        // Required empty public constructor
    }

    public static dev_navigation newInstance(String param1, String param2) {
        dev_navigation fragment = new dev_navigation();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mainmenu_dev_navigation, container, false);

        // Find buttons and set click listeners
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
