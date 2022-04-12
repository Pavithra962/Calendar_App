package com.example.calsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    private int timer=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imageView);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        LogoLauncher logoLauncher=new LogoLauncher();
        logoLauncher.start();

    }
    private class LogoLauncher extends Thread{
        @Override
        public void run() {
            try{
                sleep(1000*timer);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
        }
    }
}