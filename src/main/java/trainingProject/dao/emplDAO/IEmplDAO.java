package trainingProject.dao.emplDAO;


import trainingProject.model.Employer;

import java.util.List;

public interface IEmplDAO {
    List<Employer> getAllEmployers();
    Employer getEmployerById(long empID);
    int addEmployer(Employer employer);
    int updateEmployer(Employer employer, long employerId);
    boolean deleteEmployer(long empID);
    Employer searchEmployerByName(String empName);
}
