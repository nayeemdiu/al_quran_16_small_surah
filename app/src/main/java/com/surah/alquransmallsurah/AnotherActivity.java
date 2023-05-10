package com.surah.alquransmallsurah;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


public class AnotherActivity extends AppCompatActivity {

    TextView mTitleTv,mDescTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        ActionBar actionBar=getSupportActionBar();

          mDescTv=findViewById(R.id.decrption);
          mTitleTv=findViewById(R.id.title);


        Intent intent=getIntent();
        String mtitle=intent.getStringExtra("title");
        String mdec=intent.getStringExtra("description");
        actionBar.setTitle(mtitle);

        mTitleTv.setText(mtitle);
        mDescTv.setText(mdec);

    }
}
