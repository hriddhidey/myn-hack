package com.example.mi0213.vanyr;

import android.content.Intent;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Data> dataList;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rv_catalog);

        populateData();
         adapter = new RecyclerViewAdapter(this, dataList);

        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));

        adapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                String pos = "item"+position;
                displayVR(pos);
            }
        });
    }

    private void displayVR(String pos) {/*
        Intent moveToVRActivity = new Intent(getApplicationContext(),VRActivity.class);
        moveToVRActivity.putExtra("pos",pos);
        startActivity(moveToVRActivity);*/
        Uri uri = Uri.parse("https://hriddhidey.github.io/myn-hack/"+pos+".html");

// create an intent builder
        CustomTabsIntent.Builder intentBuilder = new CustomTabsIntent.Builder();

// Begin customizing
// set toolbar colors
        intentBuilder.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        intentBuilder.setSecondaryToolbarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        intentBuilder.setShowTitle(false);

// set start and exit animations
        intentBuilder.setStartAnimations(this, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        intentBuilder.setExitAnimations(this, android.R.anim.slide_in_left,
                android.R.anim.slide_out_right);

// build custom tabs intent
        CustomTabsIntent customTabsIntent = intentBuilder.build();

// launch the url
        customTabsIntent.launchUrl(this, uri);

    }

    private void populateData() {
        dataList = new ArrayList<>();
        Data data = new Data(R.drawable.winter_shoes,"Winter Shoes");
        dataList.add(data);
        data = new Data(R.drawable.coat,"Coat");
        dataList.add(data);
        data = new Data(R.drawable.training_shoes,"Training Shoes");
        dataList.add(data);

    }


}
