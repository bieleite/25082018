
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entite.Client;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author gabrielleite
 */
@Local
public interface GestionClientcommandeLocal {

    void creerClient(String n, String p, Date da, String l, String mp);

    Client authen(String l, String mp);
    
}
