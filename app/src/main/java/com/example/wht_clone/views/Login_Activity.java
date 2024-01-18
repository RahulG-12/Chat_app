package com.example.wht_clone.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.format.DateUtils;

import com.example.wht_clone.R;
import com.example.wht_clone.databinding.ActivityLoginBinding;
import com.example.wht_clone.viewmodel.MyViewModel;

public class Login_Activity extends AppCompatActivity {
  MyViewModel myviewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myviewmodel=new ViewModelProvider(this).get(MyViewModel.class);

        ActivityLoginBinding activityLoginBinding= DataBindingUtil.setContentView(this,R.layout.activity_login);
        activityLoginBinding.setVModel(myviewmodel);
    }
}