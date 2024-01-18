package com.example.wht_clone.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.wht_clone.Repository.Repository;
import com.example.wht_clone.model.ChatGroup;
import com.example.wht_clone.model.Chatmessage;
//import com.mastercoding.chatapp.model.ChatMessage;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

    Repository repository;


    public MyViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository();
    }

    // Auth
    public void signUpAnonymousUser() {
        Context c = this.getApplication();
        repository.firebaseAnonymousAuth(c);
    }

    public String getCurrentUserId() {
        return repository.getCurrentUserId();
    }

    public void signOut() {
        repository.signOUT();
    }


    // Getting Chat Groups
    public MutableLiveData<List<ChatGroup>> getGroupList() {
        return repository.getChatGroupMutableLiveData();
    }

    public void createNewGroup(String groupName) {
        repository.createNewChatGroup(groupName);
    }
    public MutableLiveData<List<Chatmessage>> getMessagesLiveData(String groupName){
        return repository.getMessagesLiveData(groupName);
    }
    public void sendmessage(String msg,String chatgroup){
        repository.sendmessage(msg, chatgroup);
    }
}



