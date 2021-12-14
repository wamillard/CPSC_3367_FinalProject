package com.juarez_millard.finalproject.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.juarez_millard.finalproject.db.entity.Category;

import java.util.List;

@Dao
public interface CategoryDao
{
	@Insert(onConflict= OnConflictStrategy.REPLACE)
	public void insertNewCategory(Category newCat);

	@Update(onConflict = OnConflictStrategy.REPLACE)
	public void updateCategory(Category cat);

	@Delete
	public void deleteCategory(Category cat);

	@Query("Select * from Category")
	public LiveData<List<Category>> categoryList();

}
