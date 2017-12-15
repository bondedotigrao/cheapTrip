package controller;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.entidades.Viagem;
import model.implementacoes.ViagemHibernateDAO;

/**
 *
 * @author Jarvis
 */
@ManagedBean
@ViewScoped
public class ViagemController {

    private final ViagemHibernateDAO viagemHibernate;
    private Viagem cadViagem;
    private Viagem selectedViagem;

    public ViagemController() {
        this.viagemHibernate = ViagemHibernateDAO.getInstance();
        this.cadViagem = new Viagem();
    }

    public void cadastrar() {
        this.viagemHibernate.cadastrar(this.cadViagem);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Viagem adicionada com sucesso"));
        this.cadViagem = new Viagem();
    }

    public void alterar() {
        this.viagemHibernate.alterar(this.selectedViagem);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("A viagem alterada"));
    }

    public void deletar() {
        this.viagemHibernate.deletar(this.selectedViagem);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Viagem deletada!"));
    }

    public List<Viagem> recuperarTodas() {
        return this.viagemHibernate.recuperarTodos();
    }

    public Viagem getCadViagem() {
        return cadViagem;
    }

    public void setCadViagem(Viagem cadViagem) {
        this.cadViagem = cadViagem;
    }

    public Viagem getSelectedViagem() {
        return selectedViagem;
    }

    public void setSelectedViagem(Viagem selectedViagem) {
        this.selectedViagem = selectedViagem;
    }

}
