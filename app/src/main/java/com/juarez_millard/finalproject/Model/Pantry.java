package com.juarez_millard.finalproject.Model;

public class Pantry
{
	public Integer pID;
	public String pName;
	public String pLocation;
	public Integer pCount;

	public Pantry()
	{
		this.pID=0;
		this.pName="";
		this.pLocation="";
		this.pCount=0;
	}

	public Pantry(Integer newpID, String newpName, String newpLocation, Integer newpCount)
	{
		this.pID=newpID;
		this.pName=newpName;
		this.pLocation=newpLocation;
		this.pCount=newpCount;
	}

	public Integer getpID()
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

	public Integer getpCount()
	{
		return this.pCount;
	}

	public void setpID(Integer newpID)
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

	public void setpCount(Integer newpCount)
	{
		this.pCount=newpCount;
	}

}
