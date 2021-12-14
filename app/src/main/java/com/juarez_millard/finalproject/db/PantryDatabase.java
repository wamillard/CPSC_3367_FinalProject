package com.juarez_millard.finalproject.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.juarez_millard.finalproject.db.dao.CategoryDao;
import com.juarez_millard.finalproject.db.dao.FoodCatDao;
import com.juarez_millard.finalproject.db.dao.FoodDao;
import com.juarez_millard.finalproject.db.dao.InventoryDao;
import com.juarez_millard.finalproject.db.dao.PantryDao;
import com.juarez_millard.finalproject.db.entity.CategorizedFood;
import com.juarez_millard.finalproject.db.entity.Category;
import com.juarez_millard.finalproject.db.entity.Food;
import com.juarez_millard.finalproject.db.entity.Pantry;
import com.juarez_millard.finalproject.db.entity.PantryContents;

@Database(entities = {Pantry.class, Food.class, PantryContents.class, CategorizedFood.class, Category.class}, version = 1)
public abstract class PantryDatabase extends RoomDatabase
{
	abstract public PantryDao getPantryDao();
	abstract public FoodDao getFoodDao();
	abstract public CategoryDao getCategoryDao();
	abstract public FoodCatDao getFoodCatDao();
	abstract public InventoryDao getInventoryDao();

	private static PantryDatabase dbInstance;

	public static PantryDatabase getdbInstance(Context ctx)
	{
		if(dbInstance==null)
		{
			dbInstance= Room.databaseBuilder(ctx.getApplicationContext(),PantryDatabase.class,"pantryDatabase").build();
		}
		return dbInstance;
	}

	public static void destroydbInstance()
	{
		dbInstance=null;
	}
}
