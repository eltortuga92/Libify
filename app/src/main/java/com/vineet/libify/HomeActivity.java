package com.vineet.libify;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import java.util.LinkedList;

public class HomeActivity extends AppCompatActivity {

    private static final String LOG_TAG = HomeActivity.class.getSimpleName();
    private LinkedList<String> mCategoryList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private CategoryListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int categoryListSize = mCategoryList.size();
                mCategoryList.addLast("Category " + categoryListSize);
                mRecyclerView.getAdapter().notifyItemInserted(categoryListSize);
                mRecyclerView.smoothScrollToPosition(categoryListSize);
            }
        });

        for (int i = 0; i < 20; i++) {
            mCategoryList.addLast("Category " + i);
        }
        // Get a handle to RecyclerView
        mRecyclerView = findViewById(R.id.recyclerview);
        // Create an adapter and supply the data to be displayed
        mAdapter = new CategoryListAdapter(this, mCategoryList);
        // Connect the adapter with the RecyclerView
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");

    }

}
