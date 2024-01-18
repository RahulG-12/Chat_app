package com.example.wht_clone.views.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wht_clone.R;
import com.example.wht_clone.databinding.ItemCardBinding;
import com.example.wht_clone.model.ChatGroup;
import com.example.wht_clone.views.ChatActivity;
// com.example.wht_clone.views.ChatActivity;

import java.util.ArrayList;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.GroupViewHolder> {

    private ArrayList<ChatGroup> groupArrayList;

    public GroupAdapter(ArrayList<ChatGroup> groupArrayList) {
        this.groupArrayList = groupArrayList;
    }

    @NonNull
    @Override
    public GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Initializes the ViewHolder and Inflates the Item Layout
        ItemCardBinding binding = DataBindingUtil
                .inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.item_card,
                        parent,
                        false
                );
        return new GroupViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull GroupViewHolder holder, int position) {
        // binds data to an existing ViewHolder
        // Populates the Views in the ViewHolder with Data from the Dataset
        ChatGroup currentUser = groupArrayList.get(position);
        holder.itemCardBinding.setChatGroup(currentUser);
    }

    @Override
    public int getItemCount() {

        return groupArrayList.size();
    }


    public class GroupViewHolder extends RecyclerView.ViewHolder{
        // cache references to the individual views with in an item layout
        // of a recyclerView list
        private ItemCardBinding itemCardBinding;


        public GroupViewHolder(ItemCardBinding itemCardBinding) {
            super(itemCardBinding.getRoot());
            this.itemCardBinding = itemCardBinding;

            itemCardBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    ChatGroup clickedchatgrp=groupArrayList.get(position);
                    Intent i=new Intent(view.getContext(), ChatActivity.class);
                    i.putExtra("GROUP_NAME",clickedchatgrp.getGroupName());
                    view.getContext().startActivity(i);



                }
            });

        }
    }
}
