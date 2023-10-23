package com.royals.hairstylegirls.adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.royals.hairstylegirls.DetailsActivity;
import com.royals.hairstylegirls.HairStyleList;
import com.royals.hairstylegirls.PagerActivity;
import com.royals.hairstylegirls.R;
import com.royals.hairstylegirls.model.HairStyle;
import com.royals.hairstylegirls.services.FavouriteList;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@SuppressLint("RecyclerView")
public class HairStyleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context ctx;
    private final List<HairStyle> hairStyleList;


    public HairStyleAdapter(Context ctx, String cat) {
        this.ctx = ctx;
        //LoadInterstitialAds();
        this.hairStyleList = new ArrayList<>();
        String[] data = new String[0];
        if(cat.equalsIgnoreCase("Easy")) {
            data = new HairStyleList().getEasy();
        } else if(cat.equalsIgnoreCase("Party")) {
            data = new HairStyleList().getParty();
        } else if(cat.equalsIgnoreCase("School")) {
            data = new HairStyleList().getSchool();
        } else if(cat.equalsIgnoreCase("Short")) {
            data = new HairStyleList().getShort();
        } else if(cat.equalsIgnoreCase("Work")) {
            data = new HairStyleList().getWork();
        }
        if(data.length != 0) {
            for (int i = 0; i < data.length; i++) {
                hairStyleList.add(new HairStyle(String.valueOf(i),data[i]));
            }
        } else {
            Map<String, ?> allEntries = FavouriteList.getAll(ctx);
            for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
                hairStyleList.add(new HairStyle(entry.getValue().toString(),entry.getKey()));
            }
        }
        Collections.shuffle(hairStyleList);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MehndiHolder(LayoutInflater.from(ctx).inflate(R.layout.hairstyle,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MehndiHolder mehndiHolder = (MehndiHolder) holder;
        try {
            InputStream ims = ctx.getAssets().open("img/" + hairStyleList.get(position).getImage());
            Drawable d = Drawable.createFromStream(ims, null);
            mehndiHolder.image.setImageDrawable(d);ims.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
        if (FavouriteList.isContains(ctx,hairStyleList.get(position).getImage())) {
            mehndiHolder.like.setBackgroundResource(R.drawable.liked);
        } else {
            mehndiHolder.like.setBackgroundResource(R.drawable.like);
        }
        mehndiHolder.like.setOnClickListener(view -> {
            if (FavouriteList.isContains(ctx,hairStyleList.get(position).getImage())) {
                FavouriteList.remove(ctx,hairStyleList.get(position).getImage());
                mehndiHolder.like.setBackgroundResource(R.drawable.like);
            } else {
                FavouriteList.add(ctx,hairStyleList.get(position).getImage(), DetailsActivity.hairStyle.getTitle());
                mehndiHolder.like.setBackgroundResource(R.drawable.liked);
            }
        });
        mehndiHolder.itemView.setOnClickListener(view -> {

                PagerActivity.title = hairStyleList.get(position).getImage();
                ctx.startActivity(new Intent(ctx, PagerActivity.class));

        });
    }

    @Override
    public int getItemCount() {
        return hairStyleList.size();
    }

    private static class MehndiHolder extends RecyclerView.ViewHolder{
        private final TextView like;
        private final ImageView image;
        public MehndiHolder(@NonNull View itemView) {
            super(itemView);
            like = itemView.findViewById(R.id.like);
            image = itemView.findViewById(R.id.image);
        }
    }

/*
    private void LoadInterstitialAds() {
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(ctx, ctx.getString(R.string.interstitial_id), adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                if(interstitialLoadCount < 10) {
                    interstitialLoadCount++;
                    LoadInterstitialAds();
                }
            }
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                super.onAdLoaded(interstitialAd);
                mInterstitialAd = interstitialAd;
            }
        });
    }
*/

}
