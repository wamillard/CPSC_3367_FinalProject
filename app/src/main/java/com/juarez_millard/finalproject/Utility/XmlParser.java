package com.juarez_millard.finalproject.Utility;

import android.util.Xml;

import com.juarez_millard.finalproject.Model.Food;
import com.juarez_millard.finalproject.Model.Pantry;
import com.juarez_millard.finalproject.Model.FoodEntry;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class XmlParser
{
	private static final String ns=null;

	public HashMap parse(InputStream dataIn, String newField) throws XmlPullParserException, IOException
	{
		try
		{
			XmlPullParser parser = Xml.newPullParser();
			parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
			parser.setInput(dataIn, null);
			parser.nextTag();
			if (newField=="Pantry")
			{
				return readPantry(parser);
			}
			else if (newField=="Food")
			{
				return readFood(parser);
			}
			else if (newField=="FoodEntry")
			{
				return readFoodEntry(parser);
			}
			else //(newField=="Category")
			{
				return readCategory(parser);
			}
		}
		finally
		{
			dataIn.close();
		}
	}

	private String readTag(XmlPullParser parser, String newTag) throws XmlPullParserException,IOException
	{
		parser.require(XmlPullParser.START_TAG,ns, newTag);
		String data="";
		if (parser.next()==XmlPullParser.TEXT)
		{
			data=parser.getText();
			parser.nextTag();
		}
		return data;
	}

	private HashMap readPantry(XmlPullParser parser) throws XmlPullParserException, IOException
	{
		parser.require(XmlPullParser.START_TAG, ns, "pantries");

		HashMap<Integer, Pantry> pList=new HashMap<>();

		Integer newpID=0;
		String newpName="";
		String newpLocation="";
		Integer newpCount=0;

		while (parser.next() !=XmlPullParser.END_TAG)
		{
			if (parser.getEventType()!=XmlPullParser.START_TAG)
			{
				continue;
			}

			parser.require(XmlPullParser.START_TAG,ns,"Pantry");
			while (parser.next()!=XmlPullParser.END_TAG)
			{
				if (parser.getEventType()!=XmlPullParser.START_TAG)
				{
					continue;
				}
				String newTag= parser.getName();

				if (newTag=="pID")
				{
					newpID=Integer.parseInt(readTag(parser,newTag));
				}
				else if (newTag=="pName")
				{
					newpName=readTag(parser,newTag);
				}
				else if (newTag=="pLocation")
				{
					newpLocation=readTag(parser,newTag);
				}
				else //(newTag=="pCount"
				{
					newpCount=Integer.parseInt(readTag(parser,newTag));
				}
			}

			pList.put(newpID,new Pantry(newpID,newpName,newpLocation,newpCount));

			parser.require(XmlPullParser.START_TAG,ns,"pantries");
		}
		return pList;
	}

	private HashMap readFood(XmlPullParser parser) throws XmlPullParserException, IOException
	{
		parser.require(XmlPullParser.START_TAG, ns, "foods");

		HashMap<Integer, Food> fList=new HashMap<>();

		Integer newfID=0;
		String newfName="";
		String newUoM="";
		List<Integer> newfCategory=new ArrayList<>();

		while (parser.next() !=XmlPullParser.END_TAG)
		{
			if (parser.getEventType()!=XmlPullParser.START_TAG)
			{
				continue;
			}

			parser.require(XmlPullParser.START_TAG,ns,"Food");
			while (parser.next()!=XmlPullParser.END_TAG)
			{
				if (parser.getEventType()!=XmlPullParser.START_TAG)
				{
					continue;
				}

				String newTag= parser.getName();

				if (newTag=="fID")
				{
					newfID=Integer.parseInt(readTag(parser,newTag));
				}
				else if (newTag=="fName")
				{
					newfName=readTag(parser,newTag);
				}
				else if (newTag=="Uom")
				{
					newUoM=readTag(parser,newTag);
				}
				else //(newTag=="fCategories"
				{
					parser.require(XmlPullParser.START_TAG,ns,"Category");
					while (parser.next()!=XmlPullParser.END_TAG)
					{
						if (parser.getEventType()!=XmlPullParser.START_TAG)
						{
							continue;
						}
						newfCategory.add(Integer.parseInt(readTag(parser,newTag)));
					}
					parser.require(XmlPullParser.START_TAG,ns,"Food");

				}
			}
			fList.put(newfID, new Food(newfID,newfName,newUoM,newfCategory));

			parser.require(XmlPullParser.START_TAG,ns,"foods");
		}
		return fList;

	}

	private HashMap readFoodEntry(XmlPullParser parser) throws XmlPullParserException, IOException
	{
		parser.require(XmlPullParser.START_TAG, ns, "foodentries");

		HashMap<Integer, FoodEntry> fList=new HashMap<>();

		Integer newfID=0;
		Integer newpID=0;
		Integer newQTYstocked=0;
		Integer newQtypar=0;

		while (parser.next() !=XmlPullParser.END_TAG)
		{
			if (parser.getEventType()!=XmlPullParser.START_TAG)
			{
				continue;
			}

			parser.require(XmlPullParser.START_TAG,ns,"FoodEntry");
			while (parser.next()!=XmlPullParser.END_TAG)
			{
				if (parser.getEventType()!=XmlPullParser.START_TAG)
				{
					continue;
				}
				String newTag= parser.getName();

				if (newTag=="fID")
				{
					newfID=Integer.parseInt(readTag(parser,newTag));
				}
				else if (newTag=="pID")
				{
					newpID=Integer.parseInt(readTag(parser,newTag));
				}
				else if (newTag=="QTYstocked")
				{
					newQTYstocked=Integer.parseInt(readTag(parser,newTag));
				}
				else //(newTag=="QTYpar"
				{
					newQtypar=Integer.parseInt(readTag(parser,newTag));
				}
			}

			fList.put(newfID,new FoodEntry(newfID,newpID,newQTYstocked,newQtypar));

			parser.require(XmlPullParser.START_TAG,ns,"foodentries");
		}
		return fList;

	}

	private HashMap readCategory(XmlPullParser parser) throws XmlPullParserException, IOException
	{
		parser.require(XmlPullParser.START_TAG, ns, "categories");

		HashMap<Integer, String> cList=new HashMap<>();

		Integer newcID=0;
		String newcName="";

		while (parser.next() !=XmlPullParser.END_TAG)
		{
			if (parser.getEventType()!=XmlPullParser.START_TAG)
			{
				continue;
			}

			parser.require(XmlPullParser.START_TAG,ns,"Category");
			while (parser.next()!=XmlPullParser.END_TAG)
			{
				if (parser.getEventType()!=XmlPullParser.START_TAG)
				{
					continue;
				}
				String newTag= parser.getName();

				if (newTag=="cID")
				{
					newcID=Integer.parseInt(readTag(parser,newTag));
				}
				else //(newTag=="cName"
				{
					newcName=readTag(parser,newTag);
				}
			}

			cList.put(newcID,newcName);

			parser.require(XmlPullParser.START_TAG,ns,"categories");
		}

		return cList;
	}
}
