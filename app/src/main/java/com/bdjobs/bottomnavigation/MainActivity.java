package com.bdjobs.bottomnavigation;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {
    android.app.FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        manager = getFragmentManager();
        FragmentA fa = new FragmentA();
        android.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.setCustomAnimations(R.animator.slide_in_left,R.animator.slide_out_left);
        transaction.add(R.id.fragmentHolder,fa,"A");
        transaction.commit();

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.homeTab) {
                    FragmentA fa = new FragmentA();
                    android.app.FragmentTransaction transaction = manager.beginTransaction();
                    transaction.setCustomAnimations(R.animator.slide_in_left,R.animator.slide_out_left);
                    transaction.replace(R.id.fragmentHolder,fa,"A");
                    transaction.commit();
                }
                else if (tabId == R.id.likeTab) {
                    FragmentB fb = new FragmentB();
                    android.app.FragmentTransaction transaction = manager.beginTransaction();
                    transaction.setCustomAnimations(R.animator.slide_in_left,R.animator.slide_out_left);
                    transaction.replace(R.id.fragmentHolder,fb,"B");
                    transaction.commit();
                }
                else if (tabId == R.id.shareTab) {
                    FragmentC fc = new FragmentC();
                    android.app.FragmentTransaction transaction = manager.beginTransaction();
                    transaction.setCustomAnimations(R.animator.slide_in_left,R.animator.slide_out_left);
                    transaction.replace(R.id.fragmentHolder,fc,"A");
                    transaction.commit();
                }
            }
        });
    }
}

