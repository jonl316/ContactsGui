package com.jlivesay.contactsgui.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHelper
{

	
	public static String getInput(String prompt)
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(isr);
		
		System.out.print(prompt);
		System.out.flush();
		
		try
		{
			return input.readLine();
		}
		catch(IOException ioe)
		{
			return "IO Exception Error: " + ioe.getMessage();
		}
		catch(Exception e)
		{
			return "Exception Error: " + e.getMessage();
		}
	}// end getInput method
	
	public static double getDoubleInput(String prompt) throws NumberFormatException
	{
		String strDoubleInput = getInput(prompt);
		double doubleInput = Double.parseDouble(strDoubleInput);
		return doubleInput;
	}// end getDoubleInput method
	
	public static int getIntegerInput(String prompt)
	{
		String strIntegerInput = getInput(prompt);
		int integerInput = Integer.parseInt(strIntegerInput);
		return integerInput;
	}// end getIntegerInput method
	
}
