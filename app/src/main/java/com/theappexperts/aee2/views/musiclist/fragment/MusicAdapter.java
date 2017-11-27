package com.theappexperts.aee2.views.musiclist.fragment;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.theappexperts.aee2.R;
import com.theappexperts.aee2.data.network.constants.constant.Result;

import java.util.ArrayList;

/**
 * Created by TheAppExperts on 26/11/2017.
 */

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MyViewHolder> {

    private ArrayList<Result> musicList;
    private int music_row;
    private Context applicationContext;

    public MusicAdapter(ArrayList<Result> musicList, int music_row, Context applicationContext) {
        this.musicList = musicList;
        this.music_row = music_row;
        this.applicationContext = applicationContext;
    }

    // creates views
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(applicationContext).inflate(R.layout.music_row, parent, false);

        //viewholder init view elements and is then passed back
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Uri uri = Uri.parse(musicList.get(position).getArtworkUrl60());
        holder.ivCover.setImageURI(uri);

        holder.tvTitle.setText(musicList.get(position).getCollectionName());
        holder.tvTrackName.setText(musicList.get(position).getTrackName());
        holder.tvPrice.setText(musicList.get(position).getTrackPrice().toString());

    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }

    // inits row elements
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvTrackName, tvPrice;
        ImageView ivCover;
        public MyViewHolder(View itemView) {
            super(itemView);

            ivCover = (ImageView)itemView.findViewById(R.id.ivCover);
            tvTitle = (TextView)itemView.findViewById(R.id.tvTitle);
            tvTrackName = (TextView)itemView.findViewById(R.id.tvTrackName);
            tvPrice = (TextView)itemView.findViewById(R.id.tvPrice);

        }
    }
}