
import Tables.Dependent;
import Tables.Employee;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Query09 {

    public static void main(String[] args) {
        EntityManager em=Persistence.createEntityManagerFactory("Sheet_7PU").createEntityManager();
        em.getTransaction().begin();
        
        List<Employee> Emps = em.createNamedQuery("Employee.findAll").getResultList();
        List<Dependent> Dep = em.createNamedQuery("Dependent.findAll").getResultList();

        System.out.println("\n9.List the name of each employee and his/her spouse.\n");
        System.out.println("\t______________________________________________________");
        System.out.format("\t%18s%11s%15s\n","Employee Name ","|","Spouse Name");
        System.out.println("\t____________________________|_________________________");
        for (Employee e : Emps) 
        {
            System.out.format("\t%20s%9s",e.getFname() + "." + e.getMinit() + "." + e.getLname(),"|");

            Collection<Dependent> depen = e.getDependentCollection();
            if (depen.size() == 0) {
                System.out.format("%15s\n","No spouse");
            } else {
                for (Dependent dp : depen) {
                    if (dp.getRelationship().equalsIgnoreCase("spouse")) {
                        System.out.format("%15s\n",dp.getDependentPK().getDependentname());
                    }
                }
            }
        }
        System.out.println("\t____________________________|_________________________");
    }
    
}
