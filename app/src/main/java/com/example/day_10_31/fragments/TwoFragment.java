package com.example.day_10_31.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.day_10_31.R;
import com.example.day_10_31.childFragment.ShiFragment;
import com.example.day_10_31.childFragment.TextFragment;
import com.example.day_10_31.childFragment.TuFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class TwoFragment extends Fragment {

    private TabLayout mTab;
    private ViewPager mVp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_two, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(@NonNull final View itemView) {
        mTab = (TabLayout) itemView.findViewById(R.id.tab);
        mVp = (ViewPager) itemView.findViewById(R.id.vp);
        final List<Fragment> fragments = new ArrayList<>();
        fragments.add(new TuFragment());
        fragments.add(new ShiFragment());
        fragments.add(new TextFragment());
        mVp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        mTab.setupWithViewPager(mVp);
        mTab.getTabAt(0).setText("图片");
        mTab.getTabAt(1).setText("视频");
        mTab.getTabAt(2).setText("文本");
    }
}