package io.emma;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class OrderView extends JFrame implements ActionListener {

    private JTextField orderdateInput;
    private JTextField regionInput;
    private JTextField rep1Input;
    private JTextField rep2Input;
    private JTextField itemInput;
    private JTextField unitsInput;
    private JTextField unitCostInput;
    private JTextField totalInput;


    public OrderView() {

        // Set up frame
        this.setTitle("Order center");
        this.setSize(920, 600);
        this.setResizable(false);

        // Top panel
        JPanel topPanel = new JPanel();
        JLabel headerLabel = new JLabel("Order center");
        topPanel.add(headerLabel);

        // Table set up and headers for table
        JTable orderTable = new JTable();
        orderTable.setShowVerticalLines(true);
        orderTable.setCellSelectionEnabled(false);
        orderTable.setColumnSelectionAllowed(true);
        orderTable.setAutoCreateRowSorter(true);
        DefaultTableModel dtm = new DefaultTableModel();
        String[] header = new String[]{"Order date", "Region", "Rep1", "Rep2", "Item", "Units", "Unit cost", "Total"};
        dtm.setColumnIdentifiers(header);
        orderTable.setModel(dtm);

        // Get Orderlist from OrderBean and add to table
        ArrayList<OrderBean> orderBeans = new ArrayList<>();
        OrderLoader.loadAll(orderBeans);

        for (OrderBean order : orderBeans) {
            Vector<Object> data = new Vector<Object>();
            data.add(order.getOrderDate());
            data.add(order.getRegion());
            data.add(order.getRep1());
            data.add(order.getRep2());
            data.add(order.getItem());
            data.add(order.getUnits());
            data.add(order.getUnitCost());
            data.add(order.getTotal());
            dtm.addRow(data);
        }

        orderTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for (int i = 0; i < 8; i++) {
            orderTable.getColumnModel().getColumn(i).setPreferredWidth(110);
        }


        // Bottom panel and input fields to add new orders
        JPanel newOrderPanel = new JPanel();
        orderdateInput = new JTextField(10);
        regionInput = new JTextField(10);
        rep1Input = new JTextField(10);
        rep2Input = new JTextField(10);
        itemInput = new JTextField(10);
        unitsInput = new JTextField(10);
        unitCostInput = new JTextField(10);
        totalInput = new JTextField(10);
        newOrderPanel.add(orderdateInput);
        newOrderPanel.add(regionInput);
        newOrderPanel.add(rep1Input);
        newOrderPanel.add(rep2Input);
        newOrderPanel.add(itemInput);
        newOrderPanel.add(unitsInput);
        newOrderPanel.add(unitCostInput);
        newOrderPanel.add(totalInput);

        JPanel bottomPanel = new JPanel(new GridLayout(4, 1));
        JLabel addNewOrderLabel = new JLabel("Add new order", SwingConstants.CENTER);
        JButton save = new JButton("Save");
        save.addActionListener(this);
        JLabel messageToUser = new JLabel("", SwingConstants.CENTER);
        bottomPanel.add(addNewOrderLabel);
        bottomPanel.add(newOrderPanel);
        bottomPanel.add(messageToUser);
        bottomPanel.add(save);

        // Add to frame
        this.add(topPanel, BorderLayout.NORTH);
        this.add(new JScrollPane(orderTable));
        this.add(bottomPanel, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    // ActionListener for save of new orders and add to file
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Klick");

        String[] input = {orderdateInput.getText(), regionInput.getText(), rep1Input.getText(), rep2Input.getText(),
                itemInput.getText(), unitsInput.getText(), unitCostInput.getText(), totalInput.getText()};
        try {
            FileWriter output = new FileWriter("src/Orderlist.csv", true);
            output.append("\n");
            for (int i = 0; i < input.length - 1; i++) {
                output.append(input[i]);
                output.append(",");
            }
            output.append(input[7]);

            output.flush();
            output.close();
            System.out.println("Input saved to CSV");

            JOptionPane.showMessageDialog(null, "Order is saved");
            clearTextInput();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    // Method to clear all input fields
    private void clearTextInput() {
        orderdateInput.setText(null);
        regionInput.setText(null);
        rep1Input.setText(null);
        rep2Input.setText(null);
        itemInput.setText(null);
        unitsInput.setText(null);
        unitCostInput.setText(null);
        totalInput.setText(null);
    }
}


