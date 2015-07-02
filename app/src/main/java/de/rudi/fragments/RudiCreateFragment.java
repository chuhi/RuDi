package de.rudi.fragments;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import de.rudi.R;
import de.rudi.activities.LoginActivity;
import de.rudi.activities.MainActivity;
import de.rudi.activities.RegisterActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class RudiCreateFragment extends Fragment {

    private EditText mDatum;
    private EditText mUhrzeit;
    private Button mCreate;
    private Button mCancel;

    public RudiCreateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rudi_create, container, false);

        mDatum = (EditText) view.findViewById(R.id.datum);
        mUhrzeit = (EditText) view.findViewById(R.id.uhrzeit);
        mCreate = (Button) view.findViewById(R.id.rudiAnlegenButton);
        mCancel = (Button) view.findViewById(R.id.cancelButton);

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

        mCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Dein Dinner wurde angelegt",Toast.LENGTH_LONG).show();

                Fragment fYour = new YourRuDiFragment();
                FragmentTransaction change = getFragmentManager().beginTransaction();
                change.replace(R.id.container, fYour);
                change.addToBackStack(null);
                change.commit();
            }
        });

        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = setDialog();
                dialog.show();
            }
        });

        return view;
    }

    public Dialog setDialog(){
        //create dialog
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        dialogBuilder.setTitle("Abbrechen");
        dialogBuilder.setMessage("Willst du wirklich Abbrechen?");
        dialogBuilder.setPositiveButton("Ja", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Redirect to Main activity
                Intent toMainActivity = new Intent(getActivity(), MainActivity.class);
                startActivity(toMainActivity);
            }
        });
        dialogBuilder.setNegativeButton("Nein", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //closes Dialog without other actions
            }
        });

        // create dialog
        Dialog dialog = dialogBuilder.create();
        return dialog;
    }


}
