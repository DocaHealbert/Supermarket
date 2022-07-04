package Supermarket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Cart extends JFrame {
    String[] beauty={"Dove Body Wash Sensitive 550ml",
            "Nivea Cream","Dettol Showel Foam Re Energize","Men's Biore Oil Clear",
            "Pantene Shampoo Total Damage Care","Lux Soap Soft Touch 3*80g","Colgate Tooth Brush Twister Medium",
            "Cotton Buds Drum","Vaseline Petroleum Jelly Aloe","Listerine Cool Mint"};

    Double[] beautyPrice={18.40,9.20,10.20,17.50,13.00,6.60,5.00,6.00,7.00,5.60};
    String[] snacks={"Snacks & Confectionery","Baked Cashew Nuts","Chocolate Popcorn","Lay's Classic",
            "Teiwsties","BBQ chips","Popky Cookies & Cream","Mister Potato","Lexus","Eclipse"
    };
    Double[] snackPrice={21.50,3.80,17.80,3.30,9.30,3.80,3.50,7.40,6.60,9.30};
    ArrayList<ItemInformation> carts = new ArrayList<>();

    Cart(Customer customer,ArrayList<ItemInformation> carts){
        JLabel jlCarts = new JLabel("Your Carts");
        JPanel panelNorth = new JPanel();
        JPanel panelSouth = new JPanel();
        jlCarts.setFont(new Font("MV Boli", Font.BOLD, 25));
        jlCarts.setForeground(Color.BLUE);
        JButton jbtConfirmPayment=new JButton("Make Payment");
        JButton jbtCancel=new JButton("Cancel");
        JPanel panelSubwindow = new JPanel();

        panelNorth.add(jlCarts);

        JLabel id = new JLabel("Item ID");
        JLabel name = new JLabel("Item Name");
        JLabel price = new JLabel("Item Price");
        JLabel qty = new JLabel("Quantity");

        panelSubwindow.add(id);
        panelSubwindow.add(name);
        panelSubwindow.add(price);
        panelSubwindow.add(qty);

        id.setHorizontalAlignment(SwingConstants.CENTER);
        name.setHorizontalAlignment(SwingConstants.CENTER);
        price.setHorizontalAlignment(SwingConstants.CENTER);
        qty.setHorizontalAlignment(SwingConstants.CENTER);

        id.setFont(new Font("Verdana", Font.BOLD, 15));
        name.setFont(new Font("Verdana", Font.BOLD, 15));
        price.setFont(new Font("Verdana", Font.BOLD, 15));
        qty.setFont(new Font("Verdana", Font.BOLD, 15));

        id.setForeground(Color.orange);
        name.setForeground(Color.orange);
        price.setForeground(Color.orange);
        qty.setForeground(Color.orange);

        JLabel jlID, jlName, jlPrice, jlQty;

        for (ItemInformation itemInformation : carts) {
            jlID = new JLabel(itemInformation.getItemId());
            jlName = new JLabel(itemInformation.getItemName());
            jlPrice = new JLabel(String.format("RM%.2f", itemInformation.getItemPrice()));
            jlQty = new JLabel(String.valueOf(itemInformation.getQty()));
            panelSubwindow.add(jlID);
            panelSubwindow.add(jlName);
            panelSubwindow.add(jlPrice);
            panelSubwindow.add(jlQty);
            jlID.setHorizontalAlignment(SwingConstants.CENTER);
            jlName.setHorizontalAlignment(SwingConstants.CENTER);
            jlPrice.setHorizontalAlignment(SwingConstants.CENTER);
            jlQty.setHorizontalAlignment(SwingConstants.CENTER);
        }


        panelSubwindow.setLayout(new GridLayout(carts.size() + 1, 4));
        panelSouth.add(jbtConfirmPayment);
        panelSouth.add(jbtCancel);

        jbtConfirmPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PaymentInterface(customer,carts);
            }
        });

        add(panelSouth, BorderLayout.SOUTH);
        add(panelNorth, BorderLayout.NORTH);
        add(panelSubwindow, BorderLayout.CENTER);//Add subwindow to the mainframe and make it visible
        setTitle("Customer Carts");
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }
}
