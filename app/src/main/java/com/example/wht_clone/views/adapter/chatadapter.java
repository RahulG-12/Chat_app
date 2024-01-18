package com.example.wht_clone.views.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wht_clone.BR;
import com.example.wht_clone.R;
import com.example.wht_clone.databinding.RowChatBinding;
import com.example.wht_clone.model.Chatmessage;

import java.util.List;

public class chatadapter extends RecyclerView.Adapter<chatadapter.chatviewholder> {
    private List<Chatmessage> chatmessageList;
    private Context context;

    public chatadapter(List<Chatmessage> chatmessageList, Context context) {
        this.chatmessageList = chatmessageList;
        this.context = context;
    }

    @NonNull
    @Override
    public chatviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.row_chat,parent,false);
        RowChatBinding binding= DataBindingUtil.bind(view);
        return new chatviewholder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull chatviewholder holder, int position) {
        holder.getBinding().setVariable(BR.chatmessage,chatmessageList.get(position));
        holder.getBinding().executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return chatmessageList.size();
    }

    public class chatviewholder extends RecyclerView.ViewHolder{
        private RowChatBinding binding;

        public chatviewholder(RowChatBinding rowChatBinding) {
            super(rowChatBinding.getRoot());
            this.binding = rowChatBinding;
            setRowChatBinding(rowChatBinding);

        }

        public RowChatBinding getBinding() {
            return binding;
        }

        public void setRowChatBinding(RowChatBinding rowChatBinding) {
            this.binding = rowChatBinding;
        }
    }
}
