package com.theappexperts.aee2.views.musiclist;

import com.theappexperts.aee2.views.ui.base.MvpPresenter;

/**
 * Created by TheAppExperts on 26/11/2017.
 */

public interface IMusicListMvpPresenter<V extends IMusicListMvpView> extends MvpPresenter<V> {
    void onCallMusicList();
}

