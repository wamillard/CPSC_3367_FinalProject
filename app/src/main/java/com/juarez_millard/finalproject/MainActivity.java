package com.juarez_millard.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

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
//    public HashMap<Integer, Food> foodList;       // (fID, Food)
//    public HashMap<Integer, FoodEntry> inventory; // (fID, FoodEntry)
//    public HashMap<Integer, String> categoryList;  // (cID, cName)


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());




/*        try (FileOutputStream fos = this.openFileOutput(filename, Context.MODE_APPEND))
        {
            fos.write(contents1.getBytes(StandardCharsets.UTF_8));
            fos.write(lineSeperator);
            fos.write(contents2.getBytes(StandardCharsets.UTF_8));
            fos.write(lineSeperator);
        } catch (IOException e)
        {
            e.printStackTrace();
        }*/


        DataManager dm=new DataManager();
        dm.recreateSampleFiles(this);
        pantryList=dm.readPantry(this);

        Integer p=0;



    }

}