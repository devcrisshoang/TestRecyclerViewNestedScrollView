package com.example.testrecyclerviewnestedscrollview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvCategory;
    private RecyclerView rcvUser;

    private CategoryAdapter categoryAdapter;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rcvCategory = findViewById(R.id.rcv_category);
        rcvUser = findViewById(R.id.rcv_user);

        categoryAdapter = new CategoryAdapter();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rcvCategory.setLayoutManager(gridLayoutManager);
        rcvCategory.setFocusable(false);
        rcvCategory.setNestedScrollingEnabled(false);
        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);

        userAdapter = new UserAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvUser.setLayoutManager(linearLayoutManager);
        rcvUser.setFocusable(false);
        rcvUser.setNestedScrollingEnabled(false);

        userAdapter.setData(getListUser());
        rcvUser.setAdapter(userAdapter);
    }
    private List<Category> getListCategory(){
        List<Category> list = new ArrayList<>();
        list.add(new Category(R.drawable.ic_launcher_background,"Category 1"));
        list.add(new Category(R.drawable.ic_launcher_background,"Category 2"));
        list.add(new Category(R.drawable.ic_launcher_background,"Category 3"));
        list.add(new Category(R.drawable.ic_launcher_background,"Category 4"));
        list.add(new Category(R.drawable.ic_launcher_background,"Category 1"));
        list.add(new Category(R.drawable.ic_launcher_background,"Category 2"));
        list.add(new Category(R.drawable.ic_launcher_background,"Category 3"));
        list.add(new Category(R.drawable.ic_launcher_background,"Category 4"));
        return list;
    }

    private List<User> getListUser(){
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.ic_launcher_background,"User 1"));
        list.add(new User(R.drawable.ic_launcher_background,"User 2"));
        list.add(new User(R.drawable.ic_launcher_background,"User 3"));
        list.add(new User(R.drawable.ic_launcher_background,"User 4"));
        list.add(new User(R.drawable.ic_launcher_background,"User 1"));
        list.add(new User(R.drawable.ic_launcher_background,"User 2"));
        list.add(new User(R.drawable.ic_launcher_background,"User 3"));
        list.add(new User(R.drawable.ic_launcher_background,"User 4"));
        return list;
    }
}