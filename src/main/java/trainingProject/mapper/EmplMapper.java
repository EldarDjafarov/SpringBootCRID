package trainingProject.mapper;



import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import trainingProject.model.Employer;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EmplMapper implements RowMapper<Employer> {


    public Employer mapRow(ResultSet resultSet, int i) throws SQLException {
        Employer employer= new Employer();
        employer.setEmpID(resultSet.getLong("empID"));
        employer.setEmpName(resultSet.getString("empName"));
        employer.setEmpActive(resultSet.getBoolean("empActive"));
        employer.setDptId(resultSet.getLong("dptId"));
        return employer;
    }
}


