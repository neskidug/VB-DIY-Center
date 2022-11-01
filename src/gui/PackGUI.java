package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import controller.ProductCtrl;
import model.Pack.PackLine;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PackGUI extends JDialog {
	private JTextField txtName;
	private JTextField txtBarcode;
	private PackLineTableModel tableModel;
	private ProductCtrl ctrl;
	private JTable tblProductTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PackGUI dialog = new PackGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public PackGUI(ProductCtrl ctrl) {
		this();
		init(ctrl);
	}


	/**
	 * Create the dialog.
	 */
	public PackGUI() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel = new JPanel();
				panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				FlowLayout flowLayout = (FlowLayout) panel.getLayout();
				flowLayout.setAlignment(FlowLayout.RIGHT);
				buttonPane.add(panel, BorderLayout.SOUTH);
				{
					JButton okButton = new JButton("OK");
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							okButtonClicked();
						}
					});
					panel.add(okButton);
					okButton.setActionCommand("OK");
					getRootPane().setDefaultButton(okButton);
				}
				{
					JButton cancelButton = new JButton("Cancel");
					cancelButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							cancelButtonClicked();
						}
					});
					panel.add(cancelButton);
					cancelButton.setActionCommand("Cancel");
				}
			}
			{
				JPanel panel = new JPanel();
				panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				buttonPane.add(panel, BorderLayout.NORTH);
				{
					GridBagLayout gbl_panel = new GridBagLayout();
					gbl_panel.columnWidths = new int[]{95, 0};
					gbl_panel.rowHeights = new int[]{23, 0};
					gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
					gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
					panel.setLayout(gbl_panel);
				}
				JButton btnAddProduct = new JButton("Tilføj produkt");
				btnAddProduct.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						addProductButtonClicked();
					}
				});
				GridBagConstraints gbc_btnAddProduct = new GridBagConstraints();
				gbc_btnAddProduct.anchor = GridBagConstraints.NORTHWEST;
				gbc_btnAddProduct.gridx = 0;
				gbc_btnAddProduct.gridy = 0;
				panel.add(btnAddProduct, gbc_btnAddProduct);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			getContentPane().add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				JLabel lblName = new JLabel("Navn:");
				GridBagConstraints gbc_lblName = new GridBagConstraints();
				gbc_lblName.anchor = GridBagConstraints.WEST;
				gbc_lblName.insets = new Insets(0, 0, 5, 5);
				gbc_lblName.gridx = 0;
				gbc_lblName.gridy = 0;
				panel.add(lblName, gbc_lblName);
			}
			{
				txtName = new JTextField();
				GridBagConstraints gbc_txtName = new GridBagConstraints();
				gbc_txtName.insets = new Insets(0, 0, 5, 0);
				gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtName.gridx = 1;
				gbc_txtName.gridy = 0;
				panel.add(txtName, gbc_txtName);
				txtName.setColumns(10);
			}
			{
				JLabel lblBarcode = new JLabel("Stregkode:");
				GridBagConstraints gbc_lblBarcode = new GridBagConstraints();
				gbc_lblBarcode.anchor = GridBagConstraints.WEST;
				gbc_lblBarcode.insets = new Insets(0, 0, 5, 5);
				gbc_lblBarcode.gridx = 0;
				gbc_lblBarcode.gridy = 1;
				panel.add(lblBarcode, gbc_lblBarcode);
			}
			{
				txtBarcode = new JTextField();
				GridBagConstraints gbc_txtBarcode = new GridBagConstraints();
				gbc_txtBarcode.insets = new Insets(0, 0, 5, 0);
				gbc_txtBarcode.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtBarcode.gridx = 1;
				gbc_txtBarcode.gridy = 1;
				panel.add(txtBarcode, gbc_txtBarcode);
				txtBarcode.setColumns(10);
			}
			{
				JLabel lblPackProducts = new JLabel("Produkter:");
				GridBagConstraints gbc_lblPackProducts = new GridBagConstraints();
				gbc_lblPackProducts.insets = new Insets(0, 0, 0, 5);
				gbc_lblPackProducts.gridx = 0;
				gbc_lblPackProducts.gridy = 2;
				panel.add(lblPackProducts, gbc_lblPackProducts);
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridx = 1;
				gbc_scrollPane.gridy = 2;
				panel.add(scrollPane, gbc_scrollPane);
				{
					tblProductTable = new JTable();
					scrollPane.setViewportView(tblProductTable);
				}
			}
			
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.NORTH);
			{
				JLabel lblHeader = new JLabel("Pakkemenu");
				lblHeader.setFont(new Font("Tahoma", Font.BOLD, 16));
				panel.add(lblHeader);
			}
		}
		
	}

	
	

	


	private void init(ProductCtrl ctrl) {
		this.ctrl = ctrl;
		tableModel = new PackLineTableModel();
		this.tblProductTable.setModel(tableModel);
		insertPackInformation();
	}
	
	private void addProductButtonClicked() {
			AddProduct apto = new AddProduct(ctrl);
			apto.setVisible(true);
			refresh();
	}

	private void refresh() {
		List<PackLine> currPack = ctrl.getPackLines();
		this.tableModel.setModelData(currPack);
	}
	
	private void okButtonClicked() {
		this.dispose();
	}
	
	private void cancelButtonClicked() {
		ctrl.deleteProduct(ctrl.findProduct(ctrl.getPackBarcode()));
		this.dispose();
	}
	
	private void insertPackInformation() {
		txtName.setText(ctrl.getPackName());
		txtBarcode.setText(ctrl.getPackBarcode());
		txtName.setEditable(false);
		txtBarcode.setEditable(false);
	}

}
