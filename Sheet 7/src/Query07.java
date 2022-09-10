
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import Tables.Department;
import Tables.Employee;

public class Query07 {
    
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManager em = Persistence.createEntityManagerFactory("TryProject").createEntityManager();
        em.getTransaction().begin();
        
        List<Department> allDep = em.createNamedQuery("Department.findAll").getResultList();
        List<Employee> Emps = em.createNamedQuery("Employee.findAll").getResultList();
    
        System.out.println("\n7.List the summation of salaries for each department that are paid to their employees.\n\n");
        System.out.println("\t__________________________________________________________");
        System.out.format("\t%5s%9s%25s\n"," Department Name","|","summation of salaries");
        System.out.println("\t________________________|_________________________________");
        for(Department d : allDep)
        {
            double count=0;
            for(Employee e : Emps)
            {
                if(Objects.equals(e.getDno().getDnumer(), d.getDnumer()))
                    count+=e.getSalary().doubleValue();
            }
            System.out.format("\t%15s%10s%25s\n",d.getDname(),"|",count);
        }
        System.out.println();
    }
}
