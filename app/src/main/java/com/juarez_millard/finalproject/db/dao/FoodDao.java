package com.juarez_millard.finalproject.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.juarez_millard.finalproject.db.entity.Food;

import java.util.List;

@Dao
public interface FoodDao
{
	@Insert(onConflict= OnConflictStrategy.REPLACE)
	public void insertNewFood(Food food);

	@Update(onConflict = OnConflictStrategy.REPLACE)
	public void updateFood(Food food);

	@Delete
	public void deleteFood(Food food);

	@Query("Select * from Food")
	public LiveData<List<Food>> foodList();

}
