/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tables;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Etaf Bilal
 */
@Entity
@Table(name = "department")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d")
    , @NamedQuery(name = "Department.findByDname", query = "SELECT d FROM Department d WHERE d.dname = :dname")
    , @NamedQuery(name = "Department.findByDnumer", query = "SELECT d FROM Department d WHERE d.dnumer = :dnumer")
    , @NamedQuery(name = "Department.findByMgrssn", query = "SELECT d FROM Department d WHERE d.mgrssn = :mgrssn")
    , @NamedQuery(name = "Department.findByMgrstartdate", query = "SELECT d FROM Department d WHERE d.mgrstartdate = :mgrstartdate")})
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Dname")
    private String dname;
    @Id
    @Basic(optional = false)
    @Column(name = "Dnumer")
    private Integer dnumer;
    @Basic(optional = false)
    @Column(name = "Mgr_ssn")
    private String mgrssn;
    @Basic(optional = false)
    @Column(name = "Mgr_start_date")
    @Temporal(TemporalType.DATE)
    private Date mgrstartdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private Collection<DeptLocations> deptLocationsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dnum")
    private Collection<Project> projectCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dno")
    private Collection<Employee> employeeCollection;

    public Department() {
    }

    public Department(Integer dnumer) {
        this.dnumer = dnumer;
    }

    public Department(Integer dnumer, String dname, String mgrssn, Date mgrstartdate) {
        this.dnumer = dnumer;
        this.dname = dname;
        this.mgrssn = mgrssn;
        this.mgrstartdate = mgrstartdate;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Integer getDnumer() {
        return dnumer;
    }

    public void setDnumer(Integer dnumer) {
        this.dnumer = dnumer;
    }

    public String getMgrssn() {
        return mgrssn;
    }

    public void setMgrssn(String mgrssn) {
        this.mgrssn = mgrssn;
    }

    public Date getMgrstartdate() {
        return mgrstartdate;
    }

    public void setMgrstartdate(Date mgrstartdate) {
        this.mgrstartdate = mgrstartdate;
    }

    @XmlTransient
    public Collection<DeptLocations> getDeptLocationsCollection() {
        return deptLocationsCollection;
    }

    public void setDeptLocationsCollection(Collection<DeptLocations> deptLocationsCollection) {
        this.deptLocationsCollection = deptLocationsCollection;
    }

    @XmlTransient
    public Collection<Project> getProjectCollection() {
        return projectCollection;
    }

    public void setProjectCollection(Collection<Project> projectCollection) {
        this.projectCollection = projectCollection;
    }

    @XmlTransient
    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dnumer != null ? dnumer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.dnumer == null && other.dnumer != null) || (this.dnumer != null && !this.dnumer.equals(other.dnumer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tables.Department[ dnumer=" + dnumer + " ]";
    }
    
}
