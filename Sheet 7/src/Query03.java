import Tables.DeptLocations;
import Tables.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Query03 {

    public static void main(String[] args) {
        EntityManager em=Persistence.createEntityManagerFactory("Sheet_7PU").createEntityManager();
        em.getTransaction().begin();
        
        System.out.println("\n3.Retrieve the name of each employee and his department location\n\n");
        System.out.println("______________________________________________________");
        System.out.format("%5s%5s%25s\n"," Employee Name","|","Department Location");
        System.out.println("__________________|___________________________________");
        List<Employee> allEmp= em.createNamedQuery("Employee.findAll").getResultList();
        List<DeptLocations> allDepLoc=em.createNamedQuery("DeptLocations.findAll").getResultList();
        for(Employee e:allEmp)
        {
            System.out.format("%10s%15s",e.getFname(),"");
            for(DeptLocations d:allDepLoc)
            {
                if(e.getDno().getDnumer() == d.getDepartment().getDnumer())
                {
                    System.out.print(d.getDeptLocationsPK().getDlocation()+", ");
                }
            }
            System.out.print("\n");
        }
        System.out.println("______________________________________________________");
    }
    
    
}
