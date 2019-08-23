package com.example.wenow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class adapter extends RecyclerView.Adapter<adapter.holder> {


    private String[] results;

    public adapter(String[] values){

        this.results = values;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {

        String text = results[position];
        holder.textView.setText(text);
    }

    @Override
    public int getItemCount() {
        return results.length;
    }

    public class holder extends RecyclerView.ViewHolder{

        ImageView imgv;
        TextView textView;
        public holder(@NonNull View itemView) {
            super(itemView);
            imgv = itemView.findViewById(R.id.card_image);
            textView = itemView.findViewById(R.id.card_text);
        }
    }
}
