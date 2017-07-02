package com.android.mounika.imagefromgallery;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void CaptureImage(View view) {
        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100&&resultCode==RESULT_OK){
            Toast.makeText(this, "ImageSuccess", Toast.LENGTH_SHORT).show();
            ImageView Imageview= (ImageView) findViewById(R.id.imageView);
            Uri uri=data.getData();
            Bitmap map=(Bitmap)data.getExtras().get("data");
            Imageview.setImageBitmap(map);
        }
        else{
            Toast.makeText(this, "Unsuccess", Toast.LENGTH_SHORT).show();
        }

    }
}

