package com.example.calsample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import java.util.Calendar;


public class MainActivity2 extends AppCompatActivity {
    CalendarView calendar;
    TextView date_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main2);
        calendar = (CalendarView) findViewById(R.id.calendar);
        date_view = (TextView) findViewById(R.id.date_view);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String Date=i2+"-"+(i1+1)+"-"+i;
                date_view.setText(Date);

            }
        });


    }
    public void AddCalendarEvent(View view) {
        Calendar calendarEvent = Calendar.getInstance();
        Intent i = new Intent(Intent.ACTION_EDIT);
        i.setType("vnd.android.cursor.item/event");
        i.putExtra("beginTime", calendarEvent.getTimeInMillis());
        i.putExtra("allDay", true);
        i.putExtra("rule", "FREQ=YEARLY");
        i.putExtra("endTime", calendarEvent.getTimeInMillis() + 60 * 60 * 1000);
        i.putExtra("title", "Calendar Event");
        startActivity(i);
    }
}