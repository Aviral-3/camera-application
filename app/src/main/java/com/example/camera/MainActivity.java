package com.example.camera;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {
  Button Camera;
  ImageView imageView;
  final int request_pic=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Camera=findViewById(R.id.button1);
        imageView=findViewById(R.id.imageView);

        Camera.setOnClickListener(v -> {
         ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CAMERA},1);
         Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
         startActivityForResult(intent,request_pic);
        });

    }

    @Override
    protected void onActivityResult(int request_pic, int result_Code, @Nullable Intent data) {
        super.onActivityResult(request_pic, result_Code, data);

        assert data != null;
        Bundle bundle=data.getExtras();
        Bitmap photo = (Bitmap) bundle.get("data");
       // Drawable draw=new BitmapDrawable(getResources(),photo);
        imageView.setImageBitmap(photo);
    }
}