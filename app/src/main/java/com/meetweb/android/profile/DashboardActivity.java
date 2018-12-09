package com.meetweb.android.profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.meetweb.android.profile.Fragment.DashboardFragment;
import com.meetweb.android.profile.Fragment.ProfileFragment;
import com.meetweb.android.profile.Fragment.SettingsFragment;

public class DashboardActivity
        extends AppCompatActivity
        implements View.OnClickListener,
        NavigationView.OnNavigationItemSelectedListener,
        Toolbar.OnMenuItemClickListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    View navigationViewHeader;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    TextView drawerNavTitle;

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

        drawerNavTitle = navigationViewHeader.findViewById(R.id.drawer_user_name);

        changeDrawerProfileName("Lawal Oladipupo");

        fragmentManager = getSupportFragmentManager();

        openDashboardFragment();
    }

    /**
     * Go to the dashboard of the app
     */
    public void openDashboardFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        //Adding dashboard programmatically
        //we choose to use add instead of replace because it will be serving as the home
        //and when the back button is pressed, it closes the app
        fragmentTransaction.add(R.id.mainFragmentContainer, new DashboardFragment());
        fragmentTransaction.commit();
        //setting the title of the app bar to dashboard
        setAppBarTitle("Dashboard");
    }

    /**
     * Change the text of the title of the app bar
     *
     * @param dashboard
     */
    public void setAppBarTitle(String dashboard) {
        toolbar.setTitle(dashboard);
    }

    /**
     * Go to profile
     */
    public void openProfileFragment() {
        fragmentTransaction = fragmentManager.beginTransaction()
                .replace(R.id.mainFragmentContainer, new ProfileFragment())
                .addToBackStack(null);
        fragmentTransaction.commit();
        setAppBarTitle("Profile");
    }

    /**
     * Go to Settings
     */
    public void openSettingsFragment() {
        fragmentTransaction = fragmentManager.beginTransaction()
                .replace(R.id.mainFragmentContainer, new SettingsFragment())
                .addToBackStack(null);
        fragmentTransaction.commit();
        setAppBarTitle("Settings");
    }

    /**
     * Set the text on the drawer header.
     *
     * @param userName The name to change the text shown in the drawer header to
     */
    public void changeDrawerProfileName(String userName) {
        drawerNavTitle.setText(userName);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        // set item as selected to persist highlight
        menuItem.setChecked(true);
        // close drawer when item is tapped
        drawerLayout.closeDrawers();

        switch (menuItem.getItemId()) {
            case R.id.openProfile:
                openProfileFragment();
                break;
            case R.id.openSettings:
                openSettingsFragment();
                break;
            default:
                openDashboardFragment();
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
