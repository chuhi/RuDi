package de.rudi.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import de.rudi.R;

public class RegisterActivity extends Activity {

    //Text fields
    private EditText mVorname;
    private EditText mNachname;
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

        mVorname= (EditText) findViewById(R.id.vornameInput);
        mNachname = (EditText) findViewById(R.id.nachnameInput);
        mStrasse = (EditText) findViewById(R.id.strasseInput);
        mHausnummer = (EditText) findViewById(R.id.hausnummerInput);
        mPLZ = (EditText) findViewById(R.id.plzInput);
        mStadt = (EditText) findViewById(R.id.stadtInput);
        mEmail= (EditText) findViewById(R.id.emailInput);
        mUsername =  (EditText) findViewById(R.id.usernameInput);
        mPasswort = (EditText) findViewById(R.id.registerPasswortInput);
        mPasswortWdh = (EditText) findViewById(R.id.passwortWdhInput);
        mRegister = (Button) findViewById(R.id.registerButton);
        mCancel = (Button) findViewById(R.id.cancelButton);

//        mPasswortWdh.setOnFocusChangeListener(new OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (!hasFocus) {
//                    String pass1 = mPasswort.getText().toString();
//                    String pass2 = mPasswortWdh.getText().toString();
//                    //bPasswort = pass1.equals(pass2);
//                    //mRegister.setEnabled(bEmail && bPasswort);
//                }
//            }
//        });

        //register after finishing Passwords
        mPasswortWdh.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                check();
                return true;
            }
        });

        mRegister.setEnabled(true);

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // validate input and redirekt to login
                check();
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
        if (mVorname.getText().toString().isEmpty()){
            Toast.makeText(RegisterActivity.this,"Bitte Vorname eingeben",Toast.LENGTH_LONG).show();
            mVorname.requestFocus();
            return;
        }

        //check last name
        if (mNachname.getText().toString().isEmpty()){
            Toast.makeText(RegisterActivity.this,"Bitte Nachname eingeben",Toast.LENGTH_LONG).show();
            mNachname.requestFocus();
            return;
        }

        //check Street
        if (mStrasse.getText().toString().isEmpty()){
            Toast.makeText(RegisterActivity.this,"Bitte Strasse eingeben",Toast.LENGTH_LONG).show();
            mStrasse.requestFocus();
            return;
        }

        //check number
        if (mHausnummer.getText().toString().isEmpty()){
            Toast.makeText(RegisterActivity.this,"Bitte Hausnummer eingeben",Toast.LENGTH_LONG).show();
            mHausnummer.requestFocus();
            return;
        }

        //check city code
        if (mPLZ.getText().toString().isEmpty()){
            Toast.makeText(RegisterActivity.this,"Bitte PLZ eingeben",Toast.LENGTH_LONG).show();
            mPLZ.requestFocus();
            return;
        } else {
            //check if citycode lenght is 5
            if (mPLZ.getText().toString().length() != 5){
                Toast.makeText(RegisterActivity.this,"Bitte 5-stellige PLZ eingeben",Toast.LENGTH_LONG).show();
                mPLZ.requestFocus();
                return;
            }

        }

        //check city
        if (mStadt.getText().toString().isEmpty()){
            Toast.makeText(RegisterActivity.this,"Bitte Stadt eingeben",Toast.LENGTH_LONG).show();
            mStadt.requestFocus();
            return;
        }

        //check email
        if (mEmail.getText().toString().isEmpty()){
            Toast.makeText(RegisterActivity.this,"Bitte Mailadresse eingeben",Toast.LENGTH_LONG).show();
            mEmail.requestFocus();
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
                mEmail.requestFocus();
                return;
            }
        }

        //check username
        if (mUsername.getText().toString().isEmpty()){
            Toast.makeText(RegisterActivity.this,"Bitte Username eingeben",Toast.LENGTH_LONG).show();
            mUsername.requestFocus();
            return;
        }

        //check password
        if (mPasswortWdh.getText().toString().isEmpty()||mPasswort.getText().toString().isEmpty()){
            Toast.makeText(RegisterActivity.this,"Bitte Passwort eingeben",Toast.LENGTH_LONG).show();
            mPasswort.requestFocus();
            return;
        } else {
            String pass1 = mPasswort.getText().toString();
            String pass2 = mPasswortWdh.getText().toString();
            if (!pass1.equals(pass2)){
                Toast.makeText(RegisterActivity.this,"Die Passw\u00f6rter stimmen nicht \u00fcberein",Toast.LENGTH_LONG).show();
                mPasswortWdh.requestFocus();
                return;
            }
        }

        Toast.makeText(RegisterActivity.this,"Registrierung erfolgreich",Toast.LENGTH_LONG).show();
        Intent toLoginActivity = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(toLoginActivity);
    }

}
