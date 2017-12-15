package controller;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.entidades.Carro;
import model.implementacoes.CarroHibernateDAO;

/**
 *
 * @author Mark IV
 */
@ManagedBean
@ViewScoped
public class CarroController {

    private final CarroHibernateDAO carroHDAO;
    private Carro cadCarro;
    private Carro selectedCarro;

    public CarroController() {
        this.carroHDAO = CarroHibernateDAO.getInstance();
        this.cadCarro = new Carro();
    }

    public void cadastrar() {
        this.carroHDAO.cadastrar(this.cadCarro);
        this.cadCarro = new Carro();
    }

    public String alterar() {
        this.carroHDAO.alterar(this.selectedCarro);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Carro alterado com sucesso!"));

        return "index.xhtml";
    }
    
    public void deletar(){
        this.carroHDAO.deletar(this.selectedCarro);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O carro foi deletado."));
    }
    
    public List<Carro> recuperarTodos(){
        return this.carroHDAO.recuperarTodos();
    }

    public Carro getCadCarro() {
        return cadCarro;
    }

    public void setCadCarro(Carro cadCarro) {
        this.cadCarro = cadCarro;
    }

    public Carro getSelectedCarro() {
        return selectedCarro;
    }

    public void setSelectedCarro(Carro selectedCarro) {
        this.selectedCarro = selectedCarro;
    }

}
