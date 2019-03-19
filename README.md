# 实验一_Android开发基础
1. 创建Android
    1. 关键代码

    ```xml
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <TextView
        android:id="@+id/textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:text="helloword" />
    </LinearLayout>
    ```
    1. 模拟器截图：

    ![helloword](https://img-blog.csdnimg.cn/20190319223008675.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjQ3OTEzNA==,size_16,color_FFFFFF,t_70)

1. 验证Activity的生命周期
    1. 关键代码

        1. AndroidManifest:
        ```xml
        <application>
        ....
        <activity android:name=".MainActivity">
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />
                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
        </activity>
        <activity android:name=".SecondActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        </application>
        ```
        1. MainActivity
         ```java
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
        ```
        1. SecondActivity(大部分与MainActivity一致，展示有些不同的onCreate()部分)
        ```java
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
        ```
        1. activity_main.xml
        ```xml
        <?xml version="1.0" encoding="utf-8"?>
        <android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity">
        <Button
            android:id="@+id/button1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="8dp"
            android:layout_marginEnd="8dp"
            android:layout_marginRight="8dp"
            android:text="Button"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintTop_toTopOf="parent" />
        <TextView
            android:id="@+id/textView3"
            android:layout_width="99dp"
            android:layout_height="30dp"
            android:layout_marginStart="4dp"
            android:layout_marginLeft="4dp"
            android:layout_marginTop="8dp"
            android:text="first"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />
        </android.support.constraint.ConstraintLayout>
        ```
        1. activity_second.xml
         ```xml
        <?xml version="1.0" encoding="utf-8"?>
        <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
            android:layout_width="match_parent"
            android:layout_height="match_parent">
            <TextView
                android:id="@+id/textView"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="second" />
            <Button
                android:id="@+id/button"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="Button" />
        </LinearLayout>

        ```
    1.模拟器截图

    ![first](https://img-blog.csdnimg.cn/20190319230558772.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjQ3OTEzNA==,size_16,color_FFFFFF,t_70)
    ![second](https://img-blog.csdnimg.cn/20190319230433148.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjQ3OTEzNA==,size_16,color_FFFFFF,t_70)
    ![logcat](https://img-blog.csdnimg.cn/20190319230628534.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjQ3OTEzNA==,size_16,color_FFFFFF,t_70)