package uas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

import javax.swing.UIManager;

public class Msuppliers extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection konek = null;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtNSupplier;
	private JTextField txtIDSupplier;
	private JButton btnInsert;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JLabel lblFormMenuSupplier;
	private JLabel lblNamaSupplier;
	private JLabel lblIdSupplier;
	private JComboBox cmbCari;
	private JTextField txtCari;
	private JComboBox cmbSelection;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Msuppliers frame = new Msuppliers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	
	public void refresh()
	{
		try {
			 Class.forName(koneksi.DATABASE_DRIVER);
			 konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
			String query="select * from suppliers";
			PreparedStatement pst=konek.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void Combobox()
	{
		try 
		{
			 Class.forName(koneksi.DATABASE_DRIVER);
			 konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
			 String query="select * from suppliers";
			 PreparedStatement pst=konek.prepareStatement(query);
			 ResultSet rs=pst.executeQuery();
			 
			 while(rs.next())
			 {
				 cmbCari.addItem(rs.getString("NamaSupp"));
			 }
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Create the frame.
	 */
	public Msuppliers() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 431);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.darkGray.brighter());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoadDataSupplier = new JButton("Load Data Supplier");
		btnLoadDataSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					 Class.forName(koneksi.DATABASE_DRIVER);
					 konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
					String query="select * from suppliers";
					PreparedStatement pst=konek.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		btnLoadDataSupplier.setBounds(10, 192, 300, 40);
		contentPane.add(btnLoadDataSupplier);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(320, 54, 345, 221);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try
				{
					Class.forName(koneksi.DATABASE_DRIVER);
					konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
					
					int row=table.getSelectedRow();
					String idS_=(table.getModel().getValueAt(row, 0).toString());
					String query="select * from suppliers where IdSupp='"+idS_+"' ";
					PreparedStatement pst=konek.prepareStatement(query);
					pst.setString(1, (String)cmbCari.getSelectedItem());
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{
						txtNSupplier.setText(rs.getString("NamaSupp"));
						txtIDSupplier.setText(rs.getString("IdSupp"));

						
					}
					
					pst.close();

				}
				catch (Exception ex)
				{
					ex.printStackTrace();

				}

				
			}
		});
		scrollPane.setViewportView(table);
		
		txtNSupplier = new JTextField();
		txtNSupplier.setBounds(104, 117, 206, 21);
		contentPane.add(txtNSupplier);
		txtNSupplier.setColumns(10);
		
		txtIDSupplier = new JTextField();
		txtIDSupplier.setBounds(104, 83, 206, 23);
		contentPane.add(txtIDSupplier);
		txtIDSupplier.setColumns(10);
		
		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				try 
				{
					Class.forName(koneksi.DATABASE_DRIVER);
					konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
				 	String query="insert into suppliers values (?,?)";
					PreparedStatement pst=konek.prepareStatement(query);
					pst.setString(1,txtIDSupplier.getText());
					pst.setString(2,txtNSupplier.getText());
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "data saved");
					pst.close();

				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
	
				refresh();
			}
		});
		btnInsert.setBounds(320, 296, 101, 23);
		contentPane.add(btnInsert);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					Class.forName(koneksi.DATABASE_DRIVER);
					konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
					String query="Update suppliers set IdSupp='"+txtIDSupplier.getText()+"',NamaSupp='"+txtNSupplier.getText()+"' where IdSupp='"+txtIDSupplier.getText()+"' ";    
					PreparedStatement pst=konek.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "data Updated");
					pst.close();
					
				}
				catch (Exception ex)
				{
					ex.printStackTrace();

				}

				refresh();
			}
		});
		btnUpdate.setBounds(438, 296, 107, 23);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int action=JOptionPane.showConfirmDialog(null,"Apakah anda yakin mau menghapus data tersebut","delete",JOptionPane.YES_NO_OPTION);
				if(action==0)
				{
					try
					{
						Class.forName(koneksi.DATABASE_DRIVER);
						konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
						String query="delete from suppliers where IdSupp='"+txtIDSupplier.getText()+"' ";
						PreparedStatement pst=konek.prepareStatement(query);
						pst.execute();
						JOptionPane.showMessageDialog(null, "data deleted");
						pst.close();
						
					}
					catch (Exception ex)
					{
						ex.printStackTrace();
	
					}
				}
				refresh();
			}
		});
		btnDelete.setBounds(564, 296, 101, 23);
		contentPane.add(btnDelete);
		
		lblFormMenuSupplier = new JLabel("Form Menu Supplier");
		lblFormMenuSupplier.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		lblFormMenuSupplier.setBounds(198, 11, 208, 32);
		contentPane.add(lblFormMenuSupplier);
		
		lblNamaSupplier = new JLabel("Nama Supplier");
		lblNamaSupplier.setBounds(10, 120, 89, 14);
		contentPane.add(lblNamaSupplier);
		
		lblIdSupplier = new JLabel("ID Supplier");
		lblIdSupplier.setBounds(10, 87, 83, 14);
		contentPane.add(lblIdSupplier);
		
		cmbCari = new JComboBox();
		cmbCari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					Class.forName(koneksi.DATABASE_DRIVER);
					konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
					String query="select * from suppliers where NamaSupp=?";
					PreparedStatement pst=konek.prepareStatement(query);
					pst.setString(1, (String)cmbCari.getSelectedItem());
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{
						txtNSupplier.setText(rs.getString("NamaSupp"));
						txtIDSupplier.setText(rs.getString("IdSupp"));

						
					}
					
					pst.close();

				}
				catch (Exception ex)
				{
					ex.printStackTrace();

				}
				
			}
		});
		cmbCari.setBounds(104, 52, 207, 20);
		contentPane.add(cmbCari);
		
		txtCari = new JTextField();
		txtCari.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try
				{
					Class.forName(koneksi.DATABASE_DRIVER);
					konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
					
					String selection=(String)cmbSelection.getSelectedItem();
					String query="select * from suppliers where "+selection+"=?";
					System.out.println(query);
					PreparedStatement pst=konek.prepareStatement(query);
					pst.setString(1,txtCari.getText() );
					
					ResultSet rs=pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					pst.close();

				}
				catch (Exception ex)
				{
					ex.printStackTrace();

				}
				
				
			}
		});
		txtCari.setBounds(104, 149, 206, 21);
		contentPane.add(txtCari);
		txtCari.setColumns(10);
		
		cmbSelection = new JComboBox();
		cmbSelection.setModel(new DefaultComboBoxModel(new String[] {"IdSupp", "NamaSupp"}));
		cmbSelection.setBounds(10, 149, 83, 20);
		contentPane.add(cmbSelection);
		
		JButton btnKembali = new JButton("Home");
		btnKembali.setBounds(50, 5, 100, 20);
		contentPane.add(btnKembali);
		
		btnKembali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					new MenuUtama().setVisible(true);
					dispose();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		refresh();
		Combobox();
	}

}
