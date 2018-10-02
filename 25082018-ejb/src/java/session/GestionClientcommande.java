/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entite.Client;
import facadeentite.ClientFacadeLocal;
import facadeentite.CommandeFacadeLocal;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author gabrielleite
 */
@Stateless
public class GestionClientcommande implements GestionClientcommandeLocal {

    @EJB
    private CommandeFacadeLocal commandeFacade;

    @EJB
    private ClientFacadeLocal clientFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void creerClient(String n, String p, Date da, String l, String mp) {
        clientFacade.creerClient(n, p, da, l, mp);
    }

    @Override
    public Client authen(String l, String mp) {
        return clientFacade.authentification(l, mp);
    }
    
}
