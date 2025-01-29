package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class calculator extends AppCompatActivity {

    private Button one, two, three, four, five, six, seven, eight, nine, zero, add, multiply, divide, subtract, mod, equal, clear, back, dot, exit;
    private char op='+';
    private String res1="";
    private String res2="";
    private TextView main;

    void eval(){
        res1 = "";
        res2 = "";
        int flag = 0;
        String curr = main.getText().toString();

        for (char c : curr.toCharArray()) {
            if ((c >= '0' && c <= '9') || c == '.') {
                if (flag == 0) {
                    res1 += c;
                } else {
                    res2 += c;
                }
            } else if (c == '+' || c == '-' || c == 'x' || c == '/' || c == '%') {
                flag = 1;
                op = c;
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        main = (TextView) findViewById(R.id.mainText);
        zero = (Button) findViewById(R.id.zero);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        add = (Button) findViewById(R.id.add);
        multiply = (Button) findViewById(R.id.multiply);
        divide = (Button) findViewById(R.id.divide);
        subtract = (Button) findViewById(R.id.subtract);
        mod = (Button) findViewById(R.id.mod);
        equal = (Button) findViewById(R.id.equal);
        clear = (Button) findViewById(R.id.clear);
        back = (Button) findViewById(R.id.back);
        dot = (Button) findViewById(R.id.dot);
        exit = (Button) findViewById(R.id.none);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = main.getText().toString();
                temp += "1";
                main.setText(temp);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = main.getText().toString();
                temp += "2";
                main.setText(temp);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = main.getText().toString();
                temp += "3";
                main.setText(temp);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = main.getText().toString();
                temp += "4";
                main.setText(temp);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = main.getText().toString();
                temp += "5";
                main.setText(temp);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = main.getText().toString();
                temp += "6";
                main.setText(temp);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = main.getText().toString();
                temp += "7";
                main.setText(temp);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = main.getText().toString();
                temp += "8";
                main.setText(temp);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = main.getText().toString();
                temp += "9";
                main.setText(temp);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = main.getText().toString();
                temp += "0";
                main.setText(temp);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.setText("");
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n = main.getText().toString().length();
                String curr = main.getText().toString().substring(0, n-1);
                main.setText(curr);
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eval();
                if (res1.isEmpty() || res2.isEmpty()) {
                    main.setText("Error");
                    return;
                }

                double a = Double.parseDouble(res1);
                double b = Double.parseDouble(res2);
                String res = "";

                switch (op) {
                    case '+': res = Double.toString(a + b); break;
                    case '-': res = Double.toString(a - b); break;
                    case 'x': res = Double.toString(a * b); break;
                    case '/': res = (b != 0) ? Double.toString(a / b) : "Error"; break;
                    case '%': res = (b != 0) ? Double.toString(a % b) : "Error"; break;
                }

                if (res.endsWith(".0")) {
                    res = res.substring(0, res.length() - 2);
                }

                main.setText(res);

            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = main.getText().toString();
                temp += "+";
                main.setText(temp);
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = main.getText().toString();
                temp += "-";
                main.setText(temp);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = main.getText().toString();
                temp += "x";
                main.setText(temp);
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = main.getText().toString();
                temp += "/";
                main.setText(temp);
            }
        });
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = main.getText().toString();
                temp += "%";
                main.setText(temp);
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = main.getText().toString();

                if (!temp.contains(".")) {
                    temp += ".";
                    main.setText(temp);
                }
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(calculator.this, MainActivity.class));
            }
        });


    }
}
