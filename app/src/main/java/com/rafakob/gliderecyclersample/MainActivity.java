package com.rafakob.gliderecyclersample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setItemAnimator(new DefaultItemAnimator());

        PhotoAdapter photoAdapter = new PhotoAdapter();
        photoAdapter.photos.add("https://d2lm6fxwu08ot6.cloudfront.net/img-thumbs/960w/KMOCRGXHPP.jpg");
        photoAdapter.photos.add("https://d2lm6fxwu08ot6.cloudfront.net/img-thumbs/960w/0M1SPKYTR4.jpg");
        photoAdapter.photos.add("https://d2lm6fxwu08ot6.cloudfront.net/img-thumbs/960w/VWCAICDB8W.jpg");
        photoAdapter.photos.add("https://d2lm6fxwu08ot6.cloudfront.net/img-thumbs/960w/RGOP31CS3I.jpg");
        photoAdapter.photos.add("https://d2lm6fxwu08ot6.cloudfront.net/img-thumbs/960w/I7BM1ZCLED.jpg");
        photoAdapter.photos.add("https://d2lm6fxwu08ot6.cloudfront.net/img-thumbs/960w/MIHI3RHUHK.jpg");
        photoAdapter.photos.add("https://d2lm6fxwu08ot6.cloudfront.net/img-thumbs/960w/CJAH3PXNIK.jpg");
        photoAdapter.photos.add("https://d2lm6fxwu08ot6.cloudfront.net/img-thumbs/960w/KZIVNRC3C8.jpg");
        photoAdapter.photos.add("https://d2lm6fxwu08ot6.cloudfront.net/img-thumbs/960w/OMHOP3DADH.jpg");
        photoAdapter.photos.add("https://d2lm6fxwu08ot6.cloudfront.net/img-thumbs/960w/4EICH4YZ7Z.jpg");
        photoAdapter.photos.add("https://d2lm6fxwu08ot6.cloudfront.net/img-thumbs/960w/OCBS9JTNWW.jpg");
        photoAdapter.photos.add("https://d2lm6fxwu08ot6.cloudfront.net/img-thumbs/960w/XGXORJWZIX.jpg");
        photoAdapter.photos.add("https://d2lm6fxwu08ot6.cloudfront.net/img-thumbs/960w/8GS2WH93OE.jpg");
        photoAdapter.photos.add("https://d2lm6fxwu08ot6.cloudfront.net/img-thumbs/960w/ZPD8TDKRE9.jpg");
        photoAdapter.photos.add("https://d2lm6fxwu08ot6.cloudfront.net/img-thumbs/960w/INKDH43UE5.jpg");

        recycler.setAdapter(photoAdapter);
    }

    public static class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {

        List<String> photos = new ArrayList<>();

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo, parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.label.setText("Photo #" + position);

            Glide.with(holder.itemView.getContext())
                    .load(photos.get(position))
                    .apply(new RequestOptions().centerCrop())
                    .into(holder.photo);
        }

        @Override
        public int getItemCount() {
            return photos.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            ImageView photo;
            TextView label;

            public ViewHolder(View itemView) {
                super(itemView);
                photo = itemView.findViewById(R.id.photo);
                label = itemView.findViewById(R.id.label);
            }
        }
    }
}