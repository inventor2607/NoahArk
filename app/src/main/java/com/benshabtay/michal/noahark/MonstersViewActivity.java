package com.benshabtay.michal.noahark;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
/**
 * Created by max on 26.01.2018.
 */

public class RecyclerViewActivity extends AppCompatActivity {
    private List<Monster> monsterList;
    private RecyclerView rv;

    private static int skippedImage;

    private final int[] monsterImages = {
            R.drawable.monster1,
            R.drawable.monster2,
            R.drawable.monster3,
            R.drawable.monster4,
            R.drawable.monster5,
            R.drawable.monster6,
            R.drawable.monster7,
            R.drawable.monster8,
            R.drawable.monster9,
            R.drawable.monster10,
            R.drawable.monster11,
            R.drawable.monster12,
            R.drawable.monster13,
            R.drawable.monster14,
            R.drawable.monster15,
            R.drawable.monster16,
            R.drawable.monster17,
            R.drawable.monster18,
            R.drawable.monster19,
            R.drawable.monster20
//            R.drawable.monster21,
//            R.drawable.monster22,
//            R.drawable.monster23,
//            R.drawable.monster24,
//            R.drawable.monster25,
//            R.drawable.monster26,
//            R.drawable.monster27,
//            R.drawable.monster28,
//            R.drawable.monster29,
//            R.drawable.monster30,
//            R.drawable.monster31,
//            R.drawable.monster32,
//            R.drawable.monster33,
//            R.drawable.monster34,
//            R.drawable.monster35,
//            R.drawable.monster36,
//            R.drawable.monster37,
//            R.drawable.monster38,
//            R.drawable.monster39,
//            R.drawable.monster40
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recyclerview_activity);

        rv=(RecyclerView)findViewById(R.id.rv);

        RecyclerView.LayoutManager recyclerViewLayoutManager = new GridLayoutManager(this, 4);
//        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(recyclerViewLayoutManager);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        monsterList = new ArrayList<>();
        final int randomBadImage = new Random().nextInt(20);
        skippedImage = randomBadImage;

        for(int i = 0; i < monsterImages.length; i++) {
            if(i == randomBadImage) {

                continue;
            }
            monsterList.add(new Monster("MONSTER " + i,  monsterImages[i]));
        }
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(monsterList);
        rv.setAdapter(adapter);
    }
}
