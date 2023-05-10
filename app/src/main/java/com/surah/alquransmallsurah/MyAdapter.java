package com.surah.alquransmallsurah;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.surah.alquransmallsurah.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<Model> models;

    public MyAdapter(Context c, ArrayList<Model> models) {
        this.c = c;
        this.models = models;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sura_item_list,null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        holder.mtitle.setText(models.get(position).getTitle());
        holder.mdes.setText(models.get(position).getDescription());
        holder.mimageView.setImageResource(models.get(position).getImg());




        holder.setIteamClickLecener(new IteamClickLecener() {
            @Override
            public void onIteamClickLecener(View v, int position) {


                if(models.get(position).getTitle().equals("সূরা আল-ফাতিহা")){


                    Intent intent=new Intent(c,Al_fatiha.class);

                    c.startActivity(intent);

                }

                if(models.get(position).getTitle().equals("সূরা আদিয়াত")){

                    Intent intent=new Intent(c,surah_adiyat.class);

                    c.startActivity(intent);
                }

                if(models.get(position).getTitle().equals("সূরা আল কারিয়াহ")){

                    Intent intent=new Intent(c,Al_Qariah.class);

                    c.startActivity(intent);
                }



                if(models.get(position).getTitle().equals("সূরা তাকাসুর")){

                    Intent intent=new Intent(c,takasur.class);

                    c.startActivity(intent);
                }
                if(models.get(position).getTitle().equals("সূরা আল - আসর")){

                    Intent intent=new Intent(c,asr.class);

                    c.startActivity(intent);
                }
                if(models.get(position).getTitle().equals("সূরা হুমাযাহ ")){

                    Intent intent=new Intent(c,hamzah.class);

                    c.startActivity(intent);
                }

                if(models.get(position).getTitle().equals("সূরা ফীল ")){

                    Intent intent=new Intent(c,fil.class);

                    c.startActivity(intent);
                }


                if(models.get(position).getTitle().equals("সূরা কুরাইশ")){

                    Intent intent=new Intent(c,quraesh.class);

                    c.startActivity(intent);
                }
                if(models.get(position).getTitle().equals("সূরা আল-মাউন ")){

                    Intent intent=new Intent(c,mamun.class);

                    c.startActivity(intent);
                }
                if(models.get(position).getTitle().equals("সূরা কাওসার")){

                    Intent intent=new Intent(c,kawser.class);

                    c.startActivity(intent);
                }
                if(models.get(position).getTitle().equals("সুরা কাফিরুন ")){

                    Intent intent=new Intent(c,kafirun.class);

                    c.startActivity(intent);
                }
                if(models.get(position).getTitle().equals("সূরা আন - নাছর")){

                    Intent intent=new Intent(c,nasor.class);

                    c.startActivity(intent);
                } if(models.get(position).getTitle().equals("সূরা আল - লাহাব")){

                    Intent intent=new Intent(c,masad.class);

                    c.startActivity(intent);
                } if(models.get(position).getTitle().equals("সূরা ইখলাস ")){

                    Intent intent=new Intent(c,akelas.class);

                    c.startActivity(intent);
                }
                if(models.get(position).getTitle().equals("সূরা আল - ফালাক  ")){

                    Intent intent=new Intent(c,falaq.class);

                    c.startActivity(intent);
                }if(models.get(position).getTitle().equals("সূরা নাস ")){

                    Intent intent=new Intent(c,nas.class);

                    c.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
