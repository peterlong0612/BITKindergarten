package com.BITKindergarten.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.BITKindergarten.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ActivityChangeHue extends AppCompatActivity {

    private ImageView mImageView;
    private GridLayout mGridLayout;
    private Button mBtnOk;
    private Button mBtnReset;

    private Bitmap mBitmap;

    private static final int PICK_IMAGE = 1;
    private ImageView imgViewA;
    private ImageView imgViewB;

    private EditText mEditTexts[] = new EditText[20];
    private float[] mColorMatrix = new float[20];

    private int finalPos;
    private List<float[]> mColorMatrixList;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_hue);

        mImageView = findViewById(R.id.imageView);
        mGridLayout = findViewById(R.id.gridLayout);
        mBtnOk = findViewById(R.id.btnOk);
        mBtnReset = findViewById(R.id.btnReset);
        mGridLayout.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    EditText editText = new EditText(ActivityChangeHue.this);
                    editText.setGravity(Gravity.CENTER);
                    if (i % 6 == 0) {
                        editText.setText("1");
                    } else {
                        editText.setText("0");
                    }
                    mEditTexts[i] = editText;
                    mGridLayout.addView(editText, mGridLayout.getWidth() / 5, mGridLayout.getHeight() / 4);
                }
            }
        });


        // 按钮设置
        mBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorMatrix colorMatrix = new ColorMatrix();
                colorMatrix.set(getColorMatrix());
                mImageView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            }
        });

        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorMatrix colorMatrix = new ColorMatrix();
                colorMatrix.set(getInitColorMatrix());
                mImageView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            }
        });

        // 新的位图
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test2);
        mImageView.setImageBitmap(mBitmap);    // 将此位图设置为view中内容

    }

    //按钮响应事件
    public void OnClick(View v){
        switch (v.getId()) {
            case R.id.btn_select_image:
            {
                imgViewB.setImageDrawable(null);
                chooseImage();
                break;
            }
            case R.id.btn_save_bitmap:
            {
//                saveImage(oBitmap);
                // 获取imgviewB中已经滤镜处理且加载好的图片
//                Bitmap sBitmap = ((BitmapDrawable)imgViewB.getDrawable()).getBitmap();
//                String url = FileUtils.storePath + System.currentTimeMillis() + ".jpg";
//                String url = FileUtils.SAVE_FILE + System.currentTimeMillis() + ".jpg";
//                saveImage(sBitmap);
//                imgViewB.setImageBitmap(sBitmap);

                saveImage(getChangeBitmap(mBitmap));

                break;
            }
        }
    }
    private float[] getColorMatrix() {
        for (int i = 0; i < 20; i++) {
            mColorMatrix[i] = Float.parseFloat(mEditTexts[i].getText().toString());
        }
        return mColorMatrix;
    }

    private float[] getInitColorMatrix() {
        for (int i = 0; i < 20; i++) {
            if (i % 6 == 0) {
                mColorMatrix[i] = 1;
                mEditTexts[i].setText("1");
            } else {
                mColorMatrix[i] = 0;
                mEditTexts[i].setText("0");
            }
        }
        return mColorMatrix;
    }
    /*
     * 打开本地相册选择图片
     * */
    public void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"),
                PICK_IMAGE);
    }
    /** 保存方法 */
    //保存文件到指定路径
    public boolean saveImage(Bitmap bmp) {
        // 首先保存图片
        String storePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "BITKindergartenImg";
        File appDir = new File(storePath);
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = "滤镜图片" + System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            //通过io流的方式来压缩保存图片
            boolean isSuccess = bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
            Log.d("Fliter/saveImage()", "已经保存");
            Toast toast=Toast.makeText(getApplicationContext(),"保存成功",Toast.LENGTH_SHORT    );
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();

            //把文件插入到系统图库

//            MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getAbsolutePath(), fileName, null);

            //保存图片后发送广播通知更新数据库
//            Uri uri = Uri.fromFile(file);
//            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));
//            if (isSuccess) {
//                return true;
//            } else {
//                return false;
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
    public Bitmap getChangeBitmap( Bitmap srcBitmap) {

        //创建一个大小相同的空白Bitmap
        Bitmap dstBitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        //获取颜色矩阵
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(mColorMatrixList.get(finalPos));
        //载入Canvas,Paint
        Canvas canvas = new Canvas(dstBitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        //绘图
        canvas.drawBitmap(srcBitmap, 0, 0, paint);
        return dstBitmap;
    }
}
