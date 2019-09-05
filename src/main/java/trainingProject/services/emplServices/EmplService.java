package trainingProject.services.emplServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trainingProject.dao.emplDAO.IEmplDAO;
import trainingProject.model.Employer;


import java.util.List;

@Service
public class EmplService implements IEmplService {

    @Autowired
   private IEmplDAO emplDAO;
    @Override
    public List<Employer> getAllEmployers() {
        return emplDAO.getAllEmployers();
    }

    @Override
    public Employer getEmployerById(long empID) {
        return emplDAO.getEmployerById(empID);
    }

    @Override
    public int addEmployer(Employer employer) {
       return emplDAO.addEmployer(employer);

    }

    @Override
    public int updateEmployer(Employer employer, long employerId) {
      return   emplDAO.updateEmployer(employer,employerId);

    }

    @Override
    public boolean  deleteEmployer(long empID) {
       return emplDAO.deleteEmployer(empID);

    }

    @Override
    public Employer searchEmployerByName(String name) {
        return emplDAO.searchEmployerByName(name);
    }
}
