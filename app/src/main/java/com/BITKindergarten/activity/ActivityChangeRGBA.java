package com.BITKindergarten.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.BITKindergarten.R;

public class ActivityChangeRGBA extends AppCompatActivity {

    private ImageView mImageView;

    private Bitmap mBitmap;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_rgb);
        mImageView = findViewById(R.id.imageView);

        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test);
        Bitmap bitmap = ImageUtil.beautyImage(mBitmap);

        mImageView.setImageBitmap(bitmap);

    }

}
