package Supermarket;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PaymentInterface extends JFrame {

    private JPanel panel = new JPanel();
    private JRadioButton jrbCC = new JRadioButton("Credit Card");
    private JRadioButton jrbDC = new JRadioButton("Debit Card");
    private JRadioButton jrbOB = new JRadioButton("Online Banking");
    private ButtonGroup buttonGroup = new ButtonGroup();//Allow one radio button selected

    private JTextField jtfCusName=new JTextField();
    private JTextField jtfTicketTotals=new JTextField();
    private JTextField jtfTotalPrice=new JTextField();
    private JTextField jtfBookingDate=new JTextField();

    private JCheckBox jckAgree = new JCheckBox("Agree");
    private JTextArea jTextArea = new JTextArea("These Terms and Conditions govern the relationship between you as a Customer ('Customer(s)')for providing you an access to purchase items \n" +
            "By purchasing through counter or online transaction, you have unconditionally agreed to be legally bound by these Terms and Conditions that outlined, among other things,\n the refund, exchange and " +
            "cancellation policy together with certain limitations of liability and disclaimers");

    private JButton jbtSubmit = new JButton("Submit");
    private JButton jbtCancel = new JButton("Cancel");


    PaymentInterface(Customer customer, ArrayList<ItemInformation> carts) {
        buttonGroup.add(jrbCC);
        buttonGroup.add(jrbDC);
        buttonGroup.add(jrbOB);

        panel.setBorder(new TitledBorder("Payment Summary"));
        panel.setLayout(new GridLayout(5,4));
        panel.add(new JLabel("Customer Name"));
        jtfCusName.setEditable(false);
        jtfCusName.setText(customer.getName());
        panel.add(jtfCusName);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));

        panel.add(new JLabel("Total Ordered Purchase"));
        int qty=0;
        for(ItemInformation itemInformation:carts){
            qty+=itemInformation.getQty();
        }
        jtfTicketTotals.setText(String.valueOf(qty));
        jtfTicketTotals.setEditable(false);
        panel.add(jtfTicketTotals);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));

        //Count ticket price
        double totalPrice=0;
        for(ItemInformation cart:carts){
            totalPrice+=cart.getItemPrice();
        }
        panel.add(new JLabel("Total Price"));
        jtfTotalPrice.setText("RM "+String.format("%.2f",totalPrice));
        jtfTotalPrice.setEditable(false);
        panel.add(jtfTotalPrice);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));

        panel.add(new JLabel("Purchase Date"));
        jtfBookingDate.setText(String.valueOf(carts.get(0).getDatePurchase()));
        jtfBookingDate.setEditable(false);
        panel.add(jtfBookingDate);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));


        panel.add(new JLabel("Payment Method"));
        panel.add(jrbCC);
        panel.add(jrbDC);
        panel.add(jrbOB);
        add(panel, BorderLayout.NORTH);

        JPanel panelCenter = new JPanel();
        panelCenter.add(jckAgree);
        panelCenter.add(jTextArea);
        add(panelCenter, BorderLayout.CENTER);
        jckAgree.addActionListener(new radioBtnListener());
        jTextArea.setEditable(false);

        JPanel panelSouth = new JPanel();
        panelSouth.add(jbtSubmit);
        panelSouth.add(jbtCancel);
        jbtSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((jrbCC.isSelected() || jrbDC.isSelected() || jrbOB.isSelected()) && jckAgree.isSelected()) {
                    int option = JOptionPane.showConfirmDialog(null, "Are you sure to confirm the payment ?");
                    if (option == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null,"Counter 1","Thank you for purchase our orders !",JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,"Please select payment method and check the agree box");
                }
            }
        });


        add(panelSouth, BorderLayout.SOUTH);


        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Payment Gateway");
        pack();

    }

    public class radioBtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (jckAgree.isSelected()) {
                JOptionPane.showMessageDialog(null, "Terms and conditions agreed");
            }
        }
    }


}
