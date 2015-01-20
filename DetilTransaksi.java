package uas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class DetilTransaksi extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetilTransaksi frame = new DetilTransaksi();
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
	public DetilTransaksi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdTransaksi = new JLabel("ID transaksi");
		lblIdTransaksi.setBounds(10, 50, 82, 14);
		contentPane.add(lblIdTransaksi);
		
		JLabel lblTglTransaksi = new JLabel("Tgl Transaksi");
		lblTglTransaksi.setBounds(10, 98, 82, 14);
		contentPane.add(lblTglTransaksi);
		
		JLabel lblIdProduct = new JLabel("ID Product");
		lblIdProduct.setBounds(10, 123, 82, 14);
		contentPane.add(lblIdProduct);
		
		JLabel lblNamaProduct = new JLabel("Nama Product");
		lblNamaProduct.setBounds(10, 148, 82, 14);
		contentPane.add(lblNamaProduct);
		
		JLabel lblIdSupplier = new JLabel("ID Supplier");
		lblIdSupplier.setBounds(10, 185, 82, 14);
		contentPane.add(lblIdSupplier);
		
		JLabel lblHarga = new JLabel("Harga");
		lblHarga.setBounds(10, 216, 46, 14);
		contentPane.add(lblHarga);
		
		JLabel lblNamaPembeli = new JLabel("Nama Pembeli");
		lblNamaPembeli.setBounds(10, 73, 82, 14);
		contentPane.add(lblNamaPembeli);
	}
}
