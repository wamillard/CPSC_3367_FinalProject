package com.juarez_millard.finalproject.db.entity;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Pantry")
public class Pantry
{
	@PrimaryKey(autoGenerate = true)
	@NonNull
	public int pID;
	public String pName;
	public String pRoom;
	public Integer pCount;
	public Integer pIcon;

/*	@Ignore
	public Pantry()
	{
		this.pName = "";
		this.pRoom = "";
		this.pCount = 0;
		this.pIcon = 0;
	}

	public Pantry( String newpName, String newpLocation, int newpCount, int newpIcon)
	{
		this.pName = newpName;
		this.pRoom = newpLocation;
		this.pCount = newpCount;
		this.pIcon = newpIcon;
	}*/

	public int getpID()
	{
		return this.pID;
	}

	public String getpName()
	{
		return this.pName;
	}

	public String getpRoom()
	{
		return this.pRoom;
	}

	public Integer getpCount()
	{
		return this.pCount;
	}

	public Integer getpIcon()
	{
		return this.pIcon;
	}

	public void setpID(int newpID)
	{
		this.pID = newpID;
	}

	public void setpName(String newpName)
	{
		this.pName = newpName;
	}

	public void setpRoom(String newpLocation)
	{
		this.pRoom = newpLocation;
	}

	public void setpCount(int newpCount)
	{
		this.pCount = newpCount;
	}

	public void setpIcon(int newpIcon)
	{
		this.pIcon = newpIcon;
	}
}
