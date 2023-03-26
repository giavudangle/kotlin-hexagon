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
docker pull postgres:latest
docker run -d -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=admin --name db-my -p 5432:5432  --restart=always postgres
docker pull dpage/pgadmin4
docker run -p 80:80 \
    -e 'PGADMIN_DEFAULT_EMAIL=admin@admin.com' \
    -e 'PGADMIN_DEFAULT_PASSWORD=admin' \
    -d dpage/pgadmin4
docker ps
docker inspect [postgres_pid]
```

#### Maven commands
```
 mvn cleanœ
 mvn download source
 mvn dependency:resolve
```