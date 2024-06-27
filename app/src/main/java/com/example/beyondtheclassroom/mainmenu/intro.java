package com.example.beyondtheclassroom.mainmenu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.beyondtheclassroom.R;

public class intro extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mainmenu_intro, container, false);

        ImageView buttonIntroContinue = view.findViewById(R.id.buttonImage);
        buttonIntroContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                class_code ClassCode = new class_code();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_menu_container, ClassCode);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }
}