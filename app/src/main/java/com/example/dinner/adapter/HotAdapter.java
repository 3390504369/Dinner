package com.example.dinner.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dinner.HotActivity;
import com.example.dinner.R;
import com.example.dinner.SpecificActivity;
import com.example.dinner.entity.Cai;
import com.example.dinner.entity.Database;

import java.util.List;

public class HotAdapter  extends RecyclerView.Adapter<HotAdapter.MyViewHolder>{
    private List<Cai> cais;
    private HotActivity context;
    public HotAdapter(List<Cai> cais,HotActivity context){
        this.cais = cais;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_news, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return cais.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(cais.get(position).name);
        holder.suttitle.setText("价格:"+cais.get(position).price+"元");
        holder.tianjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,cais.get(position).name,Toast.LENGTH_SHORT).show();
                Database.orderLists(cais.get(position).name,cais.get(position).price);
            }
        });
        holder.pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,SpecificActivity.class);
                Database.content = cais.get(position).content;
                context.startActivity(intent);
            }
        });

    }
    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView suttitle;
        ImageButton pic;
        Button tianjia;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.news_title);
            suttitle = itemView.findViewById(R.id.news_subtitle);
            pic =itemView.findViewById(R.id.news_pic);
            tianjia = itemView.findViewById(R.id.tianjia);
        }
    }




}
