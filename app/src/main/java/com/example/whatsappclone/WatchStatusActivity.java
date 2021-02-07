package com.example.whatsappclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.whatsappclone.Models.User;
import com.example.whatsappclone.databinding.ActivityWatchStatusBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class WatchStatusActivity extends AppCompatActivity {
    ActivityWatchStatusBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_status);
        getSupportActionBar().hide();

        binding = ActivityWatchStatusBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String userid = getIntent().getStringExtra("id");
        String status = getIntent().getStringExtra("status");
        Picasso.get().load(status).placeholder(R.drawable.camera).into(binding.imageView);

        if(userid.equals(FirebaseAuth.getInstance().getUid())){
            binding.button.setVisibility(View.INVISIBLE);
            binding.button2.setVisibility(View.VISIBLE);
        }else{
            binding.button2.setVisibility(View.INVISIBLE);
            binding.button.setVisibility(View.VISIBLE);
        }
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase.getInstance().getReference()
                        .child("Users")
                        .child(FirebaseAuth.getInstance().getUid())
                        .child("Status")
                        .setValue(status);
            }
        });

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase.getInstance().getReference()
                        .child("Users")
                        .child(userid)
                        .child("Status")
                        .setValue(null);
                WatchStatusActivity.this.finish();
            }
        });
    }
    }