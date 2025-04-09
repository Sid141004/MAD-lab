package com.example.labdb53490;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
//
//public class MainActivity extends AppCompatActivity {
//    DatabaseHelper myDb;   //create an instance of DatabaseHelper class
//
//    EditText editName, editSurname, editMarks;
//    Button btnAddData;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//
//        myDb = new DatabaseHelper(this);    //this is going to call the constructor of this DatabaseHelper class.
//        editName = findViewById(R.id.editText);
//        editSurname = findViewById(R.id.editText2);
//        editMarks = findViewById(R.id.editText3);
//        btnAddData = findViewById(R.id.button);
//
//        AddData();
//    }
//
//    public void AddData()   {
//        btnAddData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick ( View v ) {
//                boolean isInserted = myDb.insertData(editName.getText().toString(), editSurname.getText().toString(), editMarks.getText().toString());
//
//                if(isInserted == true)
//                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
//                else
//                    Toast.makeText(MainActivity.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
//            }
//        });
//    }
//}
//package com.example.labdb53490;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String contacts[] = {"BOOK1", "BOOK2", "BOOK3", "BOOK4", "BOOK5"};

    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        input = findViewById(R.id.input);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contacts);
        listView.setAdapter(adapter);
        // Register the ListView  for Context menu
        registerForContextMenu(listView);
        DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        dbHelper.insertData("book1","sid","1000");
        dbHelper.insertData("book2","sid2","10200");
        dbHelper.insertData("book3","sid3","9000");
        dbHelper.insertData("book4","sid4","3000");
        dbHelper.insertData("book5","sid5","6000");

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        menu.setHeaderTitle("Select The Action");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        if (item.getItemId() == R.id.title) {
            Toast.makeText(getApplicationContext(), "CHANGING TITLE", Toast.LENGTH_LONG).show();
            String temp = input.getText().toString();
            dbHelper.insertData(temp,"sid","1000");
//            db.execSQL("Insert into Grocery (name, cost) values ('"+s[0]+"', "+(Integer.parseInt(s[1]))+");");
        } else if (item.getItemId() == R.id.author) {
            Toast.makeText(getApplicationContext(), "CHANGING AUTHOR", Toast.LENGTH_LONG).show();
            String temp = input.getText().toString();
            dbHelper.insertData("book1",temp,"1000");
        }else if (item.getItemId() == R.id.price) {
            Toast.makeText(getApplicationContext(), "CHANGING price", Toast.LENGTH_LONG).show();
            String temp = input.getText().toString();
            dbHelper.insertData("book1","sid",temp);
        }else {
            return false;
        }
        return true;
    }
}
