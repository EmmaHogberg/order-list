package io.emma;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;

public class OrderView extends JFrame {

    private JPanel topPanel;
    private JPanel orderPanel;

    private JPanel bottomPanel;
    private JLabel headerLabel;

    private JTable orderTable;
    private DefaultTableModel dtm;

    private JPanel newOrderPanel;
    private JLabel addNewOrderLabel;
    private JTextField orderdateInput;
    private JTextField regionInput;
    private JTextField rep1Input;
    private JTextField rep2Input;
    private JTextField itemInput;
    private JTextField unitsInput;
    private JTextField unitCostInput;
    private JTextField totalInput;
    private JButton SAVE;


    public OrderView() {
        this.setTitle("Order center");
        this.setSize(900, 600);
        this.setResizable(false);

        topPanel = new JPanel();
        headerLabel = new JLabel("Order center");
        topPanel.add(headerLabel);

        // CSV print
//        orderPanel = new JPanel();
//        orderPanel.setSize(400, 200);
//        orderPanel.setBackground(Color.CYAN);
        orderTable = new JTable();
        orderTable.setShowVerticalLines(true);
        orderTable.setCellSelectionEnabled(false);
        orderTable.setColumnSelectionAllowed(true);
        orderTable.setAutoCreateRowSorter(true);
//        orderTable.setBorder(new LineBorder(Color.BLACK));
//        dtm = new DefaultTableModel(0, 0);
        dtm = new DefaultTableModel();
        String[] header = new String[]{"Order date", "Region", "Rep1", "Rep2", "Item", "Units", "Unit cost", "Total"};
        dtm.setColumnIdentifiers(header);
        orderTable.setModel(dtm);

        ArrayList<OrderBean> orderBeans = new ArrayList<>();
        OrderLoader.loadAll(orderBeans);


        for (OrderBean order :orderBeans) {
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

//            orderTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        orderTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for (int i = 0; i < 8; i++) {
            orderTable.getColumnModel().getColumn(i).setPreferredWidth(110);
        }



            // Add
            newOrderPanel = new JPanel();
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

            bottomPanel = new JPanel(new GridLayout(3, 1));
            addNewOrderLabel = new JLabel("Add new order", SwingConstants.CENTER);
            SAVE = new JButton("Save");
            bottomPanel.add(addNewOrderLabel);
            bottomPanel.add(newOrderPanel);
            bottomPanel.add(SAVE);


            this.add(topPanel, BorderLayout.NORTH);
            this.add(new JScrollPane(orderTable));
            this.add(bottomPanel, BorderLayout.SOUTH);

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);

        }
    }


