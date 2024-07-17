package com.example.beyondtheclassroom.mainmenu;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.beyondtheclassroom.R;

public class class_code extends Fragment {

    private EditText classCodeInput;
    private OnClassCodeSubmitListener listener;

    public interface OnClassCodeSubmitListener {
        void onClassCodeSubmit(String classCode);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnClassCodeSubmitListener) {
            listener = (OnClassCodeSubmitListener) context;
        } else {
            throw new RuntimeException(context.toString() + "must implement OnClassCodeSubmitListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mainmenu_class_code, container, false);
        ImageView buttonNextClassCode = view.findViewById(R.id.arrowButton);
        buttonNextClassCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                avatar_selection AvatarSelection = new avatar_selection();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_menu_container, AvatarSelection);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }
}
