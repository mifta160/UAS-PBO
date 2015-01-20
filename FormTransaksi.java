package uas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;

public class FormTransaksi extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtNamaProduct;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormTransaksi frame = new FormTransaksi();
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
	public FormTransaksi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdTransaksi = new JLabel("ID Transaksi");
		lblIdTransaksi.setBounds(10, 52, 99, 14);
		contentPane.add(lblIdTransaksi);
		
		JLabel lblTglTransaksi = new JLabel("Tgl Transaksi");
		lblTglTransaksi.setBounds(10, 84, 99, 14);
		contentPane.add(lblTglTransaksi);
		
		JLabel lblNamaPembeli = new JLabel("Nama Pembeli");
		lblNamaPembeli.setBounds(10, 119, 99, 14);
		contentPane.add(lblNamaPembeli);
		
		JLabel lblNamaProduct = new JLabel("Nama Product");
		lblNamaProduct.setBounds(10, 158, 99, 14);
		contentPane.add(lblNamaProduct);
		
		textField = new JTextField();
		textField.setBounds(119, 49, 187, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(119, 81, 187, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(119, 116, 187, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		txtNamaProduct = new JTextField();
		txtNamaProduct.setBounds(119, 155, 187, 20);
		contentPane.add(txtNamaProduct);
		txtNamaProduct.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setBounds(119, 208, 89, 23);
		contentPane.add(btnInsert);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(218, 208, 89, 23);
		contentPane.add(btnUpdate);
		
		JLabel lblFormTransaksi = new JLabel("Form Transaksi");
		lblFormTransaksi.setFont(new Font("Georgia", Font.PLAIN, 18));
		lblFormTransaksi.setBounds(218, 11, 187, 27);
		contentPane.add(lblFormTransaksi);
	}

}
