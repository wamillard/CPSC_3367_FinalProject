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


public class DataManager
{

	public DataManager()
	{

	}


	public void recreateAllfiles(Context ctx)
	{
		this.editSamplePantry(ctx, true);
		this.editSampleFood(ctx, true);
		this.editSampleFoodEntry(ctx, true);
		this.editSampleCategory(ctx, true);
		this.editSampleFoodCategory(ctx, true);
	}

	public void editSamplePantry(Context ctx, Boolean deleteThis)
	{
		StringBuilder newPantry = new StringBuilder();
		Integer fileAccess = 0;

		if (deleteThis)
		{
			ctx.deleteFile("pantry");

			newPantry.append("0\n").append("Cabinet\n").append("Kitchen\n").append("3\n").append("0\n");
			newPantry.append("1\n").append("Fridge\n").append("Kitchen\n").append("2\n").append("1\n");
			newPantry.append("2\n").append("Shelf\n").append("Laundry Room\n").append("2\n").append("0\n");
			newPantry.append("3\n").append("Fridge\n").append("Garage\n").append("2\n").append("1\n");
			fileAccess = Context.MODE_PRIVATE;
		} else
		{
			newPantry.append("4\n").append("Fridge\n").append("Garage\n").append("0\n").append("1\n");
			fileAccess = Context.MODE_APPEND;
		}

		try (FileOutputStream fos = ctx.openFileOutput("pantry", fileAccess))
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

	public void editSampleFood(Context ctx, Boolean deleteThis)
	{
		StringBuilder newFood = new StringBuilder();
		Integer fileAccess = 0;

		if (deleteThis)
		{
			newFood.append("0\n").append("Coke Zero\n").append("ea\n");
			newFood.append("1\n").append("Bananas\n").append("ea\n");
			newFood.append("2\n").append("Hugs\n").append("bg\n");
			newFood.append("3\n").append("Ramen\n").append("pk\n");
			newFood.append("4\n").append("Milk, Whole\n").append("gal\n");

			fileAccess = Context.MODE_PRIVATE;
		} else
		{
			newFood.append("5\n").append("Milk, 2%\n").append("gal\n");

			fileAccess = Context.MODE_APPEND;
		}

		try (FileOutputStream fos = ctx.openFileOutput("food", fileAccess))
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

	public void editSampleFoodEntry(Context ctx, Boolean deleteThis)
	{
		StringBuilder newFoodEntry = new StringBuilder();
		Integer fileAccess = 0;

		if (deleteThis)
		{
			ctx.deleteFile("foodEntry");

			newFoodEntry.append("0\n").append("1\n").append("3\n").append("12\n");
			newFoodEntry.append("0\n").append("3\n").append("24\n").append("36\n");
			newFoodEntry.append("1\n").append("0\n").append("2\n").append("7\n");
			newFoodEntry.append("2\n").append("0\n").append("1\n").append("6\n");
			newFoodEntry.append("2\n").append("2\n").append("4\n").append("4\n");
			newFoodEntry.append("3\n").append("0\n").append("1\n").append("5\n");
			newFoodEntry.append("3\n").append("2\n").append("8\n").append("12\n");
			newFoodEntry.append("4\n").append("1\n").append("1\n").append("1\n");
			newFoodEntry.append("4\n").append("3\n").append("2\n").append("2\n");

			fileAccess = Context.MODE_PRIVATE;
		} else
		{
			newFoodEntry.append("4\n").append("3\n").append("2\n").append("2\n");

			fileAccess = Context.MODE_APPEND;
		}

		try (FileOutputStream fos = ctx.openFileOutput("foodEntry", fileAccess))
		{
			fos.write(newFoodEntry.toString().getBytes(StandardCharsets.UTF_8));
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void editSampleCategory(Context ctx, Boolean deleteThis)
	{
		StringBuilder newFoodEntry = new StringBuilder();
		Integer fileAccess = 0;

		if (deleteThis)
		{
			ctx.deleteFile("category");

			newFoodEntry.append("0\n").append("Drink\n");
			newFoodEntry.append("1\n").append("Sugar-Free\n");
			newFoodEntry.append("2\n").append("Candy\n");
			newFoodEntry.append("3\n").append("Pasta\n");
			newFoodEntry.append("4\n").append("Instant\n");
			newFoodEntry.append("5\n").append("Fruit\n");
			newFoodEntry.append("6\n").append("Health\n");

			fileAccess = Context.MODE_PRIVATE;
		} else
		{
			newFoodEntry.append("7\n").append("Snack\n");

			fileAccess = Context.MODE_APPEND;
		}

		try (FileOutputStream fos = ctx.openFileOutput("category", fileAccess))
		{
			fos.write(newFoodEntry.toString().getBytes(StandardCharsets.UTF_8));
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}


	}

	public void editSampleFoodCategory(Context ctx, Boolean deleteThis)
	{
		StringBuilder newFoodEntry = new StringBuilder();
		Integer fileAccess = 0;

		if (deleteThis)
		{
			ctx.deleteFile("categorizedFood");

			newFoodEntry.append("0\n").append("0\n");
			newFoodEntry.append("4\n").append("0\n");
			newFoodEntry.append("0\n").append("1\n");
			newFoodEntry.append("2\n").append("2\n");
			newFoodEntry.append("3\n").append("3\n");
			newFoodEntry.append("3\n").append("4\n");
			newFoodEntry.append("1\n").append("5\n");
			newFoodEntry.append("1\n").append("6\n");
			newFoodEntry.append("4\n").append("6\n");

			fileAccess = Context.MODE_PRIVATE;
		} else
		{
			newFoodEntry.append("4\n").append("3\n").append("2\n").append("2\n");

			fileAccess = Context.MODE_APPEND;
		}

		try (FileOutputStream fos = ctx.openFileOutput("categorizedFood", fileAccess))
		{
			fos.write(newFoodEntry.toString().getBytes(StandardCharsets.UTF_8));
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	private BufferedReader getFile(Context ctx, String fileName)
	{
		try
		{
			InputStreamReader isr = new InputStreamReader(ctx.openFileInput(fileName), StandardCharsets.UTF_8);
			return new BufferedReader(isr);

		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		;

		return null;
	}

	public HashMap readPantry(Context ctx)
	{
		Integer pID = 0;
		String pName = "";
		String pLocation = "";
		Integer pCount = 0;
		Integer pIcon = 0;

		HashMap<Integer, Pantry> newPantry = new HashMap<>();

		BufferedReader pantryReader = getFile(ctx, "pantry");

		try
		{
			String nextLine = pantryReader.readLine();
			while (nextLine != null)
			{
				pID = Integer.parseInt(nextLine);
				nextLine = pantryReader.readLine();
				pName = nextLine;
				nextLine = pantryReader.readLine();
				pLocation = nextLine;
				nextLine = pantryReader.readLine();
				pCount = Integer.parseInt(nextLine);
				nextLine = pantryReader.readLine();
				pIcon = Integer.parseInt(nextLine);
				nextLine = pantryReader.readLine();

				newPantry.put(pID, new Pantry(pID, pName, pLocation, pCount, pIcon));
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
		Integer fID = 0;
		String fName = "";
		String Uom = "";
		ArrayList<Integer> fCategory = new ArrayList<>();

		HashMap<Integer, Food> newFood = new HashMap<>();

		BufferedReader foodReader = getFile(ctx, "food");

		try
		{
			String nextLine = foodReader.readLine();
			while (nextLine != null)
			{
				fID = Integer.parseInt(nextLine);
				nextLine = foodReader.readLine();
				fName = nextLine;
				nextLine = foodReader.readLine();
				Uom = nextLine;

/*				while(!nextLine.equals(new String("/Cat")))
				{
					fCategory.add(Integer.parseInt(nextLine));
					nextLine= foodReader.readLine();
				}
*/
				newFood.put(fID, new Food(fID, fName, Uom, fCategory));
				nextLine = foodReader.readLine();
			}
			foodReader.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}


		return newFood;
	}

	public HashMap readFoodEntry(Context ctx, Integer currPantry)
	{
		Integer fID = 0;
		Integer pID = 0;
		Integer QTYstocked = 0;
		Integer QTYpar = 0;

		HashMap<Integer, FoodEntry> newFoodEntry = new HashMap<>();

		BufferedReader foodEntryReader = getFile(ctx, "foodEntry");

		try
		{
			String nextLine = foodEntryReader.readLine();
			while (nextLine != null)
			{
				fID = Integer.parseInt(nextLine);
				nextLine = foodEntryReader.readLine();
				pID = Integer.parseInt(nextLine);
				nextLine = foodEntryReader.readLine();
				QTYstocked = Integer.parseInt(nextLine);
				nextLine = foodEntryReader.readLine();
				QTYpar = Integer.parseInt(nextLine);
				nextLine = foodEntryReader.readLine();

				if (pID == currPantry)
				{
					newFoodEntry.put(newFoodEntry.size(), new FoodEntry(fID, pID, QTYstocked, QTYpar));
				}
			}
			foodEntryReader.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		return newFoodEntry;
	}

	public HashMap getFoodDetails(Context ctx, HashMap<Integer, FoodEntry> inventory)
	{
		Integer fID = 0;
		String fName = "";
		String Uom = "";
		ArrayList<Integer> fCategory = new ArrayList<>();

		BufferedReader foodReader = getFile(ctx, "food");
		ArrayList<Integer> idList= new ArrayList<>();

		for (Integer i=0;i< inventory.size();i++)
		{
			idList.add(inventory.get(i).getfID());
		}

		try
		{
			String nextLine = foodReader.readLine();
			Integer iFood = 0;
			Integer currEntry=0;
			while (nextLine != null)
			{
				fID = Integer.parseInt(nextLine);
				nextLine = foodReader.readLine();
				fName = nextLine;
				nextLine = foodReader.readLine();
				Uom = nextLine;

				if (idList.indexOf(fID)>=0)
				{
					inventory.get(currEntry).setfName(fName);
					inventory.get(currEntry).setUoM(Uom);
					inventory.get(currEntry).setfCategories(fCategory);
					currEntry++;
				}

				nextLine = foodReader.readLine();

				iFood++;
			}
			foodReader.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}


		return inventory;
	}

	public HashMap getCategoryDetails(Context ctx, HashMap<Integer,FoodEntry> inventory)
	{



		return inventory;
	}

	public HashMap readCategories(Context ctx)
	{
		Integer cID = 0;
		String cName = "";

		HashMap<Integer, String> newCategory = new HashMap<>();

		BufferedReader categoryReader = getFile(ctx, "category");

		try
		{
			String nextLine = categoryReader.readLine();
			while (nextLine != null)
			{
				cID = Integer.parseInt(nextLine);
				nextLine = categoryReader.readLine();
				cName = nextLine;
				nextLine = categoryReader.readLine();

				newCategory.put(cID, cName);
			}
			categoryReader.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		return newCategory;
	}

	public void storePantry(Context ctx, HashMap<Integer, Pantry> pantryList)
	{
		ctx.deleteFile("pantry");

		StringBuilder newPantry = new StringBuilder();

		for (Integer i = 0; i < pantryList.size(); i++)
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

	public void storeFood(Context ctx, HashMap<Integer, Food> foodList)
	{
		ctx.deleteFile("food");

		StringBuilder newFood = new StringBuilder();

		for (Integer i = 0; i < foodList.size(); i++)
		{
			newFood.append(foodList.get(i).getfID().toString()).append(foodList.get(i).getfName()).append(foodList.get(i).getUoM());

			ArrayList<Integer> categories = new ArrayList<>(foodList.get(i).getfCategories());

			for (Integer j = 0; j < categories.size(); j++)
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

		StringBuilder newPantry = new StringBuilder();

		for (Integer i = 0; i < foodEntryList.size(); i++)
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

	public void storeCategories(Context ctx, HashMap<Integer, String> categoryList)
	{
		ctx.deleteFile("category");

		StringBuilder newPantry = new StringBuilder();

		for (Integer i = 0; i < categoryList.size(); i++)
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
