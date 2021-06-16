# SistemaBancario

> Sistema bancário para a disciplina de SOO 

  - Spring
  - JDBC
  - JUnit

### Endpoints 

##### Cadastrar Pessoa Física (POST):

`localhost:8080/banco/cadastrarPessoaFisica`

body:
```json
{
    "nome": "String",
    "telefone": "String",
    "rua": "String",
    "numeroEndereco": "String",
    "bairro": "String",
    "cidade": "String",
    "estado": "String",
    "dataNascimento": "String",
    "sexo": "String",
    "cpf": "String",
    "rg": "String"
}
```
------------------------------------------------------------

##### Cadastrar Pessoa Jurídica (POST):

`localhost:8080/banco/cadastrarPessoaJuridica`

body:
```json
{
    "nome": "String",
    "telefone": "String",
    "rua": "String",
    "numeroEndereco": "String",
    "bairro": "String",
    "cidade": "String",
    "estado": "String",
    "dataNascimento": "String",
    "sexo": "String",
    "cnpj": "String",
    "ie": "String"
}
```
------------------------------------------------------------

##### Cadastrar Conta (POST):

`localhost:8080/banco/cadastrarConta`

body:
```json
{
    "tipoConta": "String",
    "documentoCliente": "String"
}
```
------------------------------------------------------------

##### Extrair Relação de Contas (GET):

`localhost:8080/banco/extrairRelacaoContas`

------------------------------------------------------------

##### Efetuar Transação de Saque ou Débito (PUT):

`localhost:8080/banco/efetuarTransacao`

body:
```json
{
    "valor": "BigDecimal",
    "numero": "String",
    "tipoTransacao": "String"
}
```
------------------------------------------------------------
### TO-DO

| Status | Detalhes |
| ------ | ------ |
| done | Criar lógica e a rota de saque e depósito |
| done | Mapear exceção em todo catch |
| done | Pelo menos 3 casos de teste |
| done | Criar lógica e a rota de impressão de relatório |
| done | Pelo menos 3 persistência de dados: cadastrar conta, efetuar saque e depósito, pessoa, pessoa física e pessoa jurídica |
