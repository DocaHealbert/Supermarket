package Supermarket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    String[] beauty={"Dove Body Wash Sensitive 550ml",
            "Nivea Cream","Dettol Showel Foam Re Energize","Men's Biore Oil Clear",
            "Pantene Shampoo Total Damage Care","Lux Soap Soft Touch 3*80g","Colgate Tooth Brush Twister Medium",
            "Cotton Buds Drum","Vaseline Petroleum Jelly Aloe","Listerine Cool Mint"};

    Double[] beautyPrice={18.40,9.20,10.20,17.50,13.00,6.60,5.00,6.00,7.00,5.60};

    String[] snacks={"Snacks & Confectionery","Baked Cashew Nuts","Chocolate Popcorn","Lay's Classic",
            "Teiwsties","BBQ chips","Popky Cookies & Cream","Mister Potato","Lexus","Eclipse"
    };

    Double[] snackPrice={21.50,3.80,17.80,3.30,9.30,3.80,3.50,7.40,6.60,9.30};

    Menu(Customer customer){
        JPanel panelNorth=new JPanel();
        JPanel panelSouth=new JPanel();
        JLabel jlBeauty=new JLabel("Beauty & Personal Care");
        JLabel jlSnacks=new JLabel("Snacks & Confectionery");

        JButton jbtPurchase=new JButton("Purchase");
        JButton jbtCancel=new JButton("Cancel");

        panelNorth.setLayout(new GridLayout(25,2));

        panelNorth.add(jlBeauty);
        jlBeauty.setFont(new Font("Verdana", Font.BOLD, 20));
        jlBeauty.setForeground(Color.RED);
        panelNorth.add(new JLabel(""));
        panelNorth.add(new JLabel());
        panelNorth.add(new JLabel());
        for(int i=0;i<beauty.length;i++){
            panelNorth.add(new JLabel(String.format("B%03d >> ",i+1)+beauty[i]));
            panelNorth.add(new JLabel(String.format("RM%.2f",beautyPrice[i])));
        }

        panelNorth.add(new JLabel());
        panelNorth.add(new JLabel());
        panelNorth.add(jlSnacks);
        panelNorth.add(new JLabel());
        panelNorth.add(new JLabel());
        panelNorth.add(new JLabel());
        jlSnacks.setFont(new Font("Verdana", Font.BOLD, 20));
        jlSnacks.setForeground(Color.RED);
        for(int i=0;i<snacks.length;i++){
            panelNorth.add(new JLabel(String.format("S%03d >> ",i+1)+snacks[i]));
            panelNorth.add(new JLabel(String.format("RM%.2f",snackPrice[i])));
        }
        add(panelNorth,BorderLayout.NORTH);
        panelSouth.add(jbtPurchase);
        panelSouth.add(jbtCancel);
        add(panelSouth,BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setVisible(true);
        setBounds(100,100,650,750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Supermarket Menu");
        jbtPurchase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Purchase purchase=new Purchase(customer);
            }
        });
    }

}
