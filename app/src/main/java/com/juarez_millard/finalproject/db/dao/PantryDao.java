package com.juarez_millard.finalproject.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.juarez_millard.finalproject.db.entity.Pantry;

import java.util.List;

import static androidx.room.OnConflictStrategy.IGNORE;

@Dao
public interface PantryDao
{
	@Insert(onConflict= IGNORE)
	 void insertNewPantry(Pantry pantry);

	@Insert(onConflict = IGNORE)
	void insertPantries(Pantry... pantries);

	@Update(onConflict = IGNORE)
	 void updatePantry(Pantry pantry);

	@Delete
	 void deletePantry(Pantry pantry);

	@Query("Select * from Pantry")
	 LiveData<List<Pantry>> pantryList();
}
