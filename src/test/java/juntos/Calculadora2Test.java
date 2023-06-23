pacote  juntos ;

        importar  org . testng . Afirmar ;
        importar  org . testng . anotações . Teste ;

public  class  Calculadora2Test {

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
