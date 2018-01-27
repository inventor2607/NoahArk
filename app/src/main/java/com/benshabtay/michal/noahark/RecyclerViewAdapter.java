package com.benshabtay.michal.noahark;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by max on 26.01.2018.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MonsterViewHolder> {

    static class MonsterViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView monsterName;
        ImageButton monsterPhoto;

        MonsterViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            monsterName = (TextView)itemView.findViewById(R.id.monster_name);
            monsterPhoto = (ImageButton) itemView.findViewById(R.id.monster_photo);
        }
    }

    List<Monster> monsters;

    RVAdapter(List<Monster> monsters){
        this.monsters = monsters;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public MonsterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_monster, viewGroup, false);
        MonsterViewHolder mvh = new MonsterViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MonsterViewHolder personViewHolder, int i) {
        personViewHolder.monsterName.setText(monsters.get(i).name);
        personViewHolder.monsterPhoto.setImageResource(monsters.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return monsters.size();
    }
}
