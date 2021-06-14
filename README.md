# SistemaBancario

> Sistema bancario para a disciplina de SOO 

  - Spring
  - JDBC
  - JUnit

### Endpoints 

##### Cadastrar Pessoa Fisica (POST):

`localhost:8080/banco/cadastrarPessoaFisica`

body:
```json
{
    "nome": String,
    "telefone": String,
    "rua": String,
    "numeroEndereco": String,
    "bairro": String,
    "cidade": String,
    "estado": String,
    "dataNascimento": String,
    "sexo": String,
    "cpf": String,
    "rg": String
}
```
------------------------------------------------------------

##### Cadastrar Pessoa Juridica (POST):

`localhost:8080/banco/cadastrarPessoaJuridica`

body:
```json
{
    "nome": String,
    "telefone": String,
    "rua": String,
    "numeroEndereco": String,
    "bairro": String,
    "cidade": String,
    "estado": String,
    "dataNascimento": String,
    "sexo": String,
    "cnpj": String,
    "ie": String
}
```
------------------------------------------------------------

##### Cadastrar Conta (POST):

`localhost:8080/banco/cadastrarConta`

body:
```json
{
    "tipoConta": String,
    "documentoCliente": String
}
```

### TO-DO

| Status | Detalhes |
| ------ | ------ |
| to-do | Mapear exceção em todo catch |
| to-do | Criar lógica e a rota de impressão de relatório |