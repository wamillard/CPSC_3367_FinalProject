package com.juarez_millard.finalproject.utility;

import android.content.Context;

import com.juarez_millard.finalproject.db.entity.CategorizedFood;
import com.juarez_millard.finalproject.db.entity.Category;
import com.juarez_millard.finalproject.db.entity.Food;
import com.juarez_millard.finalproject.db.entity.Pantry;
import com.juarez_millard.finalproject.db.entity.PantryContents;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class DataManager
{

	public DataManager()
	{

	}


	public void deleteoldFiles(Context ctx)
	{

		ctx.deleteFile("Pantry");
		ctx.deleteFile("Food");
	}

	public List<Pantry> editSamplePantry()
	{

		List<Pantry> pList = new ArrayList<>();

		Pantry pantry1 = new Pantry();
		Pantry pantry2 = new Pantry();
		Pantry pantry3 = new Pantry();
		Pantry pantry4 = new Pantry();

		pantry1.setpName("Cabinet");
		pantry1.setpRoom("Kitchen");
		pantry1.setpCount(3);
		pantry1.setpIcon(0);
		pList.add(pantry1);

		pantry2.setpName("Fridge");
		pantry2.setpRoom("Kitchen");
		pantry2.setpCount(2);
		pantry2.setpIcon(1);
		pList.add(pantry2);

		pantry3.setpName("Shelf");
		pantry3.setpRoom("Laundry Room");
		pantry3.setpCount(2);
		pantry3.setpIcon(0);
		pList.add(pantry3);

		pantry4.setpName("Fridge");
		pantry4.setpRoom("Garage");
		pantry4.setpCount(2);
		pantry4.setpIcon(1);
		pList.add(pantry4);

		return pList;


	}

	public List<Food> editSampleFood()
	{
		List<Food> fList=new ArrayList<>();
		
		Food food1=new Food();
		Food food2=new Food();
		Food food3=new Food();
		Food food4=new Food();
		Food food5=new Food();
		
		
		food1.setfName("Coke Zero");
		food1.setUoM("ea");
		
		food2.setfName("Bananas");
		food2.setUoM("ea");

		food3.setfName("Hugs");
		food3.setUoM("bg");

		food4.setfName("Ramen");
		food4.setUoM("pk");

		food5.setfName("Milk, Whole");
		food5.setUoM("gal");


		fList.add(food1);
		fList.add(food2);
		fList.add(food3);
		fList.add(food4);
		fList.add(food5);
		
		return fList;
	}

	public List<PantryContents> editSampleFoodEntry()
	{
		List<PantryContents> pcList=new ArrayList<>();
		
		PantryContents pc1=new PantryContents();
		PantryContents pc2=new PantryContents();
		PantryContents pc3=new PantryContents();
		PantryContents pc4=new PantryContents();
		PantryContents pc5=new PantryContents();
		PantryContents pc6=new PantryContents();
		PantryContents pc7=new PantryContents();
		PantryContents pc8=new PantryContents();
		PantryContents pc9=new PantryContents();
		
		pc1.setfID(0);
		pc1.setpID(1);
		pc1.setQTYstocked(3);
		pc1.setQTYpar(12);

		pc2.setfID(0);
		pc2.setpID(3);
		pc2.setQTYstocked(24);
		pc2.setQTYpar(36);

		pc3.setfID(1);
		pc3.setpID(0);
		pc3.setQTYstocked(2);
		pc3.setQTYpar(7);

		pc4.setfID(2);
		pc4.setpID(0);
		pc4.setQTYstocked(1);
		pc4.setQTYpar(6);

		pc5.setfID(2);
		pc5.setpID(2);
		pc5.setQTYstocked(4);
		pc5.setQTYpar(4);

		pc6.setfID(3);
		pc6.setpID(0);
		pc6.setQTYstocked(1);
		pc6.setQTYpar(5);

		pc7.setfID(3);
		pc7.setpID(2);
		pc7.setQTYstocked(8);
		pc7.setQTYpar(12);

		pc8.setfID(4);
		pc8.setpID(1);
		pc8.setQTYstocked(1);
		pc8.setQTYpar(1);

		pc9.setfID(4);
		pc9.setpID(3);
		pc9.setQTYstocked(8);
		pc9.setQTYpar(2);

		pcList.add(pc1);
		pcList.add(pc2);
		pcList.add(pc3);
		pcList.add(pc4);
		pcList.add(pc5);
		pcList.add(pc6);
		pcList.add(pc7);
		pcList.add(pc8);
		pcList.add(pc9);


		
		return pcList;
	}

	public List<Category> editSampleCategory()
	{
		List<Category> cList=new ArrayList<>();

		Category c1=new Category();
		Category c2=new Category();
		Category c3=new Category();
		Category c4=new Category();
		Category c5=new Category();
		Category c6=new Category();
		Category c7=new Category();

		c1.setcID(0);
		c1.setcName("Drink");

		c2.setcID(1);
		c2.setcName("Sugar-Free");

		c3.setcID(2);
		c3.setcName("Candy");

		c4.setcID(3);
		c4.setcName("Pasta");

		c5.setcID(4);
		c5.setcName("Instant");

		c6.setcID(5);
		c6.setcName("Fruit");

		c7.setcID(6);
		c7.setcName("Health");

		cList.add(c1);
		cList.add(c2);
		cList.add(c3);
		cList.add(c4);
		cList.add(c5);
		cList.add(c6);
		cList.add(c7);


			return cList;

	}

	public List<CategorizedFood> editSampleFoodCategory()
	{
		List<CategorizedFood> cfList=new ArrayList<>();

			CategorizedFood cf1=new CategorizedFood();
		CategorizedFood cf2=new CategorizedFood();
		CategorizedFood cf3=new CategorizedFood();
		CategorizedFood cf4=new CategorizedFood();
		CategorizedFood cf5=new CategorizedFood();
		CategorizedFood cf6=new CategorizedFood();
		CategorizedFood cf7=new CategorizedFood();
		CategorizedFood cf8=new CategorizedFood();
		CategorizedFood cf9=new CategorizedFood();

		cf1.setcID(0);
		cf1.setfID(0);

		cf1.setcID(4);
		cf1.setfID(0);

		cf1.setcID(0);
		cf1.setfID(1);

		cf1.setcID(2);
		cf1.setfID(2);

		cf1.setcID(3);
		cf1.setfID(3);

		cf1.setcID(3);
		cf1.setfID(4);

		cf1.setcID(1);
		cf1.setfID(5);

		cf1.setcID(1);
		cf1.setfID(6);

		cf1.setcID(4);
		cf1.setfID(6);

	cfList.add(cf1);
		cfList.add(cf2);
		cfList.add(cf3);
		cfList.add(cf4);
		cfList.add(cf5);
		cfList.add(cf6);
		cfList.add(cf7);
		cfList.add(cf8);
		cfList.add(cf9);


		return cfList;
	}
}

