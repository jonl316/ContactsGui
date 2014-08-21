package com.jlivesay.contactsgui.tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.jlivesay.contactsgui.contacts.Contact;
import com.jlivesay.contactsgui.utils.DBType;
import com.jlivesay.contactsgui.utils.DBUtil;

public class ContactsManager
{
	public static void displayAllRows() throws SQLException
	{
		String sql = "SELECT c_Id, firstName, lastName FROM contactstest";
		
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				)
		{
			System.out.println("ContactsTest Table:");
			while(rs.next())
			{
				StringBuffer buf = new StringBuffer();
				buf.append(rs.getInt("c_Id") + ": ");
				buf.append(rs.getString("firstName") + " ");
				buf.append(rs.getString("lastName"));
				System.out.println(buf.toString());
			}
		}
		catch (SQLException ex)
		{
			DBUtil.processException(ex);
		}
	}// end displayAllRows
	
	public static void displayAllRows(String strTableName) throws SQLException
	{
		String sql = "SELECT c_Id, firstName, lastName FROM " + strTableName;
		
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				)
		{
			System.out.println("ContactsTest Table:");
			while(rs.next())
			{
				StringBuffer buf = new StringBuffer();
				buf.append(rs.getInt("c_Id") + ": ");
				buf.append(rs.getString("firstName") + " ");
				buf.append(rs.getString("lastName"));
				System.out.println(buf.toString());
			}
		}
		catch (SQLException ex)
		{
			DBUtil.processException(ex);
		}
	}// end displayAllRows
	
	public static ArrayList<Contact> getAllRowsArrayList() throws SQLException
	{
		String sql = "SELECT * FROM contactstest";
		Contact bean = null;
		ArrayList<Contact> beans = new ArrayList<Contact>();
		
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				)
		{
			
			while(rs.next())
			{
				bean = new Contact();
//				StringBuffer buf = new StringBuffer();
//				buf.append(rs.getInt("c_Id") + ": ");
//				buf.append(rs.getString("firstName") + " ");
//				buf.append(rs.getString("lastName"));
//				System.out.println(buf.toString());
				
				bean.setId(rs.getInt("c_Id"));
				bean.setFirstName(rs.getString("firstName"));
				bean.setLastName(rs.getString("lastName"));
				bean.setStreet1(rs.getString("street1"));
				bean.setStreet2(rs.getString("street2"));
				bean.setCity(rs.getString("city"));
				bean.setState(rs.getString("state"));
				bean.setZipCode(rs.getString("zipCode"));
				bean.setCellPhone(rs.getString("cellPhone"));
				bean.setHomePhone(rs.getString("homePhone"));
				bean.setWorkPhone(rs.getString("workPhone"));
				bean.setEmail1(rs.getString("email1"));
				bean.setEmail2(rs.getString("email2"));
				bean.setEmail3(rs.getString("email3"));
				
				beans.add(bean);
			}
			
			return beans;
		}
		catch (SQLException ex)
		{
			DBUtil.processException(ex);
			return null;
		}
	}// end getAllRowsArrayList

	public static Contact getRow(int c_Id) throws SQLException
	{
		String sql = "Select * from contactstest WHERE c_Id = ?";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try 
		{
			conn = DBUtil.getConnection(DBType.MYSQL);
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, c_Id);
			rs = stmt.executeQuery();
			
			if(rs.next())
			{
				Contact bean = new Contact();
				bean.setId(c_Id);
				bean.setFirstName(rs.getString(3));
				bean.setLastName(rs.getString(2));
				bean.setStreet1(rs.getString(4));
				bean.setStreet2(rs.getString(5));
				bean.setCity(rs.getString(6));
				bean.setState(rs.getString(7));
				bean.setZipCode(rs.getString(8));
				bean.setCellPhone(rs.getString(9));
				bean.setHomePhone(rs.getString(10));
				bean.setWorkPhone(rs.getString(11));
				bean.setEmail1(rs.getString(12));
				bean.setEmail2(rs.getString(13));
				bean.setEmail3(rs.getString(14));
				return bean;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No rows were found", 
						"Conatact Manager Error", JOptionPane.WARNING_MESSAGE);
				return null;
			}

		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, DBUtil.processExceptionString(e), 
					"Contact  Error", JOptionPane.WARNING_MESSAGE);
			return null;
		}
		finally
		{
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}// end finally 
		
	}// end getRow Method
	
	public static boolean insert(Contact bean) throws SQLException
	{
		String sql = "Insert INTO contactstest (lastName, firstName, street1, street2, city, state, zipCode, " +
				"cellPhone, homePhone, workPhone, eMail1, eMail2, eMail3) " + 
				"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet keys = null;
		
		try
		{
			conn = DBUtil.getConnection(DBType.MYSQL);
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, bean.getLastName());
			stmt.setString(2, bean.getFirstName());
			stmt.setString(3, bean.getStreet1());
			stmt.setString(4, bean.getStreet2());
			stmt.setString(5, bean.getCity());
			stmt.setString(6, bean.getState());
			stmt.setString(7, bean.getZipCode());
			stmt.setString(8, bean.getCellPhone());
			stmt.setString(9, bean.getHomePhone());
			stmt.setString(10, bean.getWorkPhone());
			stmt.setString(11, bean.getEmail1());
			stmt.setString(12, bean.getEmail2());
			stmt.setString(13, bean.getEmail3());
			
			int affected = stmt.executeUpdate();
			
			if (affected ==1)
			{
				keys = stmt.getGeneratedKeys();
				keys.next();
				int newKey = keys.getInt(1);
				bean.setId(newKey);
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "No rows Affected", 
						"Contacts Manager Error", JOptionPane.WARNING_MESSAGE);
				return false;
			}// end if else
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, DBUtil.processExceptionString(e), 
					"SQLException", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		finally
		{
			if (keys != null)
				keys.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}// end try catch finally clause
		
		return true;
		
	}//end insert method
	
	public static boolean update(Contact bean)throws SQLException
	{
		String sql = "UPDATE contactstest SET " + 
						"firstName = ?, " +
						"lastName = ?, " +
						"street1 = ?, " +
						"street2 = ?, " +
						"city = ?, " +
						"state = ?, " +
						"zipCode = ?," +
						"cellPhone = ?, " +
						"homePhone = ?, " +
						"workPhone = ?, " +
						"email1 = ?, " +
						"email2 = ?, " +
						"email3 = ? " +
						"WHERE c_ID = ? ";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try 
		{
			conn = DBUtil.getConnection(DBType.MYSQL);
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, bean.getFirstName());
			stmt.setString(2, bean.getLastName());
			stmt.setString(3, bean.getStreet1());
			stmt.setString(4, bean.getStreet2());
			stmt.setString(5, bean.getCity());
			stmt.setString(6, bean.getState());
			stmt.setString(7, bean.getZipCode());
			stmt.setString(8, bean.getCellPhone());
			stmt.setString(9, bean.getHomePhone());
			stmt.setString(10, bean.getWorkPhone());
			stmt.setString(11, bean.getEmail1());
			stmt.setString(12, bean.getEmail2());
			stmt.setString(13, bean.getEmail3());
			stmt.setInt(14, bean.getId());
			
			int affected = stmt.executeUpdate();
			
			if (affected == 1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, DBUtil.processExceptionString(e));
			return false;
		}
		finally
		{
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}// end try/catch/finally
	}// end update method
	
	public static boolean delete(int contactId)throws SQLException
	{
		String sql = "DELETE FROM contactstest WHERE c_Id = ?";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try
		{
			conn = DBUtil.getConnection(DBType.MYSQL);
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, contactId);
			int affected = stmt.executeUpdate();
			
			if (affected == 1)
			{
				return true;
			}
			else 
			{
				return false;
			}
			
		}
		catch (SQLException e)
		{
			DBUtil.processExceptionString(e);
			return false;
		}
		catch (Exception exc)
		{
			JOptionPane.showMessageDialog(null, exc.getMessage());
			return false;
		}
		finally
		{
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}// end try catch finally block
	}// end delete method
	

}// end ContactsManager Class
