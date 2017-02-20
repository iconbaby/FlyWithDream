package com.slkk.flywithdream;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dell on 2017/2/20.
 */

public class MainFragment extends Fragment {
    public MainFragment() {
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mainFragment = inflater.inflate(R.layout.main_fragmnt_layout, container, false);

        setHasOptionsMenu(true);
        return mainFragment;
    }
}
