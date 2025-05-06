import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * RecruitmentSystemGUI provides a simple form for managing
 * full-time and part-time staff hires.
 * 
 */
public class RecruitmentSystemGUI implements ActionListener
{
    // Text fields for all inputs
    private JTextField vacancyNumberTextField;
    private JTextField designationTextField;
    private JTextField jobTypeTextField;
    private JTextField staffNameTextField;
    private JTextField joiningDateTextField;
    private JTextField qualificationTextField;
    private JTextField appointedByTextField;
    private JTextField joinedStatusTextField;
    private JTextField salaryTextField;
    private JTextField weeklyFractionalHoursTextField;
    private JTextField workingHoursPerDayTextField;
    private JTextField wagesPerHourTextField;
    private JTextField shiftTextField;
    private JTextField terminateVacancyTextField;
    private JTextField displayIndexTextField;

    // Buttons for each action
    private JButton addFullTimeStaffButton;
    private JButton addPartTimeStaffButton;
    private JButton setSalaryButton;
    private JButton setWorkingShiftsButton;
    private JButton terminatePartTimeStaffButton;
    private JButton displayStaffButton;
    private JButton clearButton;

    // Holds all created StaffHire objects
    private ArrayList<StaffHire> staffHireList;

    /**
     * Build for the GUI 
     * Shows the GUI.
     */
    public RecruitmentSystemGUI()
    {
        JFrame frame = new JFrame("Recruitment System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout(10,10));

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(8, 4, 5, 5));

        vacancyNumberTextField = new JTextField(10);
        designationTextField   = new JTextField(10);
        inputPanel.add(new JLabel("Vacancy Number:"));
        inputPanel.add(vacancyNumberTextField);
        inputPanel.add(new JLabel("Designation:"));
        inputPanel.add(designationTextField);

        jobTypeTextField      = new JTextField(10);
        staffNameTextField    = new JTextField(10);
        inputPanel.add(new JLabel("Job Type:"));
        inputPanel.add(jobTypeTextField);
        inputPanel.add(new JLabel("Staff Name:"));
        inputPanel.add(staffNameTextField);

        joiningDateTextField  = new JTextField(10);
        qualificationTextField= new JTextField(10);
        inputPanel.add(new JLabel("Joining Date:"));
        inputPanel.add(joiningDateTextField);
        inputPanel.add(new JLabel("Qualification:"));
        inputPanel.add(qualificationTextField);

        appointedByTextField  = new JTextField(10);
        joinedStatusTextField = new JTextField(10);
        inputPanel.add(new JLabel("Appointed By:"));
        inputPanel.add(appointedByTextField);
        inputPanel.add(new JLabel("Joined (true/false):"));
        inputPanel.add(joinedStatusTextField);

        salaryTextField                   = new JTextField(10);
        weeklyFractionalHoursTextField    = new JTextField(10);
        inputPanel.add(new JLabel("Salary:"));
        inputPanel.add(salaryTextField);
        inputPanel.add(new JLabel("Weekly Fractional Hours:"));
        inputPanel.add(weeklyFractionalHoursTextField);

        workingHoursPerDayTextField = new JTextField(10);
        wagesPerHourTextField       = new JTextField(10);
        inputPanel.add(new JLabel("Working Hours per Day:"));
        inputPanel.add(workingHoursPerDayTextField);
        inputPanel.add(new JLabel("Wages per Hour:"));
        inputPanel.add(wagesPerHourTextField);

        shiftTextField              = new JTextField(10);
        terminateVacancyTextField   = new JTextField(10);
        inputPanel.add(new JLabel("Shift:"));
        inputPanel.add(shiftTextField);
        inputPanel.add(new JLabel("Terminate Vacancy:"));
        inputPanel.add(terminateVacancyTextField);

        displayIndexTextField = new JTextField(10);
        inputPanel.add(new JLabel("Display Index:"));
        inputPanel.add(displayIndexTextField);
        
    
        inputPanel.add(new JLabel(""));
        inputPanel.add(new JLabel(""));

        content.add(inputPanel, BorderLayout.NORTH);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,10));
        addFullTimeStaffButton       = new JButton("Add Full Time Staff");
        addPartTimeStaffButton       = new JButton("Add Part Time Staff");
        setSalaryButton              = new JButton("Set Salary");
        setWorkingShiftsButton       = new JButton("Set Working Shifts");
        terminatePartTimeStaffButton = new JButton("Terminate PT Staff");
        displayStaffButton           = new JButton("Display Staff");
        clearButton                  = new JButton("Clear");

        addFullTimeStaffButton.addActionListener(this);
        addPartTimeStaffButton.addActionListener(this);
        setSalaryButton.addActionListener(this);
        setWorkingShiftsButton.addActionListener(this);
        terminatePartTimeStaffButton.addActionListener(this);
        displayStaffButton.addActionListener(this);
        clearButton.addActionListener(this);

        buttonPanel.add(addFullTimeStaffButton);
        buttonPanel.add(addPartTimeStaffButton);
        buttonPanel.add(setSalaryButton);
        buttonPanel.add(setWorkingShiftsButton);
        buttonPanel.add(terminatePartTimeStaffButton);
        buttonPanel.add(displayStaffButton);
        buttonPanel.add(clearButton);

        content.add(buttonPanel, BorderLayout.CENTER);

        staffHireList = new ArrayList<StaffHire>();

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Handle all button clicks by sending to the correct method.
     */
    public void actionPerformed(ActionEvent event)
    {
        String cmd = event.getActionCommand();
        if (cmd.equals("Add Full Time Staff"))       addFullTimeStaff();
        if (cmd.equals("Add Part Time Staff"))       addPartTimeStaff();
        if (cmd.equals("Set Salary"))                setFullTimeSalary();
        if (cmd.equals("Set Working Shifts"))        setPartTimeShifts();
        if (cmd.equals("Terminate PT Staff"))        terminatePartTimeStaff();
        if (cmd.equals("Display Staff"))             displayStaff();
        if (cmd.equals("Clear"))                     clearFields();
    }

    /**
     * Reads inputs and adds a FullTimeStaffHire to the list.
     */
    public void addFullTimeStaff()
    {
        try {
            int vacancyNumber = Integer.parseInt(vacancyNumberTextField.getText());
            String designation          = designationTextField.getText();
            String jobType              = jobTypeTextField.getText();
            String staffName            = staffNameTextField.getText();
            String joiningDate          = joiningDateTextField.getText();
            String qualification        = qualificationTextField.getText();
            String appointedBy          = appointedByTextField.getText();
            boolean joinedStatus        = Boolean.parseBoolean(joinedStatusTextField.getText());
            double salary               = Double.parseDouble(salaryTextField.getText());
            int weeklyFractionalHours   = Integer.parseInt(weeklyFractionalHoursTextField.getText());

            FullTimeStaffHire fullTimeHire =
                new FullTimeStaffHire(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joinedStatus, salary, weeklyFractionalHours);
            staffHireList.add(fullTimeHire);
            JOptionPane.showMessageDialog(null,
                "Added full-time staff for vacancy " + vacancyNumber);
        }
        catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(null,
                "Please enter valid numbers where required.",
                "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Reads inputs and adds a PartTimeStaffHire to the list.
     */
    public void addPartTimeStaff()
    {
        try {
            int vacancyNumber   = Integer.parseInt(vacancyNumberTextField.getText());
            String designation    = designationTextField.getText();
            String jobType   = jobTypeTextField.getText();
            String staffName   = staffNameTextField.getText();
            String joiningDate   = joiningDateTextField.getText();
            String qualification  = qualificationTextField.getText();
            String appointedBy = appointedByTextField.getText();
            boolean joinedStatus  = Boolean.parseBoolean(joinedStatusTextField.getText());
            int workingHoursPerDay = Integer.parseInt(workingHoursPerDayTextField.getText());
            double wagesPerHour = Double.parseDouble(wagesPerHourTextField.getText());
            String shift = shiftTextField.getText();

            PartTimeStaffHire partTimeHire =
                new PartTimeStaffHire(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joinedStatus, workingHoursPerDay, wagesPerHour, shift);
            staffHireList.add(partTimeHire);
            JOptionPane.showMessageDialog(null,
                "Added part-time staff for vacancy " + vacancyNumber);
        }
        catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(null,
                "Please enter valid numbers where required.",
                "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Prompts for a new salary and updates the matching FullTimeStaffHire.
     */
    public void setFullTimeSalary()
    {
        try {
            int vacancyNumber = Integer.parseInt(vacancyNumberTextField.getText());
            double newSalary  = Double.parseDouble(salaryTextField.getText());

            boolean found = false;
            for (StaffHire sh : staffHireList) {
                if (sh.getVacancyNumber() == vacancyNumber
                    && sh instanceof FullTimeStaffHire) {
                    FullTimeStaffHire ft = (FullTimeStaffHire) sh;
                    ft.setSalary(newSalary);
                    JOptionPane.showMessageDialog(null,
                        "Salary updated for vacancy " + vacancyNumber);
                    found = true;
                    break;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(null,
                    "Full-time vacancy not found: " + vacancyNumber);
            }
        }
        catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(null,
                "Please enter a valid number for salary.",
                "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Prompts for a new shift and updates the matching PartTimeStaffHire.
     */
    public void setPartTimeShifts()
    {
        try {
            int vacancyNumber = Integer.parseInt(vacancyNumberTextField.getText());
            String newShift   = shiftTextField.getText();

            boolean found = false;
            for (StaffHire sh : staffHireList) {
                if (sh.getVacancyNumber() == vacancyNumber
                    && sh instanceof PartTimeStaffHire) {
                    PartTimeStaffHire pt = (PartTimeStaffHire) sh;
                    pt.setShifts(newShift);
                    JOptionPane.showMessageDialog(null,
                        "Shift updated for vacancy " + vacancyNumber);
                    found = true;
                    break;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(null,
                    "Part-time vacancy not found: " + vacancyNumber);
            }
        }
        catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null,"Please enter a valid vacancy number.","Input Error",JOptionPane.ERROR_MESSAGE);
    }
    }

    /**
     * Terminates the matching PartTimeStaffHire.
     */
    public void terminatePartTimeStaff()
    {
        try {
            int vacancyNumber = Integer.parseInt(terminateVacancyTextField.getText());

            boolean found = false;
            for (StaffHire sh : staffHireList) {
                if (sh.getVacancyNumber() == vacancyNumber
                    && sh instanceof PartTimeStaffHire) {
                    PartTimeStaffHire pt = (PartTimeStaffHire) sh;
                    pt.terminateStaff();
                    JOptionPane.showMessageDialog(null,
                        "Terminated part-time staff for vacancy " + vacancyNumber);
                    found = true;
                    break;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(null,
                    "Part-time vacancy not found: " + vacancyNumber);
            }
        }
        catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter a valid vacancy number to terminate.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Displays full details of the staff.
     */
    public void displayStaff()
    {
        try {
            int displayIndex = Integer.parseInt(displayIndexTextField.getText());

            if (displayIndex < 0
                || displayIndex >= staffHireList.size()) {
                JOptionPane.showMessageDialog(null, "Display index out of range: " + displayIndex);
                return;
            }

            StaffHire sh = staffHireList.get(displayIndex);
            String message =
                "Vacancy Number: " + sh.getVacancyNumber() + "\n" +
                "Designation: "    + sh.getDesignation()   + "\n" +
                "Job Type: "       + sh.getJobType()       + "\n" +
                "Staff Name: "     + sh.getStaffName()     + "\n" +
                "Joining Date: "   + sh.getJoiningDate()   + "\n" +
                "Qualification: "  + sh.getQualification() + "\n" +
                "Appointed By: "   + sh.getAppointedBy()   + "\n" +
                "Joined: "         + (sh.isJoined() ? "Yes" : "No") + "\n";

            if (sh instanceof FullTimeStaffHire) {
                FullTimeStaffHire ft = (FullTimeStaffHire) sh;
                message +=
                    "Salary: " + ft.getSalary() + "\n" +
                    "Weekly Fractional Hours: " + ft.getWeeklyFractionalHours() + "\n";
            } else {
                PartTimeStaffHire pt = (PartTimeStaffHire) sh;
                message +=
                    "Working Hours per Day: " + pt.getWorkingHour() + "\n" +
                    "Wages per Hour: "        + pt.getWagesPerHour() + "\n" +
                    "Shift: "                 + pt.getShifts()       + "\n" +
                    "Terminated: "            + (pt.isTerminated() ? "Yes" : "No") + "\n" +
                    "Income per Day: "        + (pt.getWorkingHour() * pt.getWagesPerHour()) + "\n";
            }

            JOptionPane.showMessageDialog(null, message);
        }
        catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(null,
                "Please enter a valid display index.",
                "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Clears all input fields.
     */
    public void clearFields()
    {
        vacancyNumberTextField.setText("");
        designationTextField.setText("");
        jobTypeTextField.setText("");
        staffNameTextField.setText("");
        joiningDateTextField.setText("");
        qualificationTextField.setText("");
        appointedByTextField.setText("");
        joinedStatusTextField.setText("");
        salaryTextField.setText("");
        weeklyFractionalHoursTextField.setText("");
        workingHoursPerDayTextField.setText("");
        wagesPerHourTextField.setText("");
        shiftTextField.setText("");
        terminateVacancyTextField.setText("");
        displayIndexTextField.setText("");
    }

    /**
     * Main method to launch the GUI without BlueJ.
     */
    public static void main(String[] args)
    {
        new RecruitmentSystemGUI();
    }
}
