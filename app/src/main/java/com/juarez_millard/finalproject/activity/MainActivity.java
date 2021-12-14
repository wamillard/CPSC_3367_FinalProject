package com.juarez_millard.finalproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.juarez_millard.finalproject.adapter.PantryListAdapter;
import com.juarez_millard.finalproject.databinding.ActivityMainBinding;
import com.juarez_millard.finalproject.db.entity.Pantry;
import com.juarez_millard.finalproject.viewmodel.PantryViewModel;
//import com.juarez_millard.finalproject.utility.DataManager;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private static final String PANTRY_LIST_FRAGMENT_TAG="com.juarez_millard.finalproject.PANTRY_LIST";
    private PantryViewModel mViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
//        dataManager.recreateAllFiles(this);
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mViewModel=new ViewModelProvider(this).get(PantryViewModel.class);
        mViewModel.setupDB();

        buildPantryListFragment();
    }

    private void buildPantryListFragment()
    {
        FragmentTransaction makeFragment=getSupportFragmentManager().beginTransaction();
        makeFragment.add(this.mBinding.fragmentsPlaceholder.getId(), new PantryFragment(),PANTRY_LIST_FRAGMENT_TAG);
        makeFragment.commit();
    }

}