package com.meetweb.android.profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
    }

    public void goBackToLogin(View view) {
        startActivity(new Intent(this, LogInActivity.class));
        finish();
    }

    public void proceed(View view) {
        startActivity(new Intent(this, DashboardActivity.class));
        finish();
    }
}
