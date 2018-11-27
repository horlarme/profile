package com.meetweb.android.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class DashboardActivity
        extends AppCompatActivity
        implements View.OnClickListener, Toolbar.OnMenuItemClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);

        //Picking toolbar from the view
        Toolbar toolbar = findViewById(R.id.toolbar_main);
        //Setting its values
        toolbar.setNavigationOnClickListener(this);
        toolbar.inflateMenu(R.menu.main);
        toolbar.setOnMenuItemClickListener(this);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), v.toString(), Toast.LENGTH_LONG).show();
    }
}
