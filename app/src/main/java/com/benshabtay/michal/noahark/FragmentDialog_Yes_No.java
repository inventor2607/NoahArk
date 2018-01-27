package com.benshabtay.michal.noahark;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by max on 27.01.2018.
 */

public class FragmentDialog_Yes_No extends AppCompatDialogFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.dialog_yes_no, container, false);


        ColorDrawable colorDrawable = new ColorDrawable(Color.BLACK);
        colorDrawable.setAlpha(120);
        getDialog().getWindow().setBackgroundDrawable(colorDrawable);

        Button close = rootView.findViewById(R.id.btnExitGame);
        Button startNewGame = rootView.findViewById(R.id.btnStartNewGame);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    getActivity().finishAffinity();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        });
        startNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ActivityStart.class));
            }
        });
        return rootView;
    }
}
