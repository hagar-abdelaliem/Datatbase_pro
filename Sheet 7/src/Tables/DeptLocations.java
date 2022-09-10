/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tables;

import java.io.Serializable;
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
@Table(name = "dept_locations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeptLocations.findAll", query = "SELECT d FROM DeptLocations d")
    , @NamedQuery(name = "DeptLocations.findByDlocation", query = "SELECT d FROM DeptLocations d WHERE d.deptLocationsPK.dlocation = :dlocation")
    , @NamedQuery(name = "DeptLocations.findByDnumber", query = "SELECT d FROM DeptLocations d WHERE d.deptLocationsPK.dnumber = :dnumber")})
public class DeptLocations implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DeptLocationsPK deptLocationsPK;
    @JoinColumn(name = "Dnumber", referencedColumnName = "Dnumer", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Department department;

    public DeptLocations() {
    }

    public DeptLocations(DeptLocationsPK deptLocationsPK) {
        this.deptLocationsPK = deptLocationsPK;
    }

    public DeptLocations(String dlocation, int dnumber) {
        this.deptLocationsPK = new DeptLocationsPK(dlocation, dnumber);
    }

    public DeptLocationsPK getDeptLocationsPK() {
        return deptLocationsPK;
    }

    public void setDeptLocationsPK(DeptLocationsPK deptLocationsPK) {
        this.deptLocationsPK = deptLocationsPK;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deptLocationsPK != null ? deptLocationsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeptLocations)) {
            return false;
        }
        DeptLocations other = (DeptLocations) object;
        if ((this.deptLocationsPK == null && other.deptLocationsPK != null) || (this.deptLocationsPK != null && !this.deptLocationsPK.equals(other.deptLocationsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tables.DeptLocations[ deptLocationsPK=" + deptLocationsPK + " ]";
    }
    
}
