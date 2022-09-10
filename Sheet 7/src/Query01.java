
import Tables.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Query01
{
    public static void main(String[] args) 
    {
        EntityManager em=Persistence.createEntityManagerFactory("Sheet_7PU").createEntityManager();
        em.getTransaction().begin();
        
        System.out.println("\n1.Retrieve names of employees who live in Houston.\n\n\t___________________________");
        System.out.println("\t  Names of all employees");
        System.out.println("\t___________________________");
        List<Employee> allEmp= em.createNamedQuery("Employee.findAll").getResultList();
        for(Employee e : allEmp)
        {
            if(e.getAddress().contains("Houston"))
            {
                System.out.println("\t\t"+e.getFname()+"."+e.getMinit()+"."+e.getLname());
            }
        }
        System.out.println("\t___________________________\n");
    }  
    
}
