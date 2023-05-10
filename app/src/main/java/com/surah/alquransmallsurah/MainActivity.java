package com.surah.alquransmallsurah;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.surah.alquransmallsurah.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.CascadingMenuPopup;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final CascadingMenuPopup.CascadingMenuInfo R = ;
    private AdView mAdView;
    RecyclerView mrecyclerView;
    MyAdapter myAdapter;

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });







        mrecyclerView=findViewById(R.id.recyclearView);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter=new MyAdapter(this,getMyList());


        mrecyclerView.setAdapter(myAdapter);



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //  FloatingActionButton fab = findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
        //   @Override
        //  public void onClick(View view) {
        //    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //.setAction("Action", null).show();
        //   }
        // });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        myAleart(MainActivity.this);
    }
    public void myAleart(Context context){

        AlertDialog.Builder alertdiolog = new AlertDialog.Builder(MainActivity.this);
        alertdiolog.setTitle("সতর্কতা" );
        alertdiolog.setMessage("আপনি কি অ্যাপ থেকে বের হতে চান ?");
        alertdiolog.setIcon(R.drawable.images);
        alertdiolog.setCancelable(false);

        alertdiolog.setPositiveButton("হ্যাঁ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }

        });

        alertdiolog.setNegativeButton("না", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }

        });


        AlertDialog  alertDialog =alertdiolog.create();
        alertDialog.show();



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.feedback) {
            Intent intent= new Intent(MainActivity.this,feedback.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_reting) {
            Uri uri = Uri.parse("https:/play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
            Intent i = new Intent(Intent.ACTION_VIEW,uri);
            try {

                startActivity(i);

            }catch (Exception e){
                Toast.makeText(MainActivity.this,"Unable to open\n"+e.getMessage(),Toast.LENGTH_SHORT).show();
            }


        } else if (id == R.id.nav_share) {

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String subject="Al Quran Coto Sura App";
            String body ="Al Quran Coto Sura App \n\n\n\"com.example.namazer33cotosura\"";
            intent.putExtra(Intent.EXTRA_TEXT,subject);
            intent.putExtra(Intent.EXTRA_TEXT,body);

            startActivity(Intent.createChooser(intent,"share with"));


        } else if (id == R.id.email) {

            Intent Email = new Intent(Intent.ACTION_SEND);
            Email.setType("text/email");
            Email.putExtra(Intent.EXTRA_EMAIL, new String[] { "nayeemdeveloper9596@gmail.com" });
            Email.putExtra(Intent.EXTRA_SUBJECT, "Email");
            Email.putExtra(Intent.EXTRA_TEXT, "Sir ...," + "");
            startActivity(Intent.createChooser(Email, "Sand Email"));
            return true;

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private ArrayList<Model>getMyList(){

        ArrayList<Model> models=new ArrayList<>();
        Model m=new Model();
        m.setTitle("সূরা আল-ফাতিহা");
        m.setDescription("Al Fatiha");
        m.setImg(R.drawable.quranpic);
        models.add(m);

        m=new Model();
        m.setTitle("সূরা আদিয়াত");
        m.setDescription("Surah Adiyat");
        m.setImg(R.drawable.quranpic);
        models.add(m);

        m=new Model();
        m.setTitle("সূরা আল কারিয়াহ");
        m.setDescription(" Surah Al Qariah");
        m.setImg(R.drawable.quranpic);
        models.add(m);


        m=new Model();
        m.setTitle("সূরা তাকাসুর");
        m.setDescription(" Surah At-Takathur");
        m.setImg(R.drawable.quranpic);
        models.add(m);

        m=new Model();
        m.setTitle("সূরা আল - আসর");
        m.setDescription(" Surah Al Asr");
        m.setImg(R.drawable.quranpic);
        models.add(m);


        m=new Model();
        m.setTitle("সূরা হুমাযাহ ");
        m.setDescription("Surah al Humazah");
        m.setImg(R.drawable.quranpic);
        models.add(m);


        m=new Model();
        m.setTitle("সূরা ফীল ");
        m.setDescription("Surah Al Fil");
        m.setImg(R.drawable.quranpic);
        models.add(m);



        m=new Model();
        m.setTitle("সূরা কুরাইশ");
        m.setDescription("Surah Quraysh");
        m.setImg(R.drawable.quranpic);
        models.add(m);


        m=new Model();
        m.setTitle("সূরা আল-মাউন ");
        m.setDescription("Surah Maun");
        m.setImg(R.drawable.quranpic);
        models.add(m);


        m=new Model();
        m.setTitle("সূরা কাওসার");
        m.setDescription("Surah Kawthar");
        m.setImg(R.drawable.quranpic);
        models.add(m);


        m=new Model();
        m.setTitle("সুরা কাফিরুন ");
        m.setDescription(" Surah Al Kafirun");
        m.setImg(R.drawable.quranpic);
        models.add(m);



        m=new Model();
        m.setTitle("সূরা আন - নাছর");
        m.setDescription("Surah Al Nasor");
        m.setImg(R.drawable.quranpic);
        models.add(m);

        m=new Model();
        m.setTitle("সূরা আল - লাহাব");
        m.setDescription(" Surah Al Lahab");
        m.setImg(R.drawable.quranpic);
        models.add(m);


        m=new Model();
        m.setTitle("সূরা ইখলাস ");
        m.setDescription("Surah Ikhlas");
        m.setImg(R.drawable.quranpic);
        models.add(m);

        m=new Model();
        m.setTitle("সূরা আল - ফালাক  ");
        m.setDescription("Surah Al Falaq");
        m.setImg(R.drawable.quranpic);
        models.add(m);

        m=new Model();
        m.setTitle("সূরা নাস ");
        m.setDescription("Surah Nas");
        m.setImg(R.drawable.quranpic);
        models.add(m);


        return models;

    }



}


