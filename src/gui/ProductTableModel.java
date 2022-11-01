package gui;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import model.Item;

public class ProductTableModel extends DefaultTableModel {

	private static final String[] COLUMN_NAMES = { "Navn", "Antal på lager" };
	private ArrayList<Item> elements;

	public ProductTableModel() {
		elements = new ArrayList<>();
	}

	public void setModelData(Item item) {
		elements.clear();
		if(item != null) {
			elements.add(item);
		}
		super.fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		int res = 0;
		if (elements != null) {
			res = elements.size();
		}
		return res;
	}

	@Override
	public int getColumnCount() {
		return COLUMN_NAMES.length;
	}

	@Override
	public String getColumnName(int column) {
		return COLUMN_NAMES[column];
	}

	@Override
	public Object getValueAt(int row, int column) {
		Item product = elements.get(row);
		String res = "UNKNOWN";
		switch (column) {
		case 0:
			res = product.getName();
			break;
		case 1:
			res = Double.toString(product.getStock());
			break;

		}
		return res;
	}

	public Item getElementAtIndex(int selectedRow) {
		if (elements.size() < 1) {
			return null;
		}
		return elements.get(selectedRow);
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		// all cells false
		return false;
	}
}
