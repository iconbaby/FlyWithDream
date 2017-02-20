package com.slkk.flywithdream;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    private FrameLayout fragment_container;
    private MainFragment mainFragment;
    private BookMarkFragment bookMarkFragment;
    public static final String ACTION_BOOKMARKS = "com.slkk.flywithdream.bookmarks";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        if (savedInstanceState != null) {
            mainFragment = (MainFragment) getSupportFragmentManager().getFragment(savedInstanceState, "mainFragment");
            bookMarkFragment = (BookMarkFragment) getSupportFragmentManager().getFragment(savedInstanceState, "bookMarkFragment");
        } else {
            mainFragment = MainFragment.newInstance();
            bookMarkFragment = new BookMarkFragment();
        }

        if (!mainFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, mainFragment, "mainFragment").commit();

        }
        if (!bookMarkFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, bookMarkFragment, "bookMarkFragment").commit();

        }

        String action = getIntent().getAction();
        if (action.equals(ACTION_BOOKMARKS)) {
            showBookMarkFragemnt();
            navigationView.setCheckedItem(R.id.book_page);

        } else {
            showMainFragment();
            navigationView.setCheckedItem(R.id.main_page);
        }

    }

    private void initView() {
        drawer = (DrawerLayout) findViewById(R.id.drawerlayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toggle = new ActionBarDrawerToggle(this,
                drawer, toolbar, R.string.open_drawer,
                R.string.close_drawer);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawer.closeDrawer(GravityCompat.START);

        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.main_page:
//                Toast.makeText(this, "main_page", Toast.LENGTH_SHORT).show();
                showMainFragment();

                break;
            case R.id.book_page:

//                Toast.makeText(this, "book_page", Toast.LENGTH_SHORT).show();
                showBookMarkFragemnt();
                break;
        }
        return true;
    }

    public void showMainFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.hide(bookMarkFragment);
        fragmentTransaction.show(mainFragment);
        fragmentTransaction.commit();
        toolbar.setTitle("纸飞机");
    }

    public void showBookMarkFragemnt() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.hide(mainFragment);
        fragmentTransaction.show(bookMarkFragment);
        fragmentTransaction.commit();
        toolbar.setTitle("收藏");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mainFragment.isAdded()) {
            getSupportFragmentManager().putFragment(outState, "mainFragment", mainFragment);
        }

        if (bookMarkFragment.isAdded()) {
            getSupportFragmentManager().putFragment(outState, "bookMarkFragment", bookMarkFragment);
        }
    }
}
