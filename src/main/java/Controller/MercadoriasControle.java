package com.example.Mercadorias.controller;

import com.example.Mercadorias.model.Mercadoria;
import java.util.ArrayList;

public class MercadoriasControle {

    private ArrayList<Mercadoria> m_vctMercadorias = new ArrayList<>();

    public String calculaMaiorTotalDeVendasEmReais() {
        double dPrecoTotal = 0;
        Mercadoria mMaiorVenda = new Mercadoria();
        for (int i = 0; i < m_vctMercadorias.size(); i++) {
            Mercadoria m = m_vctMercadorias.get(i);
            double dTotalMercadoria = m.getPreco() * m.getQuantidade();
            if (dTotalMercadoria > dPrecoTotal) {
                mMaiorVenda = m;
                dPrecoTotal = dTotalMercadoria;
            }
        }
        return "A mercadoria " + mMaiorVenda.getNome()
                + " tem o maior valor de vendas que é R$"
                + mMaiorVenda.getPreco() * mMaiorVenda.getQuantidade();
    }

    public double calculaFaturamentoTotalMensal() {
        double dFaturamento = 0;
        for (int i = 0; i < m_vctMercadorias.size(); i++) {
            Mercadoria m = m_vctMercadorias.get(i);
            dFaturamento += (m.getPreco() * m.getQuantidade());
        }
        return dFaturamento;
    }

    public int getTotalMercadorias() {
        return m_vctMercadorias.size();
    }

    public void adicionaMercadoria(String nome, double preco, int quantidade) {
        Mercadoria m = new Mercadoria();
        m.setNome(nome);
        m.setPreco(preco);
        m.setQuantidade(quantidade);
        m_vctMercadorias.add(m);
    }

    public String retornarPercentualPorMercadoria(int i, double dFaturamentoTotalMensal) {
        String s = "";
        if (i < m_vctMercadorias.size()) {
            Mercadoria m = m_vctMercadorias.get(i);
            double dPerc = ((m.getPreco() * m.getQuantidade()) / dFaturamentoTotalMensal) * 100;
            s = "A mercadoria " + m.getNome()
                    + " tem o percentual no faturamento igual a " + dPerc + " %";
        }
        return s;
    }
}