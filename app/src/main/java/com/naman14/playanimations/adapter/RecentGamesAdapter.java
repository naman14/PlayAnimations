package com.naman14.playanimations.adapter;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.naman14.playanimations.DetailActivity;
import com.naman14.playanimations.MainActivity;
import com.naman14.playanimations.R;

import java.util.List;

/**
 * Created by naman on 27/05/15.
 */
public class RecentGamesAdapter extends RecyclerView.Adapter<RecentGamesAdapter.RecentGamesListRowHolder> {

    private List<GamesData> recentList;
    private Context mContext;

    public RecentGamesAdapter(Context context, List<GamesData> recentList) {
        this.recentList = recentList;
        this.mContext = context;
    }

    @Override
    public RecentGamesListRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recent_games_item, null);
        RecentGamesListRowHolder ml = new RecentGamesListRowHolder(v);
        return ml;
    }

    @Override
    public void onBindViewHolder(RecentGamesListRowHolder recentListRowHolder, int i) {
        GamesData recentItem = recentList.get(i);

        recentListRowHolder.cover.setImageResource(recentItem.getCover());
        recentListRowHolder.icon.setImageResource(recentItem.getIcon());
        recentListRowHolder.game.setText(recentItem.getGameName());
        recentListRowHolder.publisher.setText(recentItem.getPublisher());

    }

    @Override
    public int getItemCount() {
        return (null != recentList ? recentList.size() : 0);
    }

    public class RecentGamesListRowHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected ImageView icon, cover;
        protected TextView game, publisher;

        public RecentGamesListRowHolder(View view) {
            super(view);
            this.icon = (ImageView) view.findViewById(R.id.icon);
            this.cover = (ImageView) view.findViewById(R.id.cover);
            this.game = (TextView) view.findViewById(R.id.game);
            this.publisher = (TextView) view.findViewById(R.id.publisher);

            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext, DetailActivity.class);
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.getInstance(), Pair.create((View) cover, "cover"));
            mContext.startActivity(intent, options.toBundle());
        }

    }


}

