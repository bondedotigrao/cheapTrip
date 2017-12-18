package controller;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.entidades.Local;
import model.entidades.Passageiro;
import model.negocio.PassageiroDAO;

/**
 *
 * @author Jarvis
 */
@ManagedBean
@SessionScoped
public class PassageiroController {
    private final PassageiroDAO passageiroHibernate;
    private Passageiro cadPassageiro;
    private Passageiro selectedPassageiro = (Passageiro) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("passageiroLogado");

    public PassageiroController() {
        this.passageiroHibernate = new PassageiroDAO();
        this.cadPassageiro = new Passageiro();
    }
    
    public String cadastrar(Local local){
        this.cadPassageiro.setLocal(local);
        this.passageiroHibernate.cadastrar(this.cadPassageiro);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastro realizado com sucesso!"));
        
        return "index.xhtml";
    }
    
    public String alterar(Local local){
        this.selectedPassageiro.setLocal(local);
        this.passageiroHibernate.alterar(this.selectedPassageiro);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Passageiro " + this.selectedPassageiro.getNome() + " alterado com sucesso"));
        
        return "index.xhtml";
    }
    
    public void deletar(){
        this.passageiroHibernate.deletar(this.selectedPassageiro);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O passageiro " + this.selectedPassageiro.getNome() + " foi deletado"));

    }
    
    public List<Passageiro> recuperarTodos(){
        return this.passageiroHibernate.recuperarTodos();
    }
    
    public Passageiro recuperarPorCpf(){
        return this.passageiroHibernate.recuperarPorCpf(this.selectedPassageiro.getCpf());
    }
    public Passageiro getCadPassageiro() {
        return cadPassageiro;
    }

    public void setCadPassageiro(Passageiro cadPassageiro) {
        this.cadPassageiro = cadPassageiro;
    }

    public Passageiro getSelectedPassageiro() {
        return selectedPassageiro;
    }

    public void setSelectedPassageiro(Passageiro selectedPassageiro) {
        this.selectedPassageiro = selectedPassageiro;
    }
    
    
}
