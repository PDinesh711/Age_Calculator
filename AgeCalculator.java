import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;

public class AgeCalculator extends JFrame implements ActionListener {
    // Declare components
    private JLabel birthDateLabel, ageLabel;
    private JTextField birthDateField, ageField;
    private JButton calculateButton;

    // Constructor for Age_Calculator
    public AgeCalculator() {
        // Set up window
        setTitle("Age Calculator");
       setLayout(new GridLayout(2,1));
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Initialize components
        birthDateLabel = new JLabel("Enter your birth date (MM/DD/YYYY): ");
        ageLabel = new JLabel("Your age is: ");
        birthDateField = new JTextField(20);
        ageField = new JTextField(5);
        ageField.setEditable(true);
        calculateButton = new JButton("Calculate you Age");
        calculateButton.addActionListener(this);

        // Add components to frame
        JPanel panel = new JPanel();
        panel.add(birthDateLabel);
        panel.add(birthDateField);
        panel.add(calculateButton);
        panel.add(ageLabel);
        panel.add(ageField);
        add(panel);

        // Display window
        setVisible(true);
    }

    // ActionListener method
    public void actionPerformed(ActionEvent event) {
        // Get current date
        Calendar today = Calendar.getInstance();
        int currentYear = today.get(Calendar.YEAR);
        int currentMonth = today.get(Calendar.MONTH);
        int currentDay = today.get(Calendar.DAY_OF_MONTH);

        // Parse birth date input
        String birthDateString = birthDateField.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar birthDate = Calendar.getInstance();
        try {
            birthDate.setTime(dateFormat.parse(birthDateString));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid date format. Please enter MM/DD/YYYY.");
            return;
        }

        // Calculate age
        int birthYear = birthDate.get(Calendar.YEAR);
        int birthMonth = birthDate.get(Calendar.MONTH);
        int birthDay = birthDate.get(Calendar.DAY_OF_MONTH);
        int age = currentYear - birthYear;
        if (currentMonth < birthMonth || (currentMonth == birthMonth && currentDay < birthDay)) {
            age--;
        }

        // Display age
        ageField.setText(Integer.toString(age));
    }

    public static void main(String[] args) {
        new AgeCalculator();
        System.out.println("Successfully Executed !");

    }
}
