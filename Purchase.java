package Supermarket;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.time.LocalDate; // import the LocalDate class

public class Purchase extends JFrame {
    private JLabel jlTitle = new JLabel("Supermarket Purchase");
    private JLabel jlProductCode = new JLabel("Enter Product Code : ");
    private JTextField jtfCode = new JTextField();
    private JLabel jlQty = new JLabel("Quantity");
    private JTextField jtfQty = new JTextField();
    private JButton jbtAddCart = new JButton("Add To Carts");
    private JButton jbtCancel = new JButton("Cancel");
    ArrayList<ItemInformation> carts = new ArrayList<>();

    String[] beauty = {"Dove Body Wash Sensitive 550ml",
            "Nivea Cream", "Dettol Showel Foam Re Energize", "Men's Biore Oil Clear",
            "Pantene Shampoo Total Damage Care", "Lux Soap Soft Touch 3*80g", "Colgate Tooth Brush Twister Medium",
            "Cotton Buds Drum", "Vaseline Petroleum Jelly Aloe", "Listerine Cool Mint"};

    Double[] beautyPrice = {18.40, 9.20, 10.20, 17.50, 13.00, 6.60, 5.00, 6.00, 7.00, 5.60};

    String[] snacks = {"Snacks & Confectionery", "Baked Cashew Nuts", "Chocolate Popcorn", "Lay's Classic",
            "Teiwsties", "BBQ chips", "Popky Cookies & Cream", "Mister Potato", "Lexus", "Eclipse"
    };

    Double[] snackPrice = {21.50, 3.80, 17.80, 3.30, 9.30, 3.80, 3.50, 7.40, 6.60, 9.30};


    public Purchase(Customer customer) {
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new GridLayout(4, 2));
        panelNorth.add(jlTitle);
        panelNorth.add(new JLabel());
        panelNorth.add(new JLabel());
        panelNorth.add(new JLabel());
        jlTitle.setFont(new Font("Verdana", Font.BOLD, 20));
        jlTitle.setForeground(Color.RED);
        panelNorth.add(jlProductCode);
        panelNorth.add(jtfCode);
        panelNorth.add(jlQty);
        panelNorth.add(jtfQty);
        add(panelNorth, BorderLayout.NORTH);


        JPanel panelSouth = new JPanel();
        panelSouth.add(jbtAddCart);
        panelSouth.add(jbtCancel);
        add(panelSouth, BorderLayout.SOUTH);

        jbtAddCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean checkValidCode = false;
                for (int i = 0; i < 10; i++) {
                    if (jtfCode.getText().equals(String.format("B%03d", i + 1))) {
                        checkValidCode = true;
                        break;
                    }
                    if (jtfCode.getText().equals(String.format("S%03d", i + 1))) {
                        checkValidCode = true;
                        break;
                    }
                }
                boolean checkInt = false;
                //Validation
                try {
                    int qty = Integer.parseInt(jtfQty.getText());
                    checkInt = true;
                } catch (Exception exception) {
                    checkInt = false;
                }
                if (jtfQty.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter quantity");
                }
                if (checkValidCode == false) {
                    JOptionPane.showMessageDialog(null, "Invalid Product Code !");
                } else if (checkInt == false) {
                    JOptionPane.showMessageDialog(null, "Invalid Quantity !");
                } else {
                    for (int i = 0; i < beauty.length; i++) {
                        if (jtfCode.getText().equals(String.format("B%03d", i + 1))) {
                            carts.add(new ItemInformation(jtfCode.getText(), beauty[i], Integer.parseInt(jtfQty.getText()), beautyPrice[i], LocalDate.now()));
                        }
                        if (jtfCode.getText().equals(String.format("S%03d", i + 1))) {
                            carts.add(new ItemInformation(jtfCode.getText(), snacks[i], Integer.parseInt(jtfQty.getText()), snackPrice[i], LocalDate.now()));
                        }
                    }
                    new Cart(customer, carts);
                }
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Supermarket Info Center");
    }
}

