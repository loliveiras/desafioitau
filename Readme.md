################# Expor API para armazenar tarefas #####################

Para subir o sistema e utilizar suas funcionalidades, basta executar a classe SpringBootApplicationStarter.

Pode subir tambem pelo maven através do comando mvn springboot:run.

Este sistema possui um arquivo Dockerfile, que gera uma imagem docker para subir o serviço dentro de um container.

Comandos para gerar a imagem.

---- docker build -t nomeDaImagem indicar o caminho onde esta o docker file.

---- exemplo: docker build -t tarefas .


=========================================================================

A aplicação usa um banco de dados em memória chamado H2, para simplicar a aplicação.

Quando estiver no ar, basta acessar o caminho abaixo:

http://localhost:8080/console

login: SA
não possui senha.

========================================================================

Para adicionar uma tarefa favor executar os passos abaixo:

POST: http://localhost:8080/services/tarefa
JSON:     
      {
	"nome": "teste13",
	"status": "Completed"
      }

Para buscar todas tarefas cadastradas no banco favor executar os passos abaixo:

GET:  http://localhost:8080/services/tarefa

Para atualizar alguma tarefa cadastrada no banco favor executar os passos abaixo

PUT: http://localhost:8080/services/tarefa/idTarefa

========================================================================

Para ver performance, metricas do sistemas favor seguir os passos abaixo:

http://localhost:8080/services/health

Opções para exibir informações do sistema:

health,info,httptrace,metrics,logging


========================================================================
