// 1 - Pacote
pacote  apitest ;
        importar  com . google . gson . Gson ;
        entidades de importação . AccountEntity ;
        importar  io . tranquilizado . resposta . Resposta ;
        importar  org . testng . Afirmar ;
        importar  org . testng . anotações . Teste ;
        importar  io estático  . tranquilizado . Fique tranquilo . dado ;
        importar  org estático  . . _ Combinadores . é ;
// 2 - Bibliotecas
// 3 - Aula
        classe  pública Conta {
        // 3.1 - Atributos
        String  ID do usuário ;
        String  ct = "aplicativo/json" ; // contentType da API
        String  jsonBody ; // salva o json que será enviado
        String  uri = "https://bookstore.toolsqa.com/Account/v1/" ; // Endereço base
        Resposta  resposta ; // guarda o retorno da API
        token String estático ; // salva o token - login do usuário

        // 3.1.2 Instanciar Classes Externas
        Gson  gson = novo  Gson (); // Instância do objeto de conversão de classe para json

@@ -31,7 +31,7 @@ public class TestBookStore {

    AccountEntity  conta = new  AccountEntity (); // Instância a entidade usuária
    // 3.2 - Métodos e Funções
    // Método #1 - Criar Usuário
    @ Teste ( prioridade = 1 )
    public  void  testCreateUser () {
        // Organizar - Configurar

        conta.userName = " FlexOne "; // entrada e saida (resultado esperado)
        conta.senha = "123456"; // entrada

        jsonBody = gson.toJson(conta);  // Converte uma entidade usuária no formato json


        @ @ -164, 5 + 164, 25 @@public void testResearchUser () {

            // Agir - Executar
            // Dado - Quando - Então
            // Dado - Quando - Então
            resposta = (Resposta) dada()       // dado
                    .contentType(ct)     // tipo de conteúdo
                    .registro().all()                         // registra tudo na ida
                    .body(jsonBody)     // corpo da mensagem que será enviada
                    .quando() // quando
                    .postar(uri + "Usuário")
                    // Assert - Valida
                    .então() // então
                    .registro().all()         // registra tudo na volta
                    .statusCode(201) // valida a comunicação
                    .body("username", is(account.userName)) // valida o usuário
                    .extrair()
            ; // fim da linha do REST-assured
            // extrai o userID (identificação do usuário)
            userId = resposta.jsonPath().getString("userID");
            Sistema.fora.println("UserID extraido: " + userId);
        } // fim do método de criação de usuário
        @Teste(prioridade = 2)
        public void testGenerateToken () {
            // Configurar
            // --> Dados de Entrada são fornecidos pela AccountEntity
            // --> Resultado Esperado é que ele recebe um token
            // Executa
            resposta = (Resposta) dada()
                    .tipo de conteúdo (ct)
                    .registro().todos()
                    .corpo(jsonBody)
                    .quando()
                    .post(uri + "GerarToken")
                    .então()
                    .registro().todos()
                    .statusCode(200) // valida a comunicação
                    .body("status", is("Sucesso")) // Status = Sucesso
                    .body("resultado", is("Usuário autorizado com sucesso."))
                    .extrair()
            ;
            // Extração do Token
            ficha = resposta.jsonPath().getString("token");
            Sistema.fora.println("token: " + token);
            // valida
            Afirmar.assertTrue(token.length() != 0);
        } // fim do método de geração de token de identificação do usuário
        @Teste(prioridade = 3)
        public void testAuthorized () {
            // Configurar
            // Dados de entrada
            // --> Fornecidos pele AccountEntity através do método testCreateUser - priority = 1
            // Dados de Saída / Resultado Esperado
            // Código de status = 200
            // Corpo da resposta = true
            // Executa
            dado()
                    .tipo de conteúdo (ct)
                    .registro().todos()
                    .corpo(jsonBody)
                    .quando()
                    .post(uri + "Autorizado")
                    // valida
                    .então()
                    .registro().todos()
                    .código de status (200)
            // .body(true) // ToDo: como validar o retorno do corpo apenas como true
            ;
        }
        @Teste(prioridade = 4)
        public void testResearchUserNotAuthorized () {
            // Configurar
            // Dados de entrada
            // userId foi extraido no método testCreateUser e está na memória
            // Dados de Saída / Resultado Esperado
            // Status Code = 401, Code = 1200 e Message = Usuário não autorizado!
            // Executa
            dado()                                      // Dado // Comandos do REST-garantido
                    .contentType(ct)                     // Formato da mensagem
                    .registro().all()                         // exibe tudo o que acontece na ida
                    .quando()                                      // Quando
                    .get(uri + "User/" + userId)    // Consulta o usuário pelo userId
                    // valida
                    .então()                                      // Então
                    .registro().all()                         // exibe tudo o que acontece na volta
                    .statusCode(401)      // Valida se não está autorizado
                    .body("code", is("1200")) // Valida o código de mensagem "não autorizado"
                    .body("mensagem", is("Usuário não autorizado!"))
            ;                                           // Conclui o bloco do REST-assured
        }
        @Teste(prioridade = 5)
        public void testResearchUser () {
            // Configurar
            // Dados de entrada
            // userId foi extraido no método testCreateUser e está na memória
            // Dados de Saída / Resultado Esperado
            // userName virá da classe Account e o código de status deve ser 200
            // Executa
            dado()                                      // Dado // Comandos do REST-garantido
                    .contentType(ct)                     // Formato da mensagem
                    .registro().all()                         // exibe tudo o que acontece na ida
                    .cabeçalho("Autorização", "Portador " + token)
                    .quando()                                      // Quando
                    .get(uri + "User/" + userId)    // Consulta o usuário pelo userId
                    // valida
                    .então()                                      // Então
                    .registro().all()                         // exibe tudo o que acontece na volta
                    .statusCode(200)      // Valida se a conexão teve sucesso
                    .corpo("userId", is(userId))
                    .body("username", is(account.userName)) // Valida o nome do usuário
            ;                                           // Conclui o bloco do REST-assured
        }
        @Teste(prioridade = 20)
        public void testDeleteUser () {
            // Configurar
            // Dados de entrada vem do método de teste da criação do usuário (userId)
            // Resultado esperado é o código e mensagem de sucesso na exclusão do usuário

            // Executa
            dado()
                    .registro().todos()
                    .tipo de conteúdo (ct)
                    .cabeçalho("Autorização", "Portador " + token)
                    .quando()
                    .deletar(uri + "Usuário/" + userId)
                    // valida
                    .então()
                    .registro().todos()
                    .código de status (204)
            ;

        }
    }
}
