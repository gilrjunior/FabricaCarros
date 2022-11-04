package bean;
public class Pessoa 
{
    private long codigo;
    private String nome;
    private String endereco;
    private String email;
    public Pessoa()
    {
        this.codigo = 0;
        this.nome = "sem nome";
        this.endereco = "sem endereço";
        this.email = "sem email";
    }
    public Pessoa(long codigo, String nome, String endereco, String email) 
    {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
    }
    public long getCodigo() 
    {
        return codigo;
    }
    public void setCodigo(long codigo) 
    {
        this.codigo = codigo;
    }
    public String getNome() 
    {
        return nome;
    }
    public void setNome(String nome) 
    {
        this.nome = nome;
    }
    public String getEndereco() 
    {
        return endereco;
    }
    public void setEndereco(String endereco) 
    {
        this.endereco = endereco;
    }
    public String getEmail() 
    {
        return email;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }   
    @Override
    public String toString()
    {
        return(" Codigo: "+this.codigo+" - Nome: "+this.nome+" - Endereco: "+this.endereco+" - Email: "+this.email);
    }
}

