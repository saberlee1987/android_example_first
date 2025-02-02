package com.example.myapplication1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class AndroidSimpleViewActivity extends AppCompatActivity {

    public static final String EXTRA_KEY_FULL_NAME = "fullName";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_simple_view);
        Button editProfileButton = findViewById(R.id.btn_main_edit_profile);
        Button viewWebSiteButton = findViewById(R.id.viewWebSiteButton);
        TextView tv_main_fullName = findViewById(R.id.tv_main_fullName);

        // You can do the assignment inside onAttach or onCreate, i.e, before the activity is displayed
        ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                        Intent data = result.getData();
                        tv_main_fullName.setText(data.getStringExtra(EXTRA_KEY_FULL_NAME));
                    }
                });
        editProfileButton.setOnClickListener(view -> {
            Intent intent = new Intent(AndroidSimpleViewActivity.this, EditProfileActivity.class);
            intent.putExtra(EXTRA_KEY_FULL_NAME, tv_main_fullName.getText());
            someActivityResultLauncher.launch(intent);
        });

        viewWebSiteButton.setOnClickListener(view ->{
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://faradars.org/my-account"));
            startActivity(intent);
        });

    }
}