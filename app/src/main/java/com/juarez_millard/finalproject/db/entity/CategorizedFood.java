package com.juarez_millard.finalproject.db.entity;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;

@Entity(tableName="categories",
		primaryKeys = {"cID","fID"},
		foreignKeys = {@ForeignKey(entity = Category.class,parentColumns = "cID",childColumns = "cID", onDelete = CASCADE),
					@ForeignKey(entity=Food.class,parentColumns = "fID",childColumns = "fID", onDelete = CASCADE)})
public class CategorizedFood
{
	public int cID;
	public int fID;

/*	@Ignore
	public CategorizedFood()
	{
		this.cID=0;
		this.fID=0;
	}

	public CategorizedFood(int newcID, int newfID)
	{
		this.cID=newcID;
		this.fID=newfID;
	}*/

	public int getcID()
	{
		return this.cID;
	}

	public int getfID()
	{
		return this.fID;
	}

	public void setcID(int newcID)
	{
		this.cID=newcID;
	}

	public void setfID(int newfID)
	{
		this.fID=newfID;
	}


}
