package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText num1;
    private EditText num2;
    private Button mul;
    private TextView res;
    private Button reset ;
    private Button next1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        num1 = (EditText) findViewById(R.id.editTextNumber);
        num2 = (EditText) findViewById(R.id.editTextNumber2);
        mul = (Button) findViewById(R.id.button);
        res = (TextView) findViewById(R.id.textView4);
        reset = (Button) findViewById(R.id.button2);
        next1 = (Button) findViewById(R.id.next);

        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Layouts_test.class);
                startActivity(intent);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(num1.getText().toString());
                int b = Integer.parseInt(num2.getText().toString());
                int ans = Math.multiplyExact(a,b);
                res.setVisibility(View.VISIBLE);
                reset.setVisibility(View.VISIBLE);
                res.setText("The answer is : " + String.valueOf(ans));
                Toast.makeText(MainActivity.this,"result calculated!",Toast.LENGTH_SHORT).show();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1.setText("");
                num2.setText("");
                res.setVisibility(View.GONE);
                reset.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this,"Reset succesful",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
