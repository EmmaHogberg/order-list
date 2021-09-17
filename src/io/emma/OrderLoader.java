package io.emma;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class OrderLoader {

    // Load all info from CSV to orderBean
    public static void loadAll(ArrayList<OrderBean> orderBeans) {

        for (int i = 1; i < ReadCsv.getWholeSheet().size(); i++) {

            OrderBean order = new OrderBean(Integer.parseInt(ReadCsv.getWholeSheet().get(i).get(0)),
                    ReadCsv.getWholeSheet().get(i).get(1), ReadCsv.getWholeSheet().get(i).get(2),
                    ReadCsv.getWholeSheet().get(i).get(3), ReadCsv.getWholeSheet().get(i).get(4),
                    ReadCsv.getWholeSheet().get(i).get(5), ReadCsv.getWholeSheet().get(i).get(6),
                    ReadCsv.getWholeSheet().get(i).get(7),
                    ReadCsv.getWholeSheet().get(i).get(8));

            orderBeans.add(order);
        }
    }

}
