package com.benshabtay.michal.noahark;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by max on 27.01.2018.
 */

public class WinDialog extends DialogFragment {

    TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        String text = bundle.getString(Constants.WIN_KEY);
        View rootView = inflater.inflate(R.layout.win_layout, container, false);

        ColorDrawable colorDrawable = new ColorDrawable(Color.BLACK);
        colorDrawable.setAlpha(120);
        getDialog().getWindow().setBackgroundDrawable(colorDrawable);


        textView = rootView.findViewById(R.id.TV_score);
        textView.setText(text);

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        Button yes = rootView.findViewById(R.id.btn_yes);
        Button no = rootView.findViewById(R.id.btn_no);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ActivityStart.class));
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    getActivity().finishAffinity();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        });

        return rootView;
    }
}
