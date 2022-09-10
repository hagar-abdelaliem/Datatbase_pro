
import Tables.Department;
import Tables.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Query11 {

    public static void main(String[] args) {
        EntityManager em=Persistence.createEntityManagerFactory("Sheet_7PU").createEntityManager();
        em.getTransaction().begin();
        List<Department> dept=em.createNamedQuery("Department.findAll").getResultList();
        
        System.out.println("\n11.Retrieve each department name and the average of their employees' salaries.\n");
        System.out.println("\t___________________________________________________________");
        System.out.format("\t%22s%5s%20s\n","Name of deparment","|","Average Salary");
        System.out.println("\t__________________________|_______________________________");
        for(Department d:dept)
        {
            double tsalary=0;
            int n=0;
            for(Employee e:d.getEmployeeCollection())
            {
                if(e.getDno().getDnumer()==d.getDnumer())
                {
                    n++;
                    tsalary+=e.getSalary().doubleValue();
                }
            }
             System.out.format("\t%22s%5s%15s\n",d.getDname(),"|",(tsalary/n));
        }
        System.out.println("\t___________________________________________________________\n");
    }
}
