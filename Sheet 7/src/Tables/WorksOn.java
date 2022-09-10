/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tables;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Etaf Bilal
 */
@Entity
@Table(name = "works_on")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorksOn.findAll", query = "SELECT w FROM WorksOn w")
    , @NamedQuery(name = "WorksOn.findByEssn", query = "SELECT w FROM WorksOn w WHERE w.worksOnPK.essn = :essn")
    , @NamedQuery(name = "WorksOn.findByPno", query = "SELECT w FROM WorksOn w WHERE w.worksOnPK.pno = :pno")
    , @NamedQuery(name = "WorksOn.findByHours", query = "SELECT w FROM WorksOn w WHERE w.hours = :hours")})
public class WorksOn implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WorksOnPK worksOnPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Hours")
    private Float hours;
    @JoinColumn(name = "Essn", referencedColumnName = "Ssn", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;
    @JoinColumn(name = "Pno", referencedColumnName = "Pnumber", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Project project;

    public WorksOn() {
    }

    public WorksOn(WorksOnPK worksOnPK) {
        this.worksOnPK = worksOnPK;
    }

    public WorksOn(String essn, int pno) {
        this.worksOnPK = new WorksOnPK(essn, pno);
    }

    public WorksOnPK getWorksOnPK() {
        return worksOnPK;
    }

    public void setWorksOnPK(WorksOnPK worksOnPK) {
        this.worksOnPK = worksOnPK;
    }

    public Float getHours() {
        return hours;
    }

    public void setHours(Float hours) {
        this.hours = hours;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (worksOnPK != null ? worksOnPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WorksOn)) {
            return false;
        }
        WorksOn other = (WorksOn) object;
        if ((this.worksOnPK == null && other.worksOnPK != null) || (this.worksOnPK != null && !this.worksOnPK.equals(other.worksOnPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tables.WorksOn[ worksOnPK=" + worksOnPK + " ]";
    }
    
}
