package Supermarket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class CustomerLogin extends JFrame  {
    LinkedList<Customer> customerList=new LinkedList<Customer>();
    JLabel customerName = new JLabel("Customer Name");
    JLabel customerPhoneNo = new JLabel("Phone No");
    JLabel email = new JLabel("Email");
    JTextField custNameField = new JTextField(25);
    JTextField custPhoneNoField = new JTextField(25);
    JTextField emailField = new JTextField(25);
    JButton loginButton = new JButton("PURCHASE ORDER");
    JButton resetButton = new JButton("RESET");

    CustomerLogin() {
        JPanel panelNorth = new JPanel();
        JLabel label = new JLabel("~ Welcome To Hypermarket Self-Checkout Automated System ~");
        label.setForeground(Color.red);//set font color of text
        label.setFont(new Font("MV Boli", Font.BOLD, 25));//set font of text
        panelNorth.add(label);
        panelNorth.add(new JLabel(""));
        add(panelNorth, BorderLayout.NORTH);


        JPanel panelCenter = new JPanel(new GridLayout(3, 2));
        panelCenter.add(customerName);
        panelCenter.add(custNameField);
        panelCenter.add(email);
        panelCenter.add(emailField);
        panelCenter.add(customerPhoneNo);
        panelCenter.add(custPhoneNoField);
        add(panelCenter, BorderLayout.CENTER);

        JPanel panelSouth = new JPanel();
        panelSouth.add(loginButton);
        panelSouth.add(resetButton);
        add(panelSouth, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
        pack();
        //setBounds(100,100,450,350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Supermarket Info Center");


        loginButton.addActionListener(new LoginListener());
        resetButton.addActionListener(new ResetListener());


    }

    public class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Customer customer=new Customer(custNameField.getText(),custPhoneNoField.getText(),emailField.getText());
            customerList.add(customer);
            new Menu(customer);
        }
    }

    public class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            custNameField.setText("");
            custPhoneNoField.setText("");
            email.setText("");
        }
    }

    public static void main(String[] a) {
        CustomerLogin frame = new CustomerLogin();
    }


}
