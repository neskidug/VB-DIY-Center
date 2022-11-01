package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.OrderCtrl;
import model.OrderLine;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

public class OrderTableGUI extends JFrame {

	private JPanel contentPane;
	private OrderCtrl ctrl;
	private OrderTableModel tableModel;
	private JTable tblOrderTable;
	private JLabel lblSubTotal;
	private JLabel lblDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderTableGUI frame = new OrderTableGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public OrderTableGUI(OrderCtrl ctrl) {
		this();
		init(ctrl);
	}

	/**
	 * Create the frame.
	 * 
	 * @param ctrl
	 */
	public OrderTableGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);

		tblOrderTable = new JTable();
		tblOrderTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tblOrderTable);

		JPanel Header = new JPanel();
		contentPane.add(Header, BorderLayout.NORTH);
		Header.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Ordre");
		Header.add(lblNewLabel, BorderLayout.NORTH);
		lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(lblNewLabel.getFont().getStyle() | Font.BOLD, 16f));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Header.add(panel_1, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 46, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 14, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblCustomerName = new JLabel("Kunde: ");
		GridBagConstraints gbc_lblCustomerName = new GridBagConstraints();
		gbc_lblCustomerName.insets = new Insets(0, 0, 5, 0);
		gbc_lblCustomerName.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCustomerName.gridx = 0;
		gbc_lblCustomerName.gridy = 0;
		panel_1.add(lblCustomerName, gbc_lblCustomerName);

		lblDate = new JLabel("Dato: ");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 1;
		panel_1.add(lblDate, gbc_lblDate);

		Panel panel_2 = new Panel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel_2.add(panel, BorderLayout.EAST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 95, 69, 0, 0, 51, 89, 0 };
		gbl_panel.rowHeights = new int[] { 23, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JButton btnAddProduct = new JButton("Tilføj produkt");
		GridBagConstraints gbc_btnAddProduct = new GridBagConstraints();
		gbc_btnAddProduct.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddProduct.gridx = 2;
		gbc_btnAddProduct.gridy = 0;
		panel.add(btnAddProduct, gbc_btnAddProduct);
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProductClicked();
			}
		});

		JButton btnEdit = new JButton("Redigér");
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnEdit.insets = new Insets(0, 0, 0, 5);
		gbc_btnEdit.gridx = 3;
		gbc_btnEdit.gridy = 0;
		panel.add(btnEdit, gbc_btnEdit);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditButtonClicked();
			}
		});

		JButton btnDelete = new JButton("Slet");
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnDelete.insets = new Insets(0, 0, 0, 5);
		gbc_btnDelete.gridx = 4;
		gbc_btnDelete.gridy = 0;
		panel.add(btnDelete, gbc_btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteButtonClicked();
			}
		});

		JButton btnClose = new JButton("Afslut ordre");
		GridBagConstraints gbc_btnClose = new GridBagConstraints();
		gbc_btnClose.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnClose.gridx = 5;
		gbc_btnClose.gridy = 0;
		panel.add(btnClose, gbc_btnClose);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				endOrderButtonClicked();
			}
		});

		Panel pnlSubTotal = new Panel();
		panel_2.add(pnlSubTotal, BorderLayout.NORTH);

		lblSubTotal = new JLabel("Subtotal: ");
		lblSubTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSubTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		GroupLayout gl_pnlSubTotal = new GroupLayout(pnlSubTotal);
		gl_pnlSubTotal.setHorizontalGroup(gl_pnlSubTotal.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlSubTotal
				.createSequentialGroup().addGap(346).addComponent(lblSubTotal).addContainerGap(81, Short.MAX_VALUE)));
		gl_pnlSubTotal.setVerticalGroup(gl_pnlSubTotal.createParallelGroup(Alignment.LEADING).addComponent(lblSubTotal,
				Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE));
		pnlSubTotal.setLayout(gl_pnlSubTotal);
	}

	private void init(OrderCtrl ctrl) {
		this.ctrl = ctrl;
		tableModel = new OrderTableModel();
		this.tblOrderTable.setModel(tableModel);
		lblDate.setText("Dato: " + ctrl.getOrderDate().toString());
	}

	private void refresh() {
		List<OrderLine> currOrder = ctrl.getOrderLines();
		this.tableModel.setModelData(currOrder);
		updateSubTotal();
	}

	private void updateSubTotal() {
		String subTotal = Double.toString(ctrl.getPrice());
		System.out.println(subTotal);
		lblSubTotal.setText("Subtotal: " + subTotal + " kr.");

	}

	private void addProductClicked() {
		AddProduct ap = new AddProduct(ctrl);
		ap.setVisible(true);
		refresh();
	}

	private void deleteButtonClicked() {
		int selectedRow = tblOrderTable.getSelectedRow();
		OrderLine currLine = tableModel.getElementAtIndex(selectedRow);
		if (currLine != null) {
			ctrl.removeProduct(currLine.getBarcode(), currLine.getQuantity());
			refresh();
		} else {
			JOptionPane.showMessageDialog(this, "Markér en linje.");
		}
	}

	private void endOrderButtonClicked() {

		if (tableModel.getElementAtIndex(0) != null) {
			OrderGUI og = new OrderGUI();
			og.setVisible(true);
			ctrl.endOrder();
			this.dispose();
			JOptionPane.showMessageDialog(this, "Ordre registreret.");
		} else {
			int result = JOptionPane.showConfirmDialog(this, "Er du sikker på at du vil lukke?", "Bekræft",
					JOptionPane.YES_NO_OPTION);
			if (result == 0) {
				OrderGUI og = new OrderGUI();
				og.setVisible(true);
				this.dispose();
			}
			}
		}

	private void EditButtonClicked() {
		int selectedRow = -1;
		OrderLine currLine = null;
		if(tblOrderTable.getSelectedRow() > -1) {
			selectedRow = tblOrderTable.getSelectedRow();
			currLine = tableModel.getElementAtIndex(selectedRow);
		} else {
			JOptionPane.showMessageDialog(this, "Vælg en linje.");
		}
		if (currLine != null) {
			AddProduct ap = new AddProduct(ctrl, currLine);
			ap.setVisible(true);
			refresh();
		}
	}
}
