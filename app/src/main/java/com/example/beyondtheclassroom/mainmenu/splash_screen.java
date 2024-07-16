package com.example.beyondtheclassroom.mainmenu;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.beyondtheclassroom.R;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import jp.wasabeef.blurry.Blurry;

import java.util.Random;

public class splash_screen extends Fragment {

    private int[] splashBackgrounds = {
            R.drawable.splash_bg_1,
            R.drawable.splash_bg_2,
            R.drawable.splash_bg_3,
            R.drawable.splash_bg_4,
            R.drawable.splash_bg_5
    };

    private int[] statusBarColors = {
            R.color.status_bar_color_1,
            R.color.status_bar_color_2,
            R.color.status_bar_color_3,
            R.color.status_bar_color_4,
            R.color.status_bar_color_5
    };

    private int[] navigationBarColors = {
            R.color.navigation_bar_color_1,
            R.color.navigation_bar_color_2,
            R.color.navigation_bar_color_3,
            R.color.navigation_bar_color_4,
            R.color.navigation_bar_color_5
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mainmenu_splash_screen, container, false);
        ImageView backgroundImage = view.findViewById(R.id.backgroundImage);
        ImageView logo = view.findViewById(R.id.logo);

        // Randomly select a background image and status bar color
        Random random = new Random();
        int index = random.nextInt(splashBackgrounds.length);
        backgroundImage.setImageResource(splashBackgrounds[index]);

        // Change the status bar and navigation bar color
        if (getActivity() != null) {
            getActivity().getWindow().setStatusBarColor(ContextCompat.getColor(getActivity(), statusBarColors[index]));
            getActivity().getWindow().setNavigationBarColor(ContextCompat.getColor(getActivity(), navigationBarColors[index]));
        }

        // Load the logo animation and start it
        Animation logoAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.logo_animation);
        logo.startAnimation(logoAnimation);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                // Apply blur effect from bottom to top
                Blurry.with(getActivity())
                        .radius(25) // Increase the blur radius for a more noticeable blur
                        .sampling(1) // Decrease the sampling rate for better quality blur
                        .async()
                        .animate(1000)
                        .onto((ViewGroup) view);

                // Load the exit animation and start it
                Animation exitAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.exit_animation);
                view.startAnimation(exitAnimation);

                // Delay the fragment transition to allow the exit animation to complete
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        transaction.replace(R.id.main_menu_container, new intro());
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                }, 1000); // Match this delay with the exit animation duration
            }
        }, 3000); // Duration of the splash screen

        return view;
    }
}
