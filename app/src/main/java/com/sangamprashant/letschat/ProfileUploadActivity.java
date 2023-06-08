package com.sangamprashant.letschat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ProfileUploadActivity extends AppCompatActivity {
    ImageView goToChatView;
    Button  ToToMainActivityByCancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_upload);
        goToChatView = findViewById(R.id.backButton);
        ToToMainActivityByCancelButton=findViewById(R.id.toToMainActivityByCancelButton);


        goToChatView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileUploadActivity.this, MainActivity.class));
                finish();
            }
        });
        ToToMainActivityByCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileUploadActivity.this, MainActivity.class));
                finish();
            }
        });

        // Find the ImageView in your activity or fragment
        ImageView gifImageView = findViewById(R.id.ImageToChange);

        // Load the GIF using Glide
        Glide.with(this).asGif().load(R.drawable.previewimg).into(gifImageView);
        Glide.with(this).asGif().load(R.drawable.back).into(goToChatView);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ProfileUploadActivity.this, MainActivity.class));
        finish();
    }
}
