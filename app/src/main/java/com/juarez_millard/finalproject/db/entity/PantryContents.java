package com.juarez_millard.finalproject.db.entity;


import static androidx.room.ForeignKey.CASCADE;

import androidx.room.Entity;
import androidx.room.ForeignKey;


@Entity(tableName ="inventory",
		primaryKeys = {"fID","pID"},
		foreignKeys = {@ForeignKey(entity=Food.class,parentColumns = "fID",childColumns = "fID", onDelete = CASCADE),
						@ForeignKey(entity=Pantry.class,parentColumns = "pID",childColumns = "pID", onDelete = CASCADE)})
public class PantryContents
{
	public int fID;
	public int pID;
	public int QTYstocked;
	public int QTYpar;


/*	public PantryContents()
	{
		this.fID=0;
		this.pID=0;
		this.QTYstocked=0;
		this.QTYpar=0;
	}

	public PantryContents(int newfID, int newpID, int newQTYStocked, int newQTYpar)
	{
		this.fID=newfID;
		this.pID=newpID;
		this.QTYstocked=newQTYStocked;
		this.QTYpar=newQTYpar;
	}*/

	public int getfID()
	{
		return this.fID;
	}

	public int getpID()
	{
		return this.pID;
	}

	public int getQTYstocked()
	{
		return this.QTYstocked;
	}

	public int getQTYpar()
	{
		return this.QTYpar;
	}

	public void setfID(int newfID)
	{
		this.fID=newfID;
	}

	public void setpID(int newpID)
	{
		this.pID=newpID;
	}

	public void setQTYstocked(int newQTYstocked)
	{
		this.QTYstocked=newQTYstocked;
	}

	public void setQTYpar(int newQTYpar)
	{
		this.QTYpar=newQTYpar;
	}



}
