package view;

import controller.CarroController;
import model.entidades.Carro;
import model.entidades.Local;
import model.implementacoes.CarroHibernateDAO;
import model.implementacoes.LocalHibernateDAO;
import model.negocio.CarroDAO;

/**
 *
 * @author Jarvis
 */
public class testeCarro {
    public static void main(String args[]){
        Local local = LocalHibernateDAO.getInstance().recuperar(4);
        
        local.setCidade("X");
        
        LocalHibernateDAO.getInstance().alterar(local);
    }

}
