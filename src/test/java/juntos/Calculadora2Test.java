// 1 - Pacote
package juntos;
// 2 - Bibliotecas
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

// 3 - Classe
public class Calculadora2Test {
    // 3.1 - Atributos
    // Por enquanto sem atributos

    // 3.2 Métodos e Funções
    // 3.2.1 Uso Compartilhado
    @DataProvider(name = "MassaMultiplicar")
    public Object[][] massaMultiplicar() {
        return new Object[][]{
                {5, 7, 35},
                {2, 10, 20},
                {20, 0, 0},
                {-5, 12, -60},
                {-5, -6, 30}
        }; // fecha o return
    }

    // 3.2.2 Testes em si

    @ Teste
    public  void  testeSomar () {
        // Arranjo
        duplo  num1 = 5 ;
        duplo  num2 = 7 ;
        double  resultado Esperado = 12 ;

        // Agir
        double  resultadoAtual = Calculadora2 . somar ( num1 , num2 );

        // Afirmar
        Afirmar . assertEquals ( resultadoAtual , resultadoEsperado );
    }

    @ Teste
    public  void  testeSubtrair () {
        // Arranjo
        duplo  num1 = 7 ;
        duplo  num2 = 5 ;
        double  resultado Esperado = 2 ;

        // Agir
        double  resultadoAtual = Calculadora2 . subtrair ( num1 , num2 );

        // Afirmar
        Afirmar . assertEquals ( resultadoAtual , resultadoEsperado );
    }

    @ Teste
    public  void  testeMultiplicar () {
        // Arranjo
        duplo  num1 = 7 ;
        duplo  num2 = 5 ;
        double  resultado Esperado = 35 ;

        // Agir
        double  resultadoAtual = Calculadora2 . multiplicar ( num1 , num2 );

        // Afirmar
        Afirmar . assertEquals ( resultadoAtual , resultadoEsperado );
    }

    @ Teste
    public  void  testeDividir () {
        // Arranjo
        duplo  num1 = 8 ;
        duplo  num2 = 2 ;
        double  resultado Esperado = 4 ;

        // Agir
        double  resultadoAtual = Calculadora2 . dividir ( num1 , num2 );

        // Afirmar
        Afirmar . assertEquals ( resultadoAtual , resultadoEsperado );
    }

    @ Teste
    public  void  testeDividirPorZero () {
        // Arranjo
        duplo  num1 = 8 ;
        duplo  num2 = 0 ;
        double  resultado Esperado = Double . NaN ;

        // Agir
        double  resultadoAtual = Calculadora2 . dividir ( num1 , num2 );

        // Afirmar
        Afirmar . assertEquals ( resultadoAtual , resultadoEsperado );
    }

}
