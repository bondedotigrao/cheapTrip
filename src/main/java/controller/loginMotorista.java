package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.entidades.Motorista;

/**
 *
 * @author Jarvis
 */
@ManagedBean
@SessionScoped
public class loginMotorista {
    private Motorista motoristaLogado = null;

    public loginMotorista() {
        this.motoristaLogado = new Motorista();
    }

    public Motorista getMotoristaLogado() {
        return (Motorista) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("motoristaLogado");
    }

    public void setMotoristaLogado(Motorista motoristaLogado) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("motoristaLogado", this.motoristaLogado);
    }
    
    public String realizarLogin(String login,String senha){
     List<Motorista> motoristas = new MotoristaController().recuperarTodos();
     
     for(Motorista m : motoristas){
         if(m.getLogin().equals(login)){
             if(m.getSenha().equals(senha)){
                 this.setMotoristaLogado(m);
                 return "motoristaTemplate";
             }
         }
     }
     
     return "";
    }
}
