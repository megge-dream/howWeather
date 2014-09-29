package com.example.megge.howweather;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import com.example.megge.howweather.fragments.CitiesListFragment;
import com.example.megge.howweather.fragments.DetailFragment;

/**
 * Created by megge on 29.09.14.
 */
public class FragmentsActivity extends FragmentActivity implements CitiesListFragment.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragments_activity);
    }

    @Override
    public void onArticleSelected(int position) {
        DetailFragment newFragment = DetailFragment.getInstance(position);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.add(R.id.fragment_container, newFragment);
        //transaction.addToBackStack(null);

        transaction.commit();
    }
}