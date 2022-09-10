
import Tables.Department;
import Tables.Employee;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Query04 {

    public static void main(String[] args) {
        EntityManager em=Persistence.createEntityManagerFactory("Sheet_7PU").createEntityManager();
        em.getTransaction().begin();
        
        List<Department> allDep = em.createNamedQuery("Department.findAll").getResultList();
        List<Employee> Emps = em.createNamedQuery("Employee.findAll").getResultList();
    
        System.out.println("\n4.List the count of employees for each department.\n");
        System.out.println("\t________________________________________________________");
        System.out.format("\t%5s%10s%25s\n","Department Name","|","Count of employees ");
        System.out.println("\t________________________|_______________________________");
        for(Department d : allDep)
        {
            int count=0;
            for(Employee e : Emps)
            {
                if(Objects.equals(e.getDno().getDnumer(), d.getDnumer()))
                    count++;
            }
            System.out.format("\t%15s%10s%15s\n",d.getDname(),"|",count);
        }
    }
    
}
