package de.rudi.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import de.rudi.R;

public class LoginActivity extends ActionBarActivity {

    private EditText mUsername;
    private EditText mPassword;
    private Button mLogin;
    private Button mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsername = (EditText) findViewById(R.id.usernameInput);
        mPassword = (EditText) findViewById(R.id.passwordInput);
        mLogin = (Button) findViewById(R.id.loginButton);
        mRegister = (Button) findViewById(R.id.registerButton);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String username = mUsername.getText().toString().trim();
//                String password = mPassword.getText().toString().trim();
//
//                // Implement user authentication here
//                // Authentication succeeds when username equals password
//                if (!username.equals("") && username.equals(password)) {
//                    Toast.makeText(LoginActivity.this, "Login erfolgreich!", Toast.LENGTH_LONG).show();
//                    Intent toMainActivity = new Intent(LoginActivity.this, MainActivity.class);
//                    startActivity(toMainActivity);
//                } else {
//                    Toast.makeText(LoginActivity.this, "Login fehlgeschlagen!", Toast.LENGTH_LONG).show();
//                }
                login();
            }
        });

        //login should be on keyboard after inserting password
        mPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                login();
                return true;
            }
        });

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to register activity
                Intent toRegisterActivity = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(toRegisterActivity);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.menu_login, menu);
        // return true;
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will automatically handle clicks on the Home/Up button,
        // so long as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    public final void login() {
        String username = mUsername.getText().toString().trim();
        String password = mPassword.getText().toString().trim();

        // Implement user authentication here
        // Authentication succeeds when username equals password
        if (!username.equals("") && password.equals("123456")) {
            Toast.makeText(LoginActivity.this, "Login erfolgreich!", Toast.LENGTH_LONG).show();
            Intent toMainActivity = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(toMainActivity);
        } else {
            Toast.makeText(LoginActivity.this, "Login fehlgeschlagen!", Toast.LENGTH_LONG).show();
        }
    }
}
