package com.example.yijialuo.youjian;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pop_smtp extends AppCompatActivity {
    Button send,accept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_smtp);
        send=(Button)findViewById(R.id.send);
        accept=(Button)findViewById(R.id.accept);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=getIntent();
                Intent intent_1=new Intent(pop_smtp.this,pop.class);
                intent_1.putExtra("user",intent.getStringExtra("user"));
                intent_1.putExtra("pass",intent.getStringExtra("pass"));
                startActivity(intent_1);
            }
        });
    }
}
