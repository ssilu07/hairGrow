package com.royals.hairstylegirls;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.royals.hairstylegirls.adapter.HairStyleAdapter;
import com.royals.hairstylegirls.model.Design;
import com.royals.hairstylegirls.services.FavouriteList;

import java.util.Map;

public class DetailsActivity extends AppCompatActivity {

    public static Design hairStyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
      /*  MobileAds.initialize(this, initializationStatus -> {
            Map<String, AdapterStatus> statusMap = initializationStatus.getAdapterStatusMap();
            for (String adapterClass : statusMap.keySet()) {
                AdapterStatus status = statusMap.get(adapterClass);
                assert status != null;
            }
            FrameLayout adContainerView = findViewById(R.id.adView);
            AdView adView = new AdView(this);
            adView.setAdUnitId(getString(R.string.banner_id));
            adContainerView.addView(adView);
            adView.setAdSize(getAdSize(this));
            adView.loadAd(new AdRequest.Builder().build());
            adContainerView.setVisibility(View.VISIBLE);
        });*/
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(hairStyle.getTitle());
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(view -> finish());
        ImageView imageView = findViewById(R.id.header);
        imageView.setImageResource(hairStyle.getImage());
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        if(hairStyle.getTitle().equalsIgnoreCase("Favorite")) {
            Map<String, ?> allEntries = FavouriteList.getAll(this);
            if(allEntries.isEmpty()) {
                makeText(this,"Favorite list is empty",LENGTH_SHORT).show();
            } else {
                recyclerView.setAdapter(new HairStyleAdapter(this,"Favorite"));
            }
        } else {
            recyclerView.setAdapter(new HairStyleAdapter(this,hairStyle.getTitle()));
        }
    }
}