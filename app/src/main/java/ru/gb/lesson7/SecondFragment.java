package ru.gb.lesson7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    private TextView userName;
    public static final String MESSAGE = "MESSAGE";
    private String message;

    public static SecondFragment getInstance(String message)
    {
        // создать фрагмент
        SecondFragment fragment = new SecondFragment();
        // создать аргументы
        Bundle args = new Bundle(); // добавляем данные по строковому ключу
        // добавить в аргументы входные параметры
        args.putString(MESSAGE, message);
        // присоединить аргументы к фрагменту
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        userName = view.findViewById(R.id.second_fragment_name);

        init(message);

    }

    private void init(String message) {
        // извлечь аргументы
        Bundle args = getArguments();
        if(args != null) {
            if(message == null) {
                // извлечь по ключу из аргументов входные параметры
                message = args.getString(MESSAGE, "");
            }
            else {
                // добавим новое сообщение в аргументы
                args.putString(MESSAGE, message);
                setArguments(args);
            }
            userName.setText(message);
        }
    }

    public void passMessage(String message) {
        init(message);
    }
}
