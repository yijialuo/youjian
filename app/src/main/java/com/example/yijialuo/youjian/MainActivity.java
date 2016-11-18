package com.example.yijialuo.youjian;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText user,pass;
    Button sign;
    public  SocketThread_write a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText)findViewById(R.id.user);
        pass=(EditText)findViewById(R.id.pass);
        sign=(Button) findViewById(R.id.sign);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    public void run() {
                        a = new SocketThread_write(user.getText().toString(), pass.getText().toString());
                        a.connecttoserver();
                        String temp[]=a.login().split(" ");
                        if(temp[0].equals("235")){
                            Intent intent = new Intent(MainActivity.this, pop_smtp.class);
                            intent.putExtra("user",user.getText().toString());
                            intent.putExtra("pass",pass.getText().toString());
                            startActivity(intent);
                        }

                    }
                }.start();
            }
        });
    }
}
