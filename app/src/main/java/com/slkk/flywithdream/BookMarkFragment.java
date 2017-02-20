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

public class BookMarkFragment extends Fragment {
    public BookMarkFragment() {
    }

    public static BookMarkFragment newInstance() {
        return new BookMarkFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View bookFragment = inflater.inflate(R.layout.book_mark_fragment_layout, container, false);

        setHasOptionsMenu(true);
        return bookFragment;
    }
}
