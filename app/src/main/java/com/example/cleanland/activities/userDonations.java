package com.example.cleanland.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.datastore.generated.model.Condition;
import com.amplifyframework.datastore.generated.model.Donate;
import com.amplifyframework.datastore.generated.model.Orders;
import com.example.cleanland.R;
import com.example.cleanland.adapters.ViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class userDonations extends AppCompatActivity {

    @Override
    public void onResume(){
        super.onResume();
        this.handleRViewShow();
    }
    private void handleRViewShow(){
        List<Donate> donateToView = new ArrayList<>();

        try {
            Amplify.DataStore.query(Donate.class,
                    donates -> {
                        String pickUp="";
                        Integer shirt=0;
                        Integer jacket=0;
                        Integer panties=0;
                        Integer suites=0;
                        while (donates.hasNext()) {
                            Donate donate = donates.next();
                            donateToView.add(donate);

                            if(donate.getShirtsQuantity()!=0)
                                shirt+=donate.getShirtsQuantity();

                            if(donate.getJacketsQuantity()!=0)
                                jacket+=donate.getJacketsQuantity();

                            if(donate.getPantiesQuantity()!=0)
                                panties+=donate.getPantiesQuantity();

                            if(donate.getSuitesQuantity()!=0)
                                suites+=donate.getSuitesQuantity();

                            if(donate.getPickupDate()!=null)
                                pickUp=donate.getPickupDate();


                        }
                        TextView shirtsQuantity=findViewById(R.id.shirtsQuantityDonations);
                        TextView jacketsQuantity=findViewById(R.id.jacketQuantityDonations);
                        TextView pantsQuantity=findViewById(R.id.pantiesQuantityDonations);
                        TextView suitesQuantity=findViewById(R.id.suitesQuantityDonations);
                        shirtsQuantity.setText(shirt+"");
                        jacketsQuantity.setText(jacket+"");
                        pantsQuantity.setText(panties+"");
                        suitesQuantity.setText(suites+"");
                    },
                    failure -> Log.e("Tutorial", "Could not query DataStore", failure)


            );

            try{
                Thread.sleep(1500);



            }catch(InterruptedException e){
                e.printStackTrace();
            }
        } catch (Exception e) {
            Log.e("Tutorial", "Could not initialize Amplify", e);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_donations);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("My Donations");



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent backArrow =new Intent (getApplicationContext(),MainActivity.class);
        startActivity(backArrow);
        return true;

    }
}