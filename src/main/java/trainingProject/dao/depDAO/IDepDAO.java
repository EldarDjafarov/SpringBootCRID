package trainingProject.dao.depDAO;




import trainingProject.model.Department;



import java.util.List;

public interface IDepDAO {
    List<Department> getAllDepartments();
    Department getDeparmentById(long depID);
    int addDepartment(Department departments);
    int updateDepartment(Department departments);
    void deleteDepartment(long depID);
    Department getDeparmentByName(String depName);


}
