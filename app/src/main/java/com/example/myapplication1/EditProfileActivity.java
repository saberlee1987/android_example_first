package com.example.myapplication1;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        EditText editTextProfile = findViewById(R.id.edit_profile_fullName);
        Button buttonEditProfileFullName = findViewById(R.id.btn_editProfile_fullName);

        String fullName = getIntent().getStringExtra(AndroidSimpleViewActivity.EXTRA_KEY_FULL_NAME);
        editTextProfile.setText(fullName);

        buttonEditProfileFullName.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra(AndroidSimpleViewActivity.EXTRA_KEY_FULL_NAME, editTextProfile.getText().toString());
            setResult(Activity.RESULT_OK, intent);
            finish();
        });
    }
}