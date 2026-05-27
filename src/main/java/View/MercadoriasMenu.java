package View;

import java.io.IOException;

public class MercadoriasMenu {

    private MercadoriasControle controle = new MercadoriasControle();

    public void executa() throws IOException{
        EntradaSaida.coutln("Faturamento de Mercadorias.");
        char ch = ' ';

        while (ch != 'S' && ch != 's'){
            EntradaSaida.cout("Para encerrar entrada de dados digite S ou s: ");
            ch = EntradaSaida.cinch();
            if (ch == 'S' || ch == 's')
                break;

            EntradaSaida.cout("Digite o nome: ");
            String sNome = EntradaSaida.cin();

            EntradaSaida.cout("Digite o preço: ");
            double dPreco = EntradaSaida.cind();

            EntradaSaida.cout("Digite a Quantidade: ");
            int iQuantidade = EntradaSaida.cini();

            controle.adicionaMercadoria(sNome, dPreco, iQuantidade);
        }

        String s = controle.calculaMaiorTotalDeVendasEmReais();
        EntradaSaida.coutln(s);

        double dFaturamentoTotalMensal = controle.calculaFaturamentoTotalMensal();
        EntradaSaida.coutln("O faturamento total mensal é: "+ dFaturamentoTotalMensal);

        for (int i=0; i<controle.getTotalMercadorias(); i++){
            s=controle.retornarPercentualPorMercadoria(i, dFaturamentoTotalMensal);
            EntradaSaida.coutln(s);
        }
        EntradaSaida.coutln("Encerrado.");
    }
}