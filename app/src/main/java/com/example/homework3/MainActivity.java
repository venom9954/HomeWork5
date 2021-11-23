package com.example.homework3;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private  Calculator calculator;
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] numbersId = new int[] {
                R.id.button_0,
                R.id.button_1,
                R.id.button_2,
                R.id.button_3,
                R.id.button_4,
                R.id.button_5,
                R.id.button_6,
                R.id.button_7,
                R.id.button_8,
                R.id.button_9
        };

        int[] otherId = new int[] {
                R.id.button_plus,
                R.id.button_minus,
                R.id.button_multiply,
                R.id.button_divide,
                R.id.button_equal,
                R.id.button_AC,
        };

        textView = findViewById(R.id.textView);

        calculator = new Calculator();

        View.OnClickListener numberButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.onNumPressed(v.getId());
                textView.setText(calculator.getText());
            }
        };

        View.OnClickListener actionButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.onActionPressed(v.getId());
                textView.setText(calculator.getText());
            }
        };
        for (int i = 0; i < numbersId.length; i++){
            findViewById(numbersId[i]).setOnClickListener(numberButtonClickListener);
        }
        for (int i = 0; i < otherId.length; i++){
            findViewById(otherId[i]).setOnClickListener(actionButtonClickListener);
        }

        findViewById(R.id.button_AC).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.reset();
                textView.setText(calculator.getText());
            }
        });

    }

}