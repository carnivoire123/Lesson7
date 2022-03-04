package ru.gb.lesson7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment implements View.OnClickListener {
    private Button firstFragmentButton;
    private EditText firstFragmentUserName;


    public interface Controller {
        void  startButtonPressed(String message);
        // действие 2
        // ...
    }

    // Создает и возвращает внешний вид фрагмента
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflater: R.layout.fragment => View
        return inflater.inflate(R.layout.fragment_first, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        firstFragmentButton = view.findViewById(R.id.first_fragment_button);
        firstFragmentUserName = view.findViewById(R.id.first_fragment_text);
        firstFragmentButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        // TODO запустим второй фрагмент
        String message = firstFragmentUserName.getText().toString();
        // Предполагаем, что активити импелментит интерфейс Controller
        // приводим активити к типу Controller и выполняем действие
        ((Controller)requireActivity()).startButtonPressed(message);
    }
}
