// 1 - Pacote
package br.com.iterasys.com.iterascys;
// 2 - Importação de Bibliotecas


// 3 - Classe
public class Encomenda {
    public static void calcularBarrasDeChocolatesPorCaixa(int barras) {
    }
    // 3.1 Atributos

       // 3.2 Funções e Métodos
    public int calcularBarrasDeChocolatePorCaixa(int barras){
        byte quantidadePorCaixas = 12;
        int caixas = barras / quantidadePorCaixas;
        int unidades = barras % quantidadePorCaixas;
        System.out.println("Quantidade de caixas:" + caixas);
        return barras;
    } // fim de calcularBarrasDeChocolatePorCaixa

} // fim da classe Enomenda
