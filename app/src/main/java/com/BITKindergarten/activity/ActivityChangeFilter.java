package com.BITKindergarten.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.BITKindergarten.MainActivity;
import com.BITKindergarten.PermissionUtils;
import com.BITKindergarten.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.app.Activity.RESULT_OK;

/**
 * 简单滤镜效果演示
 */
public class ActivityChangeFilter extends AppCompatActivity {
    public String TAG="ActivityChangeFilter";

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int PICK_IMAGE = 1;
    private ImageView imgViewA;
    private ImageView imgViewB;

    private Uri imgUri;
    private Bitmap mBitmap;
    private Bitmap oBitmap;

    private int savecount = 0;
    //private RecyclerView mRecyclerView;
    //private BeautyAdapter mBeautyAdapter;
    private List<float[]> mColorMatrixList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_filter);

        //PermissionUtils.isGrantExternalRW(this,1);
        chooseImage();
        initViewAB();

        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test);


        mColorMatrixList = new ArrayList<float[]>();
        mColorMatrixList.add(ImageUtil.colormatrix_huguang);
        mColorMatrixList.add(ImageUtil.colormatrix_hepian);
        mColorMatrixList.add(ImageUtil.colormatrix_landiao);
        mColorMatrixList.add(ImageUtil.colormatrix_qingning);
        mColorMatrixList.add(ImageUtil.colormatrix_yese);
        mColorMatrixList.add(ImageUtil.colormatrix_fugu);
        mColorMatrixList.add(ImageUtil.colormatrix_huan_huang);
        mColorMatrixList.add(ImageUtil.colormatrix_jiuhong);
        mColorMatrixList.add(ImageUtil.colormatrix_chuan_tong);
        mColorMatrixList.add(ImageUtil.colormatrix_ruise);
        mColorMatrixList.add(ImageUtil.colormatrix_gete);
        mColorMatrixList.add(ImageUtil.colormatrix_menghuan);
        mColorMatrixList.add(ImageUtil.colormatrix_langman);
        mColorMatrixList.add(ImageUtil.colormatrix_danya);
        mColorMatrixList.add(ImageUtil.colormatrix_jiao_pian);
        mColorMatrixList.add(ImageUtil.colormatrix_guangyun);
        mColorMatrixList.add(ImageUtil.colormatrix_heibai);
        mColorMatrixList.add(ImageUtil.colormatrix_huaijiu);
        mColorMatrixList.add(ImageUtil.colormatrix_fanse);

        //mRecyclerView = findViewById(R.id.recyclerView);
        //mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        //mRecyclerView.addItemDecoration(new ItemDecoration());
        //mBeautyAdapter = new BeautyAdapter();
        //mRecyclerView.setAdapter(mBeautyAdapter);

    }


    //按钮响应事件
    public void OnClick(View v){
        switch (v.getId()){
            case R.id.btn_select_image:
            {
                imgViewB.setImageDrawable(null);
                chooseImage();
                break;
            }
            case R.id.btn_save_bitmap:
            {
                saveImage(mBitmap);
                Toast toast=Toast.makeText(getApplicationContext(),"保存成功",Toast.LENGTH_SHORT    );
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                break;
            }
            case R.id.filterbtn_11:
            {
                if (imgViewA != null) {
                    imgViewB.setImageBitmap(mBitmap);
                    ColorMatrix colorMatrix = new ColorMatrix();
                    colorMatrix.set(mColorMatrixList.get(0));
                    //colorMatrix.set(ImageUtil.colormatrix_huguang);
                    imgViewB.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                    break;
                }
            }
            case R.id.filterbtn_12:
            {
                if (imgViewA != null) {
                    imgViewB.setImageBitmap(mBitmap);
                    ColorMatrix colorMatrix = new ColorMatrix();
                    colorMatrix.set(mColorMatrixList.get(1));
                    imgViewB.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                    break;
                }
            }
            case R.id.filterbtn_13:
            {
                if (imgViewA != null) {
                    imgViewB.setImageBitmap(mBitmap);
                    ColorMatrix colorMatrix = new ColorMatrix();
                    colorMatrix.set(mColorMatrixList.get(2));
                    imgViewB.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                    break;
                }
            }
            case R.id.filterbtn_14:
            {
                if (imgViewA != null) {
                    imgViewB.setImageBitmap(mBitmap);
                    ColorMatrix colorMatrix = new ColorMatrix();
                    colorMatrix.set(mColorMatrixList.get(3));
                    imgViewB.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                    break;
                }
            }
            case R.id.filterbtn_15:
            {
                if (imgViewA != null) {
                    imgViewB.setImageBitmap(mBitmap);
                    ColorMatrix colorMatrix = new ColorMatrix();
                    colorMatrix.set(mColorMatrixList.get(4));
                    imgViewB.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                    break;
                }
            }
            case R.id.filterbtn_16:
            {
                if (imgViewA != null) {
                    imgViewB.setImageBitmap(mBitmap);
                    ColorMatrix colorMatrix = new ColorMatrix();
                    colorMatrix.set(mColorMatrixList.get(5));
                    imgViewB.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                    break;
                }
            }
            case R.id.filterbtn_21:
            {
                if (imgViewA != null) {
                    imgViewB.setImageBitmap(mBitmap);
                    ColorMatrix colorMatrix = new ColorMatrix();
                    colorMatrix.set(mColorMatrixList.get(6));
                    imgViewB.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                    break;
                }
            }
            case R.id.filterbtn_22:
            {
                if (imgViewA != null) {
                    imgViewB.setImageBitmap(mBitmap);
                    ColorMatrix colorMatrix = new ColorMatrix();
                    colorMatrix.set(mColorMatrixList.get(7));
                    imgViewB.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                    break;
                }
            }
            case R.id.filterbtn_23:
            {
                if (imgViewA != null) {
                    imgViewB.setImageBitmap(mBitmap);
                    ColorMatrix colorMatrix = new ColorMatrix();
                    colorMatrix.set(mColorMatrixList.get(8));
                    imgViewB.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                    break;
                }
            }
            case R.id.filterbtn_24:
            {
                if (imgViewA != null) {
                    imgViewB.setImageBitmap(mBitmap);
                    ColorMatrix colorMatrix = new ColorMatrix();
                    colorMatrix.set(mColorMatrixList.get(9));
                    imgViewB.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                    break;
                }
            }
            case R.id.filterbtn_25:
            {
                if (imgViewA != null) {
                    imgViewB.setImageBitmap(mBitmap);
                    ColorMatrix colorMatrix = new ColorMatrix();
                    colorMatrix.set(mColorMatrixList.get(10));
                    imgViewB.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                    break;
                }
            }
            case R.id.filterbtn_26:
            {
                if (imgViewA != null) {
                    imgViewB.setImageBitmap(mBitmap);
                    ColorMatrix colorMatrix = new ColorMatrix();
                    colorMatrix.set(mColorMatrixList.get(11));
                    imgViewB.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                    break;
                }
            }
            case R.id.filterbtn_31:
            {
                if (imgViewA != null) {
                    imgViewB.setImageBitmap(mBitmap);
                    ColorMatrix colorMatrix = new ColorMatrix();
                    colorMatrix.set(mColorMatrixList.get(12));
                    imgViewB.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                    break;
                }
            }
            case R.id.filterbtn_32:
            {
                if (imgViewA != null) {
                    imgViewB.setImageBitmap(mBitmap);
                    ColorMatrix colorMatrix = new ColorMatrix();
                    colorMatrix.set(mColorMatrixList.get(13));
                    imgViewB.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                    break;
                }
            }
            case R.id.filterbtn_33:
            {
                if (imgViewA != null) {
                    imgViewB.setImageBitmap(mBitmap);
                    ColorMatrix colorMatrix = new ColorMatrix();
                    colorMatrix.set(mColorMatrixList.get(14));
                    imgViewB.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                    break;
                }
            }
            case R.id.filterbtn_34:
            {
                if (imgViewA != null) {
                    imgViewB.setImageBitmap(mBitmap);
                    ColorMatrix colorMatrix = new ColorMatrix();
                    colorMatrix.set(mColorMatrixList.get(15));
                    imgViewB.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                    break;
                }
            }
            case R.id.filterbtn_35:
            {
                if (imgViewA != null) {
                    imgViewB.setImageBitmap(mBitmap);
                    ColorMatrix colorMatrix = new ColorMatrix();
                    colorMatrix.set(mColorMatrixList.get(16));
                    imgViewB.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                    break;
                }
            }
            case R.id.filterbtn_36:
            {
                if (imgViewA != null) {
                    imgViewB.setImageBitmap(mBitmap);
                    ColorMatrix colorMatrix = new ColorMatrix();
                    colorMatrix.set(mColorMatrixList.get(17));
                    imgViewB.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                    break;
                }
            }

        }
    }


    //初始化图片视图
    private void initViewAB(){
        imgViewA = findViewById(R.id.imgViewA);
        imgViewB = findViewById(R.id.imgViewB);
        imgViewA.setImageDrawable(null);  //设置ImageView为空
        imgViewB.setImageDrawable(null);
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
    //选择图片之后的事件
    @Override
    protected void onActivityResult(int requestCode, int resultCode, final Intent data) {
        //用户操作完成，结果代码返1回是-，即RERULT_OK
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            //todo 获取文件定位，放置选择的图片
            imgUri= data.getData();
            Log.e("imgUri", imgUri.toString());

            ContentResolver cr= this.getContentResolver();
            try{
                //获取图片
                mBitmap = BitmapFactory.decodeStream(cr.openInputStream(imgUri));
                oBitmap = BitmapFactory.decodeStream(cr.openInputStream(imgUri));
                imgViewA.setImageBitmap(mBitmap);
            } catch (FileNotFoundException e){
                Log.e("Exception",e.getMessage(),e);
            }
            //imgViewA.setImageURI(imgUri);
            //videoView.start();  //播放视频
        }
        else{
            //操作错误或者没有选择图片
            Log.i("MainActivity","Operation Error!");

        }
        Log.d(TAG, "onActivityResult() called with: requestCode = [" + requestCode + "], resultCode = [" + resultCode + "], data = [" + data + "]");
    }

    /** 保存方法 */
//    public void saveImage(Bitmap mSaveBitmap ) {
//        if (mSaveBitmap == null)
//            return ;
//        String picName= Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + imgUri.toString() ;
//        Log.e(TAG, "保存图片");
//        File f = new File("/sdcard/BITKindergarten/files/", picName);
//        if (f.exists()) {
//            f.delete();
//        }
//        try {
//            FileOutputStream out = new FileOutputStream(f);
//            mSaveBitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
//            out.flush();
//            out.close();
//            Log.i(TAG, "已经保存");
//        } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        savecount = savecount+1;
//    }
        //保存文件到指定路径
        public static boolean saveImage( Bitmap bmp) {
            // 首先保存图片
            String storePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "BITKindergartenImg";
            File appDir = new File(storePath);
            if (!appDir.exists()) {
                appDir.mkdir();
            }
            String fileName = System.currentTimeMillis() + ".jpg";
            File file = new File(appDir, fileName);
            try {
                FileOutputStream fos = new FileOutputStream(file);
                //通过io流的方式来压缩保存图片
                boolean isSuccess = bmp.compress(Bitmap.CompressFormat.JPEG, 60, fos);
                fos.flush();
                fos.close();

//                Toast ts = Toast.makeText(getBaseContext(),"保存成功！", Toast.LENGTH_LONG);
//
//                ts.show();



                //把文件插入到系统图库
                //MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getAbsolutePath(), fileName, null);

                //保存图片后发送广播通知更新数据库
//                Uri uri = Uri.fromFile(file);
//                context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));
//                if (isSuccess) {
//                    return true;
//                } else {
//                    return false;
//                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return false;
        }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_IMAGE_CAPTURE: {
                //todo 判断权限是否已经授予

                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                for (int i = 0; i < permissions.length ; i++ ){
                    Log.i("MainActivity","申请的权限为：" + permissions[i] +"，申请结果：" +
                            grantResults[i]);
                }
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED
                        && grantResults[2] == PackageManager.PERMISSION_GRANTED) {
                    //takeVideo();
                    break;
                }
            }
        }
    }
}
