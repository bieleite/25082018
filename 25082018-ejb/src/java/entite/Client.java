/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author gabrielleite
 */
@Entity
public class Client implements Serializable {

    @OneToMany(mappedBy = "leClient")
    private List<Commande> commandes;

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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Client[ id=" + id + " ]";
    }
    
    @Column(nullable=false)
    private String nom;

    /**
     * Get the value of nom
     *
     * @return the value of nom
     */
    public String getNom() {
        return nom;
    }
    /**
     * Set the value of nom
     *
     * @param nom new value of nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    @Column(nullable=false)
    private String prenom;

    /**
     * Get the value of prenom
     *
     * @return the value of prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Set the value of prenom
     *
     * @param prenom new value of prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    @Column(unique=true, nullable=false)
    private String login;

    /**
     * Get the value of login
     *
     * @return the value of login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Set the value of login
     *
     * @param login new value of login
     */
    public void setLogin(String login) {
        this.login = login;
    }
    
    @Column(nullable=false)
    private String motpasse;

    /**
     * Get the value of motpasse
     *
     * @return the value of motpasse
     */
    public String getMotpasse() {
        return motpasse;
    }

    /**
     * Set the value of motpasse
     *
     * @param motpasse new value of motpasse
     */
    public void setMotpasse(String motpasse) {
        this.motpasse = motpasse;
    }

    @Column(nullable=false)    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date naiss;

    /**
     * Get the value of naiss
     *
     * @return the value of naiss
     */
    public Date getNaiss() {
        return naiss;
    }

    /**
     * Set the value of naiss
     *
     * @param naiss new value of naiss
     */
    public void setNaiss(Date naiss) {
        this.naiss = naiss;
    }
    @Transient
    private double age;

    /**
     * Get the value of age
     *
     * @return the value of age
     */
    public double getAge() {
        return age;
    }

    /**
     * Set the value of age
     *
     * @param age new value of age
     */
    public void setAge(double age) {
        this.age = age;
    }
    
    @PostLoad
    public void calculage(){
        age = new Date().getYear()- naiss.getYear();
    }
}
