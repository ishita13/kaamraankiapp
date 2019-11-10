package com.example.contacts_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity  {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private TabLayout tabLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout=(TabLayout)findViewById(R.id.tablayout_id) ;

        viewPager=(ViewPager)findViewById(R.id.viewpagerid);
        pagerAdapter=new PagerAdapter(getSupportFragmentManager());
        String s="";
        TextView t1;

        pagerAdapter.AddFragment(new FragPass(),"Add Contact");
        pagerAdapter.AddFragment(new Fraglogs(),"Call Logs");
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("Add Contact");
        tabLayout.getTabAt(1).setText("Logs");
    }

    private void setPermissions(){
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]

                    {Manifest.permission.READ_CONTACTS},1);
            ActivityCompat.requestPermissions(this,new String[]

                    {Manifest.permission.READ_CALL_LOG},1);


        }
    }
}
