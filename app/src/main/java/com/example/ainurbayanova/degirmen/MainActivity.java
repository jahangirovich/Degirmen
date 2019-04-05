package com.example.ainurbayanova.degirmen;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ainurbayanova.degirmen.views.fragments.MealsFragment;
import com.example.ainurbayanova.degirmen.views.fragments.OrdersFragment;
import com.example.ainurbayanova.degirmen.views.fragments.ProductsFragment;
import com.example.ainurbayanova.degirmen.views.interfaces.TypesDataInterface;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    ActionBarDrawerToggle toggle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    ProductsFragment productsFragment;
    MealsFragment mealsFragment;
    OrdersFragment ordersFragment;

    Bundle bundleForSendListToMealsFragment;

    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();

        setSupportActionBar(toolbar);
        bundleForSendListToMealsFragment = new Bundle();

        integrationToggleWithDrawer();
        navigationView.setNavigationItemSelectedListener(this);

        initFragments();
        getPermissionOfFragmentManager(productsFragment);
    }

    private void initFragments(){
        productsFragment = new ProductsFragment();
        mealsFragment = new MealsFragment();
        ordersFragment = new OrdersFragment();
    }

    public void integrationToggleWithDrawer(){
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.products) {
            getPermissionOfFragmentManager(productsFragment);
        } else if (id == R.id.meals) {
            getPermissionOfFragmentManager(mealsFragment);
        } else if (id == R.id.orders) {
            getPermissionOfFragmentManager(ordersFragment);
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void getPermissionOfFragmentManager(Fragment fragment){
        fragmentManager.beginTransaction().replace(R.id.relativeLayout,fragment).commit();
    }
}
