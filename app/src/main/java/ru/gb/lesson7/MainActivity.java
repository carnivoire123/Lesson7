package ru.gb.lesson7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, FirstFragment.Controller {

    private Button firstFragmentStartButton;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstFragmentStartButton = findViewById(R.id.start_first_fragment);
        firstFragmentStartButton.setOnClickListener(this);
        manager = getSupportFragmentManager();

    }

    @Override
    public void onClick(View view) {
        // Транзакция - набор действий с фрагментами, которые нужно выполнить вместе
        // добавление удаление замена
        // выполняются через FragmentManager

        manager
                .beginTransaction()
                .replace(R.id.first_fragment_holder, new FirstFragment())
                .addToBackStack(null)
                .commit();

    }


    public static final String SECOND_FRAGMENT_TAG = "SECOND_FRAGMENT_TAG";

    // Из интерфейса первого фрагмента Controller
    @Override
    public void startButtonPressed(String message) {

        // Поиск фрагментов на экране
        // manager.findFragmentById(R.id.second_fragment_holder) // поиск по ид лэйаута
        // manager.findFragmentByTag("SECOND_FRAGMENT_TAG") // поиск по строковому тэгу

        SecondFragment secondFragment = (SecondFragment) manager.findFragmentByTag(SECOND_FRAGMENT_TAG);

        // А есть ли уже второй фрагмент на экране? Если да, то просто передать туда новое имя
        if(secondFragment != null)
        {
            // передадим имя
            secondFragment.passMessage(message);
        }
        else { // Если нет, то статически инициализировать
            manager
                    .beginTransaction()
                    // .replace(R.id.second_fragment_holder, new SecondFragment())
                    // .replace(R.id.second_fragment_holder, SecondFragment.getInstance(message))
                    .replace(R.id.second_fragment_holder, SecondFragment.getInstance(message), SECOND_FRAGMENT_TAG)
                    .addToBackStack(null)
                    .commit();
        }
    }
}