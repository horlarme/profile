package com.meetweb.android.profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LogInActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.log_in_activity);
    }

    public void goToRegisterActivity(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
        finish();
    }

    public void goToForgetPasswordActivity(View view) {
        startActivity(new Intent(this, ForgetPasswordActivity.class));
        finish();
    }

    public void proceed(View view) {
        startActivity(new Intent(this, DashboardActivity.class));
        finish();
    }
}
