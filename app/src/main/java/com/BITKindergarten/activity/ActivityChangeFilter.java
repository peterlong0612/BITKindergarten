package com.BITKindergarten.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentResolver;
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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.BITKindergarten.R;

import java.io.FileNotFoundException;
import java.util.ArrayList;
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

    //private RecyclerView mRecyclerView;
    //private BeautyAdapter mBeautyAdapter;
    private List<float[]> mColorMatrixList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_filter);

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




    /**
     * 滤镜列表Adapter
     */
//    class BeautyAdapter extends RecyclerView.Adapter<BeautyAdapter.BeautyViewHolder> {
//
//        @NonNull
//        @Override
//        public BeautyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            View view = LayoutInflater.from(ActivityChangeFilter.this).inflate(R.layout.item_recyclerview_image, null, false);
//            BeautyViewHolder beautyViewHolder = new BeautyViewHolder(view);
//            return beautyViewHolder;
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull BeautyViewHolder holder, int position) {
//            ImageView imageView = holder.imageView;
//            if (imageView != null) {
//                imageView.setImageBitmap(mBitmap);
//                ColorMatrix colorMatrix = new ColorMatrix();
//                colorMatrix.set(mColorMatrixList.get(position));
//                imageView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
//            }
//        }
//
//        @Override
//        public int getItemCount() {
//            return mColorMatrixList == null ? 0 : mColorMatrixList.size();
//        }
//
//        class BeautyViewHolder extends RecyclerView.ViewHolder {
//
//            private ImageView imageView;
//
//            public BeautyViewHolder(View itemView) {
//                super(itemView);
//                imageView = itemView.findViewById(R.id.imageView);
//            }
//        }
//    }
//
//    /**
//     * 滤镜列表边框
//     */
//    class ItemDecoration extends RecyclerView.ItemDecoration {
//        @Override
//        public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
//            super.onDraw(c, parent, state);
//        }
//
//        @Override
//        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
//            super.onDrawOver(c, parent, state);
//        }
//
//        @Override
//        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//            outRect.set(3, 3, 3, 3);
//        }
//    }

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
        //用户操作完成，结果代码返回是-1，即RERULT_OK
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
