package com.sgy.whilesample;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sgy.whilesample.databinding.ActivityMainBinding;

import java.lang.reflect.Array;
import java.math.BigDecimal;
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

    private ArrayList<String> userInputGroup;

    private double numSum;
    private ArrayList<Double> numSumArr;
    private double numSize;
    private double numAvg;

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

        userInputGroup = new ArrayList<>();

        numSum = 0;
        numSize = 0;
        numSumArr = new ArrayList<Double>();

        btnUserInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUserInput.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "값을 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                } else if (etUserInput.getText().toString().equals("0")) {
                    etUserInput.setText("");
                    // calAvg();
                    return;
                }

                userInputGroup.add(etUserInput.getText().toString()); // 배열에 모든 숫자 값 저장(String 형)
                tvNumGroup.setText(userInputGroup.toString());

                numSumArr.add(Double.parseDouble(etUserInput.getText().toString()));
                for (int i = 0; i < numSumArr.size(); i++) {
                    if (numSumArr.size() == 1) {
                        numSum = numSumArr.get(i);
                        etUserInput.setText("");
                    } else if (numSumArr.size() >= 2) {
                        numSum = numSum + numSumArr.get(i);
                    }
//                    } else if (numSumArr.size() == 3) {
//                        numSum = numSum + numSumArr.get(i) - numSumArr.get(i - 1) - numSumArr.get(i - 2);
//                    } else {
//                        numSum = numSum + numSumArr.get(i) - numSumArr.get(i - 1);
//                    }
                }
                Toast.makeText(getApplicationContext(), String.valueOf(numSum), Toast.LENGTH_SHORT).show();

                etUserInput.setText("");
            }
        });

        btnCalSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUserInput.getText().toString().equals("0")) {
                    etUserInput.setText("");
                }
                // calAvg();
            }
        });
    }

    private void calAvg() {
        if (tvNumGroup.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "값을 입력하세요.", Toast.LENGTH_SHORT).show();
            return;
        }
        numSize = numSumArr.size() -1;
        numAvg = numSum / numSize;
        tvResultSum.setText(String.valueOf(numAvg));
    }
}