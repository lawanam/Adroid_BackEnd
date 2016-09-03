package salary.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import salary.App;
import salary.domain.Employee;
import salary.factory.EmployeeFactory;
import salary.repository.EmployeeRepo;

import static org.junit.Assert.assertNotNull;

 
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration

public class EmployeeCrudTest extends AbstractTestNGSpringContextTests {
    @Autowired
    EmployeeRepo repo;

    @Test
    public void testCreateEmployee() throws Exception {
        //repository.deleteAll();
        Employee employee = EmployeeFactory.createEmployee("admin","test","job",2.0,10);
       repo.save(employee);

       // assertNotNull("CREATE TEST",savedEmployee);
    }
/*
    @Test(dependsOnMethods = "testCreateEmployee")
    public void testReadAll() throws Exception {
        Iterable<Emplo
        yeeEntity> employees =  repository.findAll();

        assertNotNull("READ TEST",employees);
    }*/

}
