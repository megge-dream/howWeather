package com.example.megge.howweather.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.megge.howweather.R;

public class DetailFragment extends Fragment {

    public static String CITY_NAME = "city_name";

    public static DetailFragment getInstance(int city_name) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(CITY_NAME, city_name);
        detailFragment.setArguments(bundle);
        return detailFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        TextView cityDetailTextview = (TextView) view.findViewById(R.id.city_detail_textview);
        Button understoodButton = (Button) view.findViewById(R.id.understood);
        understoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().remove(DetailFragment.this).commit();
            }
        });
        cityDetailTextview.setText("Погода для " + getArguments().getInt(CITY_NAME));
    }

}
