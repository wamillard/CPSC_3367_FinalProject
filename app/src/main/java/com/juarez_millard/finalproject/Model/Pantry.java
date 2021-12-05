package com.juarez_millard.finalproject.Model;

public class Pantry
{
	public String pID;
	public String pName;
	public String pLocation;
	public String pCount;

	public Pantry()
	{
		this.pID="";
		this.pName="";
		this.pLocation="";
		this.pCount="0";
	}

	public Pantry(String newpID, String newpName, String newpLocation, String newpCount)
	{
		this.pID=newpID;
		this.pName=newpName;
		this.pLocation=newpLocation;
		this.pCount=newpCount;
	}

	public String getpID()
	{
		return this.pID;
	}

	public String getpName()
	{
		return this.pName;
	}

	public String getpLocation()
	{
		return this.pLocation;
	}

	public String getpCount()
	{
		return this.pCount;
	}

	public void setpID(String newpID)
	{
		this.pID=newpID;
	}

	public void setpName(String newpName)
	{
		this.pName=newpName;
	}

	public void setpLocation(String newpLocation)
	{
		this.pLocation=newpLocation;
	}

	public void setpCount(String newpCount)
	{
		this.pCount=newpCount;
	}

}
