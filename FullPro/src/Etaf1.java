
import Tables.Department;
import Tables.Dependent;
import Tables.Employee;
import Tables.Project;
import Tables.WorksOn;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tuhamy
 */
public class Etaf1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManager em=Persistence.createEntityManagerFactory("FullProPU").createEntityManager();
        em.getTransaction().begin();
        
        List<Employee> Emps = em.createNamedQuery("Employee.findAll").getResultList();
        List<Dependent> Dep = em.createNamedQuery("Dependent.findAll").getResultList();

        System.out.println("\n9.List the name of each employee and his/her spouse.\n");
        System.out.println("\t____________________________________________");
        System.out.format("\t%18s%5s%15s\n","Employee Name ","|","Spouse Name");
        System.out.println("\t______________________|_____________________");
        for (Employee e : Emps) 
        {
            System.out.format("\t%14s%9s",e.getFname() + "." + e.getMinit() + "." + e.getLname(),"|");

            Set<Dependent> depen = e.getDependentSet();
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
        System.out.println("\t______________________|_____________________");
    }
}
