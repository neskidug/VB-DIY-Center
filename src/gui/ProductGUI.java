package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import controller.ProductCtrl;
import model.Item;
import model.OrderLine;
import model.Pack;
import model.Product;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ProductGUI extends JFrame {

	private JPanel contentPane;
	private JTable tblProductTable;
	private JTextField txtFindProduct;
	private ProductCtrl ctrl;
	private ProductTableModel tableModel;
	private JButton btnUpdateProduct;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductGUI frame = new ProductGUI();
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
	public ProductGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 5));
		setContentPane(contentPane);
		
		JPanel pnlButtonPanel = new JPanel();
		contentPane.add(pnlButtonPanel, BorderLayout.SOUTH);
		pnlButtonPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		pnlButtonPanel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(0, 4, 5, 0));
		
		JButton btnCreatePackage = new JButton("Opret pakke");
		btnCreatePackage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createPackButtonClicked();
			}
		});
		panel_1.add(btnCreatePackage);
		
		JButton btnCreateproduct = new JButton("Opret produkt");
		panel_1.add(btnCreateproduct);
		btnCreateproduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createProductClicked();
			}
		});
		
		btnUpdateProduct = new JButton("Opdatér produkt");
		btnUpdateProduct.setEnabled(false);
		btnUpdateProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateProductButtonClicked();
			}
		});
		panel_1.add(btnUpdateProduct);
		
		JButton btnDeleteProduct = new JButton("Fjern produkt");
		btnDeleteProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteProductButtonClicked();
			}
		});
		panel_1.add(btnDeleteProduct);
		
		JPanel panel_3 = new JPanel();
		pnlButtonPanel.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnBackToMainMenu = new JButton("Tilbage");
		btnBackToMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backButtonClicked();
			}
		});
		panel_3.add(btnBackToMainMenu);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		tblProductTable = new JTable();
		tblProductTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				checkCurrentRowItemType();
			}
		});
		tblProductTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tblProductTable);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Produktmenu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		txtFindProduct = new JTextField();
		txtFindProduct.addFocusListener(new FocusAdapter() {
		});
		
		panel_2.add(txtFindProduct);
		txtFindProduct.setColumns(10);
		
		JButton btnFindProduct = new JButton("Søg");
		btnFindProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findProductClicked();
			}
		});
		btnFindProduct.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(btnFindProduct);
		
		
		
		init();
	}


	


	


	private void init(){
		ctrl = new ProductCtrl();
		tableModel = new ProductTableModel();
		this.tblProductTable.setModel(tableModel);
	}

	private void createProductClicked() {
		CreateProductGUI cpgui = new CreateProductGUI(ctrl);
		cpgui.setVisible(true);
	}
	
	private void findProductClicked() {
		Item product = ctrl.findProduct(txtFindProduct.getText());
		if(product != null) {
			refresh();
		}else {
			JOptionPane.showMessageDialog(this, "Produktet kunne ikke findes.");
		}
	}
	
	private void backButtonClicked() {
		MainMenuGUI mmgui = new MainMenuGUI();
		mmgui.setVisible(true);
		this.dispose();
	}
	
	private void deleteProductButtonClicked() {
		int selectedRow = tblProductTable.getSelectedRow();
		if (tableModel.getElementAtIndex(selectedRow) != null) {
			ctrl.deleteProduct(tableModel.getElementAtIndex(selectedRow));
			refresh();
		} else {
			JOptionPane.showMessageDialog(this, "Markér en linje.");
		}
	}


	private void refresh() {
			this.tableModel.setModelData(ctrl.findProduct(txtFindProduct.getText()));
			
//		try {
//			this.tableModel.setModelData(ctrl.findProduct(txtFindProduct.getText()));
//		} catch (NullPointerException e) {
//			
//		}
	}
	
	private void createPackButtonClicked() {
		if(createPackDialog()) {
			PackGUI pgui = new PackGUI(ctrl);
			pgui.setVisible(true);	
		}
	}
	
	private void updateProductButtonClicked() {
		Product selectedItem = (Product) tableModel.getElementAtIndex(tblProductTable.getSelectedRow());
		CreateProductGUI cpgui = new CreateProductGUI(ctrl, selectedItem);
		cpgui.setVisible(true);
		
	}

	private boolean createPackDialog() {
		  boolean okClicked = false;
		JTextField nameField = new JTextField(5);
	      JTextField barcodeField = new JTextField(5);

	      JPanel myPanel = new JPanel();
	      myPanel.add(new JLabel("Pakkenavn:"));
	      myPanel.add(nameField);
	      myPanel.add(Box.createVerticalStrut(15)); // a spacer
	      myPanel.add(new JLabel("Stregkode:"));
	      myPanel.add(barcodeField);

	      int result = JOptionPane.showConfirmDialog(this, myPanel, 
	               "Indtast pakkenavn og stregkode.", JOptionPane.OK_CANCEL_OPTION);
	      if (result == JOptionPane.OK_OPTION) {
	    	  if(!nameField.getText().isBlank() && !barcodeField.getText().isBlank()) {
	          ctrl.createPack(nameField.getText(), barcodeField.getText());
	          okClicked = true;
	    	  }else {
	    		  JOptionPane.showMessageDialog(this, "Udfyld venligst begge felter.");
	    	  }
	      }
	      return okClicked;
	}
	
	protected void checkCurrentRowItemType() {
		if(tableModel.getElementAtIndex(tblProductTable.getSelectedRow()).getClass() != Pack.class) {
			btnUpdateProduct.setEnabled(true);
		}else {
			btnUpdateProduct.setEnabled(false);
		}
	}
	
	
}
