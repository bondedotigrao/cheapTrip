package controller;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.entidades.Passageiro;
import model.implementacoes.PassageiroHibernateDAO;

/**
 *
 * @author Jarvis
 */
@ManagedBean
@ViewScoped
public class PassageiroController {
    private final PassageiroHibernateDAO passageiroHibernate;
    private Passageiro cadPassageiro;
    private Passageiro selectedPassageiro;

    public PassageiroController() {
        this.passageiroHibernate = PassageiroHibernateDAO.getInstance();
        this.cadPassageiro = new Passageiro();
    }
    
    public String cadastrar(){
        this.passageiroHibernate.cadastrar(this.cadPassageiro);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastro realizado com sucesso!"));
        
        return "index.xhtml";
    }
    
    public String alterar(){
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
