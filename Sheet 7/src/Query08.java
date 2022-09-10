
import Tables.Employee;
import Tables.WorksOn;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Query08 {

    public static void main(String[] args) {
        EntityManager em=Persistence.createEntityManagerFactory("Sheet_7PU").createEntityManager();
        em.getTransaction().begin();
        
         List<Employee> emp=em.createNamedQuery("Employee.findAll").getResultList();
        
        System.out.println("8.Retrieve the names of all employees in department 5 who work more than 20 hours per week on the “ProductX” project.\n");
        System.out.println("\t_____________________________________________________________");
        System.out.format("\t%15s%5s%15s%5s%15s\n","Name of employee","|","Project name","|","Hours");
        System.out.println("\t____________________|___________________|____________________");
        for(Employee e:emp)
        {
            if(e.getDno().getDnumer()==5)
            {
                for(WorksOn w:e.getWorksOnCollection())
                {
                    if( w.getHours().doubleValue()>20 && w.getProject().getPname().equals("ProductX"))
                    {
                        System.out.format("%23s%6s%15s%5s%15s\n",e.getFname()+"."+e.getMinit()+"."+e.getLname(),"|",w.getProject().getPname(),"|",w.getHours());
                    }
                }               
            }
        }
        System.out.println("\t_____________________________________________________________");
    }
    
}
