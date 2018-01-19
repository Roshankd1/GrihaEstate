package com.roshank.grihaestate;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.google.android.gms.maps.SupportMapFragment;
import com.roshank.grihaestate.Fragment.Login_ActivityFragment;
import com.roshank.grihaestate.Fragment.LoginorCreateAccFragment;
import com.roshank.grihaestate.Fragment.SettingsFragmentActivity;
import com.roshank.grihaestate.Fragment.ViewpagerFragment;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ViewPagerActivity viewpageractivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new ViewpagerFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.navigation, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.search) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new ViewpagerFragment()).commit();
        } else if (id == R.id.mygriha_estate) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new Login_ActivityFragment()).commit();
        } else if (id == R.id.discover_areas) {
            startActivity(new Intent(this, MapsActivity.class));
        } else if (id == R.id.property_valuation) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new PropertyValuationActivity()).commit();
        } else if (id == R.id.offices) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new OfficesActivityFragment()).commit();
        } else if (id == R.id.settings) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new SettingsFragmentActivity()).commit();
        } else if (id == R.id.login_signup) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new LoginorCreateAccFragment()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
