package com.theappexperts.aee2.data;


import com.theappexperts.aee2.data.network.constants.ApiHelper;
import com.theappexperts.aee2.data.network.constants.AppApiHelper;
import com.theappexperts.aee2.data.network.constants.constant.MusicModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by TheAppExperts on 24/11/2017.
 */

public class AppDataManager implements IDataManager{

    private ApiHelper apiHelper;

    public AppDataManager(){
        apiHelper = new AppApiHelper();
    }
    public Observable<MusicModel> getFromApi_MusicList(){
        return apiHelper.getFromApi_MusicList();
    }
}
