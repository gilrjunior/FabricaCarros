
package carroDAO;

import carro.Carro
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarroDAO {
    
    Connection conexao;
    
    public CarroDAO() throws SQLException, ClassNotFoundException{
        
        this.conexao = Conexao.getConexao();
        
    }
    
    public void insertCarro(Carro carro){
        
        PreparedStatement ps_estado;
        String query = "insert into carros values(?,?,?,?,?)";
        
        try{ 
            
            ps_estado = this.conexao.prepareStatement(query);
            
            ps_estado.setString(1, carro.getChassi());
            ps_estado.setInt(2, carro.getAno());
            ps_estado.setString(3, carro.getModelo());
            ps_estado.setString(4, carro.getFabricante());
            ps_estado.setFloat(5, carro.getPotencia());
            ps_estado.execute();
            ps_estado.close();
            
            System.out.println("\n Informação Inserida no Banco");
            
        }catch(SQLException e){
            System.out.println("\n Erro ao adicionar no banco: "+e.toString());
        }
        
    }
    
    public ArrayList<Carro> mostraCarros(){
        
        
    }
    
    
}
