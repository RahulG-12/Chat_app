package com.example.wht_clone.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.wht_clone.R;
import com.example.wht_clone.databinding.ActivityChatBinding;
import com.example.wht_clone.model.Chatmessage;
import com.example.wht_clone.viewmodel.MyViewModel;
import com.example.wht_clone.views.adapter.chatadapter;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
    private ActivityChatBinding binding;
    private RecyclerView recyclerView;
    private chatadapter chatadapter;
    private MyViewModel myViewModel;
    private List<Chatmessage> messagelist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_chat);
       myViewModel=new ViewModelProvider(this).get(MyViewModel.class);
       recyclerView=binding.recyclerView;
       recyclerView.setLayoutManager(new LinearLayoutManager(this));
       recyclerView.setHasFixedSize(true);


       String groupname= getIntent().getStringExtra("GROUP_NAME");

       myViewModel.getMessagesLiveData(groupname ).observe(this, new Observer<List<Chatmessage>>() {
           @Override
           public void onChanged(List<Chatmessage> Chatmessages) {
               messagelist=new ArrayList<>();
               messagelist.addAll(Chatmessages);

               chatadapter=new chatadapter(messagelist,getApplicationContext());
               recyclerView.setAdapter(chatadapter);
               chatadapter.notifyDataSetChanged();


               int latestposition=chatadapter.getItemCount();
               if(latestposition >0){
               recyclerView.smoothScrollToPosition(latestposition);
           }}
       });
       binding.setVModel(myViewModel);

       binding.sendmsg.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String msg=binding.edtchatmsg.getText().toString();
               myViewModel.sendmessage(msg,groupname);

               binding.edtchatmsg.getText().clear();
           }
       });

    }

}