package com.example.shiva.saveimgtodb;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.Log;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PicassoImageDownloader {

    public static String  getImageUrl(){
        String imageUrl="http://images.all-free-download.com/images/graphiclarge/travel_trip_picture_3_167827.jpg";
        return imageUrl;
    }

    public static void imageDownload() {
        try {

            String url=getImageUrl();
            Picasso.get()
                    .load(url)
                    .into(getTarget(getFileName("ImageName.jpeg")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getFileName(String fileName) {
        File file = new File(Environment.getExternalStorageDirectory().getPath(), "Images");
        if (!file.exists()) {
            file.mkdirs();
        }
        String uriSting = (file.getAbsolutePath() + "/" + fileName);
        return uriSting;

    }


    //target to save
    private static Target getTarget(final String fileName) {
        Target target = new Target() {

            @Override
            public void onBitmapLoaded(final Bitmap bitmap, Picasso.LoadedFrom from) {
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            File file = new File(getFileName(fileName));
                            if (file.exists()) {
                                file.delete();
                            }
                            file.createNewFile();
                            FileOutputStream fileoutputstream = new FileOutputStream(file);
                            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 60, bytearrayoutputstream);
                            fileoutputstream.write(bytearrayoutputstream.toByteArray());
                            fileoutputstream.close();
                        } catch (IOException e) {
                            Log.e("IOException", e.getLocalizedMessage());
                        }
                    }
                }).start();

            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }


            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };
        return target;
    }



    public static String getFileFullPath(String fileName) {
        try {
            if (fileName != null && !fileName.isEmpty()) {
                String base = Environment.getExternalStorageDirectory().getAbsolutePath().toString();
                return "file://" + base + "/Images/" + fileName;
            } else return "";
        } catch (Exception e) {
            return "";
        }
    }



}
