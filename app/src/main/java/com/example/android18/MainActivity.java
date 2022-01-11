package com.example.android18;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public String[]list = {"item 1","item 2","item 3","item 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.tv_select);
        ListView listView = findViewById(R.id.mylist);

        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("item", list[i]);
            arrayList.add(hashMap);
        }

        String[] form = {"item"};
        int value[] = {R.id.tv_listview};

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                arrayList,
                R.layout.listview,
                form,
                value
        );

        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tv.setText("你選擇了:"+list[i]);
            }
        });
    }
}