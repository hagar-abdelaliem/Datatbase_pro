
import Tables.Department;
import Tables.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Query10 {

    public static void main(String[] args) {
        EntityManager em=Persistence.createEntityManagerFactory("Sheet_7PU").createEntityManager();
        em.getTransaction().begin();
        List<Employee> allEmp= em.createNamedQuery("Employee.findAll").getResultList();
        List<Department> allDep=em.createNamedQuery("Department.findAll").getResultList();
        
        System.out.println("\n10.Retrieve the name, salary, and phone of an employee who takes the smallest salary.\n\n");
        System.out.println("__________________________________________________________________");
        System.out.format("%10s%3s%17s%12s%15s\n","Employee Name","|","Address","|","Salary");
        System.out.println("_______________|____________________________|_____________________");
        double min = 2*1000000000;
        for(Employee e:allEmp)
        {
            double sal=Double.parseDouble(e.getSalary().toString());
            if(sal < min) min=Double.parseDouble(e.getSalary().toString());
        }
        
        for(Employee e:allEmp)
        {
            double sal=Double.parseDouble(e.getSalary().toString());
            if(sal == min)
                System.out.format("%10s%6s%25s%4s%15s\n",e.getFname(),"|",e.getAddress(),"|",e.getSalary());
        }
        System.out.println("_______________|____________________________|_____________________");
    }   
    
}
