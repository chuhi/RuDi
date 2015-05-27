package de.rudi.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import de.rudi.R;

public class RegisterActivity extends Activity {

    //Text fields
    private EditText mNachname;
    private EditText mVorname;
    private EditText mStrasse;
    private EditText mHausnummer;
    private EditText mPLZ;
    private EditText mStadt;
    private EditText mEmail;
    private EditText mUsername;
    private EditText mPasswort;
    private EditText mPasswortWdh;

    //Buttons
    private Button mRegister;
    private Button mCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mUsername =  (EditText) findViewById(R.id.usernameInput);
        mNachname = (EditText) findViewById(R.id.nachnameInput);
        mVorname= (EditText) findViewById(R.id.vornameInput);
        mEmail= (EditText) findViewById(R.id.emailInput);
        mPasswort = (EditText) findViewById(R.id.passwortInput);
        mPasswortWdh = (EditText) findViewById(R.id.passwortWdhInput);
        mRegister = (Button) findViewById(R.id.registerButton);
        mCancel = (Button) findViewById(R.id.cancelButton);

        mPasswortWdh.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String pass1 = mPasswort.getText().toString();
                    String pass2 = mPasswortWdh.getText().toString();
                    //bPasswort = pass1.equals(pass2);
                    //mRegister.setEnabled(bEmail && bPasswort);
                }
            }
        });

        mRegister.setEnabled(true);

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to login activity
                Toast.makeText(RegisterActivity.this,"Click",Toast.LENGTH_LONG).show();
                check();
                //Toast.makeText(RegisterActivity.this, "Registrierung erfolgreich!", Toast.LENGTH_LONG).show();
                //Intent toLoginActivity = new Intent(RegisterActivity.this, LoginActivity.class);
                //startActivity(toLoginActivity);
            }
        });

        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to login activity
                Intent toLoginActivity = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(toLoginActivity);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.menu_register, menu);
        // return true;
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //check() checks, if fields are filled correct
    public void check(){
        //check first name
        String test = mVorname.getText().toString();
        if (mVorname.getText() == null){
            Toast.makeText(RegisterActivity.this,"Bitte Vorname eingeben",Toast.LENGTH_LONG).show();
            return;
        }

        //check last name
        if (mNachname == null){
            Toast.makeText(RegisterActivity.this,"Bitte Nachname eingeben",Toast.LENGTH_LONG).show();
            return;
        }

        //check Street
        if (mStrasse == null){
            Toast.makeText(RegisterActivity.this,"Bitte Strasse eingeben",Toast.LENGTH_LONG).show();
            return;
        }

        //check number
        if (mHausnummer == null){
            Toast.makeText(RegisterActivity.this,"Bitte Hausnummer eingeben",Toast.LENGTH_LONG).show();
            return;
        }

        //check city code
        if (mPLZ == null){
            Toast.makeText(RegisterActivity.this,"Bitte PLZ eingeben",Toast.LENGTH_LONG).show();
            return;
        } else {
            //check if citycode is Number
            String cityString = mPLZ.getText().toString();
            try {
                int cityCode = Integer.parseInt(cityString);
            } catch (NumberFormatException e){
                Toast.makeText(RegisterActivity.this,"Bitte nur Nummern bei PLZ eingeben",Toast.LENGTH_LONG).show();
                return;
            }
        }

        //check email
        if (mEmail == null){
            Toast.makeText(RegisterActivity.this,"Bitte Mailadresse eingeben",Toast.LENGTH_LONG).show();
            return;
        } else {

            String getMail = mEmail.getText().toString();
            String Expn =
                    "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                            + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                            + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                            + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                            + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                            + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

            if (!(getMail.matches(Expn) && getMail.length() > 0)) {
                Toast.makeText(RegisterActivity.this, "Bitte Mailadresse korrigieren", Toast.LENGTH_LONG).show();
                return;
            }
        }

        //TODO: check more....
        Toast.makeText(RegisterActivity.this,"Registrierung erfolgreich",Toast.LENGTH_LONG);
        Intent toLoginActivity = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(toLoginActivity);
        return;
    }

}
