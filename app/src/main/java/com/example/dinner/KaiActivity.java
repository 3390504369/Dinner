package com.example.dinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dinner.adapter.KaiAdapter;
import com.example.dinner.entity.Table;

import java.util.ArrayList;
import java.util.List;

public class KaiActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private KaiAdapter kaiAdapter;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kai);
        recyclerView = findViewById(R.id.table_recycleview);
        // 指定一个默认的布局管理器
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        // 指定适配器
        kaiAdapter = new KaiAdapter(listTables(),KaiActivity.this);
        recyclerView.setAdapter(kaiAdapter);
        button1 = findViewById(R.id.kkkbutton);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KaiActivity.this,TypeActivity.class);
                startActivity(intent);
            }
        });




    }

    private List<Table> listTables(){
        Table table = new Table("第1号桌","容量：8","可开台");
        Table table1 = new Table("第2号桌","容量：8","可开台");
        Table table2 = new Table("第3号桌","容量：8","可开台");
        Table table3 = new Table("第4号桌","容量：8","可开台");
        Table table4 = new Table("第5号桌","容量：8","可开台");
        Table table5 = new Table("第6号桌","容量：8","可开台");
        Table table6 = new Table("第7号桌","容量：8","可开台");
        Table table7 = new Table("第8号桌","容量：8","可开台");
        Table table8 = new Table("第9号桌","容量：8","可开台");
        Table table9 = new Table("第10号桌","容量：8","可开台");
        List<Table> tableList = new ArrayList<>();
        tableList.add(table);
        tableList.add(table1);
        tableList.add(table2);
        tableList.add(table3);
        tableList.add(table4);
        tableList.add(table5);
        tableList.add(table6);
        tableList.add(table7);
        tableList.add(table8);
        tableList.add(table9);
        return tableList;
    }
}
