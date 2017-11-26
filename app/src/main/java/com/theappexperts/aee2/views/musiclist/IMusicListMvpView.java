package com.theappexperts.aee2.views.musiclist;

import com.theappexperts.aee2.data.network.constants.constant.MusicModel;
import com.theappexperts.aee2.views.ui.base.MvpView;

import java.util.List;

/**
 * Created by TheAppExperts on 26/11/2017.
 */

public interface IMusicListMvpView extends MvpView {

    void onFetchDataSuccess(MusicModel musicModels);
    void onFetchDataError(String message);

}
