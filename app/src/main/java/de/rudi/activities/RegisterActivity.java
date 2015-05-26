package de.rudi.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import de.rudi.R;

public class RegisterActivity extends ActionBarActivity {

    private EditText mUsername;
    private EditText mNachname;
    private EditText mVorname;
    private EditText mStrasse;
    private EditText mHausnummer;
    private EditText mPlz;
    private EditText mStadt;
    private EditText mPasswort;
    private EditText mPasswortWdh;
    private Button mRegister;
    private Button mCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mUsername =  (EditText) findViewById(R.id.usernameInput);
        mNachname = (EditText) findViewById(R.id.nachnameInput);
        mVorname= (EditText) findViewById(R.id.vornameInput);
        mPasswort = (EditText) findViewById(R.id.passwordInput);
        mPasswortWdh = (EditText) findViewById(R.id.passwortWdhInput);
        mRegister = (Button) findViewById(R.id.registerButton);
        mCancel = (Button) findViewById(R.id.cancelButton);

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to login activity
                Toast.makeText(RegisterActivity.this, "Registrierung erfolgreich!", Toast.LENGTH_LONG).show();
                Intent toLoginActivity = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(toLoginActivity);
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

}
