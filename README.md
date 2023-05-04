
#### Architecture
<img src="./docs/diagram/1. Architecture.png"/>    
<img src="./docs/diagram/2. Layers.webp"/>

### Core processor
<img src="./docs/diagram/3. UML.png"/>    

### Request journey
``` 
HTTP -> Controller -> API -> Service Interface -> Adapter -> Core
Infrastructure -> Adapter -> Core -> Response
Dependencies go inwards (arrow is dependencies direction)
```
<img src="./docs/diagram/4. Dependencies.png"/>    


#### Docker Container
```shell
$ docker compose up
$ docker-compose up --build -d
```

#### Maven commands
``` shell
 $ mvn clean
 $ mvn download source
 $ mvn dependency:resolve
```


#### ELK Stack Setup

```shell 
1. Elasticsearch
docker ps
docker exec -u 0 -it <elasticsearch_pid> bash
./bin/elasticsearch-setup-passwords auto
2. Kibana
 
apt-get update
apt-get install nano
nano config/kibana.yml
elasticsearch.username: <kibana_username>
elasticsearch.password: <kibana_password>
3. Logstash
```

#### OpenAPI and Swagger
```text
OpenAPI: http://localhost:8080/v3/api-docs
Swagger: http://localhost:8080/swagger-ui/index.html
```

#### Deploy to K8S

```shell
$ docker build -t hexagon-root .
$ kubectl apply -f deploy.yaml
$ kubectl port-forward pod/taco-cloud-deploy-555bd8fdb4-dln45 8080:8080
```