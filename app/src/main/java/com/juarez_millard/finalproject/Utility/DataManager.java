package com.juarez_millard.finalproject.Utility;

import android.content.Context;

import com.juarez_millard.finalproject.Model.Food;
import com.juarez_millard.finalproject.Model.FoodEntry;
import com.juarez_millard.finalproject.Model.Pantry;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

public class DataManager
{

	public DataManager()
	{

	}



	public void deleteAllfiles(Context ctx)
	{
		ctx.deleteFile("pantry");
		ctx.deleteFile("food");
		ctx.deleteFile("foodEntry");
		ctx.deleteFile("category");
	}

	public void recreateSampleFiles(Context ctx)
	{
		ctx.deleteFile("pantry");

		StringBuilder newPantry=new StringBuilder();

		newPantry.append("0\n").append("Cabinet\n").append("Kitchen\n").append("1\n");
		newPantry.append("1\n").append("Fridge\n").append("Kitchen\n").append("0\n");

		try (FileOutputStream fos = ctx.openFileOutput("pantry", Context.MODE_APPEND))
		{
			fos.write(newPantry.toString().getBytes(StandardCharsets.UTF_8));
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}


	}

	private BufferedReader getFile(Context ctx,String fileName)
	{
		try
		{
			InputStreamReader isr=new InputStreamReader(ctx.openFileInput(fileName), StandardCharsets.UTF_8);
			return new BufferedReader(isr);

		}
		catch (FileNotFoundException e )
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		} ;

		return null;
	}

	public HashMap readPantry(Context ctx)
	{
		String pID="";
		String pName="";
		String pLocation="";
		String pCount="";

		HashMap<String, Pantry> newPantry= new HashMap<>();

		BufferedReader pantryReader=getFile(ctx,"pantry");

		try
		{
			String nextLine= pantryReader.readLine();
			while (nextLine!=null)
			{
				pID=nextLine;
				nextLine= pantryReader.readLine();
				pName=nextLine;
				nextLine= pantryReader.readLine();
				pLocation=nextLine;
				nextLine= pantryReader.readLine();
				pCount=nextLine;
				nextLine= pantryReader.readLine();

				newPantry.put(pID,new Pantry(pID,pName,pLocation,pCount));
			}

			pantryReader.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		return newPantry;
	}

	public HashMap readFood(Context ctx)
	{
		String fID="";
		String fName="";
		String Uom="";
		ArrayList<String> fCategory=new ArrayList<>();

		HashMap<String, Food> newFood= new HashMap<>();

		BufferedReader foodReader=getFile(ctx,"food");

		try
		{
			String nextLine= foodReader.readLine();
			while (nextLine!=null)
			{
				fID=nextLine;
				nextLine= foodReader.readLine();
				fName=nextLine;
				nextLine= foodReader.readLine();
				Uom=nextLine;
				nextLine= foodReader.readLine();
				while(!nextLine.equals(new String("/Cat")))
				{
					fCategory.add(nextLine);
					nextLine= foodReader.readLine();
				}

				newFood.put(fID,new Food(fID,fName,Uom,fCategory));
				nextLine= foodReader.readLine();
			}
			foodReader.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}


		return newFood;
	}

	public HashMap readFoodEntry(Context ctx)
	{
		String fID="";
		String pID="";
		String QTYStocked="";
		String QTYpar="";

		HashMap<String, FoodEntry> newFoodEntry= new HashMap<>();

		BufferedReader foodEntryReader=getFile(ctx,"foodEntry");

		try
		{
			String nextLine= foodEntryReader.readLine();
			while (nextLine!=null)
			{
				fID=nextLine;
				nextLine= foodEntryReader.readLine();
				pID=nextLine;
				nextLine= foodEntryReader.readLine();
				QTYStocked=nextLine;
				nextLine= foodEntryReader.readLine();
				QTYpar=nextLine;
				nextLine= foodEntryReader.readLine();

				newFoodEntry.put(fID,new FoodEntry(fID,pID,QTYStocked,QTYpar));
			}
			foodEntryReader.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		return newFoodEntry;
	}

	public HashMap readCategories(Context ctx)
	{
		String cID="";
		String cName="";

		HashMap<String,String> newCategory= new HashMap<>();

		BufferedReader categoryReader=getFile(ctx,"category");

		try
		{
			String nextLine= categoryReader.readLine();
			while (nextLine!=null)
			{
				cID=nextLine;
				nextLine= categoryReader.readLine();
				cName=nextLine;
				nextLine= categoryReader.readLine();

				newCategory.put(cID,cName);
			}
			categoryReader.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		return newCategory;
	}

}
