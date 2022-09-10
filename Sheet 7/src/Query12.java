
import Tables.Department;
import Tables.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Query12 {

    public static void main(String[] args) {
        EntityManager em=Persistence.createEntityManagerFactory("Sheet_7PU").createEntityManager();
        em.getTransaction().begin();
        
        Department dp = (Department) em.createNamedQuery("Department.findByDname").setParameter("dname","Research").getSingleResult();
        List<Employee> allEmp= em.createNamedQuery("Employee.findAll").getResultList();
        
        double sum=0;
        int count =0;
        double avg;
        
        System.out.println("\n12.Retrieve the details of each employee who takes salary greater than the average salaries of the research department's employees.\n");
        System.out.println("\t_______________________________________________________________________________________________________________");
        System.out.format("\t%20s%5s%10s%8s%20s%20s%15s\n","NameOfEmpolyee","|","Ssn","|","Adress","|","Salary");
        System.out.println("\t________________________|_________________|_______________________________________|____________________________");
        for(Employee e : allEmp)
        {
            
            if(e.getDno().getDnumer().equals(dp.getDnumer()))
            {
                count++;
                sum+=e.getSalary().doubleValue();
            }
        }
        avg =  sum/count;
        for(Employee e : allEmp)
        {
            if(e.getSalary().doubleValue()>avg)
            {
                System.out.format("\t%20s%5s%13s%5s%25s%15s%15s\n",e.getFname()+"."+e.getMinit()+"."+e.getLname(),"|",e.getSsn(),"|",e.getAddress(),"|",e.getSalary());
            }
        }
         System.out.println("\t______________________________________________________________________________________________________________");
    }
}
