package principal;
import bean.Pessoa;
import dao.PessoaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
public class Principal 
{
    public static void main(String[] args) 
    {
        try{
            //Buscar elementos que já estavam no banco.
            buscarTodosElementos();
            
            //Adicionar um novo elemento.
            //adicionarElemento();
            
            //Buscar um elemento.
            //buscarElemento();
            
            //Remover um elemento.
            //removerUmElemento();
            
            //Alterar um elemento.
            //alterarElemento();   
        }catch (SQLException e1) {
            System.out.print("\n Erro SQLException: "+e1.toString());
        }catch (ClassNotFoundException e2) {
            System.out.print("\n Erro ClassNotFoundException: "+e2.toString());
        }
    }
    public static void buscarTodosElementos() throws SQLException, ClassNotFoundException
    {
        PessoaDAO pessoaAcoes = new PessoaDAO();
        ArrayList<Pessoa> minhaLista = pessoaAcoes.buscarListaCompleta();
        
        for(int i=0; i< minhaLista.size(); i++)
        {
            System.out.println("\n -> "+minhaLista.get(i));
        }
    }
    public static void adicionarElemento() throws SQLException, ClassNotFoundException
    {
        PessoaDAO pessoaAcoes = new PessoaDAO();
        String codigo, nome, endereco, email;
        Pessoa pessoa = new Pessoa();
        
        codigo = "7236";
        nome = "Caio";
        endereco = "Rua Presbiteriana";
        email = "caio@iftm";
            
        pessoa.setCodigo(Long.parseLong(codigo));
        pessoa.setNome(nome);
        pessoa.setEndereco(endereco);
        pessoa.setEmail(email);
        
        pessoaAcoes.adicionarPessoa(pessoa);
    }
    public static void buscarElemento() throws SQLException, ClassNotFoundException
    {
        String nomeBuscado = "Iwanow";
        PessoaDAO pessoaAcoes = new PessoaDAO();
        ArrayList <Pessoa> minhaLista;
        minhaLista = pessoaAcoes.buscarPeloNome(nomeBuscado);
        for(Pessoa p : minhaLista) 
        {
            System.out.println("\n >> "+p.toString());
	} 
    }
    public static void removerUmElemento() throws SQLException, ClassNotFoundException
    {
        PessoaDAO acoes = new PessoaDAO();
        acoes.remover(555);
    }
    public static void alterarElemento() throws SQLException, ClassNotFoundException
    {
        PessoaDAO pessoaAcoes = new PessoaDAO();
        String codigo, nome, endereco, email;
        Pessoa pessoa = new Pessoa();
        
        codigo = "222";
        nome = "Gian";
        endereco = "Rua Flamengo";
        email = "gia.alves@iftm.com";
            
        pessoa.setCodigo(Long.parseLong(codigo));
        pessoa.setNome(nome);
        pessoa.setEndereco(endereco);
        pessoa.setEmail(email);
            
        pessoaAcoes.alterar(pessoa);
    }
}