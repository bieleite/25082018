/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadeentite;

import entite.Client;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author gabrielleite
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> implements ClientFacadeLocal {

    @PersistenceContext(unitName = "25082018-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }

    @Override
    public void creerClient(String n, String p, Date naissance, String l, String mp) {
        Client c;
        c=new Client();
        c.setNom(n);
        c.setPrenom(p);
        c.setNaiss(naissance);
        c.setLogin(l);
        c.setMotpasse(mp);
        em.persist(c);//para guardar na base de dados, sem essa linha ele ficaria na memoria
    }

    @Override
    public Client authentification(String l, String mp) {
        Client cl;
        String txt = "SELECT c FROM Client AS c WHERE c.login=:lo and c.motpasse=:motp";
        Query req = getEntityManager().createQuery(txt);//tem que fazer o import do persistance
        req=req.setParameter("lo", l);
        req=req.setParameter("motp",mp);
        cl = (Client)req.getSingleResult();//a pesquisa é um objeto , entao tem que colocar um tipo no caso (Client), transtiper
        return null;
    }
    
}
