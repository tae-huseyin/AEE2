package com.theappexperts.aee2.data.network.constants;




import com.theappexperts.aee2.data.network.constants.constant.MusicModel;

import io.reactivex.Observable;

/**
 * Created by TheAppExperts on 24/11/2017.
 */

public interface ApiHelper {
    Observable<MusicModel> getFromApi_MusicList();
}
