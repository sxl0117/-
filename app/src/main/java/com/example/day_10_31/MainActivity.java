package com.example.day_10_31;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.day_10_31.fragments.FiveFragment;
import com.example.day_10_31.fragments.FourFragment;
import com.example.day_10_31.fragments.OneFragment;
import com.example.day_10_31.fragments.ThreeFragment;
import com.example.day_10_31.fragments.TwoFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private TabLayout mTab;
//哈哈哈哈
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
    }

    private void initFragment() {
        final List<Fragment> fragments = new ArrayList<>();
        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());
        fragments.add(new ThreeFragment());
        fragments.add(new FourFragment());
        fragments.add(new FiveFragment());

        View one = onSelect("首页", R.drawable.one);
        View two = onSelect("沙发", R.drawable.two);
        View three = onSelect("", R.drawable.three);
        View four = onSelect("发现", R.drawable.four);
        final View five = onSelect("我的", R.drawable.five);
        mVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
        mTab.getTabAt(0).setCustomView(one);
        mTab.getTabAt(1).setCustomView(two);
        mTab.getTabAt(2).setCustomView(three);
        mTab.getTabAt(3).setCustomView(four);
        mTab.getTabAt(4).setCustomView(five);
    }
    public View onSelect(String text, int imageView){
        View view = LayoutInflater.from(this).inflate(R.layout.select, null);
        ImageView img = view.findViewById(R.id.img);
        TextView title = view.findViewById(R.id.text);

        img.setBackgroundResource(imageView);
        title.setText(text);
        return view;
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mTab = (TabLayout) findViewById(R.id.tab);
    }
}