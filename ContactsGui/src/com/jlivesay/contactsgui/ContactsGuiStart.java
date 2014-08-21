package com.jlivesay.contactsgui;

import java.awt.EventQueue;
import java.sql.SQLException;

import com.jlivesay.contactsgui.gui.ContactGuiFrame;

public class ContactsGuiStart
{

	/**
	 * @param args
	 */
	public static void main(String[] args)throws SQLException
	{
		
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					ContactGuiFrame frame = new ContactGuiFrame();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		
		
		
//		Contact bean = new Contact();
//		String choice = "Y";
//		
//		ContactsManager.displayAllRows("contactstest");
//		
//		while ((Character.toUpperCase(choice.charAt(0)) != 'N'))
//		{
//			bean = ContactsManager.getRow(InputHelper.getIntegerInput("Please enter a row number: "));
//		
//			System.out.println(bean.toString());
//		
//			choice = InputHelper.getInput("Would you like to look up another contact?: (Y or N) ");
//		
//			if (choice.equals(""))
//				choice = "Y";
//		}
//		
//		System.out.println("************* END OF PROGRAM ***************");
	}

}

