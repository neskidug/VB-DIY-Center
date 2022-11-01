package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tui.TryMe;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenuGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuGUI frame = new MainMenuGUI();
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
	public MainMenuGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnQuit = new JButton("Afslut");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				endButtonClicked();
			}
		});
		btnQuit.setBounds(325, 203, 89, 23);
		panel.add(btnQuit);
		
		JButton btnGenerateTestdata = new JButton("Generèr testdata");
		btnGenerateTestdata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					generateTestdataButtonClicked();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnGenerateTestdata.setBounds(134, 138, 150, 30);
		panel.add(btnGenerateTestdata);
		
		JButton btnCustomer = new JButton("Kundemenu");
		btnCustomer.setEnabled(false);
		btnCustomer.setBounds(134, 97, 150, 30);
		panel.add(btnCustomer);
		
		JButton btnProductMenu = new JButton("Produktmenu");
		btnProductMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productMenuButtonClicked();
			}
		});
		btnProductMenu.setBounds(134, 15, 150, 30);
		panel.add(btnProductMenu);
		
		JButton btnOrderMenu = new JButton("Ordremenu");
		btnOrderMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderMenuButtonClicked();
			}
		});
		btnOrderMenu.setBounds(134, 56, 150, 30);
		panel.add(btnOrderMenu);
		
		JLabel lblNewLabel = new JLabel("Hovedmenu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
	}
	
	

	private void endButtonClicked() {
		this.dispose();
	}

	private void orderMenuButtonClicked() {
		OrderGUI ogui = new OrderGUI();
		ogui.setVisible(true);
		this.dispose();
	}

	private void productMenuButtonClicked() {
		ProductGUI pgui = new ProductGUI();
		pgui.setVisible(true);
		this.dispose();
	}
	
	private void generateTestdataButtonClicked() throws Exception {
		TryMe tm = new TryMe();
		JOptionPane.showMessageDialog(this, "Produkter indlæst: L001 og L002.\nPakker indlæst: P001.");
	}

}
