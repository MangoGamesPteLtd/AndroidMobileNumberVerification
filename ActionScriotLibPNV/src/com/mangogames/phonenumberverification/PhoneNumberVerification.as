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
package com.mangogames.phonenumberverification
{
	
	import flash.external.ExtensionContext;

	public class PhoneNumberVerification
	{
		public var extContext : ExtensionContext;
		
		public function PhoneNumberVerification()
		{
			trace("in phonenumberverification Constructor");
			extContext = ExtensionContext.createExtensionContext("com.mangogames.phonenumberverification","");
			if(!extContext)
			{
				throw new Error("phonenumberverification native extension is not supported on this platform.");
			}
		}
	
		public function phoneNumVerificaion():void 
		{
			trace("in phoneverification ");
			extContext.call("phoneVerification");
		}
	}
}