package com.juarez_millard.finalproject.Model;


import java.util.ArrayList;
import java.util.List;

public class Food
{
	public String fID;
	public String fName;
	public String UoM;
	public List<String> fCategories;

	public Food()
	{
		this.fID="";
		this.fName="";
		this.UoM="";
		this.fCategories=new ArrayList<String>();
	}

	public Food(String newfID, String newfName, String newUoM,List newfCategories)
	{
		this.fID=newfID;
		this.fName=newfName;
		this.UoM=newUoM;
		this.fCategories=newfCategories;
	}

	public String getfID()
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

	public void setfID(String newfID)
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
