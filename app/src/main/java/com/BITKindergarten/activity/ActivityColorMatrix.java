package com.BITKindergarten.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSeekBar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.BITKindergarten.R;
import com.BITKindergarten.utils.ImageUtil;

public class ActivityColorMatrix extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private ImageView mImageView;
    private AppCompatSeekBar mRotateSeekBar;
    private AppCompatSeekBar mSaturationSeekBar;
    private AppCompatSeekBar mScaleSeekBar;


    private Bitmap mBitmap;
    private float mRotate;
    private float mSaturation;
    private float mScale;

    private static int MIN_PROGRESS = 128;
    private static int MAX_PROGRESS = 255;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_matrix);

        mImageView = findViewById(R.id.imageView);
        mRotateSeekBar = findViewById(R.id.seekBar_rotate);
        mSaturationSeekBar = findViewById(R.id.seekBar_saturation);
        mScaleSeekBar = findViewById(R.id.seekBar_scale);

        mRotateSeekBar.setOnSeekBarChangeListener(this);
        mSaturationSeekBar.setOnSeekBarChangeListener(this);
        mScaleSeekBar.setOnSeekBarChangeListener(this);

        mRotateSeekBar.setMax(MAX_PROGRESS);
        mSaturationSeekBar.setMax(MAX_PROGRESS);
        mScaleSeekBar.setMax(MAX_PROGRESS);

        mRotateSeekBar.setProgress(MIN_PROGRESS);
        mSaturationSeekBar.setProgress(MIN_PROGRESS);
        mScaleSeekBar.setProgress(MIN_PROGRESS);

        /**
         * 获得图片*/
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test2);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.seekBar_rotate:
                mRotate = (mRotateSeekBar.getProgress() - 128f) * 1.0f / 128f * 180;
                break;
            case R.id.seekBar_saturation:
                mSaturation = mSaturationSeekBar.getProgress() / 128f;
                break;
            case R.id.seekBar_scale:
                mScale = mScaleSeekBar.getProgress() / 128f;
                break;
        }

        if (mBitmap != null) {
            Bitmap bitmap = ImageUtil.beautyImage(mBitmap, mRotate, mSaturation, mScale);
            mImageView.setImageBitmap(bitmap);
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
