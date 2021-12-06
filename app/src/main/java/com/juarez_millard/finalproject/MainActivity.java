package com.juarez_millard.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.juarez_millard.finalproject.Model.Food;
import com.juarez_millard.finalproject.Model.FoodEntry;
import com.juarez_millard.finalproject.Utility.DataManager;
import com.juarez_millard.finalproject.databinding.ActivityMainBinding;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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




        DataManager dm=new DataManager();
//        dm.recreateSampleFiles(this);
        pantryList=dm.readPantry(this);
        foodList=dm.readFood(this);
        inventory=dm.readFoodEntry(this);
        categoryList=dm.readCategories(this);

        Integer p=0;



    }

}