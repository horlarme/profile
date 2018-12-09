package com.meetweb.android.profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DashboardActivity
        extends AppCompatActivity
        implements View.OnClickListener,
        NavigationView.OnNavigationItemSelectedListener,
        Toolbar.OnMenuItemClickListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    View navigationViewHeader;
    FragmentManager fragment;
    TextView title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);

        //Picking toolbar from the view
        toolbar = findViewById(R.id.toolbar_main);
        //Setting its values
        toolbar.setNavigationOnClickListener(this);
        toolbar.inflateMenu(R.menu.main);
        toolbar.setOnMenuItemClickListener(this);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.drawer_navigation);
        navigationView.setNavigationItemSelectedListener(this);
        //Using this method in other to get the view of the header for the drawer
        navigationViewHeader = navigationView.inflateHeaderView(R.layout.drawer_menu_header);

        title = navigationViewHeader.findViewById(R.id.drawer_user_name);

        changeDrawerProfileName("Lawal Oladipupo");

        fragment = getSupportFragmentManager();
    }

    /**
     * Set the text on the drawer header.
     *
     * @param userName The name to change the text shown in the drawer header to
     */
    public void changeDrawerProfileName(String userName) {
        title.setText(userName);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        // set item as selected to persist highlight
        menuItem.setChecked(true);
        // close drawer when item is tapped
        drawerLayout.closeDrawers();

        switch (menuItem.getItemId()) {
            default:
                break;
        }
        return false;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    public void onClick(View v) {
        drawerLayout.openDrawer(GravityCompat.START);
    }
}
