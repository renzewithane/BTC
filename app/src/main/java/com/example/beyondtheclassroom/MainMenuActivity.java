package com.example.beyondtheclassroom;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.beyondtheclassroom.mainmenu.avatar_selection;
import com.example.beyondtheclassroom.mainmenu.class_code;
import com.example.beyondtheclassroom.mainmenu.splash_screen;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainMenuActivity extends AppCompatActivity implements avatar_selection.OnSaveButtonClickListener, class_code

        .OnClassCodeSubmitListener {

    private FirebaseFirestore db;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        FirebaseFirestore.setLoggingEnabled(true);
        db = FirebaseFirestore.getInstance();

        // Initiate Splash Screen
        if (savedInstanceState == null) {
            splash_screen SplashScreen = new splash_screen();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_menu_container, SplashScreen)
                    .commit();
        }
    }

    @Override
    public void onClassCodeSubmit(String classCode) {
        saveClassCode(classCode);
    }

    private void saveClassCode(String classCode) {
        if (userId == null) {
            Toast.makeText(this, "User data not yet saved, please try again", Toast.LENGTH_SHORT).show();
            return;
        }

        DocumentReference userRef = db.collection("users").document(userId);

        userRef
                .update("classCode", classCode)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("MainMenuActivity", "Class code updated successfully");
                        Toast.makeText(MainMenuActivity.this, "Class code updated", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("MainMenuActivity", "Error updating class code", e);
                        Toast.makeText(MainMenuActivity.this, "Error updating class code: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }


    @Override
    public void onSaveButtonClick(String firstName, String lastName, String nickname) {
        saveUserData(firstName, lastName, nickname);
    }

    private void saveUserData(String firstName, String lastName, String nickname) {
        Log.d("MainMenuActivity", "saveUserData called");

        if (firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty() || nickname == null || nickname.isEmpty()) {
            Log.e("MainMenuActivity", "Validation failed: Empty input fields");
            Toast.makeText(MainMenuActivity.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Log.d("MainMenuActivity", "Saving user data: " + firstName + " " + lastName + " (" + nickname + ")");

        // Generate a unique ID for the user
        DocumentReference newUserRef = db.collection("users").document();
        String userId = newUserRef.getId();

        Map<String, Object> user = new HashMap<>();
        user.put("firstName", firstName);
        user.put("lastName", lastName);
        user.put("nickname", nickname);
        user.put("uid", userId);

        newUserRef
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("MainMenuActivity", "User data saved with ID: " + userId);
                        Toast.makeText(MainMenuActivity.this, "User data saved", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("MainMenuActivity", "Error saving user data", e);
                        Toast.makeText(MainMenuActivity.this, "Error saving user data: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
