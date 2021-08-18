package com.example.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    Boolean personOpen = false;
    Boolean addOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add
        FloatingActionButton add = findViewById(R.id.add);
        FloatingActionButton course = findViewById(R.id.course);
        FloatingActionButton work = findViewById(R.id.work);
        FloatingActionButton schedule = findViewById(R.id.schedule);


        //Intent
        Intent CourseIntent = new Intent(this,Course.class);

        course.setVisibility(View.GONE);
        work.setVisibility(View.GONE);
        schedule.setVisibility(View.GONE);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!addOpen){
                    course.show();
                    work.show();
                    schedule.show();
                    addOpen = true;
                }
                else{
                    course.hide();
                    work.hide();
                    schedule.hide();
                    addOpen = false;
                }
            }
        });

        course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(CourseIntent);
            }
        });

    }
}