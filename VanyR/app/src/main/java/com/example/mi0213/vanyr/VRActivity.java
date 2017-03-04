package com.example.mi0213.vanyr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class VRActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vr);
        String pos=getIntent().getStringExtra("pos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
