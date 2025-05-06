
/**
 *
 * @author (Cornelius Temitope Adenuga)
 * @version 1
 */
public class FullTimeStaffHire extends StaffHire {
    // Salary for the full-time staff
    private double salary;

    // Weekly working hours
    private int weeklyFractionalHours;
    
    /**
     * Sets up a new full-time staff hire with all the details provided.
     * Inherits the basic staff hire info, then records salary and weekly hours.
     */
    public FullTimeStaffHire(int vacancyNumber,String designation,String jobType,String staffName,String joiningDate,String qualification,String appointedBy,boolean joined,
                             double salary,int weeklyFractionalHours) 
       {
        // Call superclass constructor to initialize inherited attributes
        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined);

        // Set the salary for full-time staff
        this.salary = salary;

        // Set the number of hours worked per week
        this.weeklyFractionalHours = weeklyFractionalHours;
    }
    
     /**
     * Returns the current salary of the full-time staff.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Updates the salary, but only if the staff has already joined.
     * If not joined yet, prints an error message.
     */
    public void setSalary(double newSalary) {
        if (isJoined()) {
            this.salary = newSalary;
            System.out.println("Salary updated to: " + newSalary);
        } else {
            System.out.println("Cannot set salary: no staff appointed yet.");
        }
    }

    /**
     * Returns the number of weekly working hours.
     */
    public int getWeeklyFractionalHours() {
        return weeklyFractionalHours;
    }

    /**
     * Updates the weekly working hours.
     */
    public void setWeeklyFractionalHours(int newHours) {
        this.weeklyFractionalHours = newHours;
    }

    /**
     * Displays all details for this full-time staff member.
     * First prints the basic staff hire info, then the salary and weekly hours.
     */
    public void display() 
    {
    super.display();  // show vacancyNumber,designation,jobType, & more...
    System.out.println("Salary: " + salary);
    System.out.println("Weekly Working Hours: " + weeklyFractionalHours);
    }
}

