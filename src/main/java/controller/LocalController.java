package controller;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.entidades.Local;
import model.implementacoes.LocalHibernateDAO;

/**
 *
 * @author Jarvis
 */
@ManagedBean
@ViewScoped
public class LocalController {

    private final LocalHibernateDAO localHibernate;
    private Local cadLocal;
    private Local selectedLocal;

    public LocalController() {
        this.localHibernate = LocalHibernateDAO.getInstance();
        this.cadLocal = new Local();
    }

    public void cadastrar() {
        this.localHibernate.cadastrar(this.cadLocal);
        this.cadLocal = new Local();
    }

    public void alterar() {
        this.localHibernate.alterar(this.selectedLocal);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Local alterado com sucesso!"));
    }

    public void deletar() {
        this.localHibernate.deletar(this.selectedLocal);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Um local foi deletado."));
    }

    public List<Local> recuperarTodos() {
        return this.localHibernate.recuperarTodos();
    }

    public Local getCadLocal() {
        return cadLocal;
    }

    public void setCadLocal(Local cadLocal) {
        this.cadLocal = cadLocal;
    }

    public Local getSelectedLocal() {
        return selectedLocal;
    }

    public void setSelectedLocal(Local selectedLocal) {
        this.selectedLocal = selectedLocal;
    }

}
