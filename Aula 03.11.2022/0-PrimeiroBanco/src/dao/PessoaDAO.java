package dao;
import bean.Pessoa;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class PessoaDAO 
{
   Connection conexao;
   public PessoaDAO() throws SQLException, ClassNotFoundException
   {
      this.conexao = Conexao.getConexao();
   }
   public void adicionarPessoa(Pessoa pessoa)
   {
      PreparedStatement ps_estado;
      String msgSql = "insert into pessoa(codigo,nome,endereco,email) values(?,?,?,?)";
      try{
        ps_estado =  this.conexao.prepareStatement(msgSql);
        ps_estado.setLong(1, pessoa.getCodigo());
        ps_estado.setString(2, pessoa.getNome());
        ps_estado.setString(3, pessoa.getEndereco());
        ps_estado.setString(4, pessoa.getEmail());
        ps_estado.execute();
        ps_estado.close();
        System.out.print("\n Informacao adicionada com sucesso.");
      }catch(SQLException e){
          System.out.print("\n Erro ao adicionar no banco: "+e.toString());
      }
   }
   public ArrayList<Pessoa> buscarPeloNome(String nome)
   {
       PreparedStatement ps_estado;
       ResultSet res;
       ArrayList <Pessoa> minhaLista = null;
       String msgSql = "select * from pessoa where nome = ?";
       try{
            ps_estado = this.conexao.prepareStatement(msgSql);
            ps_estado.setString(1, nome);
            res = ps_estado.executeQuery();
            minhaLista = new ArrayList<>();
            while(res.next())
            {
                Pessoa pessoa = new Pessoa();
                pessoa.setCodigo((res.getLong("codigo")));
                pessoa.setNome(res.getString("nome"));
                pessoa.setEndereco(res.getString("endereco"));
                pessoa.setEmail(res.getString("email"));
                minhaLista.add(pessoa);
            }
            System.out.println("\n Informacao buscada com sucesso.");
            res.close();
            ps_estado.close();
       }catch(SQLException e){
            System.out.print("\n Erro ao buscar nome no banco: "+e.toString());
       } 
       return (minhaLista);
   }
   public ArrayList<Pessoa> buscarListaCompleta()
   {
       PreparedStatement ps_estado;
       ResultSet res;
       ArrayList<Pessoa> minhaLista=null;
       String msgSql = "select * from pessoa";
       try{
            ps_estado = this.conexao.prepareStatement(msgSql);
            res = ps_estado.executeQuery();
            minhaLista = new ArrayList<>();
            while(res.next())
            {
                Pessoa pessoa = new Pessoa();
                pessoa.setCodigo(res.getInt("codigo"));
                pessoa.setNome(res.getString("nome"));
                pessoa.setEndereco(res.getString("endereco"));
                pessoa.setEmail(res.getString("email"));
                minhaLista.add(pessoa);
            }
            System.out.println("\n Informacao buscada com sucesso.");
            res.close();
            ps_estado.close();
       }catch(SQLException e){
            System.out.print("\n Erro ao buscar todos no banco: "+e.toString());
       }
       return (minhaLista);
   }
   public void remover(long codigo)
   {
       PreparedStatement ps_estado;
       String msgSql = "delete from pessoa where codigo = ?";
       try{
            ps_estado = this.conexao.prepareStatement(msgSql);
            ps_estado.setLong(1, codigo);
            ps_estado.execute();
            ps_estado.close();
            System.out.println("\n Informacao removida com sucesso.");
       }catch(SQLException e){
          System.out.print("\n Erro ao remover do banco: "+e.toString());
       }
   }
   public void alterar(Pessoa pessoa)
   {
       PreparedStatement estado;
       String msgSql = "update pessoa set nome=?, endereco=?, email=? where codigo=?";
       try{
            estado = this.conexao.prepareStatement(msgSql);
            estado.setString(1, pessoa.getNome());
            estado.setString(2, pessoa.getEndereco());
            estado.setString(3, pessoa.getEmail());
            estado.setLong(4, pessoa.getCodigo());
            System.out.println("\n Informacao alterada com sucesso.");
            estado.execute();
            estado.close();
       }catch(SQLException e){
            System.out.print("\n Erro ao alterar no banco: "+e.toString());
       }
   }    
}