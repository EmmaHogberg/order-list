package io.emma;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class OrderLoader {
    private static final DateFormat orderDateFormatter = new SimpleDateFormat("MM/dd/yyyy");



    // Check if orderBean is loaded, if not load it, and return orderBean
//    public static ArrayList<OrderBean> getAllOrders() {
//
//        if (orderBeans.isEmpty()) {
//            loadAll();
//        }
//        return orderBeans;
//    }


    // Load all info from CSV to orderBean
    public static void loadAll(ArrayList<OrderBean> orderBeans) {

        for (int i = 1; i < ReadCsv.getWholeSheet().size(); i++) {

            //Format orderDate to Date
            Date orderDate = null;
            try {
                orderDate = orderDateFormatter.parse(ReadCsv.getWholeSheet().get(i).get(1));
            }catch (ParseException e) {
                e.printStackTrace();
            }


            OrderBean order = new OrderBean(Integer.parseInt(ReadCsv.getWholeSheet().get(i).get(0)),
                    orderDate, ReadCsv.getWholeSheet().get(i).get(2),
                    ReadCsv.getWholeSheet().get(i).get(3), ReadCsv.getWholeSheet().get(i).get(4),
                    ReadCsv.getWholeSheet().get(i).get(5), new BigDecimal((ReadCsv.getWholeSheet().get(i).get(6))),
                    new BigDecimal(ReadCsv.getWholeSheet().get(i).get(7)),
                    new BigDecimal(ReadCsv.getWholeSheet().get(i).get(8)));

            orderBeans.add(order);
        }
    }
}
