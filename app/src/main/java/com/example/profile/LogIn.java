package com.example.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LogIn extends AppCompatActivity {

    Button signin,signup;
    EditText username,password;
    List<Account> listacc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_log_in);
        listacc = new ArrayList<>();
        listacc.add(new Account("admin","admin"));
        listacc.add(new Account("huy","123"));
        listacc.add(new Account("test","1"));

        signin = (Button) findViewById(R.id.signin);
        username = (EditText) findViewById(R.id.editTextTextPersonName);
        password = (EditText) findViewById(R.id.editTextTextPassword);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkpass()){
                    Toast.makeText(LogIn.this,"Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent profile = new Intent(LogIn.this,Profile.class);
                    startActivity(profile);
                }
                else {
                    Toast.makeText(LogIn.this,"Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public boolean checkpass(){
        boolean result = false;
        for (Account acc : listacc) {
            boolean check1 = String.valueOf(username.getText()).equals(acc.getUserName());
            boolean check2 = String.valueOf(password.getText()).equals(acc.getPassWord());
            if (check1 && check2){
                result = true;
            }
        }
        return result;
    }
}