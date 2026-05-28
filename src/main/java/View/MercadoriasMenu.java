package com.example.Mercadorias.view;

import com.example.Mercadorias.controler.MercadoriasControle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@Component
public class MercadoriasMenu {

    @Autowired
    private MercadoriasControle controle; // ✅ Spring injeta automaticamente

    private Scanner scanner = new Scanner(System.in);

    public void executa() throws IOException {
        System.out.println("Faturamento de Mercadorias.");
        char ch = ' ';

        while (ch != 'S' && ch != 's') {
            System.out.print("Para encerrar entrada de dados digite S ou s: ");
            ch = scanner.nextLine().charAt(0);

            if (ch == 'S' || ch == 's')
                break;

            System.out.print("Digite o nome: ");
            String sNome = scanner.nextLine();

            System.out.print("Digite o preço: ");
            double dPreco = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Digite a Quantidade: ");
            int iQuantidade = scanner.nextInt();
            scanner.nextLine();

            controle.adicionaMercadoria(sNome, dPreco, iQuantidade);
        }

        String s = controle.calculaMaiorTotalDeVendasEmReais();
        System.out.println(s);

        double dFaturamentoTotalMensal = controle.calculaFaturamentoTotalMensal();
        System.out.println("O faturamento total mensal é: " + dFaturamentoTotalMensal);

        for (int i = 0; i < controle.getTotalMercadorias(); i++) {
            s = controle.retornarPercentualPorMercadoria(i, dFaturamentoTotalMensal);
            System.out.println(s);
        }

        System.out.println("Encerrado.");
        scanner.close();
    }
}