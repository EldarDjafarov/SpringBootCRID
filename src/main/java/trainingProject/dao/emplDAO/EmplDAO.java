package trainingProject.dao.emplDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import trainingProject.model.Employer;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Repository
public class EmplDAO implements IEmplDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    RowMapper<Employer> rowMapper;

    @Override
    public List<Employer> getAllEmployers() {
     
        String sql = "SELECT * FROM tblEmployees";

        return this.jdbcTemplate.query(sql, rowMapper);

    }

    @Override
    public Employer getEmployerById(long empID) {
        String sql = "SELECT * FROM tblEmployees where empId=?";
        RowMapper<Employer> rowMapper = new BeanPropertyRowMapper<Employer>(Employer.class);
        Employer employer = jdbcTemplate.queryForObject(sql, rowMapper, empID);
        return employer;
    }

    @Override
    public int addEmployer(Employer employer) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("tblEmployees").usingGeneratedKeyColumns("empId");
        Map<String, Object> parameters = new HashMap<String, Object>(3);
        parameters.put("empName", employer.getEmpName());
        parameters.put("empActive", employer.isEmpActive());
        parameters.put("dptId", employer.getDptId());
        Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
        return insertedId.intValue();
    }

    @Override
    public int updateEmployer(Employer employees, long employerId) {
        String sqlUpdate = "UPDATE tblEmployees SET empName=?, empActive=?,dptId=? WHERE empId=?";
      int resp=  jdbcTemplate.update(sqlUpdate, employees.getEmpName(), employees.isEmpActive(),employees.getDptId(), employerId);
return resp;
    }

    @Override
    public boolean deleteEmployer(long empID) {
        String sqlDelete = "DELETE  FROM tblEmployees WHERE empId=?";
        //1 need to show us delete employer or no
       return jdbcTemplate.update(sqlDelete, empID)==1;


    }

    @Override
    public Employer searchEmployerByName(String empName) {
        String sqlSearchByName="SELECT * FROM tblEmployees WHERE empName LIKE '%'+empName+''";
        Employer employer=jdbcTemplate.queryForObject(sqlSearchByName,rowMapper,empName);
        return employer;
    }

}
