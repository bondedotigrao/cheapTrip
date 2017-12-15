package view;

import model.entidades.Carro;
import model.negocio.CarroDAO;

/**
 *
 * @author Jarvis
 */
public class testeCarro {
    public static void main(String args[]){
     Carro carro = new Carro("MM", 3, "praca");
    
     CarroDAO cd = new CarroDAO();
     
     cd.cadastrar(carro);

    }

}
