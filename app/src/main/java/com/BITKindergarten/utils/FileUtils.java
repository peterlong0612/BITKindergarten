package com.BITKindergarten.utils;

import android.graphics.Bitmap;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by peterlong on 2020/4/10.
 */

public class FileUtils {
    /**
     * 保存临时图片的临时图片，在保存渲染之后删除
     */
    public static final String TEMP_FILE = Environment.getExternalStorageDirectory().getPath() +
            File.separator + "com.BITKindergarten" + File.separator + "temp" + File.separator + "temp.jpg";

    /**
     * 保存渲染后图片的路径(保存在相册里面)
     */
    public static final String SAVE_FILE = Environment
            .getExternalStorageDirectory().toString() + "/DCIM/Camera" + File.separator;

    public static final String storePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "BITKindergartenImg";


}