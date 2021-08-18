package com.example.course;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

public class Course extends AppCompatActivity {

    int year, month, date;
    int year1, month1, date1;

    int hour, minute;
    int hour1, minute1;

    Button startOne, endOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        TextView warningText = findViewById(R.id.warningText);
        TextView warningText2 = findViewById(R.id.warningText2);
        EditText csInput = findViewById(R.id.csInput);

        CheckBox Monday = findViewById(R.id.Monday);
        CheckBox Tuesday = findViewById(R.id.Tuesday);
        CheckBox Wednesday = findViewById(R.id.Wednesday);
        CheckBox Thursday = findViewById(R.id.Thursday);
        CheckBox Friday = findViewById(R.id.Friday);
        CheckBox Saturday = findViewById(R.id.Saturday);
        CheckBox Sunday = findViewById(R.id.Sunday);

        startOne = findViewById(R.id.startTime);
        endOne = findViewById(R.id.endTime);
        Button startTwo = findViewById(R.id.startDate);
        Button endTwo = findViewById(R.id.endDate);

        Button submit = findViewById(R.id.submit);

        startTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                date = c.get(Calendar.DAY_OF_MONTH);

                new DatePickerDialog(Course.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String format = "" + setDateFormat(year, month, dayOfMonth);
                        startTwo.setText(format);
                    }
                }, year, month, date).show();


            }
        });

        endTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar d = Calendar.getInstance();
                year1 = d.get(Calendar.YEAR);
                month1 = d.get(Calendar.MONTH);
                date1 = d.get(Calendar.DAY_OF_MONTH);

                new DatePickerDialog(Course.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String format = "" + setDateFormat(year, month, dayOfMonth);
                        endTwo.setText(format);
                    }
                }, year1, month1, date1).show();
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (csInput.getText().toString().matches("")) {
                    warningText.setText("您未輸入課程名稱");
                }
                else{
                    warningText.setText("");
                }
                if (Monday.isChecked() == false && Tuesday.isChecked() == false && Wednesday.isChecked() == false
                        && Thursday.isChecked() == false && Friday.isChecked() == false &&
                        Saturday.isChecked() == false && Sunday.isChecked() == false) {
                    warningText2.setText("請勾選課程上課頻率");
                }
                else{
                    warningText2.setText("");
                }

                csInput.getText().toString();

            }
        });


    }

    private String setDateFormat(int year, int month, int date) {
        return String.valueOf(year) + "-" + String.valueOf(month + 1) + "-" + String.valueOf(date);
    }

    public void picktime(View view) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selecthour, int selectminute) {
                hour = selecthour;
                minute = selectminute;
                startOne.setText(String.format(Locale.getDefault(), "%02d : %02d", hour, minute));
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener, hour, minute, true);

        timePickerDialog.setTitle("select time");
        timePickerDialog.show();
    }

    public void picktime01(View view) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selecthour, int selectminute) {
                hour1 = selecthour;
                minute1 = selectminute;
                endOne.setText(String.format(Locale.getDefault(), "%02d : %02d", hour1, minute1));

            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener, hour1, minute1, true);

        timePickerDialog.setTitle("select time");
        timePickerDialog.show();

    }

}