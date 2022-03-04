package ru.gb.lesson7;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class SecondActivity extends AppCompatActivity implements FirstFragment.Controller {

    FragmentManager manager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        manager = getSupportFragmentManager();

        if(savedInstanceState == null) {
            manager
                    .beginTransaction()
                    .replace(R.id.second_host, new FirstFragment())
                    //.addToBackStack(null)
                    .commit();
        }

    }

    @Override
    public void startButtonPressed(String message) {
        manager
                .beginTransaction()
                .replace(R.id.second_host, SecondFragment.getInstance(message))
                .addToBackStack(null)
                .commit();
    }
}
