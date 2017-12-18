package controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.entidades.Local;
import model.negocio.LocalDAO;

/**
 *
 * @author Jarvis
 */
@ManagedBean
@SessionScoped
public class LocalController{

    private final LocalDAO localHibernate;
    private Local selectedLocal;
    private Local cadLocal;

    public LocalController() {
        this.localHibernate = new LocalDAO();
        this.cadLocal = new Local();
    }

    public void cadastrar() {
        this.localHibernate.cadastrar(this.cadLocal);
    }

    public Local getCadLocal() {
        return cadLocal;
    }

    public void setCadLocal(Local cadLocal) {
        this.cadLocal = cadLocal;
    }

    public String alterar(Local local) {
        this.selectedLocal = local;
        this.localHibernate.alterar(this.selectedLocal);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Local alterado com sucesso!"));
        
        return "index.xhtml";
    }

    public void deletar() {
        this.localHibernate.deletar(this.selectedLocal);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Um local foi deletado."));
    }

    public List<Local> recuperarTodos() {
        return this.localHibernate.recuperarTodos();
    }

    public Local getSelectedLocal() {
        return selectedLocal;
    }

    public void setSelectedLocal(Local selectedLocal) {
        this.selectedLocal = selectedLocal;
    }

}
