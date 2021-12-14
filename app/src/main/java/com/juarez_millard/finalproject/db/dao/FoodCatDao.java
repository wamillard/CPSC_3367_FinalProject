package com.juarez_millard.finalproject.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.juarez_millard.finalproject.db.entity.CategorizedFood;
import com.juarez_millard.finalproject.db.entity.Food;
import com.juarez_millard.finalproject.db.entity.Category;

import java.util.List;

@Dao
public interface FoodCatDao
{
	@Insert(onConflict = OnConflictStrategy.REPLACE)
	public void insertNewFoodCat(Food food,Category category);

	@Delete
	public void deleteFoodCat(Food food, Category category);

	@Query("Select * from categories")
	public LiveData<List<CategorizedFood>> allCategorizedList();



}
