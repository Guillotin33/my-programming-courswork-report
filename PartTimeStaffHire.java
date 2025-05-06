
/**
 *
 * @author (Cornelius Temitope Adenuga)
 * @version 1
 */
public class PartTimeStaffHire extends StaffHire {
    // Number of hours this person works each day
    private int workingHour;

    // Hourly rate of pay
    private double wagesPerHour;

    // Which shift the person works (morning, day, or evening)
    private String shifts;

    // Whether this staff member has been terminated
    private boolean terminated;

    /**
     * Sets up a new part-time staff hire with all the details provided.
     */
    public PartTimeStaffHire(int vacancyNumber, String designation, String jobType, String staffName, String joiningDate, String qualification, String appointedBy,
    boolean joined,int workingHour, double wagesPerHour, String shifts) 
    {
        // Initialize all the StaffHire fields
        super(vacancyNumber, designation, jobType, staffName,
              joiningDate, qualification, appointedBy, joined);

        // Store how many hours per day this person works
        this.workingHour = workingHour;

        // Set the hourly pay rate
        this.wagesPerHour = wagesPerHour;

        // Record which shift they work (morning,day,evening)
        this.shifts = shifts;

        // New part-timers start off not terminated
        this.terminated = false;
    }

    // Returns how many hours this staff member works each day
    public int getWorkingHour() {
        return workingHour;
    }

    // Returns the hourly wage rate
    public double getWagesPerHour() {
        return wagesPerHour;
    }

    // Returns the current shift (morning/day/evening)
    public String getShifts() {
        return shifts;
    }

    // Returns true if this staff member has been terminated
    public boolean isTerminated() {
        return terminated;
    }

    /**
     * Changes the working shift, but only if someone has actually joined.
     * If no one has been appointed yet, prints an error message.
     */
    public void setShifts(String newShift) 
    {
        if (isJoined()) {
            this.shifts = newShift;
            System.out.println("Shift has been updated to: " + newShift);
        } else {
            System.out.println("Cannot update shift – no one is appointed yet.");
        }
    }

    /**
     * Terminates the staff member.
     * If already terminated, informs the user; otherwise clears their details,
     * marks them as not joined, and sets terminated to true.
     */
    public void terminateStaff() 
    {
        if (terminated) {
            System.out.println("Staff member is already terminated.");
        } else {
            // Wipe out their personal details
            setStaffName("");
            setJoiningDate("");
            setQualification("");
            setAppointedBy("");
            setJoined(false);

            // Mark them as terminated
            terminated = true;
            System.out.println("Staff member has been terminated.");
        }
    }

    /**
     * Displays all details for this part-time hire.
     * First shows the core StaffHire info, then adds wages, hours, shift,
     * termination status, and calculated daily income.
     */
    public void display() 
    {
        super.display(); 
        System.out.println("Wages per Hour: " + wagesPerHour);
        System.out.println("Working Hours per Day: " + workingHour);
        System.out.println("Shift: " + shifts);
        System.out.println("Terminated: " + (terminated ? "Yes" : "No"));
        System.out.println("Income per Day: " + (wagesPerHour * workingHour));
    }
}

