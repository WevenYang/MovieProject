package com.example.administrator.traveldiary.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.administrator.traveldiary.R;
import com.example.administrator.traveldiary.bean.LoginInfo;
import com.example.administrator.traveldiary.presenter.RecyclerViewPresent;
import com.example.administrator.traveldiary.subscribers.ProgressSubscriber;
import com.example.administrator.traveldiary.subscribers.SubscriberOnNextListener;
import com.example.administrator.traveldiary.util.LoginRequest;
import com.example.administrator.traveldiary.util.MyToast;
import com.example.administrator.traveldiary.util.PhotoDialog;
import com.example.administrator.traveldiary.util.SharePreferenceUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class WriteActivity extends BaseActivity implements View.OnClickListener {

    EditText title, content;
    ImageView public_icon;
    RecyclerViewPresent present;
    String pathImage;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        initBase();
        toolbar.setNavigationIcon(R.mipmap.back_ib);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void initBase(){
        title = (EditText) findViewById(R.id.title);
        content = (EditText) findViewById(R.id.content);
        public_icon = (ImageView) findViewById(R.id.public_icon);
        public_icon.setOnClickListener(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_edit_comment);
        toolbar.setOnMenuItemClickListener(listener);
        present = new RecyclerViewPresent(this);
    }

    private Toolbar.OnMenuItemClickListener listener = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()){
                case R.id.finish:
                    if (TextUtils.isEmpty(title.getText().toString()) || TextUtils.isEmpty(content.getText().toString())){
                        MyToast.showMyToast(WriteActivity.this, "标题或者内容不能为空");
                    }else {
                        LoginRequest.newInstance().submitMovieShare(new ProgressSubscriber(new SubscriberOnNextListener<LoginInfo>() {
                            @Override
                            public void onNext(LoginInfo o) {
                                MyToast.showMyToast(WriteActivity.this, o.getResult());
                                if (o.isSuccess()){
                                   finish();
                                }
                            }
                        }, WriteActivity.this), SharePreferenceUtils.getParam(WriteActivity.this, "id", "0").toString(), SharePreferenceUtils.getParam(WriteActivity.this, "name", "0").toString(),
                                title.getText().toString(), content.getText().toString(), "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577599166750&di=246a10e10eb523078d19c00107b54346&imgtype=0&src=http%3A%2F%2Fimg2.moko.cc%2Fusers%2F0%2F35%2F10534%2Fpost%2Fff%2Fimg2_src_10601702.jpg");
                    }
//                    present.uploadComment(EditActivity.this, SharePreferenceUtils.getParam(EditActivity.this, "token", "").toString(), getIntent().getStringExtra("nick"), "鸡汤高手",
//                            getIntent().getStringExtra("img"), title.getText().toString(), content.getText().toString(), "http://pic2.ooopic.com/11/03/95/92b1OOOPIC75.jpg",TimeUtil.newInstance().getTime());
//                    try {
//                        new AsyncHttpUtil(EditActivity.this).upload("http://192.168.1.101/dashboard/new/practise/upload.php", file);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    MyToast.showMyToast(EditActivity.this, "click");
                    break;
//                case R.id.photo:
//                    PhotoDialog dialog = new PhotoDialog(WriteActivity.this);
//                    dialog.show();
//                    break;
                default:
                    break;
            }
            return true;
        }
    };

//    private void bitmapFactory(Uri uri){
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;
//        DisplayMetrics dm = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//        int width = dm.widthPixels;
//        int height = dm.heightPixels;
//        int heightRadio = (int)Math.ceil(options.outHeight / (float)height);
//        int widthRadio = (int)Math.ceil(options.outWidth / (float)width);
//        if(heightRadio > 1 && widthRadio > 1){
//            options.inSampleSize = heightRadio;
//        }else {
//            options.inSampleSize = widthRadio;
//        }
//
//        options.inJustDecodeBounds = false;
//        Bitmap b;
//        try {
//            b = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), null, options);
//            content.setIm(b);
//        };
//    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PhotoDialog.TAKE_PHOTO_WITH_DATA:

                if (hasSdcard()){
                    file = new File(Environment.getExternalStorageDirectory(),
                            PhotoDialog.IMAGE_NAME);
                }else {
                    MyToast.showMyToast(WriteActivity.this, "没有SDCard");
                }
                break;
            case PhotoDialog.GET_PHOTO_WITH_DATA:
                Uri uri = data.getData();
                //写法一：使用cursor加载单张或者多张图片
//                    if (!TextUtils.isEmpty(uri.getAuthority())){
//                        Cursor cursor = getContentResolver().query(uri, new String[] {MediaStore.Images.Media.DATA}, null, null, null);
//                        if (null == cursor){
//                            return;
//                        }
//                        cursor.moveToFirst();
//                            pathImage = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
//                            if (!TextUtils.isEmpty(pathImage)){
//                                Bitmap addbmp = BitmapFactory.decodeFile(pathImage);
//                                public_icon.setImageBitmap(addbmp);
//                                pathImage = null;
//                            }

                //写法二：使用输入流加载单张图片
                try {
                    InputStream input = getContentResolver().openInputStream(uri);
                    Bitmap bitmap = BitmapFactory.decodeStream(input);
                    comp(bitmap);
                    public_icon.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                break;
            default:
                break;
        }
    }

    //判断是否有SDcard
    public static boolean hasSdcard(){
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)){
            return true;
        }else {
            return false;
        }
    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.public_icon:
                PhotoDialog dialog = new PhotoDialog(WriteActivity.this);
                dialog.show();
                break;
            default:
                break;
        }
    }

    //对图片进行质量压缩
    private Bitmap compressImage(Bitmap image) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        int options = 100;
        while ( baos.toByteArray().length / 1024>100) {  //循环判断如果压缩后图片是否大于100kb,大于继续压缩
            baos.reset();//重置baos即清空baos
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
            options -= 10;//每次都减少10
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//把ByteArrayInputStream数据生成图片
        return bitmap;
    }

    //对图片进行等比例压缩
    private Bitmap comp(Bitmap image) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        if( baos.toByteArray().length / 1024>1024) {//判断如果图片大于1M,进行压缩避免在生成图片（BitmapFactory.decodeStream）时溢出
            baos.reset();//重置baos即清空baos
            image.compress(Bitmap.CompressFormat.JPEG, 50, baos);//这里压缩50%，把压缩后的数据存放到baos中
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());
        BitmapFactory.Options newOpts = new BitmapFactory.Options();
        //开始读入图片，此时把options.inJustDecodeBounds 设回true了
        newOpts.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);
        newOpts.inJustDecodeBounds = false;
        int w = newOpts.outWidth;
        int h = newOpts.outHeight;
        //现在主流手机比较多是800*480分辨率，所以高和宽我们设置为
        float hh = 800f;//这里设置高度为800f
        float ww = 480f;//这里设置宽度为480f
        //缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
        int be = 1;//be=1表示不缩放
        if (w > h && w > ww) {//如果宽度大的话根据宽度固定大小缩放
            be = (int) (newOpts.outWidth / ww);
        } else if (w < h && h > hh) {//如果高度高的话根据宽度固定大小缩放
            be = (int) (newOpts.outHeight / hh);
        }
        if (be <= 0)
            be = 1;
        newOpts.inSampleSize = be;//设置缩放比例
        //重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
        isBm = new ByteArrayInputStream(baos.toByteArray());
        bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);
        return compressImage(bitmap);//压缩好比例大小后再进行质量压缩
    }
}
