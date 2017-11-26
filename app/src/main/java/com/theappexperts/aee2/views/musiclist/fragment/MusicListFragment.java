package com.theappexperts.aee2.views.musiclist.fragment;


import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.theappexperts.aee2.MainActivity;
import com.theappexperts.aee2.R;
import com.theappexperts.aee2.data.network.constants.constant.MusicModel;
import com.theappexperts.aee2.data.network.constants.constant.Result;
import com.theappexperts.aee2.views.musiclist.IMusicListMvpView;
import com.theappexperts.aee2.views.musiclist.MusicListPresenter;

import java.io.IOException;
import java.util.ArrayList;

public class MusicListFragment extends Fragment implements IMusicListMvpView {

    private RecyclerView rvMusicList;
    private MusicListPresenter<MainActivity> musicListPresenter;
    private MediaPlayer mediaPlayer = new MediaPlayer();

    ArrayList<Result> musicListArray;

    public MusicListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvMusicList = (RecyclerView) view.findViewById(R.id.rvMusicList);
        rvMusicList.setLayoutManager(new LinearLayoutManager(getContext()));

        //musicListPresenter = new MusicListPresenter<>(new AppDataManager(), new AppSchedulerProvider(), new CompositeDisposable());
        //musicListPresenter.onAttach();

        rvMusicList.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), rvMusicList ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // when clicked
                        Log.i("tag",  "item " + position);

                        if(musicListArray != null) {
                            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                            try {
                                mediaPlayer.setDataSource(musicListArray.get(position).getPreviewUrl());
                                mediaPlayer.prepare(); // might take long! (for buffering, etc)
                                mediaPlayer.start();
                            } catch (IOException e) {
                                e.printStackTrace();
                                mediaPlayer.stop();
                                mediaPlayer.release();
                            }
                        }

                    }

                    @Override public void onLongItemClick(View view, int position) {

                    }
                })
        );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music_list, container, false);
    }

    @Override
    public void onFetchDataSuccess(MusicModel musicModels) {
        musicListArray = new ArrayList<>(musicModels.getResults());
        rvMusicList.setAdapter(new MusicAdapter(musicListArray, R.layout.music_row, getContext()));
    }

    @Override
    public void onFetchDataError(String message) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void openActivityOnTokenExpire() {

    }

    @Override
    public void onError(int resId) {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showMessage(int resId) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void hideKeyboard() {

    }
}
