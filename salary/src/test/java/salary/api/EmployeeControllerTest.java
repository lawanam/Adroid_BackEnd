package salary.api;

import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;
import salary.domain.Employee;
import salary.factory.EmployeeFactory;

import java.util.Set;

 
public class EmployeeControllerTest {
    @Test
    public void testCreate(){
        String URI =  "http://localhost:8080/emp";
        RestTemplate restTemplate = new RestTemplate();

        Employee employeeEntity = EmployeeFactory.createEmployee("testApi","test","admin",20.1,10);
        restTemplate.postForObject(URI,employeeEntity, Employee.class );
    }
    @Test
    public void testFindById() {
        String URI =  "http://localhost:8080/emp/{id}";
        RestTemplate restTemplate = new RestTemplate();
        Employee employeeEntity= restTemplate.getForObject(URI, Employee.class, "3");
        Assert.assertNotNull(employeeEntity);
        Assert.assertEquals("admin", employeeEntity.getName());

        Assert.assertEquals("test", employeeEntity.getSurname());
    }
    @Test
    public void testUpdate(){
        String URI =  "http://localhost:8080/emp/{id}";
        RestTemplate restTemplate = new RestTemplate();
        Employee employeeEntity= restTemplate.getForObject(URI, Employee.class, "5");
        if(employeeEntity!=null) {
            String UPDATE_URI = "http://localhost:8080/emp";
            Employee updateEmployee = new Employee.EmployeeBuilder()
                    .copy(employeeEntity)
                    .name("successApi")
                    .build();
            restTemplate.put(UPDATE_URI,updateEmployee);
            Employee updatedEmployee= restTemplate.getForObject(URI, Employee.class, "5");

            Assert.assertNotEquals(updatedEmployee.getName(), updatedEmployee.getName());
        }
    }
    @Test
    public void testFindAll(){
        String URI =  "http://localhost:8080/emp";
        RestTemplate restTemplate = new RestTemplate();
        Set employeeSet = restTemplate.getForObject(URI,Set.class);
        Assert.assertTrue(employeeSet.size()>0);
    }
    @Test
    public void testDelete(){
        String URI =  "http://localhost:8080/emp/{id}";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(URI,"1");
        Employee employeeEntity= restTemplate.getForObject(URI, Employee.class, "1");

        Assert.assertNull(employeeEntity);


    }
}
