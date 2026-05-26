package Model;

public class Mercadoria {

    private String m_sNome = "";
    private double m_dPreço = 0;
    private int m_iQuantidade = 0;

    public void setQuantidade(int i){
        m_iQuantidade = i;
    }
}
public int getQuantidade(){
    return m_iQuantidade;
}
public double getPreco(){
    return m_dPreco();
}
public void setPreco(double preco){
    m_dPreco = preco;
}
public String getNome(){
    return m_sNome;
}
public void setNome(String nome){
    m_sNome = nome;
}