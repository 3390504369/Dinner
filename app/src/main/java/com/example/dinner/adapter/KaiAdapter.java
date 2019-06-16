package com.example.dinner.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dinner.KaiActivity;
import com.example.dinner.R;
import com.example.dinner.entity.Database;
import com.example.dinner.entity.Table;

import java.util.List;

public class KaiAdapter extends RecyclerView.Adapter<KaiAdapter.MyViewHolder>{

    private List<Table> tables;
    private KaiActivity context;
    public KaiAdapter(List<Table> tables,KaiActivity context){
        this.tables = tables;
        this.context = context;
    }

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 每一个item对象
        //从一个Context中，获得一个布局填充器，这样你就可以使用这个填充器来把xml布局文件转为View对象了。
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.table, parent, false);
        // 由VM持有
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(tables.get(position).name);
        holder.suttitle.setText(tables.get(position).capacity);
        holder.kai.setText("空");
        holder.kbutton.setText("开台");
        holder.pic.setImageResource(R.mipmap.table);
        holder.kbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.kai.getText().equals("空")){
                    Database.tableName = tables.get(position).name;
                    holder.kai.setText("满");
                    holder.kai.setTextColor(Color.RED);
                    holder.kbutton.setText("关台");
                    holder.kbutton.setTextColor(Color.RED);
                    Toast.makeText(context,"开台成功",Toast.LENGTH_LONG).show();
                }else {
                    holder.kai.setText("空");
                    holder.kai.setTextColor(Color.parseColor("#3399FF"));
                    holder.kbutton.setText("开台");
                    holder.kbutton.setTextColor(Color.parseColor("#3399FF"));
                    Toast.makeText(context,"退台成功",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return tables.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView suttitle;
        TextView kai;
        ImageView pic;
        Button kbutton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.news_title);
            suttitle = itemView.findViewById(R.id.news_subtitle);
            kai = itemView.findViewById(R.id.kai);
            pic = itemView.findViewById(R.id.table_pic);
            kbutton = itemView.findViewById(R.id.kt);
        }
    }
}
