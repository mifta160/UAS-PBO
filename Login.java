package uas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.UIManager;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private Connection konek = null;
	public String cekUser;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public String cek(String cek)
	{
		return cek;
	}
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 331);
		contentPane = new JPanel();
		contentPane.setBackground(Color.cyan.brighter());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblUsername.setBounds(257, 88, 76, 20);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblPassword.setBounds(257, 121, 76, 14);
		contentPane.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtUsername.setBounds(320, 89, 126, 19);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Calibri", Font.PLAIN, 12));
		passwordField.setBounds(320, 119, 127, 20);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("LOG IN");
		btnLogin.addActionListener(new ActionListener() {
			/*User usr = null;
			
			private long eventMask;
			private String level;
			private int kondisilogin=3;
			private String userlogin;
			*/
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Class.forName(koneksi.DATABASE_DRIVER);
					konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
					String query="select * from users where Username=? and Password=?";
					PreparedStatement pst=konek.prepareStatement(query);
					pst.setString(1,txtUsername.getText());
					pst.setString(2,passwordField.getText());
					ResultSet rs=pst.executeQuery();
					int count=0;
					while (rs.next())
					{
						count=count+1;
						cekUser=rs.getString("Level");
						
					}
					if(count==1)
					{
						
						
						if(cekUser.equals("admin"))
						{
							Class.forName(koneksi.DATABASE_DRIVER);
							konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
							String query1="update users set status=1  where Username='"+txtUsername.getText()+"' and Password='"+passwordField.getText()+"' ";
							PreparedStatement pst1=konek.prepareStatement(query1);
							ResultSet rs1=pst1.executeQuery();
							
							JOptionPane.showMessageDialog(null, "Login Berhasil");
							new MenuUtama().setVisible(true);
							dispose();
						}
						else if(cekUser.equals("user"))
						{
							Class.forName(koneksi.DATABASE_DRIVER);
							konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
							String query2="update users set status=1  where Username='"+txtUsername.getText()+"' and Password='"+passwordField.getText()+"' ";
							PreparedStatement pst2=konek.prepareStatement(query2);
							ResultSet rs2=pst2.executeQuery();
							
							JOptionPane.showMessageDialog(null, "Login Berhasil");
							new Transaksi().setVisible(true);
							dispose();
						}
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Maaf username atau password yang anda masukkan salah");
					}
					
				
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		btnLogin.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnLogin.setBounds(305, 160, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel label = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("img/logo.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(15, 11, 300, 257);
		contentPane.add(label);
	

		
		
	}
}
