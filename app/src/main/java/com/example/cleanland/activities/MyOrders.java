package com.example.cleanland.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.datastore.generated.model.Orders;
import com.amplifyframework.datastore.generated.model.State;
import com.example.cleanland.R;
import com.example.cleanland.adapters.ViewAdapter;
//import com.example.cleanland.adapters.ViewAdapter;

import java.util.ArrayList;
import java.util.List;


public class MyOrders extends AppCompatActivity implements ViewAdapter.OnInteractingWithTaskListener {
    public  List<com.amplifyframework.datastore.generated.model.Orders> ordersTables = new ArrayList<>();





    @Override
    protected void onStart()
    {
        super.onStart();
        try {
            Amplify.addPlugin(new AWSDataStorePlugin());
            Amplify.configure(getApplicationContext());
            this.handleRViewShow();
        }catch (AmplifyException ex){
            System.out.println(ex);
        }
    }
    @Override
    public void onResume(){
        super.onResume();
        this.handleRViewShow();
    }
    private void handleRViewShow(){
        List<Orders> ordersToView = new ArrayList<>();
        try {
            Amplify.DataStore.query(Orders.class,
                    tasks -> {
                        while (tasks.hasNext()) {
                            Orders orders = tasks.next();

                            ordersToView.add(new Orders("2",orders.getPickupDate().toString(),"description",2.2,1.1,orders.getShirtsQuantity(),orders.getJacketsQuantity(),orders.getUnderWaresQuantity(),orders.getPantiesQuantity(),orders.getSuitesQuantity(),0,"null",null));
                            System.out.println(orders);
                        }
                    },
                    failure -> Log.e("Tutorial", "Could not query DataStore", failure)
            );
            try{
                Thread.sleep(1500);
                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
                ViewAdapter orderAdpater = new ViewAdapter(ordersToView,this);
                recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                recyclerView.setAdapter(orderAdpater);
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
        setContentView(R.layout.activity_my_orders);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.actionBarColor)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void taskListener(Orders ordersTable) {
        Intent intent = new Intent(MyOrders.this, OrderPage.class);
        this.startActivity(intent);

    }

}