package com.theappexperts.aee2.views.musiclist;

import com.theappexperts.aee2.data.IDataManager;
import com.theappexperts.aee2.data.network.constants.constant.MusicModel;
import com.theappexperts.aee2.views.ui.base.BasePresenter;
import com.theappexperts.aee2.views.ui.utils.rx.SchedulerProvider;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by TheAppExperts on 24/11/2017.
 */

public class MusicListPresenter<V extends IMusicListMvpView>
        extends BasePresenter<V>
        implements IMusicListMvpPresenter<V> {

    public MusicListPresenter(IDataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onCallMusicList() {

        getCompositeDisposable().add(
                getDataManager().getFromApi_MusicList()
                        .observeOn(getSchedulerProvider().ui())
                        .subscribeOn(getSchedulerProvider().io())
                        .subscribe(new Consumer<MusicModel>() {
                                       @Override
                                       public void accept(MusicModel musicModels) throws Exception {
                                           getMvpView().onFetchDataSuccess(musicModels);
                                       }
                                   },
                                new Consumer<Throwable>() {
                                    @Override
                                    public void accept(Throwable throwable) throws Exception {
                                        getMvpView().onError(throwable.getMessage());
                                    }
                                }));

    }
}
