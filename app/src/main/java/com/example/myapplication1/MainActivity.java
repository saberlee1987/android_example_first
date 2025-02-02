package com.example.myapplication1;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editTextFirstName = findViewById(R.id.editTextFirstName);
        EditText editTextLastName = findViewById(R.id.editTextLastName);
        Button buttonSayHello = findViewById(R.id.buttonSayHello);
        Button buttonEditProfile = findViewById(R.id.buttonEditProfile);

        buttonEditProfile.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this,AndroidSimpleViewActivity.class);
            startActivity(intent);
        });

        buttonSayHello.setOnClickListener(v -> {
            String firstName = editTextFirstName.getText().toString();
            String lastName = editTextLastName.getText().toString();
            String message = String.format("Hello %s %s", firstName, lastName);

            new AlertDialog.Builder(this)
                    .setTitle("Say Hello Information")
                    .setMessage(message)
                    .setPositiveButton("OK", (dialog, which) -> {
                        Toast.makeText(this, "ok button is clicked", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    })
                    .setNegativeButton("cancel",(dialog, which) -> {
                        Toast.makeText(this, "cancel button is clicked", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    })
                    .setCancelable(true)
                    .create().show();

            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        });
    }
}