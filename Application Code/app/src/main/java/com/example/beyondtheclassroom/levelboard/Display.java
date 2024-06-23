package com.example.beyondtheclassroom.levelboard;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.beyondtheclassroom.R;
import java.util.ArrayList;
import java.util.List;

public class Display extends Fragment {

    public Display() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_level_board_display, container, false);

        // Set up RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        // Set up Adapter
        LevelAdapter levelAdapter = new LevelAdapter(getLevels());
        recyclerView.setAdapter(levelAdapter);

        return view;
    }

    // Dummy data for levels
    private List<String> getLevels() {
        List<String> levels = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            levels.add("Level " + i);
        }
        return levels;
    }
}
