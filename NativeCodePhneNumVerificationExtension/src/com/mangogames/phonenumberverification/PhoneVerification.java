package com.mangogames.phonenumberverification;

/*******************************************************************************
Copyright (c) 2014 Mango Games Interactive Pte Ltd
 
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
 
The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.
*******************************************************************************/
/**
 * @author Percis
 */
import android.content.Context;
import android.widget.Toast;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class PhoneVerification implements FREFunction 
{

	@Override
	public FREObject call(FREContext context, FREObject[] args) 
	{
		try
		{
			/*Context con= context.getActivity().getApplicationContext();*/
			Context con = context.getActivity();
			
			String phoneNumber = args[0].getAsString();
			Toast.makeText(context.getActivity().getApplicationContext(), args[0].getAsString(), 
					Toast.LENGTH_SHORT).show();
			SmsVerification app = new SmsVerification(con, phoneNumber);
		}
		catch(Exception e)
		{
			Toast.makeText(context.getActivity().getApplicationContext(), "Error 1: Exception" + e.getMessage(), 
					Toast.LENGTH_SHORT).show();	
		}
		return null;
	}

}
