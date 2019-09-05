package trainingProject.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private Long dpId;
    private String dpName;
    private List<Employer> employers=new ArrayList<>();

    public Department() {
    }



    public List<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(List<Employer> emloyers) {
        this.employers = emloyers;
    }

    public Department(String dpName) {
        this.dpName = dpName;
    }

    public Department(Long dpId, String dpName) {
        this.dpId = dpId;
        this.dpName = dpName;
    }

    public Long getDpId() {
        return dpId;
    }

    public void setDpId(Long dpId) {
        this.dpId = dpId;
    }

    public String getDpName() {
        return dpName;
    }

    public void setDpName(String dpName) {
        this.dpName = dpName;
    }
}
