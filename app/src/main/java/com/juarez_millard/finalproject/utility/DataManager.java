package com.juarez_millard.finalproject.utility;

import android.content.Context;

import com.juarez_millard.finalproject.model.Food;
import com.juarez_millard.finalproject.model.FoodEntry;
import com.juarez_millard.finalproject.model.Pantry;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

		newPantry.append("0\n").append("Cabinet\n").append("Kitchen\n").append("1\n").append("0\n");
		newPantry.append("1\n").append("Fridge\n").append("Kitchen\n").append("0\n").append("0\n");

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
		Integer pID=0;
		String pName="";
		String pLocation="";
		Integer pCount=0;
		Integer pIcon=0;

		HashMap<Integer, Pantry> newPantry= new HashMap<>();

		BufferedReader pantryReader=getFile(ctx,"pantry");

		try
		{
			String nextLine= pantryReader.readLine();
			while (nextLine!=null)
			{
				pID=Integer.parseInt(nextLine);
				nextLine= pantryReader.readLine();
				pName=nextLine;
				nextLine= pantryReader.readLine();
				pLocation=nextLine;
				nextLine= pantryReader.readLine();
				pCount=Integer.parseInt(nextLine);
				nextLine= pantryReader.readLine();
				pIcon=Integer.parseInt(nextLine);
				nextLine=pantryReader.readLine();

				newPantry.put(pID,new Pantry(pID,pName,pLocation,pCount,pIcon));
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
		Integer fID=0;
		String fName="";
		String Uom="";
		ArrayList<Integer> fCategory=new ArrayList<>();

		HashMap<Integer, Food> newFood= new HashMap<>();

		BufferedReader foodReader=getFile(ctx,"food");

		try
		{
			String nextLine= foodReader.readLine();
			while (nextLine!=null)
			{
				fID=Integer.parseInt(nextLine);
				nextLine= foodReader.readLine();
				fName=nextLine;
				nextLine= foodReader.readLine();
				Uom=nextLine;
				nextLine= foodReader.readLine();
				while(!nextLine.equals(new String("/Cat")))
				{
					fCategory.add(Integer.parseInt(nextLine));
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

	public HashMap readFoodEntry(Context ctx,Integer currPantry)
	{
		Integer fID=0;
		Integer pID=0;
		Integer QTYStocked=0;
		Integer QTYpar=0;

		HashMap<Integer, FoodEntry> newFoodEntry= new HashMap<>();

		BufferedReader foodEntryReader=getFile(ctx,"foodEntry");

		try
		{
			String nextLine= foodEntryReader.readLine();
			while (nextLine!=null)
			{
				fID=Integer.parseInt(nextLine);
				nextLine= foodEntryReader.readLine();
				pID=Integer.parseInt(nextLine);
				nextLine= foodEntryReader.readLine();
				QTYStocked=Integer.parseInt(nextLine);
				nextLine= foodEntryReader.readLine();
				QTYpar=Integer.parseInt(nextLine);
				nextLine= foodEntryReader.readLine();

				if (pID==currPantry)
				{
					newFoodEntry.put(fID,new FoodEntry(fID,pID,QTYStocked,QTYpar));
				}
			}
			foodEntryReader.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		return newFoodEntry;
	}

	public HashMap getFoodDetails(Context ctx, HashMap foodEntries)
	{
		String fName="";
		String Uom="";
		ArrayList<Integer> fCategory=new ArrayList<>();

		BufferedReader foodReader=getFile(ctx,"food");

		ArrayList<Integer> foodList=new ArrayList<>();

		for(Object entry: foodEntries.entrySet())
		{
			FoodEntry newEntry= (FoodEntry) entry;
			foodList.add(newEntry.fID);
		}



		try
		{
			String nextLine= foodReader.readLine();
			while (nextLine!=null)
			{
				for (Integer i = 0; i < foodEntries.size(); i++)
				{
					while (Integer.parseInt(nextLine)!=foodList.get(i) || nextLine!=null || !nextLine.equals("/Cat"))
					{
						nextLine=foodReader.readLine();

					}
					nextLine = foodReader.readLine();
					fName = nextLine;
					nextLine = foodReader.readLine();
					Uom = nextLine;
					nextLine = foodReader.readLine();
					while (!nextLine.equals(new String("/Cat")))
					{
						fCategory.add(Integer.parseInt(nextLine));
						nextLine = foodReader.readLine();
					}


					nextLine = foodReader.readLine();
				}
			}
			foodReader.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
		return foodEntries;
	}


	public HashMap readCategories(Context ctx)
	{
		Integer cID=0;
		String cName="";

		HashMap<Integer,String> newCategory= new HashMap<>();

		BufferedReader categoryReader=getFile(ctx,"category");

		try
		{
			String nextLine= categoryReader.readLine();
			while (nextLine!=null)
			{
				cID=Integer.parseInt(nextLine);
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

	public void storePantry(Context ctx,HashMap<Integer,Pantry> pantryList)
	{
		ctx.deleteFile("pantry");

		StringBuilder newPantry=new StringBuilder();

		for(Integer i=0; i< pantryList.size(); i++)
		{
			newPantry.append(pantryList.get(i).getpID().toString()).append(pantryList.get(i).getpName());
			newPantry.append(pantryList.get(i).getpRoom()).append(pantryList.get(i).getpCount().toString()).append(pantryList.get(i).getpIcon().toString());
		}

		try (FileOutputStream fos = ctx.openFileOutput("pantry", Context.MODE_PRIVATE))
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

	public void storeFood(Context ctx,HashMap<Integer,Food> foodList)
	{
		ctx.deleteFile("food");

		StringBuilder newFood=new StringBuilder();

		for(Integer i=0; i< foodList.size(); i++)
		{
			newFood.append(foodList.get(i).getfID().toString()).append(foodList.get(i).getfName()).append(foodList.get(i).getUoM());

			ArrayList<Integer> categories=new ArrayList<> (foodList.get(i).getfCategories());

			for (Integer j=0; j<categories.size();j++)
			{
				newFood.append(categories.get(j).toString());
			}
		}

		try (FileOutputStream fos = ctx.openFileOutput("food", Context.MODE_PRIVATE))
		{
			fos.write(newFood.toString().getBytes(StandardCharsets.UTF_8));
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void storeFoodEntries(Context ctx, HashMap<Integer, FoodEntry> foodEntryList)
	{
		ctx.deleteFile("foodEntry");

		StringBuilder newPantry=new StringBuilder();

		for(Integer i=0; i< foodEntryList.size(); i++)
		{
			newPantry.append(foodEntryList.get(i).getfID().toString()).append(foodEntryList.get(i).getpID().toString());
			newPantry.append(foodEntryList.get(i).getQTYstocked().toString()).append(foodEntryList.get(i).getQTYpar().toString());
		}

		try (FileOutputStream fos = ctx.openFileOutput("foodEntry", Context.MODE_PRIVATE))
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

	public void storeCategories(Context ctx,HashMap<Integer,String> categoryList)
	{
		ctx.deleteFile("category");

		StringBuilder newPantry=new StringBuilder();

		for(Integer i=0; i< categoryList.size(); i++)
		{
			newPantry.append(i.toString()).append(categoryList.get(i));
		}

		try (FileOutputStream fos = ctx.openFileOutput("category", Context.MODE_PRIVATE))
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


}
