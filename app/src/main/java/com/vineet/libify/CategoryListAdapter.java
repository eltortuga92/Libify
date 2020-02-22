package com.vineet.libify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder> {

    private final LinkedList<String> mCategoryList;
    private LayoutInflater mInflater;

    public CategoryListAdapter(Context context, LinkedList<String> categoryList) {
        mInflater = LayoutInflater.from(context);
        mCategoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryListAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.categorylist_item, parent, false);
        return new CategoryViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryListAdapter.CategoryViewHolder holder, int position) {
        String mCurrent = mCategoryList.get(position);
        holder.categoryItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView categoryItemView;
        final CategoryListAdapter mAdapter;

        public CategoryViewHolder(View itemView, CategoryListAdapter adapter) {
            super(itemView);
            categoryItemView = itemView.findViewById(R.id.category);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // Get the position of the clicked item
            int mPosition = getLayoutPosition();

            // get the clicked item using the postion
            String element = mCategoryList.get(mPosition);

            // change text
            mCategoryList.set(mPosition, "Clicked! " + element);

            mAdapter.notifyDataSetChanged();
        }
    }
}
