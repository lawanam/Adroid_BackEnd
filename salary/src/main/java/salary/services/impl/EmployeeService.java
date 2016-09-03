package salary.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import salary.domain.Employee;
import salary.repository.EmployeeRepo;
import salary.services.IEmployeeService;

import java.util.Set;


@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    EmployeeRepo repo;
    @Override
    public Employee create(Employee entity) {
        return null; //repo.save(entity);
    }

    @Override
    public Employee readById(Long id) {
        return  null;//repo.findOne(id);
    }

    @Override
    public Set<Employee> readAll() {
        return null;
    }

    @Override
    public Employee update(Employee entity) {
        return null;
    }

    @Override
    public void delete(Employee entity) {

    }

}
