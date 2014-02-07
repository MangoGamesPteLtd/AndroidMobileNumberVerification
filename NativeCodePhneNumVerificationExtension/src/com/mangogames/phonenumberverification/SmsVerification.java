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

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.telephony.gsm.SmsManager;
import android.telephony.gsm.SmsMessage;
import android.widget.Toast;
import android.widget.RelativeLayout.LayoutParams;



public class SmsVerification 
{
	private Context _ctx;
	BroadcastReceiver receiverregister;
	ProgressDialog progress;
	String myPhoneNum = "";
	String regexStr = "^([7-9]{1})([0-9]{9})$";
	
	SmsVerification(Context context, String phnoNum)
	{
		_ctx = context;
		myPhoneNum = phnoNum;
		if(myPhoneNum.length() == 10 && myPhoneNum.matches(regexStr) == true)
		{
			new phoneNumVerification().execute();
		}
		else
		{
			Toast.makeText(context, "InValid Number", Toast.LENGTH_SHORT).show();
		}
			
	}
	private void sendSMS(String phNo) 
	{
		final String myPhoneNumber = "+91"+phNo;
		TelephonyManager telephneMangr = (TelephonyManager)_ctx.getSystemService(_ctx.TELEPHONY_SERVICE);
		String countryIso = telephneMangr.getNetworkCountryIso();
		
		SmsManager smsMan = SmsManager.getDefault();
		smsMan.sendTextMessage(phNo, null, "Verfied Successful for Num ::"+myPhoneNumber, null, null);
		
		
		receiverregister = new 	BroadcastReceiver()
		{
			@Override
			public void onReceive(Context context, Intent intent)
			{	
				Bundle extras = intent.getExtras();
				
				 SmsMessage[] msgs1 = null;
		        String str = "";
		        String str1 = ""; 
		        if (extras != null)
		        {
		            //---retrieve the SMS message received---
		            Object[] pdus = (Object[]) extras.get("pdus");
		            msgs1 = new SmsMessage[pdus.length];            
		            for (int i=0; i<msgs1.length; i++){
		                msgs1[i] = SmsMessage.createFromPdu((byte[])pdus[i]); 
		                str1 = msgs1[i].getOriginatingAddress().toString();
		                str += "SMS from " + msgs1[i].getOriginatingAddress();                     
		                str += " :";
		                str += msgs1[i].getMessageBody().toString();
		                
		                str += "\n";  
		             
		            }
		          
		            if(str1.equals(myPhoneNumber))
		            {
			            Toast.makeText(context, "Verified Successfully "+str1.equals(myPhoneNumber), 
		                        Toast.LENGTH_SHORT).show();
		            }
		            else
		            {
			            Toast.makeText(context, "Verification Failed", 
		                        Toast.LENGTH_SHORT).show();
		            }
			        }			
			}
		};
		
		_ctx.registerReceiver(receiverregister, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));

	}
	
	
	 private class phoneNumVerification extends AsyncTask<String, Void, String>
	    {

		 @Override
	        protected void onPostExecute(String result)
	        {
	            // TODO Auto-generated method stub
	            if(progress.isShowing())
	            {
	                progress.dismiss();
	               
	                
	            }
	            super.onPostExecute(result);
	        }
		@Override
		protected String doInBackground(String... arg0) 
		{
			 sendSMS(myPhoneNum);
			 timeout();
			return null;
		}
		   @Override
	        protected void onPreExecute() 
	        {
	            progress = ProgressDialog.show(_ctx, "","Checking Mobile Number...");
	            progress.setIndeterminate(true);
	            progress.getWindow().setLayout(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
	             super.onPreExecute();
	        }
		 
	    }
	    private void timeout()
	    {
	              try
	              {
	                Thread.sleep(5000);
	              }
	              catch (InterruptedException e)
	              {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	              }
	      
	     }

}
