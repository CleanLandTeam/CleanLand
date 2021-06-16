package com.example.cleanland.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amplifyframework.datastore.generated.model.Orders;
import com.example.cleanland.R;


import java.util.List;



public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.OrdersViewHolder> {

    private List<Orders> localDataSet;
    public OnInteractingWithTaskListener listener;

    public ViewAdapter(List<Orders> ordersTables, OnInteractingWithTaskListener listener) {
        localDataSet = ordersTables;
        this.listener=listener;
    }


    public static class OrdersViewHolder extends RecyclerView.ViewHolder {
        public Orders ordersTable;
        public View itemView;


        public OrdersViewHolder(@NonNull View view) {
            super(view);
            this.itemView = view;

        }
    }

    @NonNull
    @Override
    public OrdersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fragment_my_order, viewGroup, false);

        final OrdersViewHolder viewHolder = new OrdersViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(" this is the task title on click " + viewHolder.ordersTable);
                listener.taskListener(viewHolder.ordersTable);
            }
        });
        return  viewHolder;
    }
    public void CustomAdapter(List<Orders> dataSet ) {
        localDataSet = dataSet;
    }
    public static interface OnInteractingWithTaskListener{
        public void taskListener(Orders ordersTable);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewAdapter.OrdersViewHolder viewHolder, final int position) {
        viewHolder.ordersTable = localDataSet.get(position);

        Integer sum=0;
         // for OrdersName
        if(localDataSet.get(position).getShirtsQuantity()!=null)
            sum+=localDataSet.get(position).getShirtsQuantity();

        if(localDataSet.get(position).getJacketsQuantity()!=null)
            sum+=localDataSet.get(position).getJacketsQuantity();

        if(localDataSet.get(position).getUnderWaresQuantity()!=null)
            sum+=localDataSet.get(position).getUnderWaresQuantity();

        if(localDataSet.get(position).getPantiesQuantity()!=null)
            sum+=localDataSet.get(position).getPantiesQuantity();

        if(localDataSet.get(position).getSuitesQuantity()!=null)
            sum+=localDataSet.get(position).getSuitesQuantity();


        if(localDataSet.get(position).getOthersQuantity()!=null)
            sum+=localDataSet.get(position).getOthersQuantity();
        TextView allItem =  viewHolder.itemView.findViewById(R.id.quantityDileveryDetail);
        TextView pickUpDate =viewHolder.itemView.findViewById(R.id.pickUpDateDetails);
        TextView status =viewHolder.itemView.findViewById(R.id.stateItemDetails);

        allItem.setText(sum+"");
       pickUpDate.setText(localDataSet.get(position).getPickupDate());
       status.setText(localDataSet.get(position).getState().toString());
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }



}
