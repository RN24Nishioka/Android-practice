package com.example.cybaryhelloapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<DbbTable> shoppingItems;

    public ItemAdapter(List<DbbTable> items) {
        this.shoppingItems = items;
    }

    public void setDate(List<DbbTable> items) {
        this.shoppingItems = items;
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {
        DbbTable dbbTable= shoppingItems.get(position);

        holder.txtItemName.setText(dbbTable.item);
        holder.txtItemQuantity.setText("Quantity: "+ dbbTable.quantity);

    }

    @Override
    public int getItemCount() {
        return shoppingItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtItemName;
        TextView txtItemQuantity;
        ImageView imageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtItemName = itemView.findViewById(R.id.txt_item_name);
            txtItemQuantity = itemView.findViewById(R.id.txt_item_quantity);
            imageView = itemView.findViewById(R.id.img_delete);
        }
    }
}
