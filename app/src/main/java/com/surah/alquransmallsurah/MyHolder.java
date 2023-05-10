package com.surah.alquransmallsurah;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.surah.alquransmallsurah.R;

public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView mimageView;
    TextView mtitle,mdes;
    IteamClickLecener iteamClickLecener;
    MyHolder(@NonNull View itemView) {
        super(itemView);

        this.mimageView=itemView.findViewById(R.id.imageIv);
        this.mtitle=itemView.findViewById(R.id.titleTv);
        this.mdes=itemView.findViewById(R.id.descriptionTv);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        this.iteamClickLecener.onIteamClickLecener(v,getLayoutPosition());

    }
    public void setIteamClickLecener(IteamClickLecener ic){

        this.iteamClickLecener = ic;
    }
}
