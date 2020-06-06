package com.example.cdots;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String name_key = "com.example.cdots.NAME";
    public static final String address_key = "com.example.cdots.ADDRESS";
    public static final String mobile_number_key = "com.example.cdots.MOBILE";
    public static final String email_key = "com.example.cdots.EMAIL";
    public static final String grocery_list_key = "com.example.cdots.GROCERY_LIST";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    public void sendMessage(View view) {
//        Intent intent = new Intent(this, DisplayMessageActivity.class);
//        EditText editText = (EditText) findViewById(R.id.editText);
//        String message = editText.getText().toString();
//        intent.putExtra(name_key, message);
//        startActivity(intent);
//    }

    public void post_grocery(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText name = (EditText) findViewById(R.id.name);
        String name_s = name.getText().toString();
        EditText address = (EditText) findViewById(R.id.address);
        String address_s = address.getText().toString();
        EditText mobile_number = (EditText) findViewById(R.id.mobile_number);
        String mobile_number_s = mobile_number.getText().toString();
        EditText email = (EditText) findViewById(R.id.email);
        String email_s = email.getText().toString();
        EditText grocery_list = (EditText) findViewById(R.id.grocery_list);
        String grocery_list_s = grocery_list.getText().toString();
        intent.putExtra(name_key, name_s);
        intent.putExtra(mobile_number_key, mobile_number_s);
        intent.putExtra(email_key, email_s);
        intent.putExtra(address_key, address_s);
        intent.putExtra(grocery_list_key, grocery_list_s);
        startActivity(intent);
    }
}