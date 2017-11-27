package com.theappexperts.aee2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.theappexperts.aee2.data.AppDataManager;
import com.theappexperts.aee2.data.network.constants.constant.MusicModel;
import com.theappexperts.aee2.data.network.constants.constant.Result;
import com.theappexperts.aee2.views.musiclist.IMusicListMvpView;
import com.theappexperts.aee2.views.musiclist.MusicListPresenter;
import com.theappexperts.aee2.views.musiclist.fragment.MusicListFragment;
import com.theappexperts.aee2.views.ui.utils.rx.AppSchedulerProvider;

import java.lang.reflect.Array;
import java.util.ArrayList;

import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.pop_btn:
                    //fragmentManager.beginTransaction()
                    //        .add(R.id.fragView, new MusicListPopFragment())
                    //        .commit();
                    return true;
                case R.id.classic_btn:
                    fragmentManager.beginTransaction()
                            .add(R.id.fragView, new MusicListFragment())
                            .commit();
                    return true;
                case R.id.rock_btn:
                    //fragmentManager.beginTransaction()
                    //       .add(R.id.fragView, new MusicListRockFragment())
                    //        .commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        if(savedInstanceState == null){
            fragmentManager.beginTransaction()
                    .add(R.id.fragView, new MusicListFragment())
                    .commit();
        }

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
