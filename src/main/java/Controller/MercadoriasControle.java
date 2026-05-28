package com.example.Mercadorias.controler;

import com.example.Mercadorias.model.Mercadoria;
import com.example.Mercadorias.repository.MercadoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MercadoriasControle {

    @Autowired
    private MercadoriaRepository repository;

    public String calculaMaiorTotalDeVendasEmReais() {
        List<Mercadoria> lista = repository.findAll();
        double dPrecoTotal = 0;
        Mercadoria mMaiorVenda = new Mercadoria();
        for (Mercadoria m : lista) {
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
        List<Mercadoria> lista = repository.findAll();
        double dFaturamento = 0;
        for (Mercadoria m : lista) {
            dFaturamento += (m.getPreco() * m.getQuantidade());
        }
        return dFaturamento;
    }

    public int getTotalMercadorias() {
        return (int) repository.count();
    }

    public void adicionaMercadoria(String nome, double preco, int quantidade) {
        Mercadoria m = new Mercadoria();
        m.setNome(nome);
        m.setPreco(preco);
        m.setQuantidade(quantidade);
        repository.save(m); // ✅ salva no banco
    }

    public String retornarPercentualPorMercadoria(int i, double dFaturamentoTotalMensal) {
        List<Mercadoria> lista = repository.findAll();
        String s = "";
        if (i < lista.size()) {
            Mercadoria m = lista.get(i);
            double dPerc = ((m.getPreco() * m.getQuantidade()) / dFaturamentoTotalMensal) * 100;
            s = "A mercadoria " + m.getNome()
                    + " tem o percentual no faturamento igual a " + dPerc + " %";
        }
        return s;
    }
}