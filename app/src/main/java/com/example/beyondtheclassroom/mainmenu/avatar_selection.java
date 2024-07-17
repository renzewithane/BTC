package com.example.beyondtheclassroom.mainmenu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.beyondtheclassroom.LevelBoardActivity;
import com.example.beyondtheclassroom.R;

public class avatar_selection extends Fragment {

    private EditText nicknameInput;
    private EditText firstNameInput;
    private EditText lastNameInput;
    private OnSaveButtonClickListener listener;

    public interface OnSaveButtonClickListener {
        void onSaveButtonClick(String firstName, String lastName, String nickname);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnSaveButtonClickListener) {
            listener = (OnSaveButtonClickListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnSaveButtonClickListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mainmenu_avatar_selection, container, false);

        nicknameInput = view.findViewById(R.id.nickname_entry);
        firstNameInput = view.findViewById(R.id.first_name_entry);
        lastNameInput = view.findViewById(R.id.last_name_entry);

        ImageView buttonIntroContinue = view.findViewById(R.id.arrowButton);
        buttonIntroContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Proceeds to LevelBoard
                Intent intent = new Intent(getActivity(), LevelBoardActivity.class);
                startActivity(intent);

                // Save User Data
                String nickname = nicknameInput.getText().toString().trim();
                String firstName = firstNameInput.getText().toString().trim();
                String lastName = lastNameInput.getText().toString().trim();

                if (firstName.isEmpty() || lastName.isEmpty() || nickname.isEmpty()) {
                    Toast.makeText(getContext(), "Please fill out all fields", Toast.LENGTH_SHORT).show();
                } else {
                    listener.onSaveButtonClick(firstName, lastName, nickname);
                }
            }
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
