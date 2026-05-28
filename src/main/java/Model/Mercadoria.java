package com.example.Mercadorias.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mercadorias")
public class Mercadoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String m_sNome;
    private double m_dPreco;
    private int m_iQuantidade;

    public Long getId() { return id; }

    public void setQuantidade(int i) { m_iQuantidade = i; }
    public int getQuantidade() { return m_iQuantidade; }

    public double getPreco() { return m_dPreco; }
    public void setPreco(double preco) { m_dPreco = preco; }

    public String getNome() { return m_sNome; }
    public void setNome(String nome) { m_sNome = nome; }
}