package com.juarez_millard.finalproject.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Pantry implements Parcelable
{
	public Integer pID;
	public String pName;
	public String pRoom;
	public Integer pCount;
	public Integer pIcon;

	public Pantry()
	{
		this.pID=0;
		this.pName="";
		this.pRoom ="";
		this.pCount=0;
		this.pIcon=0;
	}

	public Pantry(Integer newpID, String newpName, String newpLocation, Integer newpCount, Integer newpIcon)
	{
		this.pID=newpID;
		this.pName=newpName;
		this.pRoom =newpLocation;
		this.pCount=newpCount;
		this.pIcon=newpIcon;
	}

	protected Pantry(Parcel source)
	{
		this.pID=source.readInt();
		this.pName=source.readString();
		this.pRoom =source.readString();
		this.pCount=source.readInt();
		this.pIcon=source.readInt();
	}

	public Integer getpID()
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

	public void setpID(Integer newpID)
	{
		this.pID=newpID;
	}

	public void setpName(String newpName)
	{
		this.pName=newpName;
	}

	public void setpRoom(String newpLocation)
	{
		this.pRoom =newpLocation;
	}

	public void setpCount(Integer newpCount)
	{
		this.pCount=newpCount;
	}

	public void setpIcon(Integer newpIcon)
	{
		this.pIcon=newpIcon;
	}

	@Override
	public int describeContents()
	{
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i)
	{
		parcel.writeInt(this.pID);
		parcel.writeString(this.pName);
		parcel.writeString(this.pRoom);
		parcel.writeInt(this.pCount);
		parcel.writeInt(this.pIcon);
	}

	public static final Creator<Pantry> CREATOR=new Creator<Pantry>()
	{
		@Override
		public Pantry createFromParcel(Parcel source)
		{
			return new Pantry(source);
		}

		@Override
		public Pantry[] newArray(int size)
		{
			return new Pantry[size];
		}
	};

}
