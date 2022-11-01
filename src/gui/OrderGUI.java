package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OrderCtrl;
import tui.TryMe;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderGUI extends JFrame {

	private JPanel contentPane;
	private OrderCtrl ctrl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderGUI frame = new OrderGUI();
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
	public OrderGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(5, 0, 419, 250);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnFindOrder = new JButton("Find ordre");
		btnFindOrder.setEnabled(false);
		btnFindOrder.setBounds(147, 101, 130, 36);
		panel.add(btnFindOrder);

		JButton btnCreateOrder = new JButton("Opret ordre");
		btnCreateOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createOrderClicked();
			}

		});
		btnCreateOrder.setBounds(147, 56, 130, 33);
		panel.add(btnCreateOrder);

		JLabel lblNewLabel = new JLabel("Ordremenu");
		lblNewLabel.setBounds(0, -2, 419, 33);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(lblNewLabel.getFont().getStyle() | Font.BOLD, 16f));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnBack = new JButton("Tilbage");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backButtonClicked();
			}
		});
		btnBack.setBounds(340, 227, 79, 23);
		panel.add(btnBack);
		
		
		
		
		init();
	}



	public void init() {
		OrderCtrl ctrl = new OrderCtrl();
		this.ctrl = ctrl;
	}

	private void createOrderClicked() {
		ctrl.createOrder();
		OrderTableGUI otg = new OrderTableGUI(this.ctrl);
		otg.setVisible(true);
		this.dispose();
	}

	
	
	protected void backButtonClicked() {
		MainMenuGUI mmgui = new MainMenuGUI();
		mmgui.setVisible(true);
		this.dispose();
	}
}
