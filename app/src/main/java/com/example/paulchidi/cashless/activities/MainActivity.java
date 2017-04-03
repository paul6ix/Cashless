package com.example.paulchidi.cashless.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.paulchidi.cashless.R;
import com.example.paulchidi.cashless.fragments.HelpFragment;
import com.example.paulchidi.cashless.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navigation;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    android.support.v4.app.Fragment homefragment = new HomeFragment();
                    FragmentTransaction homefragmentTransaction = getSupportFragmentManager().beginTransaction();
                    homefragmentTransaction.replace(R.id.content, homefragment);
                    homefragmentTransaction.commit();
                    return true;

                case R.id.navigation_help:
                    android.support.v4.app.Fragment helpfragment = new HelpFragment();
                    FragmentTransaction helpfragmentTransaction = getSupportFragmentManager().beginTransaction();
                    helpfragmentTransaction.replace(R.id.content, helpfragment);
                    helpfragmentTransaction.commit();
                    return true;

                case R.id.navigation_notifications:
                    return true;

                case R.id.navigation_settings:
                    return true;

                case R.id.navigation_account:
                    return true;

            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        android.support.v4.app.Fragment homefragment = new HomeFragment();
        FragmentTransaction homefragmentTransaction = getSupportFragmentManager().beginTransaction();
        homefragmentTransaction.replace(R.id.content, homefragment);
        homefragmentTransaction.commit();
    }

}
