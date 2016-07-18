package com.bandou.common;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ImageView;
import com.bandou.library.util.BitmapUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ImageView ivImageDemo = (ImageView) findViewById(R.id.ivImageDemo);
        Bitmap bitmap = BitmapUtils.drawableToBitmap(BitmapUtils.resToDrawable(this, R.mipmap.ic_launcher));
        bitmap = BitmapUtils.scaleEqualRatioMax(bitmap,20,false);
        ivImageDemo.setImageBitmap(bitmap);
    }
}
