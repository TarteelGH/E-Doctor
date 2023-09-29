package com.gxstudio.e_doctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    public NavigationView navigationView;

    ImageButton startBtn;

    SharedPreferences shared;

    TextView UserName, UserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        shared = this.getSharedPreferences("User", Context.MODE_PRIVATE);
        String username = shared.getString("Name","Username");
        String userEmail = shared.getString("Email","example@gmail.com");

        navigationView = findViewById(R.id.nav_view);

        View header = navigationView.getHeaderView(0);
        UserName = header.findViewById(R.id.userName);
        UserEmail = header.findViewById(R.id.userEmail);

        UserName.setText(username);
        UserEmail.setText(userEmail);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_item1:{
                        Toast.makeText(HomeActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    }

                    case R.id.nav_item2:{
                        Toast.makeText(HomeActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    }

                    case R.id.nav_item3:{
                        Toast.makeText(HomeActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    }

                    case R.id.nav_item4:{
                        Toast.makeText(HomeActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    }
                }

                return false;
            }
        });

        // start to be ready for scan
        startBtn = findViewById(R.id.homeActivityStartBtn);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HomeActivity.this, TestTypeActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}