package trainingProject.services.depServices;



import trainingProject.model.Department;


import java.util.List;

public interface IDepService {
     List<Department> getAllDepartments();
    Department getDeparmentById(long dpId);
    int addDepartment(Department department);
    int updateDepartment(Department department);
    void deleteDepartment(long depID);
    Department getDeparmentByName(String depName);
}
