package model.negocio;

import java.util.List;
import model.entidades.Motorista;
import model.implementacoes.MotoristaHibernateDAO;
import model.interfaces.DAO;

/**
 *
 * @author Jarvis
 */
public class MotoristaDAO {
    private DAO<Motorista>dao = MotoristaHibernateDAO.getInstance();
    
    public void cadastrar(Motorista motorista){
        if(((MotoristaHibernateDAO)dao).recuperar(motorista.getId_motorista()) == null){
            this.dao.cadastrar(motorista);
        }
    }
    
    public Motorista recuperar(Integer codigo){
        if(codigo == null){
            return null;
        }
        
       return ((MotoristaHibernateDAO)dao).recuperar(codigo);
    }
    
    public void alterar(Motorista motorista){
        if(((MotoristaHibernateDAO)dao).recuperar(motorista.getId_motorista()) != null){
            this.dao.alterar(motorista);
        }
    }
    
      public void deletar(Motorista motorista){
        if(((MotoristaHibernateDAO)dao).recuperar(motorista.getId_motorista()) != null){
            this.dao.deletar(motorista);
        }
    }
      
      public Motorista recuperarPorCpf(String cpf){
          if(((MotoristaHibernateDAO)dao).recuperarPorCpf(cpf) == null){
              return null;
          }
          
          return ((MotoristaHibernateDAO)dao).recuperarPorCpf(cpf);
      }
      
      public List<Motorista> recuperarTodos(){
          return ((MotoristaHibernateDAO)dao).recuperarTodos();
      }
      
      public boolean login(String login,String senha){
          if(login == null || senha == null){
              return false;
          }
          return ((MotoristaHibernateDAO)dao).login(login, senha);
      }
}
