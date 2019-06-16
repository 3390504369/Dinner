package com.example.dinner.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dinner.ListActivity;
import com.example.dinner.R;
import com.example.dinner.entity.Database;
import com.example.dinner.entity.OrderList;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder>{
    private List<OrderList> lists;
    private ListActivity context;
    public ListAdapter(List<OrderList> lists,ListActivity context){
        this.context = context;
        this.lists = lists;
    }
    @NonNull
    @Override
    public ListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 每一个item对象
        //从一个Context中，获得一个布局填充器，这样你就可以使用这个填充器来把xml布局文件转为View对象了。
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listrecyclerview, parent, false);
        // 由VM持有
        return new ListAdapter.MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.caiName.setText(lists.get(position).caiName);
        holder.caiPrice.setText(lists.get(position).price+"元");
       // holder.caiCount.setText(lists.get(position).caiCount);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"催菜已收到，后厨正在努力",Toast.LENGTH_LONG).show();
            }
        });
        holder.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"退菜成功",Toast.LENGTH_LONG).show();
                Database.lists.remove(position);
                notifyItemRemoved(position);
                Database.sum -= lists.get(position).price;
                context.textView.setText(Database.sum+"元");
            }
        });
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView caiName;
        TextView caiCount;
        TextView caiPrice;
        Button button;
        Button button1;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            caiName = itemView.findViewById(R.id.cainame);
            caiCount = itemView.findViewById(R.id.caicount);
            caiPrice =itemView.findViewById(R.id.caiprice);
            button = itemView.findViewById(R.id.cuicai);
            button1 = itemView.findViewById(R.id.tuicai);
        }
    }


}
