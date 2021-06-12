//package com.example.cleanland.adapters;
//
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.cleanland.R;
//
//
//import org.jetbrains.annotations.NotNull;
//
//import java.util.List;
//
////
////
//public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {
//    @NonNull
//    @NotNull
//    @Override
//    public ViewAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
//        return null;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull @NotNull ViewAdapter.ViewHolder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
////
////    private List<OrdersTable> localDataSet;
////    public OnInteractingWithTaskListener listener;
////
////
////    public ViewAdapter(List<OrdersTable> ordersTables, OnInteractingWithTaskListener listener) {
////        localDataSet = ordersTables;
////        this.listener=listener;
////    }
////
////
////    public static class ViewHolder extends RecyclerView.ViewHolder {
////        public OrdersTable ordersTable;
////        TextView shirts ;
////        TextView jackets ;
////        TextView underwares ;
////        TextView panties ;
////        TextView suites ;
////        TextView others ;
////
////
////
////        public ViewHolder(View view) {
////            super(view);
////            // Define click listener for the ViewHolder's View
////
////
////            shirts = (TextView) view.findViewById(R.id.shirtsViewFragment);
////            jackets = (TextView) view.findViewById(R.id.jacketsViewFragment);
////            underwares = (TextView) view.findViewById(R.id.underWaresViewFragment);
////            panties = (TextView) view.findViewById(R.id.pantiesViewFragment);
////            suites = (TextView) view.findViewById(R.id.suitesViewFragment);
////            others = (TextView) view.findViewById(R.id.othersViewFragment);
////
////        }
////
////        public TextView getTextView() {
////            return shirts;
////        }
////    }
////    public void CustomAdapter(List<OrdersTable> dataSet ) {
////        localDataSet = dataSet;
////    }
////    public static interface OnInteractingWithTaskListener{
////        public void taskListener(OrdersTable ordersTable);
////    }
////    @Override
////    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
////        View view = LayoutInflater.from(viewGroup.getContext())
////                .inflate(R.layout.fragment_my_order, viewGroup, false);
////
////        final ViewHolder viewHolder = new ViewHolder(view);
////
////        view.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                listener.taskListener(viewHolder.ordersTable);
////            }
////        });
////        return new ViewHolder(view);
////    }
////    @Override
////    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
////
////         // for OrdersName
////        viewHolder.shirts.setText(localDataSet.get(position).getShirts());
////        viewHolder.jackets.setText(localDataSet.get(position).getJackets());
////        viewHolder.underwares.setText(localDataSet.get(position).getUnderwares());
////        viewHolder.panties.setText(localDataSet.get(position).getPanties());
////        viewHolder.suites.setText(localDataSet.get(position).getSuites());
////        viewHolder.others.setText(localDataSet.get(position).getOthers());
////
////    }
////
////    @Override
////    public int getItemCount() {
////        return localDataSet.size();
////    }
////
////
////
//}
