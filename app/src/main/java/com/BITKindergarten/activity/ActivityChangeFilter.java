package com.BITKindergarten.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.BITKindergarten.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 简单滤镜效果演示
 */
public class ActivityChangeFilter extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private BeautyAdapter mBeautyAdapter;
    private List<float[]> mColorMatrixList;

    private Bitmap mBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_filter);

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

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mRecyclerView.addItemDecoration(new ItemDecoration());
        mBeautyAdapter = new BeautyAdapter();
        mRecyclerView.setAdapter(mBeautyAdapter);

    }


    /**
     * 滤镜列表Adapter
     */
    class BeautyAdapter extends RecyclerView.Adapter<BeautyAdapter.BeautyViewHolder> {

        @NonNull
        @Override
        public BeautyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(ActivityChangeFilter.this).inflate(R.layout.item_recyclerview_image, null, false);
            BeautyViewHolder beautyViewHolder = new BeautyViewHolder(view);
            return beautyViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull BeautyViewHolder holder, int position) {
            ImageView imageView = holder.imageView;
            if (imageView != null) {
                imageView.setImageBitmap(mBitmap);
                ColorMatrix colorMatrix = new ColorMatrix();
                colorMatrix.set(mColorMatrixList.get(position));
                imageView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            }
        }

        @Override
        public int getItemCount() {
            return mColorMatrixList == null ? 0 : mColorMatrixList.size();
        }

        class BeautyViewHolder extends RecyclerView.ViewHolder {

            private ImageView imageView;

            public BeautyViewHolder(View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.imageView);
            }
        }
    }

    /**
     * 滤镜列表边框
     */
    class ItemDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
            super.onDraw(c, parent, state);
        }

        @Override
        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
            super.onDrawOver(c, parent, state);
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.set(3, 3, 3, 3);
        }
    }
}
