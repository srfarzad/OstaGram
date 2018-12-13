package com.ostagram.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ostagram.R;
import com.ostagram.customView.CircleTransform;
import com.ostagram.models.Images;
import com.ostagram.models.Posts;
import com.ostagram.webservice.ApiClient;
import com.ostagram.webservice.DataParser;
import com.squareup.picasso.Picasso;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {

    List<Posts> postsList;
    Context context;
    public PostsAdapter(Context context, List<Posts> posts){
        postsList = posts;
        this.context = context;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.instagram_row,null);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int position) {


        Posts posts = postsList.get(position);

        postViewHolder.txt_title.setText(posts.getUsername());


        Picasso.get().load(ApiClient.BaseURL+"images/"+posts.getImageProfile()).
                transform(new CircleTransform())
                .into(postViewHolder.img_profile);


        String images = posts.getImages();


        Log.e("","");


        try {
            List<Images> imagesList = DataParser.getImages(images);

            postViewHolder.pager.setAdapter(new SlidingImage_Adapter(context, imagesList));

            postViewHolder.indicator.setViewPager(postViewHolder.pager);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.img_profile) AppCompatImageView img_profile;
        @BindView(R.id.img_favorite) AppCompatImageView img_favorite;
        @BindView(R.id.img_share) AppCompatImageView img_share;
        @BindView(R.id.img_comments) AppCompatImageView img_comments;
        @BindView(R.id.txt_title) AppCompatTextView txt_title;
        @BindView(R.id.pager) ViewPager pager;
        @BindView(R.id.indicator) CirclePageIndicator indicator;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
