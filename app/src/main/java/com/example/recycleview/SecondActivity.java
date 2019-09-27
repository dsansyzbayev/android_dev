package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class SecondActivity extends AppCompatActivity {

    private TextView titleView;
    private TextView descriptionView;
    private ImageView image;
    private ImageView profileImage;
    private ImageButton share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        titleView = findViewById(R.id.title);
        descriptionView = findViewById(R.id.description);
        image = findViewById(R.id.imageView);
        profileImage = findViewById(R.id.imageView2);
        share = findViewById(R.id.imageButton);

        final Bundle extras = getIntent().getExtras();
        final String title = extras.getString("title");
        final String description = extras.getString("description");

        titleView.setText(title);
        descriptionView.setText(description);
        profileImage.setImageResource(R.drawable.androidpic);
        profileImage.setImageResource(R.mipmap.ic_launcher_round);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*Uri imageUri = Uri.parse("android.resource://" + getPackageName()
                        + "/drawable/" + "androidpic.jpg");*/
                String shareBody = title + "\n" + description;
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                /*
                sharingIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
                sharingIntent.setType("image/jpeg");
                sharingIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);*/
                startActivity(Intent.createChooser(sharingIntent, "send"));

            }
        });
    }
}

