package salary.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import salary.domain.Employee;

 
@Repository
public interface EmployeeRepo extends CrudRepository<Employee,Long> {
}
