package trainingProject.services.depServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trainingProject.dao.depDAO.IDepDAO;
import trainingProject.model.Department;


import java.util.List;

@Service
public class DepartmentService implements IDepService {
    @Autowired
    private IDepDAO depDAO;

    @Override
    public List<Department> getAllDepartments(){
        return depDAO.getAllDepartments();
    }


    @Override
    public Department getDeparmentById(long dpID) {
        return depDAO.getDeparmentById(dpID);
    }

    @Override
    public int addDepartment(Department department) {
      return   depDAO.addDepartment(department);

    }

    @Override
    public int updateDepartment(Department department) {
       return depDAO.updateDepartment(department);

    }

    @Override
    public void   deleteDepartment(long depID) {
        depDAO.deleteDepartment(depID);

    }

    @Override
    public Department getDeparmentByName(String depName) {
        return depDAO.getDeparmentByName(depName);
    }
}
