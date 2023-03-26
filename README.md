#### Architecture
<img src="./docs/diagram/1. Architecture.png"/>    
<img src="./docs/diagram/2. Layers.webp"/>

### Core processor
<img src="./docs/diagram/3. UML.png"/>    

### Request journey
``` 
HTTP -> Controller -> API -> Service Interface -> Adapter -> Core
Infrastructure -> Adapter -> Core -> Response
```
<img src="./docs/diagram/4. Dependencies.png"/>    


#### Container
```shell
cd ./deployment/docker
run docker compose up
docker ps
docker inspect [postgres_port] | grep 'IPAddress'
run pgadmin
```

#### Maven commands
```
 mvn cleanœ
 mvn download source
 mvn dependency:resolve
```