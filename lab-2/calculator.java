package com.example.firstapp;

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

    private Button one, two, three, four, five, six, seven, eight, nine, zero, add, multiply, divide, subtract, mod, equal, clear, back, dot;
    private String temp="";
    private TextView main;

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

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp += "1";
                main.setText(temp);
//                if(op1 != ""){
//                    op1 += "1";
//                    main.setText(op1);
//                }else if (op2 != ""){
//                    op2 += "1";
//                    main.setText(op2);
//                }
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp += "2";
                main.setText(temp);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp += "3";
                main.setText(temp);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp += "4";
                main.setText(temp);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp += "5";
                main.setText(temp);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp += "6";
                main.setText(temp);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp += "7";
                main.setText(temp);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp += "8";
                main.setText(temp);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp += "9";
                main.setText(temp);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp += "0";
                main.setText(temp);
            }
        });


    }
}
