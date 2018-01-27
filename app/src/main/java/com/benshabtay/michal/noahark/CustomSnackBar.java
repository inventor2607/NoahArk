package com.benshabtay.michal.noahark;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

/**
 * Created by max on 27.01.2018.
 */

public class CustomSnackBar {

    public CustomSnackBar(View idViewToRender, String text, int length) {
        Snackbar snackbar = Snackbar
                .make(idViewToRender, text, length);
        // Changing message text color
        snackbar.setActionTextColor(Color.GREEN);

        // Changing action button text color
        View sbView = snackbar.getView();
        TextView textView = sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.RED);
        snackbar.show();
    }
}
