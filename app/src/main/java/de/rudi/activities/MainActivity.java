package de.rudi.activities;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import de.rudi.R;
import de.rudi.fragments.*;

public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.container, new StartFragment()).commit();
        }

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open_drawer, R.string.close_drawer) {

            // Called when a drawer has settled in a completely closed state
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
            }

            // Called when a drawer has settled in a completely open state
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        String[] fragmentTitles = new String[]{"Meine RuDi's", "RuDi finden", "RuDi anlegen", "Hilfe? Was ist RuDi?", "Mein Profil", "Logout"};

        // Set the adapter for the list view
        drawerList.setAdapter(new ArrayAdapter<>(this, R.layout.drawer_list_item, fragmentTitles));
        // Set the list's click listener
        drawerList.setOnItemClickListener(this);

        drawerLayout.setDrawerListener(drawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present
        // getMenuInflater().inflate(R.menu.menu_main, menu);
        // return true;
        return false;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will automatically handle clicks on the Home/Up button,
        // so long as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        FragmentManager fragmentManager = getFragmentManager();

        // Call fragment Your RuDi's
        if (position == 0) {
            fragmentManager.beginTransaction().replace(
                    R.id.container, new YourRuDiFragment()
            ).commit();
        }

        // Call fragment Search RuDi
        if (position == 1) {
            fragmentManager.beginTransaction().replace(
                    R.id.container, new RuDiSearchFragment()
            ).commit();
        }
        
        // Call fragment Create RuDi
        if (position == 2) {
            fragmentManager.beginTransaction().replace(
                    R.id.container, new RudiCreateFragment()
            ).commit();
        }

        // Call fragment Help/About
        if (position == 3) {
            fragmentManager.beginTransaction().replace(
                    R.id.container, new AboutFragment()
            ).commit();
        }

        // Call fragment Profil
        if (position == 4) {
            fragmentManager.beginTransaction().replace(
                    R.id.container, new ProfilFragment()
            ).commit();
        }

        // Logout
        if (position == 5) {
            Intent toLoginActivity = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(toLoginActivity);
        }

        drawerList.setItemChecked(position, true);
        drawerLayout.closeDrawer(drawerList);
    }

    @Override
    public void onBackPressed(){
        getFragmentManager().beginTransaction().replace(
                R.id.container, new StartFragment()
        ).commit();
    }
}
