package com.juarez_millard.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.juarez_millard.finalproject.adapter.PantryAdapter;
import com.juarez_millard.finalproject.databinding.ActivityMainBinding;
import com.juarez_millard.finalproject.model.Pantry;
import com.juarez_millard.finalproject.utility.DataManager;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private DataManager dataManager;

    public HashMap pantryList;    // (pID, Pantry)
    public HashMap foodList;       // (fID, Food)
    public HashMap inventory; // (fID, FoodEntry)
    public HashMap categoryList;  // (cID, cName)


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());




        DataManager dataManager=new DataManager();

//        dataManager.recreateAllfiles(this);


        pantryList=dataManager.readPantry(this);

        foodList=dataManager.readFood(this);
        categoryList=dataManager.readCategories(this);


        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this);
        PantryAdapter mAdapter=new PantryAdapter(this,pantryList);
        mAdapter.setOnPantryClickListener(new PantryAdapter.OnPantryClickListener()
        {
            @Override
            public void onPantryClick(View view, Pantry pantry, Integer position)
            {
                Intent openPantry=new Intent(MainActivity.this,PantryActivity.class);
                openPantry.putExtra("Pantry", pantry);
                startActivity(openPantry);
            }

        });

        RecyclerView mainRecyclerView= this.mBinding.recyclerView;
        mainRecyclerView.setLayoutManager(layoutManager);
        mainRecyclerView.setAdapter(mAdapter);




    }

}