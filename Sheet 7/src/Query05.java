
import Tables.Department;
import Tables.Employee;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Query05 {

    public static void main(String[] args) {
        EntityManager em=Persistence.createEntityManagerFactory("Sheet_7PU").createEntityManager();
        em.getTransaction().begin();
        List<Employee> allEmp= em.createNamedQuery("Employee.findAll").getResultList();
        List<Department> allDep=em.createNamedQuery("Department.findAll").getResultList();
        
        System.out.println("\n5.Increase the salary with 10% to all employees who work in research department.\n\n");
        
        //---------------Before Update--------------//
        System.out.println("\t\t Salary Before Update");
        System.out.println("__________________________________________________________");
        System.out.format("%10s%3s%13s%8s%18s\n","Employee Name","|","Salary","|","Department");
        System.out.println("_______________|____________________|_____________________");
        for(Employee e:allEmp)
        {
            if(e.getDno().getDname().equals("Research"))
                System.out.format("%10s%6s%13s%8s%18s\n",e.getFname(),"|",e.getSalary(),"|",e.getDno().getDname());
        }
        System.out.println("_______________|____________________|_____________________\n\n\n");
        
        //--------------------------After Update-------------------//
        System.out.println("\t\t Salary After Update");
        System.out.println("__________________________________________________________");
        System.out.format("%10s%3s%13s%8s%18s\n","Employee Name","|","Salary","|","Department");
        System.out.println("_______________|____________________|_____________________");
        for(Employee e:allEmp)
        {
            if(e.getDno().getDname().equals("Research"))
            {
                double updatedSalalry = Double.parseDouble(e.getSalary().toString());
                updatedSalalry+=(updatedSalalry*10)/100;
                BigDecimal Bd= new BigDecimal(updatedSalalry); 
                e.setSalary(Bd);
                em.persist(e);
                System.out.format("%10s%6s%13s%8s%18s\n",e.getFname(),"|",e.getSalary(),"|",e.getDno().getDname());
            }
        }
        System.out.println("_______________|____________________|_____________________");
        em.getTransaction().commit();
        em.close();
    }  
}
