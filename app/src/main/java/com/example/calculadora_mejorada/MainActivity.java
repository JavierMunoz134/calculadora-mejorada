package com.example.calculadora_mejorada;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        calculator = new Calculator();

        // Obtener referencias a los botones y establecer escuchadores de clic
        Button[] numberButtons = new Button[10];
        for (int i = 0; i < 10; i++) {
            String buttonID = "button" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            numberButtons[i] = findViewById(resID);
        }

        Button buttonPlus = findViewById(R.id.buttonPlus);
        Button buttonMinus = findViewById(R.id.buttonMinus);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonEquals = findViewById(R.id.buttonEquals);
        Button buttonClear = findViewById(R.id.buttonClear);

        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            numberButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calculator.appendNumber(finalI);
                    updateDisplay();
                }
            });
        }

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.setOperator("+");
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.setOperator("-");
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.setOperator("*");
            }
        });



        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.calculate();
                updateDisplay();
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.clearCalculator();
                updateDisplay();
            }
        });
    }

    private void updateDisplay() {
        editText.setText(calculator.getCurrentInput());
    }
}
