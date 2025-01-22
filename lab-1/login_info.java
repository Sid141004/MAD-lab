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

public class login_info extends AppCompatActivity {

    private TextView nameTextView, emailTextView;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nameTextView = (TextView) findViewById(R.id.username);
        emailTextView = (TextView) findViewById(R.id.email);
        back = (Button) findViewById(R.id.back);

        String username1 = getIntent().getStringExtra("name");
        username1 += " !!";
        String email1 = getIntent().getStringExtra("email");

        nameTextView.setText(username1);
        emailTextView.setText(email1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login_info.this, signup.class));
            }
        });

    }
}
