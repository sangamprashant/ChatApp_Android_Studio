package com.sangamprashant.letschat;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.github.drjacky.imagepicker.ImagePicker;
import com.github.drjacky.imagepicker.constant.ImageProvider;

import org.jetbrains.annotations.NotNull;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

public class ProfileUploadActivity extends AppCompatActivity {
    ImageView goToChatView;
    Button toMainActivityByCancelButton;

    private final ActivityResultLauncher<Intent> launcher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), (result) -> {
                if (result.getResultCode() == RESULT_OK) {
                    Uri uri = result.getData().getData();
                    // Use the uri to load the image
                } else if (result.getResultCode() == ImagePicker.RESULT_ERROR) {
                    // Use ImagePicker.Companion.getError(result.getData()) to show an error
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_upload);
        goToChatView = findViewById(R.id.backButton);
        toMainActivityByCancelButton = findViewById(R.id.toToMainActivityByCancelButton);

        goToChatView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileUploadActivity.this, MainActivity.class));
                finish();
            }
        });

        toMainActivityByCancelButton.setOnClickListener(new View.OnClickListener() {
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

        gifImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.Companion.with(ProfileUploadActivity.this)
                        .cropSquare()    //Crop square image, its same as crop(1f, 1f)
                        .maxResultSize(512, 512, true)
                        .provider(ImageProvider.BOTH) //Or bothCameraGallery()
                        .createIntentFromDialog(new Function1<Intent, Unit>() {
                            @Override
                            public Unit invoke(Intent it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                launcher.launch(it);
                                return null;
                            }
                        });
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ProfileUploadActivity.this, MainActivity.class));
        finish();
    }
}
