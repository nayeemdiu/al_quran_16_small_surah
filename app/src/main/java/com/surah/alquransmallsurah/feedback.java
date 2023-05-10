package com.surah.alquransmallsurah;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.surah.alquransmallsurah.R;

public class feedback extends AppCompatActivity implements View.OnClickListener {

    private Button sandbutton,clearbutton;
    private EditText editText1,editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        getSupportActionBar().setTitle("Feedback");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sandbutton=findViewById(R.id.sand_btn);
        clearbutton=findViewById(R.id.clear_btn);

        editText1=findViewById(R.id.edit1_id);
        editText2=findViewById(R.id.edittext2_id);

        sandbutton.setOnClickListener(this);
        clearbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        try {

            String sand=editText1.getText().toString();
            String clear=editText2.getText().toString();


            if(v.getId()==R.id.clear_btn){

                Intent Email = new Intent(Intent.ACTION_SEND);
                Email.setType("text/email");
                Email.putExtra(Intent.EXTRA_EMAIL, new String[] { "nayeemdeveloper9596@gmail.com" });
                Email.putExtra(Intent.EXTRA_SUBJECT, "Feedback from app");
                Email.putExtra(Intent.EXTRA_TEXT, "Name : "+sand+ "\n\nFeedback : "+clear);
                startActivity(Intent.createChooser(Email, "Send Feedback:"));

            }
            else if(v.getId()==R.id.sand_btn){

                editText1.setText("");
                editText2.setText("");
            }


        }catch (Exception e){


            Toast.makeText(getApplicationContext(),"Exception"+e,Toast.LENGTH_SHORT).show();
        }
    }
}
