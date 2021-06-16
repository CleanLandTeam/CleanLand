package com.example.cleanland.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
import com.example.cleanland.utils.SpacingRecyclerView;
//import com.example.cleanland.adapters.ViewAdapter;

import java.util.ArrayList;
import java.util.List;


public class MyOrders extends AppCompatActivity implements ViewAdapter.OnInteractingWithTaskListener {
    public  List<com.amplifyframework.datastore.generated.model.Orders> ordersTables = new ArrayList<>();
    List<Orders> ordersToView = new ArrayList<>();

    RecyclerView recyclerView;
    ViewAdapter orderAdpater;
    @Override
    public void onResume(){
        super.onResume();

        this.orderAdpater.notifyDataSetChanged();

    }
    private void handleRViewShow(){
        try {
            Amplify.DataStore.query(Orders.class,
                    AllOrders -> {
                        while (AllOrders.hasNext()) {
                            Orders orders = AllOrders.next();
                            SharedPreferences spref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                            String UserEmail=spref.getString("userLoggedInEmail","");
                            Log.d("email is", "onClick:+ " +UserEmail);
                            if (orders.getUserId().equals(UserEmail))
                                ordersToView.add(orders);


                        }
                    },
                    failure -> Log.e("Tutorial", "Could not query DataStore", failure)
            );
            try{
                Thread.sleep(1500);

                recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
                 orderAdpater = new ViewAdapter(ordersToView,this);
                LinearLayoutManager layoutManager= new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(layoutManager);
                SpacingRecyclerView spacingRecyclerView=new SpacingRecyclerView(10);
                recyclerView.addItemDecoration(spacingRecyclerView);
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
       // getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.actionBarColor)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("My Orders");
        this.handleRViewShow();



    }


    @Override
    public void taskListener(Orders ordersTable) {
        Intent intent = new Intent(MyOrders.this, Details.class);
        intent.putExtra("shirt",  ordersTable.getShirtsQuantity()+"");
        intent.putExtra("jacket", ordersTable.getJacketsQuantity()+"");
        intent.putExtra("panties", ordersTable.getPantiesQuantity()+"");
        intent.putExtra("suites", ordersTable.getSuitesQuantity()+"");
        intent.putExtra("underWare", ordersTable.getUnderWaresQuantity()+"");
        intent.putExtra("pickupDate", ordersTable.getPickupDate()+"");
        intent.putExtra("DeliveryDate", ordersTable.getDeliveryDate()+"");
        intent.putExtra("state", ordersTable.getState()+"");
        this.startActivity(intent);

    }

}