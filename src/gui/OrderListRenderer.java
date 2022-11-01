package gui;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.OrderLine;

public class OrderListRenderer implements ListCellRenderer<OrderLine> {

	@Override
	public Component getListCellRendererComponent(JList<? extends OrderLine> list, OrderLine value, int index,
			boolean isSelected, boolean cellHasFocus) {
		DefaultListCellRenderer dfcr = new DefaultListCellRenderer();
		String res = value.getProduct().getName() + ": " + value.getQuantity();
		return dfcr.getListCellRendererComponent(list, res, index, isSelected, cellHasFocus);
	}

}
