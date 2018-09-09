package com.example.shiva.saveimgtodb;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shiva.saveimgtodb.Models.News;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{

    ArrayList<News> arrayList = new ArrayList<>();
    public RecyclerAdapter(ArrayList<News> arrayList){
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_item,viewGroup,false);
       RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);


        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i) {
        News news = arrayList.get(i);





        if (TextUtils.isEmpty(news.getTHUMBNAIL()) || TextUtils.isEmpty(news.getTITLE()) || TextUtils.isEmpty(news.getCONTENT())){

            Log.e("empty","dkzbckj");

        }else {
            recyclerViewHolder.title.setText(news.getTITLE());
            recyclerViewHolder.description.setText(getSafeSubstring(news.getCONTENT(), 40) + "...");

            Picasso.get().load(news.getTHUMBNAIL().toString()).into(recyclerViewHolder.image);


        }





    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class  RecyclerViewHolder extends  RecyclerView.ViewHolder{
        TextView title,description;
        ImageView image;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.news_title);
            description = (TextView) itemView.findViewById(R.id.news_description);
            image = (ImageView) itemView.findViewById(R.id.news_image);

        }
    }

    public String getSafeSubstring(String s, int maxLength){
        if(!TextUtils.isEmpty(s)){
            if(s.length() >= maxLength){
                return s.substring(0, maxLength);
            }
        }
        return s;
    }
}
