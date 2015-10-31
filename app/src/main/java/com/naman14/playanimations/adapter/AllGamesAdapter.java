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
public class AllGamesAdapter extends RecyclerView.Adapter<AllGamesAdapter.AllGamesGridHolder> {

    private List<GamesData> allGamesList;
    private Context mContext;

    public AllGamesAdapter(Context context, List<GamesData> allGamesList) {
        this.allGamesList = allGamesList;
        this.mContext = context;
    }

    @Override
    public AllGamesGridHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.all_games_item, null);
        AllGamesGridHolder ml = new AllGamesGridHolder(v);
        return ml;
    }

    @Override
    public void onBindViewHolder(AllGamesGridHolder allGamesGridHolder, int i) {
        GamesData allGamesItem = allGamesList.get(i);

        allGamesGridHolder.icon.setImageResource(allGamesItem.getIcon());
        allGamesGridHolder.game.setText(allGamesItem.getGameName());

    }

    @Override
    public int getItemCount() {
        return (null != allGamesList ? allGamesList.size() : 0);
    }


    public class AllGamesGridHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected ImageView icon, cover;
        protected TextView game, publisher;

        public AllGamesGridHolder(View view) {
            super(view);
            this.icon = (ImageView) view.findViewById(R.id.icon);
            this.game = (TextView) view.findViewById(R.id.game);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext, DetailActivity.class);
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.getInstance(), Pair.create((View) icon, "cover"), Pair.create((View) icon, "icon"));
            mContext.startActivity(intent, options.toBundle());
        }

    }
}

