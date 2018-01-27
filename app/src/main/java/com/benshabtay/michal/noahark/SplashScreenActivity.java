package com.benshabtay.michal.noahark;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by max on 27.01.2018.
 */

public class SplashScreenActivity extends AppCompatActivity {

    private ImageView IV_splashImage;
    final int[] splashImages = {
            R.drawable.arkani1,    //0
            R.drawable.arkani2,    //1
            R.drawable.arkani3,    //2
            R.drawable.trasmiter1, //3
            R.drawable.trasmiter2, //4
            R.drawable.trasmiter3, //5
            R.drawable.trasmiter6, //6
            R.drawable.trasmiter7, //7
            R.drawable.trasmiter6, //8
            R.drawable.trasmiter8, //9
            R.drawable.trasmiter6, //10
            R.drawable.trasmiter9, //11
            R.drawable.trasmiter6, //12
            R.drawable.trasmiter11, //13
            R.drawable.trasmiter6, //14
            R.drawable.trasmiterbad, //15
            R.drawable.malfunction1, //16
            R.drawable.malfunction2, //17
            R.drawable.malfunction2, //19
            R.drawable.malfunction3, //20
            R.drawable.malfunction4 //21
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        IV_splashImage = findViewById(R.id.IV_splashScreenImage);
        startActivity();
    }

    @Override
    protected void onStart() {
        super.onStart();
        startAnimation();
    }

    private void playAnimation(final int picture, int delayMiniseconds) {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    IV_splashImage.setImageResource(picture);
                                }
                            }, delayMiniseconds

        );
    }

    private void startAnimation() {
        int millis = 400;
        for (int i = 0; i < splashImages.length; i++) {
            playAnimation(splashImages[i], millis);
            if (i == 0 || i == 1) {
                millis += 400;
            } else if (i == 2 || i == 3) {
                millis += 800;
            } else if (i >= 4 && i <= 6) {
                millis += 200;
            } else if (i >= 7 && i <= 14) {
                millis += 300;
            } else if (i == 15) {
                millis += 700;
            } else if (i >= 16 && i <= 18) {
                millis += 500;
            } else if (i == 19 || i == 20) {
                millis += 2000;
            }
        }
    }

    private void startActivity() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    startActivity(new Intent(SplashScreenActivity.this, ActivityStart.class));
                                }
                            }, 14000

        );

    }
}