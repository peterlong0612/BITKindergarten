package com.BITKindergarten.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.BITKindergarten.R;
import com.BITKindergarten.utils.ImageUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 简单滤镜效果演示
 */
public class ActivityChangeFilter extends AppCompatActivity {
    public String TAG="ActivityChangeFilter";

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int PICK_IMAGE = 1;
    private ImageView imgViewA;
    private ImageView imgViewB;

    public static final int DRAW_TYPE_MATRIX = 0;
    public static final int DRAW_TYPE_MASK = 1;
    private BlurMaskFilter blurMaskFilter;
    private RectF rectF;
    private int finalPos;
    private int drawType = 0;

    private Uri imgUri;
    private Bitmap mBitmap;
    private Bitmap sBitmap;

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
        /** 获得图片*/
//        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test2);


        mColorMatrixList = new ArrayList<float[]>();
        mColorMatrixList.add(ImageUtil.colormatrix_huguang);
        mColorMatrixList.add(ImageUtil.colormatrix_hepian);
        mColorMatrixList.add(ImageUtil.colormatrix_landiao);
        mColorMatrixList.add(ImageUtil.colormatrix_qingning);
        mColorMatrixList.add(ImageUtil.colormatrix_yese);
        mColorMatrixList.add(ImageUtil.colormatrix_fugu);
        mColorMatrixList.add(ImageUtil.colormatrix_fan_huang);
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

    private void addFilter(int pos){
        /** 这个判定稍显简单，但是有效*/
        if (imgViewA != null) {
            imgViewB.setImageBitmap(mBitmap);
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.set(mColorMatrixList.get(pos));
            //colorMatrix.set(ImageUtil.colormatrix_huguang);
            imgViewB.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        }

        finalPos = pos;
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
            case R.id.filterbtn_11:
            {
                addFilter(0);
                break;
            }
            case R.id.filterbtn_12:
            {
                addFilter(1);
                break;
            }
            case R.id.filterbtn_13:
            {
                addFilter(2);
                break;
            }
            case R.id.filterbtn_14:
            {
                addFilter(3);break;
            }
            case R.id.filterbtn_15:
            {
                addFilter(4);break;
            }
            case R.id.filterbtn_16:
            {
                addFilter(5);break;
            }
            case R.id.filterbtn_21:
            {
                addFilter(6);break;
            }
            case R.id.filterbtn_22:
            {
                addFilter(7);break;
            }
            case R.id.filterbtn_23:
            {
                addFilter(8);break;
            }
            case R.id.filterbtn_24:
            {
                addFilter(9);break;
            }
            case R.id.filterbtn_25:
            {
                addFilter(10);break;
            }
            case R.id.filterbtn_26:
            {
                addFilter(11);break;
            }
            case R.id.filterbtn_31:
            {
                addFilter(12);break;
            }
            case R.id.filterbtn_32:
            {
                addFilter(13);break;
            }
            case R.id.filterbtn_33:
            {
                addFilter(14);break;
            }
            case R.id.filterbtn_34:
            {
                addFilter(15);break;
            }
            case R.id.filterbtn_35:
            {
                addFilter(16);break;
            }
            case R.id.filterbtn_36:
            {
                addFilter(17);break;
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
                // mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test2);
                mBitmap = BitmapFactory.decodeStream(cr.openInputStream(imgUri));
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

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        switch (requestCode) {
//            case REQUEST_IMAGE_CAPTURE: {
//                //todo 判断权限是否已经授予
//
//                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//                for (int i = 0; i < permissions.length ; i++ ){
//                    Log.i("MainActivity","申请的权限为：" + permissions[i] +"，申请结果：" +
//                            grantResults[i]);
//                }
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED
//                        && grantResults[1] == PackageManager.PERMISSION_GRANTED
//                        && grantResults[2] == PackageManager.PERMISSION_GRANTED) {
//                    //takeVideo();
//                    break;
//                }
//            }
//        }
//    }
}
