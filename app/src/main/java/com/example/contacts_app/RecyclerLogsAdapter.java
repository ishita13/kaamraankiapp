package com.example.contacts_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerLogsAdapter extends RecyclerView.Adapter<RecyclerLogsAdapter.Viewholder> {
    private LayoutInflater layoutInflater;
    private Context con;
    private List<ModelClass> items;
    public RecyclerLogsAdapter(Context c, List<ModelClass> l)
    {
        con=c;
        items=l;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater=LayoutInflater.from(con);
        View v=layoutInflater.inflate(R.layout.callitem_logs,parent,false);
        Viewholder viewHolder=new Viewholder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position)
    {
        TextView number,name,dura;

        
        holder.name.setText(items.get(position).getName());
        holder.number.setText(items.get(position).getNumber());
        holder.durati.setText(items.get(position).getDuration());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder
    {
        TextView number,name,durati;
        public Viewholder(@NonNull View itemView) {
            super(itemView);

            name=(TextView)itemView.findViewById(R.id.names);
              number=(TextView)itemView.findViewById(R.id.numberlog);
              durati=(TextView)itemView.findViewById(R.id.logTime);

        }
    }
}