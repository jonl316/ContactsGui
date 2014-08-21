package com.jlivesay.contactsgui.gui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import com.jlivesay.contactsgui.contacts.Contact;
import com.jlivesay.contactsgui.tables.ContactsManager;
import com.jlivesay.contactsgui.utils.DBUtil;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class ContactGuiFrame extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4850452993466724456L;
	private JPanel contentPane;
	private JTextField txtFieldFirstName;
	private JTextField txtFieldLastName;
	private JTextField txtFieldStreet1;
	private JTextField txtFieldStreet2;
	private JTextField txtFieldCity;
	private JTextField txtFieldState;
	private JTextField txtFieldZipCode;
	private JTextField txtFieldHomePhone;
	private JTextField txtFieldWorkPhone;
	private JTextField txtFieldEmail1;
	private JTextField txtFieldEmail2;
	private JTextField txtFieldEmail3;
	private JTextField txtFieldCellPhone;
	private JTextField txtFieldContactID;
	
	ArrayList<Contact> contacts = new ArrayList<Contact>();
	private JTextField txtFieldCurrentContact;
	private JTextField txtFieldTotalContacts;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args)
//	{
//
//	}
	
	/**
	 * Create the frame.
	 */
	public ContactGuiFrame()
	{
		setTitle("Contact Organizer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 700);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnSetup = new JMenu("Setup");
		menuBar.add(mnSetup);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[][grow][][grow]", "[]"));
		
		JLabel lblContactInfo1 = new JLabel("Contact");
		panel_1.add(lblContactInfo1, "cell 0 0,alignx trailing");
		
		txtFieldCurrentContact = new JTextField();
		txtFieldCurrentContact.setEditable(false);
		panel_1.add(txtFieldCurrentContact, "cell 1 0,growx");
		txtFieldCurrentContact.setColumns(5);
		
		JLabel lblContactInfo2 = new JLabel("of");
		panel_1.add(lblContactInfo2, "cell 2 0,alignx trailing");
		
		txtFieldTotalContacts = new JTextField();
		txtFieldTotalContacts.setEditable(false);
		panel_1.add(txtFieldTotalContacts, "cell 3 0,growx");
		txtFieldTotalContacts.setColumns(5);
		
		JTabbedPane tabbedPaneName = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneName.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		contentPane.add(tabbedPaneName);
		
		JPanel panelNameInfo = new JPanel();
		tabbedPaneName.addTab("New tab", null, panelNameInfo, null);
		tabbedPaneName.setTabComponentAt(0,new JLabel("Contact Info"));
		panelNameInfo.setLayout(new MigLayout("", "[80px:80px:80px][250px:227.00:250px,grow]", "[][][][][][][][]"));
		
		JLabel lblId = new JLabel("ID:");
		panelNameInfo.add(lblId, "cell 0 0,alignx trailing");
		
		txtFieldContactID = new JTextField();
		txtFieldContactID.setEditable(false);
		panelNameInfo.add(txtFieldContactID, "cell 1 0,growx");
		txtFieldContactID.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name:");
		panelNameInfo.add(lblFirstName, "cell 0 1,alignx trailing");
		
		txtFieldFirstName = new JTextField();
		panelNameInfo.add(txtFieldFirstName, "cell 1 1,growx");
		txtFieldFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		panelNameInfo.add(lblLastName, "cell 0 2,alignx trailing");
		
		txtFieldLastName = new JTextField();
		panelNameInfo.add(txtFieldLastName, "cell 1 2,growx");
		txtFieldLastName.setColumns(10);
		
		JLabel lblStreet1 = new JLabel("Street 1:");
		panelNameInfo.add(lblStreet1, "cell 0 3,alignx trailing");
		
		txtFieldStreet1 = new JTextField();
		panelNameInfo.add(txtFieldStreet1, "cell 1 3,growx");
		txtFieldStreet1.setColumns(10);
		
		JLabel lblStreet2 = new JLabel("Street 2:");
		panelNameInfo.add(lblStreet2, "cell 0 4,alignx trailing");
		
		txtFieldStreet2 = new JTextField();
		panelNameInfo.add(txtFieldStreet2, "cell 1 4,growx");
		txtFieldStreet2.setColumns(10);
		
		JLabel lblCity = new JLabel("City:");
		panelNameInfo.add(lblCity, "cell 0 5,alignx trailing");
		
		txtFieldCity = new JTextField();
		panelNameInfo.add(txtFieldCity, "cell 1 5,growx");
		txtFieldCity.setColumns(10);
		
		JLabel lblState = new JLabel("State:");
		panelNameInfo.add(lblState, "cell 0 6,alignx trailing");
		
		txtFieldState = new JTextField();
		panelNameInfo.add(txtFieldState, "cell 1 6,growx");
		txtFieldState.setColumns(10);
		
		JLabel lblZipCode = new JLabel("ZipCode:");
		panelNameInfo.add(lblZipCode, "cell 0 7,alignx trailing");
		
		txtFieldZipCode = new JTextField();
		panelNameInfo.add(txtFieldZipCode, "cell 1 7,growx");
		txtFieldZipCode.setColumns(10);
		
		JTabbedPane tabbedPanePhone = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPanePhone);
		
		JPanel panelPhoneInfo = new JPanel();
		tabbedPanePhone.addTab("New tab", null, panelPhoneInfo, null);
		tabbedPanePhone.setTabComponentAt(0,new JLabel("Phone Info"));
		panelPhoneInfo.setLayout(new MigLayout("", "[80px:80px:80px][250px:250px:250px,grow]", "[][][]"));
		
		JLabel lblCellPhone = new JLabel("Cell Ph:");
		panelPhoneInfo.add(lblCellPhone, "cell 0 0,alignx trailing");
		
		txtFieldCellPhone = new JTextField();
		panelPhoneInfo.add(txtFieldCellPhone, "cell 1 0,growx");
		txtFieldCellPhone.setColumns(10);
		
		JLabel lblHomePhone = new JLabel("Home Ph:");
		panelPhoneInfo.add(lblHomePhone, "cell 0 1,alignx trailing");
		
		txtFieldHomePhone = new JTextField();
		panelPhoneInfo.add(txtFieldHomePhone, "cell 1 1,growx");
		txtFieldHomePhone.setColumns(10);
		
		JLabel lblWorkPhone = new JLabel("Work Ph:");
		panelPhoneInfo.add(lblWorkPhone, "cell 0 2,alignx trailing");
		
		txtFieldWorkPhone = new JTextField();
		panelPhoneInfo.add(txtFieldWorkPhone, "cell 1 2,growx");
		txtFieldWorkPhone.setColumns(10);
		
		JTabbedPane tabbedPaneEmail = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPaneEmail);
		
		JPanel panelEmailInfo = new JPanel();
		tabbedPaneEmail.addTab("New tab", null, panelEmailInfo, null);
		tabbedPaneEmail.setTabComponentAt(0, new JLabel("Email Info"));
		panelEmailInfo.setLayout(new MigLayout("", "[80px:80px:80px][250px:250px:250px,grow]", "[][][]"));
		
		JLabel lblEmail1 = new JLabel("Email 1:");
		panelEmailInfo.add(lblEmail1, "cell 0 0,alignx trailing");
		
		txtFieldEmail1 = new JTextField();
		panelEmailInfo.add(txtFieldEmail1, "cell 1 0,growx");
		txtFieldEmail1.setColumns(10);
		
		JLabel lblEmail2 = new JLabel("Email 2:");
		panelEmailInfo.add(lblEmail2, "cell 0 1,alignx trailing");
		
		txtFieldEmail2 = new JTextField();
		panelEmailInfo.add(txtFieldEmail2, "cell 1 1,growx");
		txtFieldEmail2.setColumns(10);
		
		JLabel lblEmail3 = new JLabel("Email 3:");
		panelEmailInfo.add(lblEmail3, "cell 0 2,alignx trailing");
		
		txtFieldEmail3 = new JTextField();
		panelEmailInfo.add(txtFieldEmail3, "cell 1 2,growx");
		txtFieldEmail3.setColumns(10);
		
		JPanel panelPickContact = new JPanel();
		contentPane.add(panelPickContact);
		panelPickContact.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		final JButton btnFirstContact = new JButton("|<");
		btnFirstContact.setFont(new Font("Dialog", Font.PLAIN, 10));
		final JButton btnPreviousContact = new JButton("<<");
		btnPreviousContact.setFont(new Font("Dialog", Font.PLAIN, 10));
		final JButton btnNextContact = new JButton(">>");
		btnNextContact.setFont(new Font("Dialog", Font.PLAIN, 10));
		final JButton btnLastContact = new JButton(">|");	
		btnLastContact.setFont(new Font("Dialog", Font.PLAIN, 10));
		final JLabel lblContactStatus = new JLabel("");
		
		
		// btnFirstContact logic here 
		btnFirstContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: Enter functionality to go to beginning of arraylist
				// of contacts.
				
				try 
				{
				contacts = ContactsManager.getAllRowsArrayList();
				
				if(contacts != null)
				{

					txtFieldContactID.setText(contacts.get(0).getId() + "");
					txtFieldFirstName.setText(contacts.get(0).getFirstName());
					txtFieldLastName.setText(contacts.get(0).getLastName());
					txtFieldStreet1.setText(contacts.get(0).getStreet1());
					txtFieldStreet2.setText(contacts.get(0).getStreet2());
					txtFieldCity.setText(contacts.get(0).getCity());
					txtFieldState.setText(contacts.get(0).getState());
					txtFieldZipCode.setText(contacts.get(0).getZipCode());
					txtFieldCellPhone.setText(contacts.get(0).getCellPhone());
					txtFieldHomePhone.setText(contacts.get(0).getHomePhone());
					txtFieldWorkPhone.setText(contacts.get(0).getWorkPhone());
					txtFieldEmail1.setText(contacts.get(0).getEmail1());
					txtFieldEmail2.setText(contacts.get(0).getEmail2());
					txtFieldEmail3.setText(contacts.get(0).getEmail3());
					
					txtFieldCurrentContact.setText(getCurrentContact(contacts, 0) + "" );
					txtFieldTotalContacts.setText(getLastContactIndex(contacts) + "" );
					
					btnFirstContact.setEnabled(false);
					btnPreviousContact.setEnabled(false);
					btnNextContact.setEnabled(true);
					btnLastContact.setEnabled(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,  "Issue getting Contact Please try again");
				}
				
				}
				catch (SQLException e2)
				{
					DBUtil.processException(e2);
				}// end try/catch statement
			}
			
			
		});
		btnFirstContact.setToolTipText("First Contact");
		panelPickContact.add(btnFirstContact);
		

		// btnPreviousContact here
		btnPreviousContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: Enter code to go to previous contact in arraylist

				try 
				{
					contacts = ContactsManager.getAllRowsArrayList();
					int intContactIDText = Integer.parseInt(txtFieldContactID.getText());
					int contactCount = 0;
					
					for (int i = 0; i < contacts.size(); i++)
					{
						int contactID = contacts.get(i).getId();
						if (contactID == intContactIDText)
						{
							contactCount = i;
						}
					}// end for loop
					contactCount--;
					
					if(contactCount >= 0)
					{
						txtFieldContactID.setText(contacts.get(contactCount).getId() + "");
						txtFieldFirstName.setText(contacts.get(contactCount).getFirstName());
						txtFieldLastName.setText(contacts.get(contactCount).getLastName());
						txtFieldStreet1.setText(contacts.get(contactCount).getStreet1());
						txtFieldStreet2.setText(contacts.get(contactCount).getStreet2());
						txtFieldCity.setText(contacts.get(contactCount).getCity());
						txtFieldState.setText(contacts.get(contactCount).getState());
						txtFieldZipCode.setText(contacts.get(contactCount).getZipCode());
						txtFieldCellPhone.setText(contacts.get(contactCount).getCellPhone());
						txtFieldHomePhone.setText(contacts.get(contactCount).getHomePhone());
						txtFieldWorkPhone.setText(contacts.get(contactCount).getWorkPhone());
						txtFieldEmail1.setText(contacts.get(contactCount).getEmail1());
						txtFieldEmail2.setText(contacts.get(contactCount).getEmail2());
						txtFieldEmail3.setText(contacts.get(contactCount).getEmail3());
						
						txtFieldCurrentContact.setText(getCurrentContact(contacts, txtFieldContactID.getText()) + "" );
						txtFieldTotalContacts.setText(getLastContactIndex(contacts) + "" );
						
						if (contactCount == 0)
						{
							btnFirstContact.setEnabled(false);
							btnPreviousContact.setEnabled(false);
							btnNextContact.setEnabled(true);
							btnLastContact.setEnabled(true);
						}
						else
						{
							btnFirstContact.setEnabled(true);
							btnPreviousContact.setEnabled(true);
							btnNextContact.setEnabled(true);
							btnLastContact.setEnabled(true);
						}// ends if else
					}
					else
					{
						JOptionPane.showMessageDialog(null,  "Issue getting Contact Please try again");
					}// ends if else 
				}// ends try 
				catch (SQLException e2)
				{
					DBUtil.processException(e2);
				}// end try/catch statement
				catch (Exception ex1)
				{
					JOptionPane.showMessageDialog(null,
							ex1.getMessage());
				}// end try catch 
			}// end actionListenster
		});
		btnPreviousContact.setToolTipText("Previous Contact");
		panelPickContact.add(btnPreviousContact);
		

		// btnNextContact logic here
		btnNextContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: Enter code to go to next contact in arraylist
				
				try 
				{
				contacts = ContactsManager.getAllRowsArrayList();
				int intContactIDText = Integer.parseInt(txtFieldContactID.getText());
				int contactCount = 0;
				
				for (int i = 0; i < contacts.size(); i++)
				{
					int contactID = contacts.get(i).getId();
					if (contactID == intContactIDText)
					{
						contactCount = i;
					}
				}
				
				contactCount++;
				
				if (contactCount < contacts.size())
				{
					if(contacts != null)
					{
	
						txtFieldContactID.setText(contacts.get(contactCount).getId() + "");
						txtFieldFirstName.setText(contacts.get(contactCount).getFirstName());
						txtFieldLastName.setText(contacts.get(contactCount).getLastName());
						txtFieldStreet1.setText(contacts.get(contactCount).getStreet1());
						txtFieldStreet2.setText(contacts.get(contactCount).getStreet2());
						txtFieldCity.setText(contacts.get(contactCount).getCity());
						txtFieldState.setText(contacts.get(contactCount).getState());
						txtFieldZipCode.setText(contacts.get(contactCount).getZipCode());
						txtFieldCellPhone.setText(contacts.get(contactCount).getCellPhone());
						txtFieldHomePhone.setText(contacts.get(contactCount).getHomePhone());
						txtFieldWorkPhone.setText(contacts.get(contactCount).getWorkPhone());
						txtFieldEmail1.setText(contacts.get(contactCount).getEmail1());
						txtFieldEmail2.setText(contacts.get(contactCount).getEmail2());
						txtFieldEmail3.setText(contacts.get(contactCount).getEmail3());
						

						
						if (contactCount == (contacts.size() -1))
						{
							btnFirstContact.setEnabled(true);
							btnPreviousContact.setEnabled(true);
							btnNextContact.setEnabled(false);
							btnLastContact.setEnabled(false);
						}
						else
						{
							btnFirstContact.setEnabled(true);
							btnPreviousContact.setEnabled(true);
							btnNextContact.setEnabled(true);
							btnLastContact.setEnabled(true);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,  "Issue getting Contact Please try again");
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No More Contacts in this Direction");
				}
				
				
				}
				catch (SQLException e2)
				{
					DBUtil.processException(e2);
				}// end try/catch statement
				catch (Exception ex1)
				{
					JOptionPane.showMessageDialog(null,
							ex1.getMessage());
				}
				
				txtFieldCurrentContact.setText(getCurrentContact(contacts, txtFieldContactID.getText()) + "" );
				txtFieldTotalContacts.setText(getLastContactIndex(contacts) + "" );
			}
		});
		btnNextContact.setToolTipText("Next Contact");
		panelPickContact.add(btnNextContact);
		

		// btnLastContact here
		btnLastContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: Enter code to go to the last contact in arraylist
				try 
				{
				contacts = ContactsManager.getAllRowsArrayList();
				int contactCount = contacts.size() - 1;
				
				if(contacts != null)
				{

					txtFieldContactID.setText(contacts.get(contactCount).getId() + "");
					txtFieldFirstName.setText(contacts.get(contactCount).getFirstName());
					txtFieldLastName.setText(contacts.get(contactCount).getLastName());
					txtFieldStreet1.setText(contacts.get(contactCount).getStreet1());
					txtFieldStreet2.setText(contacts.get(contactCount).getStreet2());
					txtFieldCity.setText(contacts.get(contactCount).getCity());
					txtFieldState.setText(contacts.get(contactCount).getState());
					txtFieldZipCode.setText(contacts.get(contactCount).getZipCode());
					txtFieldCellPhone.setText(contacts.get(contactCount).getCellPhone());
					txtFieldHomePhone.setText(contacts.get(contactCount).getHomePhone());
					txtFieldWorkPhone.setText(contacts.get(contactCount).getWorkPhone());
					txtFieldEmail1.setText(contacts.get(contactCount).getEmail1());
					txtFieldEmail2.setText(contacts.get(contactCount).getEmail2());
					txtFieldEmail3.setText(contacts.get(contactCount).getEmail3());
					
					txtFieldCurrentContact.setText(getCurrentContact(contacts, 
											txtFieldContactID.getText()) + "" );
					txtFieldTotalContacts.setText(getLastContactIndex(contacts) + "" );
					
					btnFirstContact.setEnabled(true);
					btnPreviousContact.setEnabled(true);
					btnNextContact.setEnabled(false);
					btnLastContact.setEnabled(false);
					

				}
				else
				{
					JOptionPane.showMessageDialog(null,  "Issue getting Contact Please try again");
				}
				
				}
				catch (SQLException e2)
				{
					DBUtil.processException(e2);
				}// end try/catch statement
				catch (Exception ex1)
				{
					JOptionPane.showMessageDialog(null,
							ex1.getMessage());
				}
				
			}
		});
		btnLastContact.setToolTipText("Last Contact");
		panelPickContact.add(btnLastContact);
		
		JPanel panelButtons = new JPanel();
		contentPane.add(panelButtons);
		panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewContact = new JButton("New");
		btnNewContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Code to create a new contact.
				// Code to get the form ready to create a new contact. 
				// Mainly to clear out the screen. 
				txtFieldContactID.setText("*");
				clearTxtFields();
				
				txtFieldCurrentContact.setText("*");
				txtFieldTotalContacts.setText(getLastContactIndex(contacts) + "" );
			}
		});
		btnNewContact.setToolTipText("Enter a New Contact");
		panelButtons.add(btnNewContact);
		
		JButton btnSaveContact = new JButton("Save");
		btnSaveContact.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				String strContactID = "";
				strContactID = txtFieldContactID.getText();
				boolean boolUpdate = true;
				
				if (strContactID.equals("*") || (strContactID.equals("")))
				{
					boolUpdate = false;
				}
				else if ((Integer.parseInt(strContactID)) <= (contacts.size() -1))
				{
					boolUpdate = true;
				}
				else
				{
					boolUpdate = true;
				}
					
					
				if (boolUpdate == true)
					{
						Contact bean = new Contact();
						
						int intContactID = Integer.parseInt(txtFieldContactID.getText());
						bean.setId(intContactID);
						bean.setFirstName(txtFieldFirstName.getText());
						bean.setLastName(txtFieldLastName.getText());
						bean.setStreet1(txtFieldStreet1.getText());
						bean.setStreet2(txtFieldStreet2.getText());
						bean.setCity(txtFieldCity.getText());
						bean.setState(txtFieldState.getText());
						bean.setZipCode(txtFieldZipCode.getText());
						bean.setCellPhone(txtFieldCellPhone.getText());
						bean.setHomePhone(txtFieldHomePhone.getText());
						bean.setWorkPhone(txtFieldWorkPhone.getText());
						bean.setEmail1(txtFieldEmail1.getText());
						bean.setEmail2(txtFieldEmail2.getText());
						bean.setEmail3(txtFieldEmail3.getText());
						
						try
						{
							boolean insertOk = ContactsManager.update(bean);
							
							if (insertOk)
							{
								StringBuilder okMessage = new StringBuilder();
		
								okMessage.append("Contact: \n");
								okMessage.append(bean.getId() + " ");
								okMessage.append(bean.getFirstName() + " ");
								okMessage.append(bean.getLastName() + " ");
								okMessage.append("Updated Successfully!!!");
								//JOptionPane.showMessageDialog(null, okMessage.toString());
								lblContactStatus.setText(okMessage.toString());
							}
							else 
							{
								JOptionPane.showMessageDialog(null, "Contact was not Updated Successfully!!!!");
							}
					
						} 
						catch (SQLException e1)
						{
							JOptionPane.showMessageDialog(null, DBUtil.processExceptionString(e1));
						}
					
						
						
					}
					else if (boolUpdate == false)
					{
					
						Contact bean = new Contact();
						
						bean.setFirstName(txtFieldFirstName.getText());
						bean.setLastName(txtFieldLastName.getText());
						bean.setStreet1(txtFieldStreet1.getText());
						bean.setStreet2(txtFieldStreet2.getText());
						bean.setCity(txtFieldCity.getText());
						bean.setState(txtFieldState.getText());
						bean.setZipCode(txtFieldZipCode.getText());
						bean.setCellPhone(txtFieldCellPhone.getText());
						bean.setHomePhone(txtFieldHomePhone.getText());
						bean.setWorkPhone(txtFieldWorkPhone.getText());
						bean.setEmail1(txtFieldEmail1.getText());
						bean.setEmail2(txtFieldEmail2.getText());
						bean.setEmail3(txtFieldEmail3.getText());
						
		
						try
						{
							boolean insertOk = ContactsManager.insert(bean);
							
							if (insertOk)
							{
								StringBuilder okMessage = new StringBuilder();
		
								okMessage.append("Contact: \n");
								okMessage.append(bean.getId() + " ");
								okMessage.append(bean.getFirstName() + " ");
								okMessage.append(bean.getLastName() + " ");
								okMessage.append("Added Successfully!!!");
								// JOptionPane.showMessageDialog(null, okMessage.toString());
								lblContactStatus.setText(okMessage.toString());
							}
							else 
							{
								JOptionPane.showMessageDialog(null, "Contact was not added Successfully!!!!");
							}
					
						} 
						catch (SQLException e1)
						{
							JOptionPane.showMessageDialog(null, DBUtil.processExceptionString(e1));
						}// end try catch
					
						// After saving the new contact, want to show that information on screen. 
						// using the code below to refresh the contacts arraylist and 
						// display the last contact, which is the one you created  if it saved. 
						
						try 
						{
						contacts = ContactsManager.getAllRowsArrayList();;
						int contactCount = contacts.size() -1;
						
						if(contacts != null)
						{

							txtFieldContactID.setText(contacts.get(contactCount).getId() + "");
							txtFieldFirstName.setText(contacts.get(contactCount).getFirstName());
							txtFieldLastName.setText(contacts.get(contactCount).getLastName());
							txtFieldStreet1.setText(contacts.get(contactCount).getStreet1());
							txtFieldStreet2.setText(contacts.get(contactCount).getStreet2());
							txtFieldCity.setText(contacts.get(contactCount).getCity());
							txtFieldState.setText(contacts.get(contactCount).getState());
							txtFieldZipCode.setText(contacts.get(contactCount).getZipCode());
							txtFieldCellPhone.setText(contacts.get(contactCount).getCellPhone());
							txtFieldHomePhone.setText(contacts.get(contactCount).getHomePhone());
							txtFieldWorkPhone.setText(contacts.get(contactCount).getWorkPhone());
							txtFieldEmail1.setText(contacts.get(contactCount).getEmail1());
							txtFieldEmail2.setText(contacts.get(contactCount).getEmail2());
							txtFieldEmail3.setText(contacts.get(contactCount).getEmail3());
							
							btnFirstContact.setEnabled(true);
							btnPreviousContact.setEnabled(true);
							btnNextContact.setEnabled(false);
							btnLastContact.setEnabled(false);
							
							// contacts = ContactsManager.getAllRowsArrayList();
							txtFieldCurrentContact.setText(getCurrentContact(contacts, 
															txtFieldContactID.getText()) + "" );
							txtFieldTotalContacts.setText(getLastContactIndex(contacts) + "" );
						}
						else
						{
							JOptionPane.showMessageDialog(null,  "Issue getting Contact Please try again");
						}
						
						}
						catch (SQLException e2)
						{
							DBUtil.processException(e2);
						}// end try/catch statement
						catch (Exception ex1)
						{
							JOptionPane.showMessageDialog(null,
									ex1.getMessage());
						}// end catch
						
						
						
				}// end else 
			}// end actionEvent
		});
		btnSaveContact.setToolTipText("Save Contact");
		panelButtons.add(btnSaveContact);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: fix code to delete contact. 
				
				int contactCount = 0;
				
				try
				{
					
					contacts = ContactsManager.getAllRowsArrayList();
					int intContactIDText = Integer.parseInt(txtFieldContactID.getText());
					
					for (int i = 0; i < contacts.size(); i++)
					{
						int contactID = contacts.get(i).getId();
						if (contactID == intContactIDText)
						{
							contactCount = i;
						}
					}// end for clause
					
						int deleteOK = JOptionPane.showConfirmDialog(null, 
								"Are you sure you want to delete contact? ", "DeleteContact", 
								JOptionPane.YES_NO_OPTION);
						
						// JOptionPane.showMessageDialog(null, "You Clicked Option: " +  deleteOK);
						
						if (deleteOK == 0)
						{
							boolean booleanContactDeleted = ContactsManager.delete(intContactIDText);
							
							if (booleanContactDeleted == true)
							{
								contacts = ContactsManager.getAllRowsArrayList();
								// JOptionPane.showMessageDialog(null, "Contact Deleted");
								lblContactStatus.setText("************* Contact Deleted *************");
							}
							else 
							{
								JOptionPane.showMessageDialog(null, "Problem Deleting \nContact # " + 
										contactCount + " " + intContactIDText);

							}// end if else 
					}// end if else
						
				}// end try 
				catch (SQLException ex5)
				{
					DBUtil.processExceptionString(ex5);
				}
				catch (Exception ex4) 
				{
					
					JOptionPane.showMessageDialog(null, "Something Bad Happened");
				}// end catch clauses
				
				
				/**
				 * After contact is deleted, need to get all rows again and show the previous 
				 * contact on the screen.  That is what this does. 
				 */
				
				try 
				{
				contacts = ContactsManager.getAllRowsArrayList();;
				// Getting error if Deleting the last contact.  
				// subtracting the contactCount by one fixes that problem.
				// Making it an if statement because if I do that and delete 
				// the first contact that errors out. 
				if (contactCount == contacts.size())
				{
					contactCount = contactCount - 1;
				}
				
				if(contacts != null)
				{

					txtFieldContactID.setText(contacts.get(contactCount).getId() + "");
					txtFieldFirstName.setText(contacts.get(contactCount).getFirstName());
					txtFieldLastName.setText(contacts.get(contactCount).getLastName());
					txtFieldStreet1.setText(contacts.get(contactCount).getStreet1());
					txtFieldStreet2.setText(contacts.get(contactCount).getStreet2());
					txtFieldCity.setText(contacts.get(contactCount).getCity());
					txtFieldState.setText(contacts.get(contactCount).getState());
					txtFieldZipCode.setText(contacts.get(contactCount).getZipCode());
					txtFieldCellPhone.setText(contacts.get(contactCount).getCellPhone());
					txtFieldHomePhone.setText(contacts.get(contactCount).getHomePhone());
					txtFieldWorkPhone.setText(contacts.get(contactCount).getWorkPhone());
					txtFieldEmail1.setText(contacts.get(contactCount).getEmail1());
					txtFieldEmail2.setText(contacts.get(contactCount).getEmail2());
					txtFieldEmail3.setText(contacts.get(contactCount).getEmail3());
					
//					btnFirstContact.setEnabled(true);
//					btnPreviousContact.setEnabled(true);
//					btnNextContact.setEnabled(false);
//					btnLastContact.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null,  "Issue getting Contact Please try again");
				}
				
				}
				catch (SQLException e2)
				{
					DBUtil.processException(e2);
				}// end try/catch statement
				catch (Exception ex1)
				{
					JOptionPane.showMessageDialog(null,
							ex1.getMessage());
				}// end catch
				
				txtFieldCurrentContact.setText(getCurrentContact(contacts, 
									txtFieldContactID.getText()) + "" );
				txtFieldTotalContacts.setText(getLastContactIndex(contacts) + "" );
				
			}// end actionListener
		});
		btnDelete.setToolTipText("Delete Contact");
		panelButtons.add(btnDelete);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// code to close the form when button is clicked.!!!
				System.exit(0);
			}
		});
		btnClose.setToolTipText("Close The Form");
		panelButtons.add(btnClose);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		

		lblContactStatus.setFont(new Font("Dialog", Font.PLAIN, 10));
		panel.add(lblContactStatus);
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
			
			try 
			{
			contacts = ContactsManager.getAllRowsArrayList();
			
			if(contacts != null)
			{

				txtFieldContactID.setText(contacts.get(0).getId() + "");
				txtFieldFirstName.setText(contacts.get(0).getFirstName());
				txtFieldLastName.setText(contacts.get(0).getLastName());
				txtFieldStreet1.setText(contacts.get(0).getStreet1());
				txtFieldStreet2.setText(contacts.get(0).getStreet2());
				txtFieldCity.setText(contacts.get(0).getCity());
				txtFieldState.setText(contacts.get(0).getState());
				txtFieldZipCode.setText(contacts.get(0).getZipCode());
				txtFieldCellPhone.setText(contacts.get(0).getCellPhone());
				txtFieldHomePhone.setText(contacts.get(0).getHomePhone());
				txtFieldWorkPhone.setText(contacts.get(0).getWorkPhone());
				txtFieldEmail1.setText(contacts.get(0).getEmail1());
				txtFieldEmail2.setText(contacts.get(0).getEmail2());
				txtFieldEmail3.setText(contacts.get(0).getEmail3());
				
				btnFirstContact.setEnabled(false);
				btnPreviousContact.setEnabled(false);
				btnNextContact.setEnabled(true);
				btnLastContact.setEnabled(true);
			}
			else
			{
				JOptionPane.showMessageDialog(null,  "Issue getting Contact Please try again");
			}
			
			}
			catch (SQLException e3)
			{
				DBUtil.processException(e3);
			}// end try/catch statement
			
			txtFieldCurrentContact.setText(getCurrentContact(contacts, 0) + "" );
			txtFieldTotalContacts.setText(getLastContactIndex(contacts) + "" );
		
		}
			
		});
		
		
	}// end ContactGuiFrame Constructor

	public void clearTxtFields()
	{
		this.txtFieldFirstName.setText("");
		this.txtFieldLastName.setText("");
		this.txtFieldStreet1.setText("");
		this.txtFieldStreet2.setText("");
		this.txtFieldCity.setText("");
		this.txtFieldState.setText("");
		this.txtFieldZipCode.setText("");
		this.txtFieldCellPhone.setText("");
		this.txtFieldWorkPhone.setText("");
		this.txtFieldHomePhone.setText("");
		this.txtFieldEmail1.setText("");
		this.txtFieldEmail2.setText("");
		this.txtFieldEmail3.setText("");
	}
	
//
//	
	
	public int getCurrentContact(ArrayList<Contact> cAL, int contactID)
	{
		int contactIndex = 0;
		
		
		for(int i = 0; i < cAL.size(); i++)
		{
			if (cAL.get(i).getId() == contactID)
				contactIndex = i;
		}
		
		contactIndex++;
		
		return contactIndex;
	}
	
	public int getCurrentContact(ArrayList<Contact> cAL, String ContactID)
	{
		int contactIndex = 0;
		int intContactID = 0;
		
		intContactID = Integer.parseInt(ContactID);
		
		for(int i = 0; i < cAL.size(); i++)
		{
			if (cAL.get(i).getId() == intContactID)
				contactIndex = i;
		}
		
		contactIndex++;
		
		return contactIndex;
	}
	
	public int getLastContactIndex(ArrayList<Contact> cAL)
	{
		int lastContactIndex = 0;
		lastContactIndex = cAL.size() - 1;
		
		lastContactIndex++;
		
		return lastContactIndex;
	}
	
//	public static void disablePrevButtons()
//	{
//		btnFirstContact.setEnabled(false);
//		btnPreviousContact.setEnabled(false);
//		btnNextContact.setEnabled(true);
//		btnLastContact.setEnabled(true);
//	}


}// End ConatctGuiFrame Class
