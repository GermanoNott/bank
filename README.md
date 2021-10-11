#O PROJETO
Aplicação semelhante a um sistema bancário.
- Consulta de saldo;
- Transferência entre contas;
- Reverter uma transferência;

https://github.com/GermanoNott/bank



# Tecnologias Usadas
- Spring initializr para criar o projeto com dependencias: Spring Boot Devtools, Lombok, Spring web.
- Java 
- Maven
- intelliJ como IDE de desenvolvimento.
- Postman
- pgAdmin 4

# Para testes foi usado Postman:
Consultar Saldo
http://localhost:8080/account/1 //Trocar "1" por id da conta

Para transferencia
Put http://localhost:8080/transfer/
{
"idAccountOrigin": 1,  //Usar "1" por id da conta que é incrementado em 1
"idAccountDestiny": 2, //Trocar "2" por id da conta que é incrementado em 1
"value": 100
}

Para reverter transferência
Post http://localhost:8080/transfer/
{
"idTransferCredit": 2, //Usar "1" por id da conta que é incrementado em 1
"idTransferDebit": 1 //Usar "1" por id da conta que é incrementado em 1
}
