package com.company.recyclerviewproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    Context context;
    ArrayList<Item> items;


    public ItemAdapter(Context context, ArrayList<Item> items){
        this.context=context;
        this.items=items;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.custom_row,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(v);
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item item=items.get(position);

        holder.title.setText(item.getTitle());
        holder.desc.setText(item.getDesc());

    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title,desc;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.txt1);
            desc=itemView.findViewById(R.id.txt2);
        }
    }
}
