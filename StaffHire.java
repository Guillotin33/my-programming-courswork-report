
/**
 *
 * @author (Cornelius Temitope Adenuga)
 * @version 1
 */
public class StaffHire {
    // Vacancy number assigned to the job position
    private int vacancyNumber;
    
    // Job title or role designation
    private String designation;
    
    // Type of job (e.g., permanent, contract, temporary)
    private String jobType;
    
    // Name of the staff member appointed to this position
    private String staffName;
    
    // Date when the staff member joined the job
    private String joiningDate;
    
    // Qualification of the appointed staff
    private String qualification;
    
    // Name of the person who appointed the staff
    private String appointedBy;
    
    // Status indicating if the position has been filled (true if joined, false otherwise)
    private boolean joined;

    /**
     * Creates a new StaffHire object with the given details.
     * This constructor initializes all the attributes with the provided values.
     */
    public StaffHire(int vacancyNumber,String designation,String jobType,String staffName,String joiningDate,String qualification,String appointedBy, boolean joined)
    {
        // Store the vacancy number for this job
        this.vacancyNumber = vacancyNumber;
        
        // Set the job title or position
        this.designation = designation;
        
        // Define the type of job (e.g., permanent, contract, temporary)
        this.jobType = jobType;
        
        // Record the name of the staff member assigned to this role
        this.staffName = staffName;
        
        // Store the date when the staff member joined
        this.joiningDate = joiningDate;
        
        // Save the qualification details of the staff member
        this.qualification = qualification;
        
        // Keep track of who appointed the staff member
        this.appointedBy = appointedBy;
        
        // Indicate whether the staff member has joined the position
        this.joined = joined;
    }

    /**
     * Returns the vacancy number of the job position.
     */
    public int getVacancyNumber() {
        return vacancyNumber;
    }

    /**
     * Returns the job designation/title.
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Returns the type of job (permanent, contract, temporary).
     */
    public String getJobType() {
        return jobType;
    }

    /**
     * Returns the name of the staff member appointed to this position.
     */
    public String getStaffName() {
        return staffName;
    }

    /**
     * Returns the joining date of the staff member.
     */
    public String getJoiningDate() {
        return joiningDate;
    }

    /**
     * Returns the qualification of the appointed staff.
     */
    public String getQualification() {
        return qualification;
    }

    /**
     * Returns the name of the person who appointed the staff.
     */
    public String getAppointedBy() {
        return appointedBy;
    }

    /**
     * Returns the joined status (true if the staff has joined, false otherwise).
     */
    public boolean isJoined() {
        return joined;
    }

    /**
     * Sets the vacancy number for the job position.
     */
    public void setVacancyNumber(int vacancyNumber) {
        this.vacancyNumber = vacancyNumber;
    }

    /**
     * Sets the job designation/title.
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * Sets the type of job (permanent, contract, temporary).
     */
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    /**
     * Sets the name of the staff member appointed to this position.
     */
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    /**
     * Sets the joining date of the staff member.
     */
    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    /**
     * Sets the qualification of the appointed staff.
     */
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    /**
     * Sets the name of the person who appointed the staff.
     */
    public void setAppointedBy(String appointedBy) {
        this.appointedBy = appointedBy;
    }

    /**
     * Sets the joined status of the staff member.
     */
    public void setJoined(boolean joined) {
        this.joined = joined;
    }

    /**
     * Updates the joined status of the staff member.
     * Displays a message if no change is needed.
     */
    public void amendJoinedStatus(boolean newStatus) {
        if (this.joined == newStatus) {
            System.out.println("No change needed. The joined status is already set to: " + (newStatus ? "Yes" : "No"));
        } else {
            this.joined = newStatus;
            System.out.println("Joined status updated to: " + (newStatus ? "Yes" : "No"));
        }
    }

    /**
     * Displays the details of the staff hire position.
     * Prints out all relevant information in a form.
     */
    public void display() {
        System.out.println("Vacancy Number: " + vacancyNumber);
        System.out.println("Designation: " + designation);
        System.out.println("Job Type: " + jobType);
        System.out.println("Staff Name: " + (staffName.isEmpty() ? "Not Assigned" : staffName));
        System.out.println("Joining Date: " + (joiningDate.isEmpty() ? "Not Assigned" : joiningDate));
        System.out.println("Qualification: " + (qualification.isEmpty() ? "Not Assigned" : qualification));
        System.out.println("Appointed By: " + (appointedBy.isEmpty() ? "Not Assigned" : appointedBy));
        System.out.println("Joined: " + (joined ? "Yes" : "No"));
    }
}

