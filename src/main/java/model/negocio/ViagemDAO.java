package model.negocio;

import java.util.ArrayList;
import java.util.List;
import model.entidades.Local;
import model.entidades.Viagem;
import model.implementacoes.ViagemHibernateDAO;
import model.interfaces.DAO;

/**
 *
 * @author Jarvis
 */
public class ViagemDAO {
    private final DAO<Viagem> dao;
    
    public ViagemDAO(){
        this.dao = ViagemHibernateDAO.getInstance();
    }
    
    public void cadastrar(Viagem viagem){
        if(((ViagemHibernateDAO)dao).recuperar(viagem.getId_viagem()) == null){
            this.dao.cadastrar(viagem);
        }
    }
    
    public Viagem recuperar(Integer codigo){
        if(codigo == null){
            return null;
        }
        
       return ((ViagemHibernateDAO)dao).recuperar(codigo);
    }
    
    public void deletar(Viagem viagem){
        if(((ViagemHibernateDAO)dao).recuperar(viagem.getId_viagem()) != null){
            this.dao.deletar(viagem);
        }
    }
    
    public void alterar(Viagem viagem){
      if(((ViagemHibernateDAO)dao).recuperar(viagem.getId_viagem()) != null){
            this.dao.alterar(viagem);
      }
    }
    
    public List<Viagem> recuperarTodos(){
        return ((ViagemHibernateDAO)dao).recuperarTodos();
    }
    
    public List<Viagem> recuperarPorDestino(Local local){
        List<Viagem> viagens =  this.recuperarTodos();
        List<Viagem> retorno = new ArrayList<>();
        
        for(Viagem v : viagens){
           
            if(local.getEstado().equals(v.getLocal().getEstado()) 
                    && local.getCidade().equals(v.getLocal().getCidade())){
                
                  
                retorno.add(v);
            }
        }
         return retorno;
    }
}
