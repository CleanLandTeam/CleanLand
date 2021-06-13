package com.example.cleanland.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.cleanland.R;
//import com.example.cleanland.adapters.ViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyOrders extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);

//        List<OrdersTable> myOrder = new ArrayList<>();
//
//        OrdersTable viewOne = new OrdersTable("hello","abd","alrahman","hello","abd","alrahman");
//        OrdersTable ViewTow = new OrdersTable("hello","ahmad","kefak","hello","abd","alrahman");
//        OrdersTable ViewThree = new OrdersTable("hello","ali","mohd","hello","abd","alrahman");
//
//        myOrder.add(viewOne);
//        myOrder.add(ViewTow);
//        myOrder.add(ViewThree);
//
//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
//        ViewAdapter adapter = new ViewAdapter(myOrder,this);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();


    }
//    @Override
//    public void taskListener(OrdersTable ordersTable) {
//        Intent intent = new Intent(MyOrders.this, OrderPage.class);
//        this.startActivity(intent);
//
//    }





}