package com.juarez_millard.finalproject.model;

import java.util.ArrayList;
import java.util.List;

public class FoodEntry
{
	public Integer fID;
	public Integer pID;
	public Integer QTYstocked;
	public Integer QTYpar;
	public String fName;
	public String UoM;
	public List<Integer> fCategories;


	public FoodEntry()
	{
		this.fID=0;
		this.pID=0;
		this.QTYstocked=0;
		this.QTYpar=0;
		this.fName="";
		this.UoM="";
		this.fCategories=new ArrayList<Integer>();
	}

	public FoodEntry(Integer newfID, Integer newpID, Integer newQTYStocked, Integer newQTYpar)
	{
		this.fID=newfID;
		this.pID=newpID;
		this.QTYstocked=newQTYStocked;
		this.QTYpar=newQTYpar;
	}

	public Integer getfID()
	{
		return this.fID;
	}

	public Integer getpID()
	{
		return this.pID;
	}

	public Integer getQTYstocked()
	{
		return this.QTYstocked;
	}

	public Integer getQTYpar()
	{
		return this.QTYpar;
	}

	public String getfName()
	{
		return this.fName;
	}

	public String getUoM()
	{
		return this.UoM;
	}

	public void setfID(Integer newfID)
	{
		this.fID=newfID;
	}

	public void setpID(Integer newpID)
	{
		this.pID=newpID;
	}

	public void setQTYstocked(Integer newQTYstocked)
	{
		this.QTYstocked=newQTYstocked;
	}

	public void setQTYpar(Integer newQTYpar)
	{
		this.QTYpar=newQTYpar;
	}

	public void setfName(String newfName)
	{
		this.fName=newfName;
	}

	public void setUoM(String newUoM)
	{
		this.UoM=newUoM;
	}

	public void setfCategories(List newfCategories)
	{
		this.fCategories=newfCategories;
	}
}
