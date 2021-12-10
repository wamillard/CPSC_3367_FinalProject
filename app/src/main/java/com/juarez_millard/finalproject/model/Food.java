package com.juarez_millard.finalproject.model;


import java.util.ArrayList;
import java.util.List;

public class Food
{
	public Integer fID;
	public String fName;
	public String UoM;
	public List<Integer> fCategories;

	public Food()
	{
		this.fID=0;
		this.fName="";
		this.UoM="";
		this.fCategories=new ArrayList<Integer>();
	}

	public Food(Integer newfID, String newfName, String newUoM,List newfCategories)
	{
		this.fID=newfID;
		this.fName=newfName;
		this.UoM=newUoM;
		this.fCategories=newfCategories;
	}

	public Integer getfID()
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

	public List getfCategories()
	{
		return this.fCategories;
	}

	public void setfID(Integer newfID)
	{
		this.fID=newfID;
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
