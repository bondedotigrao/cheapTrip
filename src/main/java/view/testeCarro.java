package view;

import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import model.entidades.Passageiro;
import model.entidades.Viagem;
import model.implementacoes.ViagemHibernateDAO;
import model.negocio.ViagemDAO;

/**
 *
 * @author Jarvis
 */
public class testeCarro {
    public static void main(String args[]){
        Passageiro p = (Passageiro) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("passageiroLogado");
       List<Viagem> viagens = new ViagemDAO().recuperarPorDestino(p.getLocal());
       for(Viagem v1 : viagens){
               System.out.println("s");
           }
    }

}
