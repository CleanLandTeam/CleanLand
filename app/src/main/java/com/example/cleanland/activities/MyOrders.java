package com.example.cleanland.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.amplifyframework.datastore.generated.model.Orders;
import com.example.cleanland.R;
import com.example.cleanland.adapters.ViewAdapter;
//import com.example.cleanland.adapters.ViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyOrders extends AppCompatActivity implements {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);

        List<Orders> myOrder = new ArrayList<>();

        Orders viewOne = new Orders("1","hello","abd",5.1,6.4,1,2,3,4,5,6,"heloo","hi");
        myOrder.add(viewOne);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        ViewAdapter adapter = new ViewAdapter(myOrder,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }
    @Override
    public void taskListener(Orders ordersTable) {
        Intent intent = new Intent(MyOrders.this, OrderPage.class);
        this.startActivity(intent);

    }
}