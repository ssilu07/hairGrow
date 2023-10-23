package com.royals.hairstylegirls.adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.royals.hairstylegirls.DetailsActivity;
import com.royals.hairstylegirls.R;
import com.royals.hairstylegirls.model.Design;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("RecyclerView")
public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context ctx;
    private final List<Design> hairStyleList;
 //   private InterstitialAd mInterstitialAd;

    public CategoryAdapter(Context ctx) {
        this.ctx = ctx;
        //LoadInterstitialAds();
        this.hairStyleList = new ArrayList<>();
        hairStyleList.add(new Design("Easy", R.drawable.easy));
        hairStyleList.add(new Design("Party", R.drawable.party));
        hairStyleList.add(new Design("School",R.drawable.school));
        hairStyleList.add(new Design("Short",R.drawable.shoort));
        hairStyleList.add(new Design("Work",R.drawable.work));
        hairStyleList.add(new Design("Favorite",R.drawable.favorite));
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryHolder(LayoutInflater.from(ctx).inflate(R.layout.category, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CategoryHolder categoryHolder = (CategoryHolder) holder;
        categoryHolder.title.setText(hairStyleList.get(position).getTitle());
        categoryHolder.image.setImageResource(hairStyleList.get(position).getImage());
        categoryHolder.itemView.setOnClickListener(view -> {

                DetailsActivity.hairStyle = hairStyleList.get(position);
                ctx.startActivity(new Intent(ctx, DetailsActivity.class));

        });
    }

    @Override
    public int getItemCount() {
        return hairStyleList.size();
    }

    private static class CategoryHolder extends RecyclerView.ViewHolder{
        private final TextView title;
        private final ImageView image;
        public CategoryHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.image);
        }
    }

/*    private void LoadInterstitialAds() {
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
    }*/
}
