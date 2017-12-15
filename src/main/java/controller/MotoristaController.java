package controller;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.entidades.Motorista;
import model.implementacoes.MotoristaHibernateDAO;

/**
 *
 * @author Mark IV
 */
@ManagedBean
@ViewScoped
public class MotoristaController {
    private final MotoristaHibernateDAO motoristaHibernate;
    private Motorista cadMotorista;
    private Motorista selectedMotorista;

    public MotoristaController() {
        this.motoristaHibernate = MotoristaHibernateDAO.getInstance();
        this.cadMotorista = new Motorista();
    }
    
    public String cadastrar(){
        this.motoristaHibernate.cadastrar(this.cadMotorista);
        this.cadMotorista = new Motorista();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Motorista cadastrado com sucesso!"));
        
        return "index.xhtml";
    }
    
    public String alterar(){
        this.motoristaHibernate.alterar(this.selectedMotorista);
   
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Motorista alterado com sucesso!"));
        
        return "index.xhtml";
    }
    
    public String deletar(){
        this.motoristaHibernate.deletar(this.selectedMotorista);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Motorista deletado com sucesso!"));
        
        return "index.xhtml";
    }
    
    public Motorista recuperar(){
        return this.motoristaHibernate.recuperar(this.selectedMotorista.getId_motorista());
    }
    
    public List<Motorista> recuperarTodos(){
        return this.motoristaHibernate.recuperarTodos();
    }
    
    public Motorista recuperarPorCpf(){
        return this.motoristaHibernate.recuperarPorCpf(this.selectedMotorista.getCpf());
    }
    
    public boolean login(){
        return false;
    }

    public Motorista getCadMotorista() {
        return cadMotorista;
    }

    public void setCadMotorista(Motorista cadMotorista) {
        this.cadMotorista = cadMotorista;
    }

    public Motorista getSelectedMotorista() {
        return selectedMotorista;
    }

    public void setSelectedMotorista(Motorista selectedMotorista) {
        this.selectedMotorista = selectedMotorista;
    }
    
    
}
