package calculator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Calculator extends JFrame implements ActionListener {

    String inputString, mark, model;
    double result, liters, distance, price, cost_1km, cost_100km, costTrip, litersUsed, consumptionUsed;
    java.text.DecimalFormat df = new java.text.DecimalFormat();
    JLabel head, car;
    JMenuBar menuBar;
    JMenu menuEdit, menuHelp;
    JMenuItem mchooseCar, mchangeAppColor, mexit, mabout, minfo;
    JFrame okienko;
    JButton button = new JButton("Consumption l/100km");
    JButton button1 = new JButton("Cost of 1km");
    JButton button2 = new JButton("Cost of 100km");
    JButton button3 = new JButton("Cost of your trip");

    public Calculator() {

        setSize(500, 700);
        setLocationRelativeTo(null);
        setTitle("Fuel consumption calculator");
        setLayout(null);

        menuBar = new JMenuBar();
        menuEdit = new JMenu("Edit");
        menuHelp = new JMenu("Help");
        mchooseCar = new JMenuItem("Choose car");
        mchangeAppColor = new JMenuItem("Change app color");
        mexit = new JMenuItem("Exit");
        mabout = new JMenuItem("About");
        minfo = new JMenuItem("Info");
        menuBar.setBackground(Color.WHITE);
        menuEdit.setBackground(Color.WHITE);
        menuHelp.setBackground(Color.WHITE);
        mchooseCar.setBackground(Color.WHITE);
        mchangeAppColor.setBackground(Color.WHITE);
        mexit.setBackground(Color.WHITE);
        mabout.setBackground(Color.WHITE);
        minfo.setBackground(Color.WHITE);

        setJMenuBar(menuBar);
        menuBar.add(menuEdit);
        menuBar.add(menuHelp);
        menuEdit.add(mchooseCar);
        menuEdit.add(mchangeAppColor);
        menuEdit.addSeparator();
        menuEdit.add(mexit);
        menuHelp.add(mabout);
        menuHelp.add(minfo);

        mchooseCar.addActionListener((ActionEvent e) -> {
            chooseCar();
        });

        mchangeAppColor.addActionListener((ActionEvent e) -> {
            changeColorApp();
        });

        mexit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        mabout.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "This is a fuel consuption calculator");
        });

        minfo.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "This app is made by Kasjan Różycki");
        });

        head = new JLabel("FUEL CONSUPTION CALCULATOR");
        head.setBounds(160, 25, 300, 50);
        add(head);

        car = new JLabel();
        car.setBounds(160, 75, 300, 50);
        add(car);

        button.setBackground(Color.LIGHT_GRAY);
        button.setBounds(125, 150, 250, 50);
        add(button);
        setVisible(true);
        button.addActionListener((ActionEvent e) -> {
            consumption();
        });

        button1.setBackground(Color.LIGHT_GRAY);
        button1.setBounds(125, 250, 250, 50);
        add(button1);
        button1.addActionListener((ActionEvent e) -> {
            cost1();
        });

        button2.setBackground(Color.LIGHT_GRAY);
        button2.setBounds(125, 350, 250, 50);
        add(button2);
        button2.addActionListener((ActionEvent e) -> {
            cost100();
        });

        button3.setBackground(Color.LIGHT_GRAY);
        button3.setBounds(125, 450, 250, 50);
        add(button3);
        button3.addActionListener((ActionEvent e) -> {
            costTrip();
        });
    }

    public void getLiters() {
        inputString = JOptionPane.showInputDialog("How many liters you filled up? ");
        try {
            liters = Double.parseDouble(inputString);
            System.out.println("Your number is: " + liters);
        } catch (NumberFormatException e) {
            System.err.println("This is not a number!");
        }
        while (liters <= 0) {
            inputString = JOptionPane.showInputDialog("How many liters you filled up? \n(Amout must be more than 0.)");
            liters = Double.parseDouble(inputString);
        }
    }

    public void getLitersUsed() {
        inputString = JOptionPane.showInputDialog("How many liters you used? ");
        try {
            litersUsed = Double.parseDouble(inputString);
            System.out.println("Your number is: " + litersUsed);
        } catch (NumberFormatException e) {
            System.err.println("This is not a number!");
        }
        while (litersUsed <= 0) {
            inputString = JOptionPane.showInputDialog("How many liters you used? \n(Amout must be more than 0.)");
            litersUsed = Double.parseDouble(inputString);
        }
    }

    public void getDistance() {
        inputString = JOptionPane.showInputDialog("What is distance you done? ");
        try {
            distance = Double.parseDouble(inputString);
            System.out.println("Your number is: " + distance);
        } catch (NumberFormatException e) {
            System.err.println("This is not a number!");
        }
        while (distance <= 0) {
            inputString = JOptionPane.showInputDialog("What is distance you done? \n(Distans must be more than 0.)");
            distance = Double.parseDouble(inputString);
        }
    }

    public void getPrice() {
        inputString = JOptionPane.showInputDialog("The price you paid for one liter of petrol? ");
        try {
            price = Double.parseDouble(inputString);
            System.out.println("Your number is: " + price);
        } catch (NumberFormatException e) {
            System.err.println("This is not a number!");
        }
        while (price <= 0) {
            inputString = JOptionPane.showInputDialog("The price you paid for one liter of petrol? \n(Price must be more than 0)");
            price = Double.parseDouble(inputString);
        }
    }

    public void getMark() {
        mark = JOptionPane.showInputDialog("Your car mark:");
    }

    public void getModel() {
        model = JOptionPane.showInputDialog("Your " + mark + " model:");
    }

    public void chooseCar() {
        getMark();
        getModel();
        car.setText(mark + " " + model);
    }

    public void changeColorApp() {

        menuBar.setBackground(Color.BLACK);
        button.setBackground(Color.WHITE);
        button1.setBackground(Color.WHITE);
        button2.setBackground(Color.WHITE);
        button3.setBackground(Color.WHITE);
        menuBar.setBackground(Color.BLACK);
        menuEdit.setBackground(Color.BLACK);
        menuHelp.setBackground(Color.BLACK);
        mchooseCar.setBackground(Color.BLACK);
        mchangeAppColor.setBackground(Color.BLACK);
        mexit.setBackground(Color.BLACK);
        mabout.setBackground(Color.BLACK);
        minfo.setBackground(Color.BLACK);
        car.setBackground(Color.WHITE);
        head.setBackground(Color.WHITE);

    }

    public void consumption() {
        getLitersUsed();
        getDistance();
        consumptionUsed = litersUsed / distance * 100;
        endResult();
    }

    public void result() {
        getLiters();
        getDistance();
        getPrice();
        result = liters / distance * 100;
    }

    public void cost100() {
        result();
        cost_100km = result * price;
        endResult();
    }

    public void cost1() {
        result();
        cost_1km = result / 100 * price;
        endResult();
    }

    public void costTrip() {
        result();
        costTrip = cost_1km * distance;
        endResult();
    }

    public void endResult() {
        df.setMaximumFractionDigits(2);
        if (consumptionUsed > 0) {
            JOptionPane.showMessageDialog(null, mark + " " + model + "\nYour fuel consumption is: " + df.format(consumptionUsed) + " liters per 100km");
        } else if (cost_100km > 0) {
            JOptionPane.showMessageDialog(null, mark + " " + model + "\nYour cost of 100km is: " + df.format(cost_100km) + " $");
        } else if (cost_1km > 0) {
            JOptionPane.showMessageDialog(null, mark + " " + model + "\nYour cost of 1km is: " + df.format(cost_1km) + " $");
        } else if (costTrip > 0) {
            JOptionPane.showMessageDialog(null, mark + " " + model + "\nYour cost of 1km is: " + df.format(costTrip) + " $");
        }

        System.exit(0);
    }

    public static void main(String[] args) {

        new Calculator();
        Calculator okienko = new Calculator();
        okienko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okienko.setVisible(true);
        okienko.getContentPane().setBackground(Color.WHITE);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
