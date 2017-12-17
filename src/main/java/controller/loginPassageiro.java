package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.entidades.Passageiro;

/**
 *
 * @author Jarvis
 */
@ManagedBean
@SessionScoped
public class loginPassageiro {

    public loginPassageiro() {
    }

    public Passageiro getPassageiroLogado() {
        return (Passageiro) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("passageiroLogado");
    }

    public void setPassageiroLogado(Passageiro passageiroLogado) {
       FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("passageiroLogado", passageiroLogado);
    }
    
    public String login(String login,String senha){
        
        List<Passageiro> passageiros = new PassageiroController().recuperarTodos();
        
        for(Passageiro p : passageiros){
            if(p.getLogin().equals(p.getLogin())){
                if(p.getSenha().equals(senha)){
                    return "index.xthml";
                }
            }
        }
        
        return "";
    }
}
