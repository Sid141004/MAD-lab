package com.example.lab5;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ToggleButton  btn2;
    SwitchCompat btn1;
    RadioGroup grp;
    RadioButton rbtn1, rbtn2;
    TextView txt1, txt2, main;
    CheckBox cbtn1;

    int i = 0;

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

        btn1 = findViewById(R.id.toggleButton);
        btn2 = findViewById(R.id.toggleButton3);
        grp = findViewById(R.id.group1);
        rbtn1 = findViewById(R.id.radioButton);
        rbtn2 = findViewById(R.id.radioButton2);
        main = findViewById(R.id.selected);
        cbtn1 = findViewById(R.id.checkBox);

        btn1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                i++;
                if(btn1.isChecked()){
                    Toast.makeText(MainActivity.this, "Blueetooth on", Toast.LENGTH_SHORT).show();
                    String temp = main.getText().toString();
                    main.setText(temp + "\n" +i+".bluetooth was turned on");
                }
                if(! btn1.isChecked()){
                    String temp = main.getText().toString();
                    main.setText(temp + "\n" +i+".bluetooth was turned off");
                }
            }
        });
        btn2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                i++;
                if(btn2.isChecked()){
                    Toast.makeText(MainActivity.this, "wifi on", Toast.LENGTH_SHORT).show();
                    String temp = main.getText().toString();
                    main.setText(temp + "\n" +i+".wifi was turned on");
                }
                if(! btn2.isChecked()){
                    String temp = main.getText().toString();
                    main.setText(temp + "\n" +i+".wifi was turned off");
                }
            }
        });
        grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                i++;
                if(checkedId == R.id.radioButton){
                    String temp = main.getText().toString();
                    main.setText(temp + "\n" + i + ".radio button 1 was turned on");
                }else if(checkedId == R.id.radioButton2){
                    String temp = main.getText().toString();
                    main.setText(temp + "\n" + i + ".radio button 2 was turned on");
                }
            }
        });
        cbtn1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                i++;
                if(cbtn1.isChecked()){
                    Toast.makeText(MainActivity.this, "checkBox on", Toast.LENGTH_SHORT).show();
                    String temp = main.getText().toString();
                    main.setText(temp + "\n" +i+".checkBox1 was turned on");
                }
                if(! cbtn1.isChecked()){
                    String temp = main.getText().toString();
                    main.setText(temp + "\n" +i+".checkBox1 was turned off");
                }
            }
        });
    }
}
