import android.os.Handler;

import com.benshabtay.michal.noahark.R;

import java.util.Random;

/**
 * Created by Michal on 26-Jan-18.
 */

public class beamme1 {
    final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            answer.setImageResource(R.drawable.trasmiter1);
        }
    }, 100


            );
    final Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
        @Override
        public void run() {
            answer.setImageResource(R.drawable.trasmiter2);
        }
    }, 200


            );
    final Handler handler2 = new Handler();
                handler2.postDelayed(new Runnable() {
        @Override
        public void run() {
            answer.setImageResource(R.drawable.trasmiter3);
        }
    }, 300


            );
    final Handler handler3 = new Handler();
                handler3.postDelayed(new Runnable() {
        @Override
        public void run() {
            answer.setImageResource(R.drawable.trasmiter4);
        }
    }, 400


            );
    final Handler handler4 = new Handler();
                handler4.postDelayed(new Runnable() {

        @Override
        public void run() {
            answer.setImageResource(R.drawable.trasmiter5);
        }
    }, 600

            );
    final Handler handler5 = new Handler();
                handler5.postDelayed(new Runnable() {

        @Override
        public void run() {
            answer.setImageResource(R.drawable.trasmiter1);
        }
    }, 800

            );

}
