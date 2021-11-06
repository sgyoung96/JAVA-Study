package com.sgy.whilesample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sgy.whilesample.databinding.ActivityMainBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;

// 예제 3-2
/*
 while 문을 이용하여 키보드에서 숫자를 여러 개 입력받아 입력받은 수의 평균을 출력하는 프로그램을 작성해보자.
 0이 입력되면 반복을 종료하고 평균을 구하여 출력한다.
 */
public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getName();

    private ActivityMainBinding binding;
    private EditText etUserInput;
    private Button btnUserInput;
    private TextView tvNumGroup;
    private Button btnCalSum;
    private TextView tvResultSum;

    private String userInput;
    private ArrayList<String> userInputGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        etUserInput = binding.etUserInput;
        btnUserInput = binding.btnUserInput;
        tvNumGroup = binding.tvNumGroup;
        btnCalSum = binding.btnCalSum;
        tvResultSum = binding.tvResultSum;

        userInput = "";
        userInputGroup = new ArrayList<>();

        btnUserInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput = etUserInput.getText().toString();
                userInputGroup.add(userInput); // 배열에 들어가기는 한다. [1, 1, 1, 1]
                // TODO 두번 눌러야 출력됨
                // TODO 1 5 10 3 55 이런 형태로 출력시키고 싶음
                String numGroup = userInputGroup.toString();
                String[] num = numGroup.split("");
                numGroup = num.toString();
                numGroup.replace("[", "");
                numGroup.replace("]", "");
                numGroup.replace(",", "");
            }
        });
    }
}