package com.example.cleanland.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.amplifyframework.datastore.generated.model.Orders;
import com.example.cleanland.R;


import java.util.List;



public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {

    private List<Orders> localDataSet;
    public OnInteractingWithTaskListener listener;


    public ViewAdapter(List<Orders> ordersTables, OnInteractingWithTaskListener listener) {
        localDataSet = ordersTables;
        this.listener=listener;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public Orders ordersTable;
        TextView allItem ;
        TextView pickUpDate ;
        TextView status;




        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            allItem = (TextView) view.findViewById(R.id.quantityItemFragment);
            pickUpDate = (TextView) view.findViewById(R.id.pickUpDateFragment);
            status = (TextView) view.findViewById(R.id.stateItemFragment);

        }

        public TextView getTextView() {
            return allItem;
        }
    }
    public void CustomAdapter(List<Orders> dataSet ) {
        localDataSet = dataSet;
    }
    public static interface OnInteractingWithTaskListener{
        public void taskListener(Orders ordersTable);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fragment_my_order, viewGroup, false);

        final ViewHolder viewHolder = new ViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.taskListener(viewHolder.ordersTable);
            }
        });
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
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

        viewHolder.allItem.setText(sum+"");
        viewHolder.pickUpDate.setText(localDataSet.get(position).getPickupDate());
        viewHolder.status.setText(localDataSet.get(position).getState().toString());
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }



}
