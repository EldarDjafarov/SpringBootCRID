package trainingProject.model;

public class Employer {

    private Long empID;
    private String empName;
    private boolean empActive;
    private Long dptId;



    public Employer() {
    }

    public Employer(String empName, boolean empActive,Long dptId) {
        this(empName,empActive);
        this.dptId = dptId;
    }

    public Employer(String empName, boolean empActive) {
        this.empName = empName;
        this.empActive = empActive;
    }


    public Long getEmpID() {
        return empID;
    }

    public void setEmpID(Long empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public boolean isEmpActive() {
        return empActive;
    }

    public void setEmpActive(boolean empActive) {
        this.empActive = empActive;
    }

    public Long getDptId() {
        return dptId;
    }

    public void setDptId(Long dptId) {
        this.dptId = dptId;
    }
}
