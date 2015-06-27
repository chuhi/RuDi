package de.rudi.fragments;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import de.rudi.R;
import de.rudi.activities.LoginActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class RudiCreateFragment extends Fragment {

    private EditText mDatum;
    private EditText mUhrzeit;

    public RudiCreateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rudi_create, container, false);

        mDatum = (EditText) view.findViewById(R.id.datum);
        mUhrzeit = (EditText) view.findViewById(R.id.uhrzeit);

        // Java Kalender abrufen
        final Calendar c = Calendar.getInstance();

        //Dialog
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                c.set(Calendar.YEAR, year);
                c.set(Calendar.MONTH, monthOfYear);
                c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

                mDatum.setText(dateFormat.format(c.getTime()));
            }
        };

        // Aufruf Date Picker
        mDatum.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(getActivity(), date, c
                        .get(Calendar.YEAR), c.get(Calendar.MONTH),
                        c.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        //Aufruf Time Picker
        mUhrzeit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);
                TimePickerDialog timePicker;
                timePicker = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String hour = String.valueOf(selectedHour);
                        String minutes = String.valueOf(selectedMinute);
                        if (selectedHour < 10) {
                            hour = "0" + selectedHour;
                        }

                        if (selectedMinute < 10) {
                            minutes = "0" + selectedMinute;
                        }
                        mUhrzeit.setText(hour + ":" + minutes);
                    }
                }, hour, minute, true);
                timePicker.show();
            }
        });

        return view;
    }


}
