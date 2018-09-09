package com.example.shiva.saveimgtodb;


import android.database.Cursor;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shiva.saveimgtodb.Models.Media.Media;
import com.example.shiva.saveimgtodb.Models.PostList.PostList;
import com.example.shiva.saveimgtodb.Models.RetrofitClient;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    DataHelper myDb;
    Button button;
    EditText text_name,text_surname,text_marks;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DataHelper(this);

        button = (Button) findViewById(R.id.button);

        text_name = (EditText) findViewById(R.id.editText);
        text_surname = (EditText) findViewById(R.id.editText2);
        text_marks = (EditText) findViewById(R.id.editText3);
        textView = (TextView) findViewById(R.id.textView);


        Call<List<PostList>> call = RetrofitClient.getmInstance().getApi().getPostList();
        Cursor cursor = myDb.getAllData();
        final ArrayList<String> mylist = new ArrayList<String>();


        while (cursor.moveToNext()){
            mylist.add(cursor.getString(1));
        }

        final ArrayList<String> image_array = new ArrayList<String>();
        final ArrayList<String> thumbnai_array = new ArrayList<String>();
       final StringBuilder builder = new StringBuilder();

        call.enqueue(new Callback<List<PostList>>() {
            private String post_id,link,title,content,small_img,image,date,photo_id;
            @Override
            public void onResponse(Call<List<PostList>> call, Response<List<PostList>> response) {
                List<PostList> postLists = response.body();
                for(int i=0;i < postLists.size();i++){
                    Document title_r = Jsoup.parse(postLists.get(i).getTitle().getRendered());
                    Document body_r = Jsoup.parse(postLists.get(i).getContent().getRendered());



                    post_id = postLists.get(i).getId().toString();
                    link = postLists.get(i).getLink().toString();
                    title = title_r.text();
                    content = body_r.text();
                    date = postLists.get(i).getDate().toString();

                    if (!mylist.contains(postLists.get(i).getId().toString())){


                        boolean isInseter = myDb.insertData(post_id,link,title,content,date);
                        if (isInseter == true){
                        }else {
                            Toast.makeText(getApplicationContext(), "Error inserting data", Toast.LENGTH_LONG).show();
                        }


                        Call<List<Media>> call1 = RetrofitClient.getmInstance().getApi().resposForImg(postLists.get(i).getId());

                        call1.enqueue(new Callback<List<Media>>() {
                            @Override
                            public void onResponse(Call<List<Media>> call, Response<List<Media>> response) {
                                List<Media> mediaList = response.body();
                                for (int j=0; j<mediaList.size(); j++){
                                    photo_id = mediaList.get(j).getPost().toString();
                                    image = mediaList.get(j).getGuid().getRendered().toString();
                                    small_img = mediaList.get(j).getMediaDetails().getSizes().getThumbnail().getSourceUrl().toString();

                                    Log.e("image" ,image);
                                    Log.e("thumbnail" ,small_img);
                                    Log.e("if" ,photo_id);




                                    boolean update =  myDb.updateImage(image,small_img,photo_id);

                                    if (update){
                                        Toast.makeText(getApplicationContext(),"updated success fully", Toast.LENGTH_LONG).show();
                                    }



                                }
                            }

                            @Override
                            public void onFailure(Call<List<Media>> call, Throwable t) {

                            }
                        });






                    }









                }
                Toast.makeText(getApplicationContext(),"ssssuccsess", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<PostList>> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"eeeeeeeror", Toast.LENGTH_LONG).show();

            }
        });


    }





}
