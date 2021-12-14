package com.juarez_millard.finalproject.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.juarez_millard.finalproject.db.entity.PantryContents;

import java.util.List;

@Dao
public interface InventoryDao
{
	@Insert(onConflict = OnConflictStrategy.REPLACE)
	public void insertNewPantryContent(PantryContents newPC);

	@Update(onConflict = OnConflictStrategy.REPLACE)
	public void updatePantryContent(PantryContents inventoryChange);

	@Delete
	public void deleteInventoryEntry(PantryContents removeStock);

	@Query("Select * from inventory")
	public LiveData<List<PantryContents>> inventoryList();

}
