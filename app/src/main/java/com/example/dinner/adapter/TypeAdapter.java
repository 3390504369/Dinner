package com.example.dinner.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dinner.HotActivity;
import com.example.dinner.R;
import com.example.dinner.TypeActivity;
import com.example.dinner.entity.CaiType;

import java.util.List;

public class TypeAdapter extends RecyclerView.Adapter<TypeAdapter.MyViewHolder>{
    private List<CaiType> types;
    private TypeActivity context;
    public TypeAdapter(List<CaiType> type,TypeActivity context){
        this.context = context;
        types = type;
    }

    @NonNull
    @Override
    public TypeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 每一个item对象
        //从一个Context中，获得一个布局填充器，这样你就可以使用这个填充器来把xml布局文件转为View对象了。
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.caitype, parent, false);
        // 由VM持有
        return new TypeAdapter.MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return types.size();
    }

    @Override
    public void onBindViewHolder(@NonNull TypeAdapter.MyViewHolder holder, int position) {
        holder.title.setText(types.get(position).type);
        holder.pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HotActivity.class);
                context.startActivity(intent);
            }
        });
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageButton pic;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.type_text);
            pic = itemView.findViewById(R.id.typeIm_pic);
        }
    }
}
