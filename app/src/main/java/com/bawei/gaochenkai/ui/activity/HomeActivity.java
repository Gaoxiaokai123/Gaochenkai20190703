package com.bawei.gaochenkai.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bawei.gaochenkai.R;
import com.bawei.gaochenkai.data.frag.HomeFragment;
import com.bawei.gaochenkai.data.frag.MeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.radio1)
    RadioButton radio1;
    @BindView(R.id.radio2)
    RadioButton radio2;
    @BindView(R.id.radioGaoup)
    RadioGroup radioGaoup;
    @BindView(R.id.vp)
    ViewPager vp;
    private Fragment homeFragment;
    private Fragment meFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

         HomeFragment homeFragment = new HomeFragment();
         MeFragment meFragment = new MeFragment();

        //创建事务管理器
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.vp,homeFragment).hide(homeFragment);
        fragmentTransaction.add(R.id.vp,meFragment).show(meFragment);

        fragmentTransaction.commit();//提交事务
    }

    @OnClick({R.id.radio1, R.id.radio2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.radio1:

//                FragmentManager supportFragmentManager1 = getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction1 = supportFragmentManager1.beginTransaction();
//                fragmentTransaction1.hide(homeFragment);
//                fragmentTransaction1.show(meFragment);
//                fragmentTransaction1.commit();

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction fragment = manager.beginTransaction();
                fragment.show(homeFragment);
                fragment.hide(meFragment);
                fragment.commit();

                break;
            case R.id.radio2:
                FragmentManager supportFragmentManager2 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction2 = supportFragmentManager2.beginTransaction();
                fragmentTransaction2.hide(meFragment);
                fragmentTransaction2.show(homeFragment);
                fragmentTransaction2.commit();

                break;
        }
    }

    @OnClick(R.id.vp)
    public void onViewClicked() {

    }
}
