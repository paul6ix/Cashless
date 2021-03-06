package com.example.paulchidi.cashless.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.paulchidi.cashless.R;
import com.example.paulchidi.cashless.activities.GeneratorActivity;
import com.example.paulchidi.cashless.activities.ReaderActivity;


public class HomeFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        ImageButton ScanQrButton = (ImageButton) v.findViewById(R.id.imageButton_ScanQr);
        ScanQrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ReaderActivity.class);
                startActivity(intent);
            }
        });
        ImageButton GenQrButton = (ImageButton) v.findViewById(R.id.imageButton_GenQr);
        GenQrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GeneratorActivity.class);
                startActivity(intent);

            }
        });
        return v;
    }


}
