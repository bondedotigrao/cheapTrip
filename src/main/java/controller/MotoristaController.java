package controller;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.entidades.Carro;
import model.entidades.Local;
import model.entidades.Motorista;
import model.negocio.MotoristaDAO;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Mark IV
 */
@ManagedBean
@SessionScoped
public class MotoristaController {

    private final MotoristaDAO motoristaHibernate;
    private Motorista cadMotorista;
    private Motorista selectedMotorista = (Motorista) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("motoristaLogado");

    public MotoristaController() {
        this.motoristaHibernate = new MotoristaDAO();
        this.cadMotorista = new Motorista();
    }

    public String cadastrar(Local local, Carro carro) {
        this.cadMotorista.setLocal(local);
        this.cadMotorista.setCarro(carro);

        this.motoristaHibernate.cadastrar(this.cadMotorista);

        this.cadMotorista = new Motorista();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Motorista cadastrado com sucesso!"));

        return "loginMotorista.xhtml";
    }

    public String alterar(Local local,Carro carro) {
        this.selectedMotorista.setLocal(local);
        this.selectedMotorista.setCarro(carro);
        this.motoristaHibernate.alterar(this.selectedMotorista);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Motorista alterado com sucesso!"));

        return "index.xhtml";
    }

    public String deletar() {
        this.motoristaHibernate.deletar(this.selectedMotorista);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Motorista deletado com sucesso!"));

        return "index.xhtml";
    }

    public Motorista recuperar() {
        return this.motoristaHibernate.recuperar(this.selectedMotorista.getId_motorista());
    }

    public List<Motorista> recuperarTodos() {
        return this.motoristaHibernate.recuperarTodos();
    }

    public Motorista recuperarPorCpf() {
        return this.motoristaHibernate.recuperarPorCpf(this.selectedMotorista.getCpf());
    }

    public boolean login(String login,String senha) {
       return this.motoristaHibernate.login(login, senha);
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
