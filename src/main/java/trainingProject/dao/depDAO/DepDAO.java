package trainingProject.dao.depDAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import trainingProject.model.Department;
import trainingProject.model.Employer;

import trainingProject.services.emplServices.IEmplService;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Transactional
@Repository
public class DepDAO implements IDepDAO {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RowMapper<Department> rowMapper;

    @Autowired
    private IEmplService emplService;

    @Override
    public List<Department> getAllDepartments() {
        String sql = "SELECT * FROM tblDepartments, tblEmployees where tblDepartments.dpId=tblEmployees.dptId";

       return this.jdbcTemplate.query(sql, rowMapper);
    }

    public Department getDeparmentById(long dpId) {
        String sql = "SELECT * FROM tblDepartments where dpId=?";
        RowMapper<Department> rowMapper = new BeanPropertyRowMapper<Department>(Department.class);
        Department department = jdbcTemplate.queryForObject(sql, rowMapper, dpId);
        return department;

    }

    public int addDepartment(Department department) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("tblDepartments").usingGeneratedKeyColumns("dptId");
        Map<String, Object> parameters = new HashMap<String, Object>(1);
        parameters.put("dpName", department.getDpName());
        Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
        for (Employer employer :
                department.getEmployers()) {
            emplService.addEmployer(employer);
        }
        return insertedId.intValue();
    }


    public int updateDepartment(Department departments) {
        String sql = "UPDATE tblDepartments SET dpName=? WHERE dpId=?";
        for (Employer employer :
                departments.getEmployers()) {
            emplService.updateEmployer(employer,employer.getEmpID());
        }
        int resp = jdbcTemplate.update(sql, departments.getDpId(), departments.getDpName());
        return resp;
    }


    public void deleteDepartment(long depID) {
        String sql = "DELETE FROM tblDepartments WHERE dpId=?";
        jdbcTemplate.update(sql, depID);

    }

    @Override
    public Department getDeparmentByName(String depName) {
        String sql = "SELECT * FROM tblDepartments where dpName=?";
        RowMapper<Department> rowMapper = new BeanPropertyRowMapper<Department>(Department.class);
        try {


            Department department = jdbcTemplate.queryForObject(sql, rowMapper, depName);
            return department;

        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }
}


