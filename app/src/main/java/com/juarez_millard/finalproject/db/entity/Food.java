package com.juarez_millard.finalproject.db.entity;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Food")
public class Food
{
	@PrimaryKey(autoGenerate = true)
	@NonNull
	public int fID;
	public String fName;
	public String UoM;

/*	@Ignore
	public Food()
	{
		this.fName="";
		this.UoM="";
	}

	public Food( String newfName, String newUoM)
	{
		this.fName=newfName;
		this.UoM=newUoM;
	}*/

	public int getfID()
	{
		return this.fID;
	}

	public String getfName()
	{
		return this.fName;
	}

	public String getUoM()
	{
		return this.UoM;
	}

	public void setfName(String newfName)
	{
		this.fName=newfName;
	}

	public void setUoM(String newUoM)
	{
		this.UoM=newUoM;
	}

}
