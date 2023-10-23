package com.royals.hairstylegirls;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.royals.hairstylegirls.services.FavouriteList;

import java.util.Arrays;
import java.util.List;

public class PagerActivity extends AppCompatActivity {

    public static String title;
    private final int[] EasyList = new int[]{R.raw.easy1,R.raw.easy2,R.raw.easy3,R.raw.easy4,R.raw.easy5,R.raw.easy6,R.raw.easy7,R.raw.easy8,R.raw.easy9,R.raw.easy10,R.raw.easy11,R.raw.easy12,R.raw.easy13,R.raw.easy14,R.raw.easy15,R.raw.easy16};
    private final int[] PartyList = new int[]{R.raw.party1,R.raw.party2,R.raw.party3,R.raw.party4,R.raw.party5,R.raw.party6,R.raw.party7,R.raw.party8,R.raw.party9,R.raw.party10,R.raw.party11,R.raw.party12,R.raw.party13,R.raw.party14,R.raw.party15,R.raw.party16};
    private final int[] SchoolList = new int[]{R.raw.school1,R.raw.school2,R.raw.school3,R.raw.school4,R.raw.school5,R.raw.school6,R.raw.school7,R.raw.school8,R.raw.school9,R.raw.school10,R.raw.school11,R.raw.school12,R.raw.school13,R.raw.school14,R.raw.school15,R.raw.school16};
    private final int[] ShortList = new int[]{R.raw.short1,R.raw.short2,R.raw.short3,R.raw.short4,R.raw.short5,R.raw.short6,R.raw.short7,R.raw.short8,R.raw.short9,R.raw.short10,R.raw.short11,R.raw.short12,R.raw.short13,R.raw.short14,R.raw.short15,R.raw.short16};
    private final int[] WorkList = new int[]{R.raw.work1,R.raw.work2,R.raw.work3,R.raw.work4,R.raw.work5,R.raw.work6,R.raw.work7,R.raw.work8,R.raw.work9,R.raw.work10,R.raw.work11,R.raw.work12,R.raw.work13,R.raw.work14,R.raw.work15,R.raw.work16};
    private final int[] FavList = new int[]{R.raw.easy1,R.raw.easy2,R.raw.easy3,R.raw.easy4,R.raw.easy5,R.raw.easy6,R.raw.easy7,R.raw.easy8,R.raw.easy9,R.raw.easy10,R.raw.easy11,R.raw.easy12,R.raw.easy13,R.raw.easy14,R.raw.easy15,R.raw.easy16,R.raw.party1,
            R.raw.party2,R.raw.party3,R.raw.party4,R.raw.party5,R.raw.party6,R.raw.party7,R.raw.party8,R.raw.party9,R.raw.party10,R.raw.party11,R.raw.party12,R.raw.party13,R.raw.party14,R.raw.party15,R.raw.party16,R.raw.school1,R.raw.school2,R.raw.school3,
            R.raw.school4,R.raw.school5,R.raw.school6,R.raw.school7,R.raw.school8,R.raw.school9,R.raw.school10,R.raw.school11,R.raw.school12,R.raw.school13,R.raw.school14,R.raw.school15,R.raw.school16,R.raw.short1,R.raw.short2,R.raw.short3,R.raw.short4,R.raw.short5,
            R.raw.short6,R.raw.short7,R.raw.short8,R.raw.short9,R.raw.short10,R.raw.short11,R.raw.short12,R.raw.short13,R.raw.short14,R.raw.short15,R.raw.short16,R.raw.work1,R.raw.work2,R.raw.work3,R.raw.work4,R.raw.work5,R.raw.work6,R.raw.work7,R.raw.work8,R.raw.work9,
            R.raw.work10,R.raw.work11,R.raw.work12,R.raw.work13,R.raw.work14,R.raw.work15,R.raw.work16};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
       /* MobileAds.initialize(this, initializationStatus -> {
            Map<String, AdapterStatus> statusMap = initializationStatus.getAdapterStatusMap();
            for (String adapterClass : statusMap.keySet()) {
                AdapterStatus status = statusMap.get(adapterClass);
                assert status != null;
            }

        });*/
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(view -> finish());
        VideoView videoView = findViewById(R.id.video);
        String cat = DetailsActivity.hairStyle.getTitle();Uri src;
        if(cat.equalsIgnoreCase("Easy")) {
            List<String> I = Arrays.asList(new HairStyleList().getEasy());
            src = Uri.parse("android.resource://" + getPackageName() + "/raw/" + EasyList[I.indexOf(title)]);
        } else if(cat.equalsIgnoreCase("Party")) {
            List<String> I = Arrays.asList(new HairStyleList().getParty());
            src = Uri.parse("android.resource://" + getPackageName() + "/raw/" + PartyList[I.indexOf(title)]);
        } else if(cat.equalsIgnoreCase("School")) {
            List<String> I = Arrays.asList(new HairStyleList().getSchool());
            src = Uri.parse("android.resource://" + getPackageName() + "/raw/" + SchoolList[I.indexOf(title)]);
        } else if(cat.equalsIgnoreCase("Short")) {
            List<String> I = Arrays.asList(new HairStyleList().getShort());
            src = Uri.parse("android.resource://" + getPackageName() + "/raw/" + ShortList[I.indexOf(title)]);
        } else if(cat.equalsIgnoreCase("Work")) {
            List<String> I = Arrays.asList(new HairStyleList().getWork());
            src = Uri.parse("android.resource://" + getPackageName() + "/raw/" + WorkList[I.indexOf(title)]);
        } else {
            List<String> I = new HairStyleList().getFavorite();
            src = Uri.parse("android.resource://" + getPackageName() + "/raw/" + FavList[I.indexOf(title)]);
        }
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        mediaController.setMediaPlayer(videoView);
        videoView.setVideoURI(src);
        videoView.setMediaController(mediaController);
        videoView.setOnPreparedListener(mediaPlayer -> findViewById(R.id.play).setVisibility(View.VISIBLE));
        videoView.setOnCompletionListener(mediaPlayer -> findViewById(R.id.play).setVisibility(View.VISIBLE));
        findViewById(R.id.play).setOnClickListener(view -> {
            findViewById(R.id.play).setVisibility(View.GONE);
            videoView.start();
        });
        LinearLayout box = findViewById(R.id.box);
        findViewById(R.id.fab).setOnClickListener(view -> {
            if(box.getVisibility() == View.VISIBLE) {
                box.setVisibility(View.GONE);
            } else {
                box.setVisibility(View.VISIBLE);
            }
        });
        if (FavouriteList.isContains(PagerActivity.this,title)) {
            ((TextView)findViewById(R.id.like)).setCompoundDrawablesWithIntrinsicBounds(0,0,0,R.drawable.favtt);
        } else {
            ((TextView)findViewById(R.id.like)).setCompoundDrawablesWithIntrinsicBounds(0,0,0,R.drawable.favt);
        }
        findViewById(R.id.share).setOnClickListener(view -> {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(Intent.EXTRA_TITLE,getString(R.string.app_name));
            sharingIntent.putExtra(Intent.EXTRA_TEXT,"Hair Style App\n\nDownload the app from playstore \uD83D\uDC49 https://play.google.com/store/apps/details?id=" + getPackageName());
            startActivity(sharingIntent);
        });
        findViewById(R.id.like).setOnClickListener(view -> {
            if (FavouriteList.isContains(PagerActivity.this,title)) {
                FavouriteList.remove(PagerActivity.this,title);
                ((TextView)findViewById(R.id.like)).setCompoundDrawablesWithIntrinsicBounds(0,0,0,R.drawable.favt);
            } else {
                FavouriteList.add(PagerActivity.this,title, DetailsActivity.hairStyle.getTitle());
                ((TextView)findViewById(R.id.like)).setCompoundDrawablesWithIntrinsicBounds(0,0,0,R.drawable.favtt);
            }
        });

    }

}