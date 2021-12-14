package com.juarez_millard.finalproject.db.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Category")
public class Category
{
	@PrimaryKey(autoGenerate = true)
	@NonNull
	public int cID;
	public String cName;

/*	@Ignore
	public Category()
	{
		this.cID=0;
		this.cName="";
	}

	public Category(String newcName)
	{
		this.cName=newcName;
	}*/

	public int getcID()
	{
		return this.cID;
	}

	public String getcName()
	{
		return this.cName;
	}

	public void setcID(int newcID)
	{
		this.cID=newcID;
	}

	public void setcName(String newcName)
	{
		this.cName=newcName;
	}


}
