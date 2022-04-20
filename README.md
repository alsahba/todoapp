# todoapp

It is an example of a todo application.  

Tech-stack:
- Spring boot with Java 17
- Kafka
- Postgresql
- Docker
- ELK Stack (Logstash, Kibana, Elasticsearch, Filebeat) (8.1.0)

You can try the project by running in the main directory:

```docker-compose up```

For detached mode you can add -d flag:

```docker-compose up -d```

Then you can check out the logs in the kibana ```localhost:5061``` address.
After indexing ('todoapp-*' is usable), you can create data view in the kibana console 
(Stack management -> Kibana -> Data views).

If you want to run the project without full dockerization and play with the code by yourself,
you can run the following commands for both infrastructure and elk stack:

```docker-compose -f elk_docker-compose.yml -p todoapp_elk up```

```docker-compose -f infra_docker-compose.yml -p todoapp_infra up```

<br />
Important: If you want to change the logstash.conf file be sure that the commands run must with the no-cache option.
Because it is layered configuration, commands must be ran again with respect to new version of configuration file.
<br /><br />
