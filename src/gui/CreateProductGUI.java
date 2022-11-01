package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ProductCtrl;
import model.Item;
import model.Product;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateProductGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ProductCtrl ctrl;
	private JTextField txtBrand;
	private JTextField txtStock;
	private JTextField txtCategory;
	private JTextField txtPrice;
	private JTextField txtDescription;
	private JTextField txtName;
	private JTextField txtBarcode;
	private JLabel lblName;
	private JLabel lblBarcode;
	private JLabel lblBrand;
	private JLabel lblStock;
	private JLabel lblCategory;
	private JLabel lblPrice;
	private JLabel lblProductDescription;
	private boolean editing = false;
	private JLabel lblHeader;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CreateProductGUI dialog = new CreateProductGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public CreateProductGUI(ProductCtrl ctrl) {
		this();
		init(ctrl);
	}
	
	public CreateProductGUI(ProductCtrl ctrl, Product item) {
		this();
		init(ctrl, item);
	}

	

	

	/**
	 * Create the dialog.
	 */
	public CreateProductGUI() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			lblHeader = new JLabel("Opret produkt");
			lblHeader.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblHeader, BorderLayout.NORTH);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{66, 86, 18};
			gbl_panel.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				lblName = new JLabel("Navn");
				lblName.setHorizontalAlignment(SwingConstants.LEFT);
				GridBagConstraints gbc_lblName = new GridBagConstraints();
				gbc_lblName.insets = new Insets(0, 0, 5, 5);
				gbc_lblName.anchor = GridBagConstraints.WEST;
				gbc_lblName.gridx = 0;
				gbc_lblName.gridy = 0;
				panel.add(lblName, gbc_lblName);
			}
			{
				txtName = new JTextField();
				GridBagConstraints gbc_txtName = new GridBagConstraints();
				gbc_txtName.gridwidth = 2;
				gbc_txtName.insets = new Insets(0, 0, 5, 0);
				gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtName.gridx = 1;
				gbc_txtName.gridy = 0;
				panel.add(txtName, gbc_txtName);
				txtName.setColumns(10);
			}
			{
				lblBarcode = new JLabel("Stregkode");
				GridBagConstraints gbc_lblBarcode = new GridBagConstraints();
				gbc_lblBarcode.insets = new Insets(0, 0, 5, 5);
				gbc_lblBarcode.anchor = GridBagConstraints.WEST;
				gbc_lblBarcode.gridx = 0;
				gbc_lblBarcode.gridy = 1;
				panel.add(lblBarcode, gbc_lblBarcode);
			}
			{
				txtBarcode = new JTextField();
				GridBagConstraints gbc_txtBarcode = new GridBagConstraints();
				gbc_txtBarcode.gridwidth = 2;
				gbc_txtBarcode.insets = new Insets(0, 0, 5, 0);
				gbc_txtBarcode.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtBarcode.gridx = 1;
				gbc_txtBarcode.gridy = 1;
				panel.add(txtBarcode, gbc_txtBarcode);
				txtBarcode.setColumns(10);
			}
			{
				lblBrand = new JLabel("Mærke");
				GridBagConstraints gbc_lblBrand = new GridBagConstraints();
				gbc_lblBrand.insets = new Insets(0, 0, 5, 5);
				gbc_lblBrand.anchor = GridBagConstraints.WEST;
				gbc_lblBrand.gridx = 0;
				gbc_lblBrand.gridy = 2;
				panel.add(lblBrand, gbc_lblBrand);
			}
			{
				txtBrand = new JTextField();
				GridBagConstraints gbc_txtBrand = new GridBagConstraints();
				gbc_txtBrand.gridwidth = 2;
				gbc_txtBrand.insets = new Insets(0, 0, 5, 0);
				gbc_txtBrand.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtBrand.gridx = 1;
				gbc_txtBrand.gridy = 2;
				panel.add(txtBrand, gbc_txtBrand);
				txtBrand.setColumns(10);
			}
			{
				lblStock = new JLabel("Antal");
				GridBagConstraints gbc_lblStock = new GridBagConstraints();
				gbc_lblStock.insets = new Insets(0, 0, 5, 5);
				gbc_lblStock.anchor = GridBagConstraints.WEST;
				gbc_lblStock.gridx = 0;
				gbc_lblStock.gridy = 3;
				panel.add(lblStock, gbc_lblStock);
			}
			{
				txtStock = new JTextField();
				GridBagConstraints gbc_txtStock = new GridBagConstraints();
				gbc_txtStock.gridwidth = 2;
				gbc_txtStock.insets = new Insets(0, 0, 5, 0);
				gbc_txtStock.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtStock.gridx = 1;
				gbc_txtStock.gridy = 3;
				panel.add(txtStock, gbc_txtStock);
				txtStock.setColumns(10);
			}
			{
				lblCategory = new JLabel("Kategori");
				GridBagConstraints gbc_lblCategory = new GridBagConstraints();
				gbc_lblCategory.insets = new Insets(0, 0, 5, 5);
				gbc_lblCategory.anchor = GridBagConstraints.WEST;
				gbc_lblCategory.gridx = 0;
				gbc_lblCategory.gridy = 4;
				panel.add(lblCategory, gbc_lblCategory);
			}
			{
				txtCategory = new JTextField();
				GridBagConstraints gbc_txtCategory = new GridBagConstraints();
				gbc_txtCategory.gridwidth = 2;
				gbc_txtCategory.insets = new Insets(0, 0, 5, 0);
				gbc_txtCategory.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtCategory.gridx = 1;
				gbc_txtCategory.gridy = 4;
				panel.add(txtCategory, gbc_txtCategory);
				txtCategory.setColumns(10);
			}
			{
				lblPrice = new JLabel("Stk. pris");
				GridBagConstraints gbc_lblPrice = new GridBagConstraints();
				gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
				gbc_lblPrice.anchor = GridBagConstraints.WEST;
				gbc_lblPrice.gridx = 0;
				gbc_lblPrice.gridy = 5;
				panel.add(lblPrice, gbc_lblPrice);
			}
			{
				txtPrice = new JTextField();
				GridBagConstraints gbc_txtPrice = new GridBagConstraints();
				gbc_txtPrice.gridwidth = 2;
				gbc_txtPrice.insets = new Insets(0, 0, 5, 0);
				gbc_txtPrice.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtPrice.gridx = 1;
				gbc_txtPrice.gridy = 5;
				panel.add(txtPrice, gbc_txtPrice);
				txtPrice.setColumns(10);
			}
			{
				lblProductDescription = new JLabel("Beskrivelse");
				GridBagConstraints gbc_lblProductDescription = new GridBagConstraints();
				gbc_lblProductDescription.insets = new Insets(0, 0, 0, 5);
				gbc_lblProductDescription.anchor = GridBagConstraints.WEST;
				gbc_lblProductDescription.gridx = 0;
				gbc_lblProductDescription.gridy = 6;
				panel.add(lblProductDescription, gbc_lblProductDescription);
			}
			{
				txtDescription = new JTextField();
				GridBagConstraints gbc_txtDescription = new GridBagConstraints();
				gbc_txtDescription.gridwidth = 2;
				gbc_txtDescription.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtDescription.gridx = 1;
				gbc_txtDescription.gridy = 6;
				panel.add(txtDescription, gbc_txtDescription);
				txtDescription.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						okButtonClicked();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancelButtonClicked();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	

	

	private void init(ProductCtrl ctrl) {
		this.ctrl = ctrl;
	}
	
	private void init(ProductCtrl ctrl, Product item) {
		this.ctrl = ctrl;
		editing = true;
		lblHeader.setText("Opdater produkt");
		txtName.setText(item.getName());
		txtBarcode.setText(item.getBarcode());
		txtBrand.setText(item.getBrand());
		txtCategory.setText(item.getCategory());
		txtDescription.setText(item.getProductDescription());
		txtStock.setText(Integer.toString(item.getStock()));
		txtPrice.setText(Double.toString(item.getPrice()));
		txtName.setEditable(false);
		txtBarcode.setEditable(false);
		txtBrand.setEditable(false);
		txtCategory.setEditable(false);
		txtDescription.setEditable(false);
		txtStock.setEditable(false);
		
	}
	
	private void cancelButtonClicked() {
		this.dispose();
	}
	
	private void okButtonClicked() {
		if(isANumber(txtPrice.getText()) && !txtPrice.getText().isBlank() && isANumber(txtStock.getText()) && !txtStock.getText().isBlank()) {
			if(!editing) {
				ctrl.createProduct(txtName.getText(), txtDescription.getText(), txtBrand.getText(), txtBarcode.getText(),
				Double.parseDouble(txtPrice.getText()), Integer.parseInt(txtStock.getText()), txtCategory.getText());
			}else {
				Product tempProduct = (Product) ctrl.findProduct(txtBarcode.getText());
				tempProduct.setPrice(Double.parseDouble(txtPrice.getText()));
			}
			this.dispose();
		}else {
			JOptionPane.showMessageDialog(this, "Pris skal udfyldes og være et tal.");
		}
		
		
		}
	
	private boolean isANumber(String string) {
		try {
			Double.parseDouble(string);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
		

}
