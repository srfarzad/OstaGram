package com.ostagram.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ostagram.R;
import com.ostagram.models.Images;
import com.ostagram.webservice.ApiClient;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android on 9/27/2017.
 */

public class SlidingImage_Adapter extends PagerAdapter {


    Context m_context;

    List<Images> appsArrayList = new ArrayList<>();
    LayoutInflater inflater;

    public SlidingImage_Adapter(Context context, List<Images> data) {

        m_context = context;

        appsArrayList = data;

        inflater = LayoutInflater.from(m_context);

    }

    @Override
    public int getCount() {
        return appsArrayList.size();
    }


    @Override
    public Object instantiateItem(ViewGroup view, final int position) {
        View imageLayout = inflater.inflate(R.layout.slidingimages_layout, view, false);

        Images apps = appsArrayList.get(position);
        assert imageLayout != null;
        final ImageView imageView = (ImageView) imageLayout
                .findViewById(R.id.image);

        LinearLayout lin_product = (LinearLayout) imageLayout.findViewById(R.id.lin_product);


        Picasso.get()
                .load(ApiClient.BaseURL + "images/" + apps.getImg())
                .error(R.mipmap.ic_launcher)
                .into(imageView);

        view.addView(imageLayout, 0);


        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}
