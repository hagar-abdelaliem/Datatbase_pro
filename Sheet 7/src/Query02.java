import Tables.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Query02 {

    public static void main(String[] args) {
        EntityManager em=Persistence.createEntityManagerFactory("Sheet_7PU").createEntityManager();
        em.getTransaction().begin();
        
        System.out.println("\n2.Retrieve name of the employee who has not supervisor.\n");
        
        List<Employee> emp=em.createNamedQuery("Employee.findAll").getResultList();
        for(Employee e:emp)
        {
            if(e.getSuperssn()==null)
            System.out.println("\tEmployee Name is "+e.getFname()+"."+e.getMinit()+"."+e.getLname()+"\n");
        }
    } 
    
}
