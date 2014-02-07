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
import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class PhoneNumExtension implements FREExtension 
{

	@Override
	public FREContext createContext(String arg0)
	{
		return new PhoneNumExtensionContext();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

}
