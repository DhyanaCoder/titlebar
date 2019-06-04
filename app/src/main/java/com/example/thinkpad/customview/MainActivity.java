package com.example.thinkpad.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.thinkpad.titlebar.TitleBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getSupportActionBar()!=null)
            getSupportActionBar().hide();
        final CustomViewOne customViewOne=(CustomViewOne)findViewById(R.id.customView);

        Button slideButton=(Button) findViewById(R.id.slideButton);
        slideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customViewOne.smoothScrollTo(-400,0);
            }
        });
        TitleBar titleBar=(TitleBar) findViewById(R.id.titlebar);
        titleBar.setLeftOnlickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"left was clicked！",Toast.LENGTH_SHORT).show();
            }
        });
        titleBar.setRightOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"right was clicked！",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
