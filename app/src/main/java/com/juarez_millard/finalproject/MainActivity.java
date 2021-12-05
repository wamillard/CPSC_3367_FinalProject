package com.juarez_millard.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;

import com.juarez_millard.finalproject.Model.Food;
import com.juarez_millard.finalproject.Model.FoodEntry;
import com.juarez_millard.finalproject.Model.Pantry;
import com.juarez_millard.finalproject.Utility.XmlParser;
import com.juarez_millard.finalproject.databinding.ActivityMainBinding;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    public HashMap pantryList;    // (pID, Pantry)
//    public HashMap<Integer, Food> foodList;       // (fID, Food)
//    public HashMap<Integer, FoodEntry> inventory; // (fID, FoodEntry)
//    public HashMap<Integer, String> categoryList;  // (cID, cName)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

//        this.deleteFile("pantrydata");

        String filename="pantrydata";


/*
        String contents="\nStupid second line";
        try (FileOutputStream fos=this.openFileOutput(filename, Context.MODE_APPEND))
        {
            fos.write(contents.getBytes("UTF-8"));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
*/


        StringBuilder readFile=new StringBuilder();

        try
        {
            InputStreamReader isr=new InputStreamReader(this.openFileInput("pantrydata"),StandardCharsets.UTF_8);
            BufferedReader br=new BufferedReader(isr);
            String nextLine=br.readLine();
            while (nextLine!=null)
            {
                readFile.append(nextLine).append('\n');
                nextLine=br.readLine();
            }
            Integer pause=0;
        }
        catch (IOException e){};



/*        XmlParser pantryParse= new XmlParser();
        try
        {
            InputStreamReader isr=new InputStreamReader(this.openFileInput("pantrydata"),StandardCharsets.UTF_8);
//           FileInputStream dataIn= this.openFileInput("pantrydata");
           pantryList=pantryParse.parse(isr,"Pantry");

        } catch (Exception e) {e.printStackTrace();}*/




    }



}