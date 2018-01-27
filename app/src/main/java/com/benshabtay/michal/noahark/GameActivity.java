package com.benshabtay.michal.noahark;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by max on 26.01.2018.
 */

public class GameActivity extends AppCompatActivity {
    private static final String TAG = "MONSTERS_ACTIVITY";
    private List<Monster> monsterList;
    private RecyclerView rv;

    private long startGameTime;

    private static int badImageId;

    private ArrayList<Integer> listForCurrentDifficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.monsters_view_activity);

        String difficulty = receiveDifficultyFromIntent(getIntent());
        if(difficulty != null) {
            createListForCurrentDifficulty(difficulty);
        }

        rv=(RecyclerView)findViewById(R.id.rv);

        RecyclerView.LayoutManager recyclerViewLayoutManager = new GridLayoutManager(this, 3);
//        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(recyclerViewLayoutManager);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        startGameTime = System.currentTimeMillis();
    }

    private String receiveDifficultyFromIntent(Intent intent) {
        if(intent != null) {
            return intent.getStringExtra(Constants.DIFFICULTY_KEY);
        }
        else return null;
    }

    private void createListForCurrentDifficulty(String difficulty) {
          int numberOfMonsterToInit = 0;
        switch (difficulty) {
            case Constants.DIFFICULTY_EASY:
                numberOfMonsterToInit = 10;
                break;
            case Constants.DIFFICULTY_MEDIUM:
                numberOfMonsterToInit = 20;
                break;
            case Constants.DIFFICULTY_HARD:
                numberOfMonsterToInit = 40;
                break;
        }
        if(numberOfMonsterToInit > 0) {
            listForCurrentDifficulty = new ArrayList<>();
            for(int i = 0; i < numberOfMonsterToInit; i ++) {
                listForCurrentDifficulty.add(i, Constants.ALL_monsterImages[i]);
            }
            Log.d(TAG, "LIST OF CURRENT DIFFICULTY: " + listForCurrentDifficulty);
            listForCurrentDifficulty.addAll(listForCurrentDifficulty);
            Log.d(TAG, "DOUBLE LIST OF CURRENT DIFFICULTY: " + listForCurrentDifficulty);
        }
    }


    private void initializeData(){
        monsterList = new ArrayList<>();
        final int randomBadImage = new Random().nextInt(20);
        Log.d(TAG, "RANDOM NUMBER = " + randomBadImage);
        if(listForCurrentDifficulty != null && !listForCurrentDifficulty.isEmpty()) {
            for(int i = 0; i < listForCurrentDifficulty.size(); i++) {
                if(i == randomBadImage) {
                    badImageId = listForCurrentDifficulty.get(randomBadImage);
                    Log.d(TAG, "REACHED TO RANDOM NUMBER = " + randomBadImage + "AT THE POSITION " + i +
                            "WITH ID " + listForCurrentDifficulty.get(randomBadImage));
                    continue;
                }
                monsterList.add(new Monster("MONSTER ",  listForCurrentDifficulty.get(i)));
            }
        }
    }

    private void initializeAdapter(){
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(monsterList);
        rv.setAdapter(adapter);
    }


    private void respondeToClick(int clickedId) {
        Log.d(TAG, "respondeToClick: clicked = " + clickedId + " missing = " + badImageId);
        if(clickedId == badImageId) {
            long passedTimeMillis = System.currentTimeMillis() - startGameTime;
            long timeInMinutes = passedTimeMillis / (60 * 1000);
            long timeInSeconds = passedTimeMillis / 1000;
            String time = "Your time is: " + timeInMinutes + " : " + timeInSeconds;
            Bundle bundle = new Bundle();
            bundle.putString(Constants.WIN_KEY, time);
            FragmentManager fm = getSupportFragmentManager();
            WinDialog winDialog = new WinDialog();
            winDialog.setArguments(bundle);
            winDialog.show(fm, "WIN DIALOG");
        } else {
            new CustomSnackBar(findViewById(R.id.root_gameView), "WRONG MONSTER", Snackbar.LENGTH_LONG);
        }
    }


    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentDialog_Yes_No yesNoDialog = new FragmentDialog_Yes_No();
        yesNoDialog.show(fm, null);
    }





    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MonsterViewHolder> {

        class MonsterViewHolder extends RecyclerView.ViewHolder {

            CardView cardView;
            TextView monsterName;
            ImageButton monsterPhoto;

            MonsterViewHolder(View itemView) {
                super(itemView);
                cardView = itemView.findViewById(R.id.cv);
                monsterName = itemView.findViewById(R.id.monster_name);
                monsterPhoto = itemView.findViewById(R.id.monster_photo);
            }
        }

        List<Monster> monsters;

        RecyclerViewAdapter(List<Monster> monsters){
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
        public void onBindViewHolder(final MonsterViewHolder personViewHolder, final int i) {
            personViewHolder.monsterName.setText(monsters.get(i).name);
            personViewHolder.monsterPhoto.setImageResource(monsters.get(i).photoId);
            personViewHolder.monsterPhoto.setTag(monsters.get(i).photoId);

            personViewHolder.monsterPhoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
    //                Toast.makeText(GameActivity.this, "MY ID IS: " + personViewHolder.monsterPhoto.getId(), Toast.LENGTH_LONG).show();
                    respondeToClick((Integer) personViewHolder.monsterPhoto.getTag());
                }
            });
        }

        @Override
        public int getItemCount() {
            return monsters.size();
        }
    }

}
