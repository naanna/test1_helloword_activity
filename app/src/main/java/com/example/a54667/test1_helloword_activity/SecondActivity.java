package com.example.a54667.test1_helloword_activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
public class SecondActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("SecondActivity","调用onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("SecondActivity","调用onStart()");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("SecondActivity","调用onResume()");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("SecondActivity","调用onPause()");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("SecondActivity","调用onStop()");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SecondActivity","调用onDestroy()");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("SecondActivity","调用onRestart()");
    }
}