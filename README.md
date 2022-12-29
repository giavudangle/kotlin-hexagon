```
[Shared, API] -> Core -> Adapter -> Domain
```

### Docker Container

#### PostgresSQL
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
 mvn clean
 mvn download source
 mvn dependency:resolve
```