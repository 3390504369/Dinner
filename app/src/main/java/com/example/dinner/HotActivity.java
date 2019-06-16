package com.example.dinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.dinner.adapter.HotAdapter;
import com.example.dinner.entity.Cai;
import com.example.dinner.entity.Database;

import java.util.ArrayList;
import java.util.List;

public class HotActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HotAdapter adapter;
    private Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot);

        /*初始化主体*/
        recyclerView = findViewById(R.id.act_main_recyclerview);
        // 指定一个默认的布局管理器
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        // 指定item插入/移除动画
        // recyclerView.setItemAnimator(new DefaultItemAnimator());
        // 指定item分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        // 指定适配器
        adapter = new HotAdapter(ListNews(),HotActivity.this);
        recyclerView.setAdapter(adapter);
        button1 = findViewById(R.id.tiaodingdan);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HotActivity.this,"点了" +"个菜"+Database.lists.size(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HotActivity.this,ListActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<Cai> ListNews(){
        Cai cai1 = new Cai(1,"土   豆",12,"含有大量蛋白质");
        Cai cai2 = new Cai(1,"西   瓜",12,"含有大量维生素");
        Cai cai3 = new Cai(1,"南   瓜",12,"含有大量淀粉");
        Cai cai4 = new Cai(1,"土   豆",12,"含有大量蛋白质");
        Cai cai5 = new Cai(1,"土   豆",12,"含有大量蛋白质");
        Cai cai7 = new Cai(1,"土   豆",12,"含有大量蛋白质");
        Cai cai8 = new Cai(1,"土   豆",12,"含有大量蛋白质");
        Cai cai9 = new Cai(1,"土   豆",12,"含有大量蛋白质");
        Cai cai6 = new Cai(1,"土   豆",12,"含有大量蛋白质");
        List<Cai> cais = new ArrayList<>();
        cais.add(cai1);
        cais.add(cai2);
        cais.add(cai3);
        cais.add(cai4);
        cais.add(cai5);
        cais.add(cai6);
        cais.add(cai7);
        cais.add(cai8);
        cais.add(cai9);
        return cais;
    }
}
