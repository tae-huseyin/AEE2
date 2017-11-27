package com.theappexperts.aee2.data.network.constants.services;

import com.theappexperts.aee2.data.network.constants.constant.API_List;
import com.theappexperts.aee2.data.network.constants.constant.MusicModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Samuel on 22/11/2017.
 */

public interface RequestInterface {
    //https://itunes.apple.com/search?term=classick&amp;media=music&amp;entity=song&amp;limit=50
    @GET(API_List.CLASSIC_URL)
    Observable<MusicModel> getMusicsList();
//    Observable<MusicModel> getMusicsList(@Query("term") String term,
//                                         @Query("media") String media,
//                                         @Query("entity") String entity,
//                                         @Query("limit") int length);
    //@GET("https://itunes.apple.com/search?term=classick&amp;media=music&amp;entity=song&amp;limit=50")
    //Observable<MusicModel> getMusicsList();
}
