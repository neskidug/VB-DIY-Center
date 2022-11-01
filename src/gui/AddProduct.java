package gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OrderCtrl;
import controller.ProductCtrl;
import model.OrderLine;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddProduct extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtBarcode;
	private JTextField txtQuantity;
	private OrderCtrl ctrl;
	private ProductCtrl pctrl;
	private JLabel lblHeader;
	private boolean editing;
	private boolean creatingPack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddProduct dialog = new AddProduct();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AddProduct(OrderCtrl ctrl) {
		this();
		init(ctrl, null);
	}

	public AddProduct(ProductCtrl pctrl) {
		this();
		init(pctrl);
	}

	public AddProduct(OrderCtrl ctrl, OrderLine currLine) {
		this();
		this.init(ctrl, currLine);
	}

	/**
	 * Create the dialog.
	 */
	public AddProduct() {
		setModal(true);
		setBounds(100, 100, 350, 200);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 334, 161);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			lblHeader = new JLabel("Tilføj produkt");
			lblHeader.setFont(lblHeader.getFont().deriveFont(lblHeader.getFont().getStyle() | Font.BOLD, 16f));
			lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
			lblHeader.setBounds(10, 0, 300, 24);
			contentPanel.add(lblHeader);
		}
		{
			JLabel lblBarcode = new JLabel("Stregkode:");
			lblBarcode.setBounds(10, 38, 74, 14);
			contentPanel.add(lblBarcode);
		}
		{
			txtBarcode = new JTextField();
			txtBarcode.setHorizontalAlignment(SwingConstants.LEFT);
			txtBarcode.setBounds(81, 35, 229, 20);
			contentPanel.add(txtBarcode);
			txtBarcode.setColumns(10);
		}
		{
			JLabel lblQuantity = new JLabel("Antal: ");
			lblQuantity.setBounds(10, 77, 46, 14);
			contentPanel.add(lblQuantity);
		}
		{
			txtQuantity = new JTextField();
			txtQuantity.setHorizontalAlignment(SwingConstants.LEFT);
			txtQuantity.setBounds(81, 74, 229, 20);
			contentPanel.add(txtQuantity);
			txtQuantity.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 126, 334, 34);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton btnOK = new JButton("OK");
				btnOK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						OKButtonClicked();
					}
				});
				btnOK.setActionCommand("OK");
				buttonPane.add(btnOK);
				getRootPane().setDefaultButton(btnOK);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						closeDialogue();
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}

	}

	private void init(OrderCtrl ctrl, OrderLine currLine) {
		this.ctrl = ctrl;
//		this.currLine = currLine;
		if (currLine != null) {
			txtBarcode.setText(currLine.getBarcode());
			txtQuantity.setText("" + currLine.getQuantity());
			editQuantity();
		}

	}

	private void init(ProductCtrl pctrl) {
		this.pctrl = pctrl;
		addToPack();

	}

	private void OKButtonClicked() {
		String barcode = txtBarcode.getText();
		StringBuilder strb = new StringBuilder(100);
		double quantity = 0d;
		double oldQuantity = 0d;
		boolean hasError = false;

		if (quantity > 0) {
			oldQuantity = quantity;
		}
		
		if (isANumber(txtQuantity.getText()) && !txtQuantity.getText().isBlank()) {
			if (Double.parseDouble(txtQuantity.getText()) % 1 == 0 || Double.parseDouble(txtQuantity.getText()) == 0) {
				quantity = Double.parseDouble(txtQuantity.getText());
			} else {
				JOptionPane.showMessageDialog(this, "Antal skal være et helt tal.\n");
				return;
			}
		}
		
		if (!creatingPack) {
			if (ctrl.findProduct(barcode) == null) {
				strb.append("Produktet findes ikke.\n");
				hasError = true;
			} else if (ctrl.findProduct(barcode).getStock() < quantity) {
				strb.append("Ikke nok varer på lager.\n");
				hasError = true;
			}
		}
		

		if (quantity <= 0) {
			strb.append("Antallet skal være større end nul.\n");
			quantity = oldQuantity;
			hasError = true;
		}

		if (!creatingPack) {
			try {
				if (!hasError && !editing) {
					ctrl.addProduct(barcode, quantity);
				} else if (!hasError && editing) {
					ctrl.removeProduct(barcode, quantity);
					editing = false;
					ctrl.addProduct(barcode, quantity);
				}
			} catch (NumberFormatException e) {

				e.printStackTrace();
			} catch (Exception e) {

				e.printStackTrace();
			}
		} else {
			pctrl.addItemToPack(barcode, quantity);
		}

		if (hasError) {
			JOptionPane.showMessageDialog(this, strb.toString());
		} else {
			closeDialogue();
		}

	}

	private void closeDialogue() {
		this.setVisible(false);
		this.dispose();
	}

	public void editQuantity() {
		txtBarcode.setEditable(false);
		lblHeader.setText("Redigèr antal");
		editing = true;
	}

	private void addToPack() {
		creatingPack = true;
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
