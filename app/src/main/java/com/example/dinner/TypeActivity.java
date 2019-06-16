package com.example.dinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.dinner.adapter.HotAdapter;
import com.example.dinner.adapter.TypeAdapter;
import com.example.dinner.entity.Cai;
import com.example.dinner.entity.CaiType;

import java.nio.file.FileVisitOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TypeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TypeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);

        /*初始化主体*/
        recyclerView = findViewById(R.id.type_recycle);
        // 指定一个默认的布局管理器
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        //指定item插入/移除动画
         //recyclerView.setItemAnimator(new DefaultItemAnimator());
        // 指定item分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        // 指定适配器
        adapter = new TypeAdapter(lists(),TypeActivity.this);
        recyclerView.setAdapter(adapter);
    }
    public List<CaiType> lists(){
        CaiType r9 = new CaiType("特    色    菜");
        CaiType r1 = new CaiType("特    价    菜");
        CaiType r2 = new CaiType("川        菜");
        CaiType r3 = new CaiType("鲁        菜");
        CaiType r4 = new CaiType("闽        菜");
        CaiType r5 = new CaiType("苏        菜");
        CaiType r6 = new CaiType("浙        菜");
        CaiType r7 = new CaiType("汤        羹");
        CaiType r8 = new CaiType("酒        水");
        List<CaiType> list = new ArrayList<>();
        list.add(r1);
        list.add(r2);
        list.add(r3);
        list.add(r4);
        list.add(r5);
        list.add(r6);
        list.add(r7);
        list.add(r8);
        list.add(r9);
        return list;


    }
}
