/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tables;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Etaf Bilal
 */
@Embeddable
public class DeptLocationsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Dlocation")
    private String dlocation;
    @Basic(optional = false)
    @Column(name = "Dnumber")
    private int dnumber;

    public DeptLocationsPK() {
    }

    public DeptLocationsPK(String dlocation, int dnumber) {
        this.dlocation = dlocation;
        this.dnumber = dnumber;
    }

    public String getDlocation() {
        return dlocation;
    }

    public void setDlocation(String dlocation) {
        this.dlocation = dlocation;
    }

    public int getDnumber() {
        return dnumber;
    }

    public void setDnumber(int dnumber) {
        this.dnumber = dnumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dlocation != null ? dlocation.hashCode() : 0);
        hash += (int) dnumber;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeptLocationsPK)) {
            return false;
        }
        DeptLocationsPK other = (DeptLocationsPK) object;
        if ((this.dlocation == null && other.dlocation != null) || (this.dlocation != null && !this.dlocation.equals(other.dlocation))) {
            return false;
        }
        if (this.dnumber != other.dnumber) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tables.DeptLocationsPK[ dlocation=" + dlocation + ", dnumber=" + dnumber + " ]";
    }
    
}
