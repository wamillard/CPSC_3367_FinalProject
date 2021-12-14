package com.juarez_millard.finalproject.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.juarez_millard.finalproject.db.PantryDatabase;
import com.juarez_millard.finalproject.db.entity.CategorizedFood;
import com.juarez_millard.finalproject.db.entity.Category;
import com.juarez_millard.finalproject.db.entity.Food;
import com.juarez_millard.finalproject.db.entity.Pantry;
import com.juarez_millard.finalproject.db.entity.PantryContents;

import org.chromium.base.task.AsyncTask;

import java.util.List;

public class PantryViewModel extends AndroidViewModel
{
	private PantryDatabase pantryDatabase;

	private LiveData<List<Pantry>> pantryList;
	private LiveData<List<Food>> foodList;
	private LiveData<List<Category>> categoryList;
	private LiveData<List<PantryContents>> pantryInv;
	private LiveData<List<CategorizedFood>> categorizedFood;

	public PantryViewModel(@NonNull Application application)
	{
		super(application);
	}

	public void setupDB()
	{
		pantryDatabase = PantryDatabase.getdbInstance(getApplication());
		pantryList = pantryDatabase.getPantryDao().pantryList();
		foodList = pantryDatabase.getFoodDao().foodList();
		categoryList = pantryDatabase.getCategoryDao().categoryList();
		pantryInv = pantryDatabase.getInventoryDao().inventoryList();
		categorizedFood = pantryDatabase.getFoodCatDao().allCategorizedList();

	}

	public void populateDB(List<Pantry> pList, List<Food> fList, List<Category> cList, List<PantryContents> pcList, List<CategorizedFood> cfList)
	{

		for (Integer i = 0; i < pList.size(); i++)
		{
			pantryDatabase.getPantryDao().insertNewPantry(pList.get(i));
		}

		for (Integer i = 0; i < fList.size(); i++)
		{
			pantryDatabase.getFoodDao().insertNewFood(fList.get(i));
		}

		for (Integer i = 0; i < cList.size(); i++)
		{
			pantryDatabase.getCategoryDao().insertNewCategory(cList.get(i));
		}

		for (Integer i = 0; i < pcList.size(); i++)
		{
			pantryDatabase.getInventoryDao().insertNewPantryContent(pcList.get(i));
		}

		for (Integer i = 0; i < cfList.size(); i++)
		{
			pantryDatabase.getFoodCatDao().insertNewFoodCat(fList.get(fList.indexOf(cfList.get(i).getfID())), cList.get(cList.indexOf(cfList.get(i).getcID())));
		}


	}

	public LiveData<List<Pantry>> getPantryList()
	{
		return this.pantryList;
	}

	public LiveData<List<Food>> getFoodList()
	{
		return this.foodList;
	}

	public LiveData<List<Category>> getCategoryList()
	{
		return this.categoryList;
	}

	public LiveData<List<PantryContents>> getPantryInv()
	{
		return this.pantryInv;
	}

	public LiveData<List<CategorizedFood>> getCategorizedFood()
	{
		return this.categorizedFood;
	}


}
