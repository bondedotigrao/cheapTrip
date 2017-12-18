package controller;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.entidades.Local;
import model.entidades.Motorista;
import model.entidades.Viagem;
import model.negocio.ViagemDAO;

/**
 *
 * @author Jarvis
 */
@ManagedBean
@ViewScoped
public class ViagemController {

    private final ViagemDAO viagemHibernate;
    private Viagem cadViagem;
    private Viagem selectedViagem;

    public ViagemController() {
        this.viagemHibernate = new ViagemDAO();
        this.cadViagem = new Viagem();
    }

    public void cadastrar(Local local) {
        ServletRequest req = null;
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = (HttpSession) request.getSession();
        Motorista m = (Motorista) session.getAttribute("motoristaLogado");
        
        this.cadViagem.setLocal(local);
        this.cadViagem.setMotorista(m);

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
