package com.example.dinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dinner.adapter.ListAdapter;
import com.example.dinner.entity.Database;

public class ListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ListAdapter adapter;
    public TextView textView;
    private Button button;
    private Button button1;
    private TextView zhuohao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        //Database.l();
        recyclerView = findViewById(R.id.list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        adapter = new ListAdapter(Database.lists,ListActivity.this);
        recyclerView.setAdapter(adapter);
        button = findViewById(R.id.jie);
        textView = findViewById(R.id.zongjia);
        button1 = findViewById(R.id.jiezh);
        zhuohao = findViewById(R.id.hao);
        //设置桌号
        zhuohao.setText(Database.tableName);
        //设置总价
        textView.setText(Database.sum+"元");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this,JiezhangActivity.class);
                startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this,JiezhangActivity.class);
                startActivity(intent);
            }
        });
    }
}


