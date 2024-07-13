package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class BookHotel extends JFrame {
    private JPanel contentPane;
    JTextField t1, t2, t3;
    Choice c3;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BookHotel frame = new BookHotel("");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public BookHotel(String username) {
        setBounds(420, 220, 1100, 600);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/book.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(450, 100, 700, 300);
        add(la1);

        JLabel lblName = new JLabel("BOOK HOTEL");
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblName.setBounds(118, 11, 300, 53);
        contentPane.add(lblName);

        JLabel la2 = new JLabel("Username:");
        la2.setBounds(35, 70, 200, 14);
        contentPane.add(la2);

        JLabel l1 = new JLabel(username);
        l1.setBounds(271, 70, 200, 14);
        contentPane.add(l1);

        JLabel lblHotelName = new JLabel("Hotel Name:");
        lblHotelName.setBounds(35, 110, 200, 14);
        contentPane.add(lblHotelName);

        t1 = new JTextField();
        t1.setBounds(271, 110, 150, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        JLabel la3 = new JLabel("Total Persons:");
        la3.setBounds(35, 150, 200, 14);
        contentPane.add(la3);

        t2 = new JTextField();
        t2.setText("0");
        t2.setBounds(271, 150, 150, 20);
        contentPane.add(t2);
        t2.setColumns(10);

        JLabel la4 = new JLabel("Number of Days:");
        la4.setBounds(35, 190, 200, 14);
        contentPane.add(la4);

        t3 = new JTextField();
        t3.setText("0");
        t3.setBounds(271, 190, 150, 20);
        contentPane.add(t3);
        t3.setColumns(10);

        JLabel la6 = new JLabel("Food Included:");
        la6.setBounds(35, 230, 200, 14);
        contentPane.add(la6);

        c3 = new Choice();
        c3.add("Yes");
        c3.add("No");
        c3.setBounds(271, 230, 150, 30);
        add(c3);

        JButton btnNewButton = new JButton("Book");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Conn c = new Conn();
                try {
                    String query = "insert into bookHotel8 (username, hotel_name, total_persons, number_of_days, food_included) values('" + l1.getText() + "', '" + t1.getText() + "', '" + t2.getText() + "', '" + t3.getText() + "', '" + c3.getSelectedItem() + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                    setVisible(false);
                } catch (Exception ee) {
                    System.out.println(ee.getMessage());
                }
            }
        });
        btnNewButton.setBounds(200, 310, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnExit.setBounds(350, 310, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);
    }
}
