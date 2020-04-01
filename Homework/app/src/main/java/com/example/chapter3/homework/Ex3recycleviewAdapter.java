package com.example.chapter3.homework;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Ex3recycleviewAdapter extends RecyclerView.Adapter<Ex3recycleviewAdapter.Ex3ViewHolder> {

    private int itemnums;

    public Ex3recycleviewAdapter(int i){
        itemnums=i;
    }

    @NonNull
    @Override
    public Ex3recycleviewAdapter.Ex3ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ex3_itemview,viewGroup,false);
        return new Ex3ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Ex3recycleviewAdapter.Ex3ViewHolder ex3ViewHolder, int i) {
        ex3ViewHolder.textView.setText("your friends"+String.valueOf(i));
    }

    @Override
    public int getItemCount() {
        return itemnums;
    }

    public class Ex3ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public Ex3ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv_item);
        }
    }
}
