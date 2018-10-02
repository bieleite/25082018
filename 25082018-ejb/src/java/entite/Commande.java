/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author gabrielleite
 */
@Entity
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Commande[ id=" + id + " ]";
    }
    @Column(nullable=false)
    private String numero;

    /**
     * Get the value of numero
     *
     * @return the value of numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Set the value of numero
     *
     * @param numero new value of numero
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCommande;

    /**
     * Get the value of dateCommande
     *
     * @return the value of dateCommande
     */
    public Date getDateCommande() {
        return dateCommande;
    }

    /**
     * Set the value of dateCommande
     *
     * @param dateCommande new value of dateCommande
     */
    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    private OuiNon paye;

    /**
     * Get the value of paye
     *
     * @return the value of paye
     */
    public OuiNon getPaye() {
        return paye;
    }

    /**
     * Set the value of paye
     *
     * @param paye new value of paye
     */
    public void setPaye(OuiNon paye) {
        this.paye = paye;
    }

    private double montant;

    /**
     * Get the value of montant
     *
     * @return the value of montant
     */
    public double getMontant() {
        return montant;
    }

    /**
     * Set the value of montant
     *
     * @param montant new value of montant
     */
    public void setMontant(double montant) {
        this.montant = montant;
    }

    @ManyToOne
    private Client leClient;

    /**
     * Get the value of leClient
     *
     * @return the value of leClient
     */
    public Client getLeClient() {
        return leClient;
    }

    /**
     * Set the value of leClient
     *
     * @param leClient new value of leClient
     */
    public void setLeClient(Client leClient) {
        this.leClient = leClient;
    }

}
