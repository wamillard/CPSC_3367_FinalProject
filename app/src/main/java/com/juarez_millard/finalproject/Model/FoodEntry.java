package com.juarez_millard.finalproject.Model;

public class FoodEntry
{
	public String fID;
	public String pID;
	public String QTYstocked;
	public String QTYpar;



	public FoodEntry()
	{
		this.fID="";
		this.pID="";
		this.QTYstocked="";
		this.QTYpar="";
	}

	public FoodEntry(String newfID, String newpID, String newQTYStocked, String newQTYpar)
	{
		this.fID=newfID;
		this.pID=newpID;
		this.QTYstocked=newQTYStocked;
		this.QTYpar=newQTYpar;
	}

	public String getfID()
	{
		return this.fID;
	}

	public String getpID()
	{
		return this.pID;
	}

	public String getQTYstocked()
	{
		return this.QTYstocked;
	}

	public String getQTYpar()
	{
		return this.QTYpar;
	}

	public void setfID(String newfID)
	{
		this.fID=newfID;
	}

	public void setpID(String newpID)
	{
		this.pID=newpID;
	}

	public void setQTYstocked(String newQTYstocked)
	{
		this.QTYstocked=newQTYstocked;
	}

	public void setQTYpar(String newQTYpar)
	{
		this.QTYpar=newQTYpar;
	}
}
