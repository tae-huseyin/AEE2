package com.theappexperts.aee2.data.network.constants;

import com.theappexperts.aee2.data.network.constants.constant.API_List;
import com.theappexperts.aee2.data.network.constants.constant.MusicModel;
import com.theappexperts.aee2.data.network.constants.services.RequestInterface;
import com.theappexperts.aee2.data.network.constants.services.ServerConnection;

import io.reactivex.Observable;

/**
 * Created by TheAppExperts on 24/11/2017.
 */

public class AppApiHelper implements ApiHelper{

    private RequestInterface requestInterface;

    public AppApiHelper() {
        requestInterface = ServerConnection.BackendService();
    }

    //@Query("term") String term,@Query("media") String media, @Query("entity") String entity, @Query("limit") int length
    @Override
    public Observable<MusicModel> getFromApi_MusicList() {
        //return requestInterface.getMusicsList(API_List.TERM_CLASSIC, API_List.MEDIA, API_List.ENTITY, 50);
        return requestInterface.getMusicsList();
    }

}
