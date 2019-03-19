    package com.example.a54667.test1_helloword_activity;
    import android.content.Intent;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.util.Log;
    import android.view.View;
    import android.widget.Button;
    public class MainActivity extends AppCompatActivity {
        private Button button;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            Log.d("MainActivity","调用onCreate()");
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            button=(Button)findViewById(R.id.button1);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(intent);
                }
            });
        }
        @Override
        protected void onStart() {
            super.onStart();
            Log.d("MainActivity","调用onStart()");
        }
        @Override
        protected void onResume() {
            super.onResume();
            Log.d("MainActivity","调用onResume()");
        }
        @Override
        protected void onPause() {
            super.onPause();
            Log.d("MainActivity","调用onPause()");
        }
        @Override
        protected void onStop() {
            super.onStop();
            Log.d("MainActivity","调用onStop()");
        }
        @Override
        protected void onRestart() {
            super.onRestart();
            Log.d("MainActivity","调用onRestart()");
        }
        @Override
        protected void onDestroy() {
            super.onDestroy();
            Log.d("MainActivity","调用onDestroy()");
        }
    }