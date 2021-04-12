# todo-list
Poc para armazenar e atualizar tarefas - Java 11 - SpringBoot - Banco H2 - Oauth2 - Validação de permissões - Métricas com Actuactor Prometheus e Grafana - Docker Compose - JMeter

## INFOS

- **Swagger**<br>
`http://127.0.0.1:8080/todo-list/api/v1/swagger-ui.html` <br>
- **Banco em Memória H2**<br>
`http://127.0.0.1:8080/todo-list/api/v1/h2-console/` <br>
`JDBC URL: jdbc:h2:mem:todolist`<br>
`User Name: SA`<br>
`Password:`<br>
- **Actuator**<br>
`http://127.0.0.1:8080/todo-list/api/v1/actuator` <br>
- **Grafana**<br>
`User Name: admin`<br>
`Password: pass`<br>
`http://127.0.0.1:3000/login` <br>
- **Prometheus**<br>
`http://127.0.0.1:8080/todo-list/api/v1/actuator/prometheus` <br>

- **Users do Sisema**<br>
<br>
`email: admin@admin.com`<br>
`password: admin`<br>
`role: ROLE_ADMIN`<br>
<br>

`email: fulano@fulano.com`<br>
`password: fulano`<br>
`role: ROLE_DEFAULT`<br>
<br>

`email: ciclano@ciclano.com`<br>
`password: ciclano`<br>
`role: ROLE_DEFAULT`<br>
<br>

## Executar Localmente
- **Executar Java** Dentro da pasta target executar o comando (`java -jar todo-list-0.0.1-SNAPSHOT.jar`) ou dentro da pasta principal do projeto executar o comando (`mvn spring-boot:run`) *verificar se o maven suporta java 11 (`mvn-version`)*

## CURL

`curl --location --request POST 'http://localhost:8080/todo-list/api/v1/oauth/token' \
--header 'Authorization: Basic bXlhcHBuYW1lMTIzQDpteWFwcHNlY3JldDEyM0A=' \
--form 'grant_type="password"' \
--form 'username="admin@admin.com"' \
--form 'password="admin"'`

`curl --location --request GET 'http://localhost:8080/todo-list/api/v1/tasks/all' \
--header 'Authorization: Bearer 331fa10b-8bec-4c3a-af4d-f2ae9a901823'`

`curl --location --request GET 'http://localhost:8080/todo-list/api/v1/tasks' \
--header 'Authorization: Bearer d95f4602-dd47-4dba-b0a2-c50d56911ef3'`

`curl --location --request PUT 'http://localhost:8080/todo-list/api/v1/tasks' \
--header 'Authorization: Bearer 331fa10b-8bec-4c3a-af4d-f2ae9a901823' \
--header 'Content-Type: application/json' \
--data-raw '{
 "id": "5",
 "date":"2021-03-11T17:19:00.000",
 "description":"Finallizado",
 "summary":"Tarefa Terminada",
 "status": "COMPLETED"
}'`
  
`curl --location --request GET 'http://localhost:8080/todo-list/api/v1/tasks/1' \
--header 'Authorization: Bearer 331fa10b-8bec-4c3a-af4d-f2ae9a901823'`

`curl --location --request DELETE 'http://localhost:8080/todo-list/api/v1/tasks/1' \
--header 'Authorization: Bearer 331fa10b-8bec-4c3a-af4d-f2ae9a901823'`

`curl --location --request GET 'http://localhost:8080/todo-list/api/v1/tasks/status/pending' \
--header 'Authorization: Bearer 331fa10b-8bec-4c3a-af4d-f2ae9a901823'`

`curl --location --request POST 'http://localhost:8080/todo-list/api/v1/oauth/token' \
--header 'Authorization: Basic bXlhcHBuYW1lMTIzQDpteWFwcHNlY3JldDEyM0A=' \
--form 'grant_type="password"' \
--form 'username="fulano@fulano.com"' \
--form 'password="fulano"'`

`curl --location --request POST 'http://localhost:8080/todo-list/api/v1/oauth/token' \
 --header 'Authorization: Basic bXlhcHBuYW1lMTIzQDpteWFwcHNlY3JldDEyM0A=' \
 --form 'grant_type="password"' \
 --form 'username="ciclano@ciclano.com"' \
 --form 'password="ciclano"'`
 
## Para Métricas do Grafana e Prometheus Subir Docker Compose Localmente

- **Executar Docker-compose** Pelo terminal ou prompt de comando execute o comando na pasta principal do projeto(**`docker-compose up`**)*
**É preciso configurar os arquivos docker-compose.yml e prometheus.yml para a máquina específica**

## Jmeter

![image](https://user-images.githubusercontent.com/10129476/114401845-ac5c2480-9b79-11eb-854f-12f4f3946c66.png)

## Images / Imagens 

![image](https://user-images.githubusercontent.com/10129476/114401731-951d3700-9b79-11eb-87fd-64ce207bbdda.png)
![image](https://user-images.githubusercontent.com/10129476/114401774-9d757200-9b79-11eb-81d1-e6fa93ae145d.png)
![image](https://user-images.githubusercontent.com/10129476/114401884-b2ea9c00-9b79-11eb-8250-7e591df163f7.png)
![image](https://user-images.githubusercontent.com/10129476/114401926-bc740400-9b79-11eb-9407-f82c542627f7.png)

###### Nota: Necessário java 11

