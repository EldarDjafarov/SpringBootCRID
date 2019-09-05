package trainingProject.mapper;




import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import trainingProject.model.Department;
import trainingProject.model.Employer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Component
public class DepMapper implements RowMapper<Department> {

    public Department mapRow(ResultSet resultSet, int i) throws SQLException {
        Department department = new Department();
        department.setDpId(resultSet.getLong("dpId"));
        department.setDpName(resultSet.getString("dpName"));
        List<Employer> employers=new ArrayList<>();
        Employer employer= new Employer();
        employer.setEmpID(resultSet.getLong("empID"));
        employer.setEmpName(resultSet.getString("empName"));
        employer.setEmpActive(resultSet.getBoolean("empActive"));
        employer.setDptId(resultSet.getLong("dptId"));
        employers.add(employer);
        department.setEmployers(employers);
        return department;

    }
}
