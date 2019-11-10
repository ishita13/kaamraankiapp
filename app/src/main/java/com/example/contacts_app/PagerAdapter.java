package com.example.contacts_app;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fir=new ArrayList<>();
    private final List<String> Tit=new ArrayList<>();

    public PagerAdapter(FragmentManager fragmentMa)
    {
        super(fragmentMa);
    }

    @Override
    public Fragment getItem(int posi)

    {
        return fir.get(posi);
    }
    public CharSequence getPage(int posi)
    {
        return Tit.get(posi);
    }
    public void AddFragment(Fragment fg,String tt)
    {
        fir.add(fg);
        Tit.add(tt);
    }
    @Override
    public int getCount()
    {
        return Tit.size();
    }
}
