package com.example.cleanland.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.amplifyframework.datastore.generated.model.Condition;
import com.amplifyframework.datastore.generated.model.Donate;
import com.example.cleanland.R;

import java.util.ArrayList;

public class userDonations extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_donations);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<Donate> donates=new ArrayList<>();
//        donates.add(new Donate("0","0",1.2,1.3,1,2,
//                0,3,4,5,"0",Condition.A));

        TextView test1=findViewById(R.id.shirtsQuantitryDonations);
        test1.setText("1");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent backArrow =new Intent (getApplicationContext(),MainActivity.class);
        startActivity(backArrow);
        return true;

    }
}