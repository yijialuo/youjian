package com.example.yijialuo.youjian;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class pop extends AppCompatActivity {
    EditText sendto,subject,content;
    Button send;
    SocketThread_write a;
    String name;
    String pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);
        sendto=(EditText)findViewById(R.id.sendto);
        subject=(EditText)findViewById(R.id.subject);
        content=(EditText)findViewById(R.id.content);
        send=(Button)findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=getIntent();
                 name=intent.getStringExtra("user");
                Log.i("ttt","____________"+name);
                pass=intent.getStringExtra("pass");
                Log.i("ttt","____________"+pass);
                new Thread() {
                    public void run() {

                        a=new SocketThread_write(name,pass);
                        a.connecttoserver();
                        a.login();
                        a.sendemail(sendto.getText().toString(),subject.getText().toString(),content.getText().toString());

                    }
                }.start();
                Toast.makeText(pop.this,"已发送",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
