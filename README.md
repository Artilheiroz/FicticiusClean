# Ficticius Clean
Rest API com Java SpringBoot usando Hibernate e PostgreSql

### Pré-Requisitos
- Java JDK 8+  [Download JDK](https://www.oracle.com/technetwork/pt/java/javase/downloads/index.html "Download JDK");
- Maven compativel com Java 8 [Download Maven](https://maven.apache.org/download.cgi "Download Maven").

### Executando
Alterar os dados de Conexão com o banco de dados no arquivo  src\main\resources\application.properties

Para iniciar a API no eclipse basta clicar com o botão direito no main da classe FicticiusCleanApplication.java e selecionar **Run As -> Java Aplication**

ou executar a seguinte linha de comando no Prompt de comando na pasta raiz do projeto

```bash
mvn spring-boot:run
```

### End-Points
#### A aplicação possui os seguintes end-points:
- **(GET)** /FicticiusClean/veiculo/getVeiculos : Retorna todos os Veículos do banco de dados
- **(GET)** /FicticiusClean/veiculo/getVeiculoId/{veiculoId} : Retorna o Veículos com aquele ID
- **(POST)** /FicticiusClean/veiculo/createVeiculo: Cadastra Veiculo, espera JSON no RequestBody como demonstrado no exemplo 1
- **(PUT)** /FicticiusClean/veiculo/updadeVeiculo/{veiculoId}: Atualiza Veiculo, espera JSON no RequestBody como demonstrado no exemplo 1
- **(DELETE)** /FicticiusClean/veiculo/deleteVeiculo/{veiculoId}: Remove Veículo
- **(GET)** /FicticiusClean/veiculo/getGastos: Espera JSON no RequestBody, como demonstrado no exemplo 2, com os dados da viagem, e retorna umas lista com os gastos estimados dos veículos cadastrados no fomrmato de JSON como demonstrado no exemplo 3

##### Exemplo 1: JSON Veículo
```json
{
	"nome": "320i",
	"marca": "BMW",
	"modelo": "GP 2.0",
	"dataFabricacao": "10/11/2021",
	"consumoCidade": 11.1,
	"consumoRodovia": 12.5
}
```

##### Exemplo 2: JSON Dados Viagem
```json
{
	"precoGasolina": 3.91,
	"kmCidade": 17.25,
	"kmRodovia": 82.12
}
```

##### Exemplo 3: JSON Gastos Aproximados
```json
[
	{
        "nome": "320i",
        "marca": "BMW",
        "modelo": "GP 2.0",
        "ano": 2021,
        "quantidadeCombustivel": 8.123654,
        "valorGasto": 31.76
    }
]
```
