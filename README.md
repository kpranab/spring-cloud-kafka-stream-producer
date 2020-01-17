#Run Application from CMD 
mvn spring-boot:run

#Build Jar File
mvn clean install

#Created Docker image from docker file
- Create a file name with Dockerfile in project directory
- Then add required info and run below command in the location where Dockerfile is present
docker build -t spring-cloud-kafka-producer .

-t -> tag name
spring-cloud-kafka-producer -> Name of image

docker images
docker rmi imagename/imageid -->To remove image from local


Test Data for PostMan
---------------------
localhost:8081/publishAccount

POST

Body

{
      "account_number": 1011,
      "account_status": "Active",
      "account_type": "Saving",
      "account_subtype": "Salary",
      "line_of_business": "NA"
}


cassandra_db:
      hostname: cassandra-db1
      image: cassandra:latest
      command: /bin/bash -c "sleep 1 && echo ' -- Pausing to let system catch up ... -->' && /docker-entrypoint.sh cassandra -f"
      ports:
        - "7000:7000"
        - "7001:7001"
        - "7199:7199"
        - "9042:9042"
        - "9160:9160"
      volumes:
        - ./data/cassandra-db1:/var/lib/cassandra:rw
      healthcheck:
        test: ["CMD", "cqlsh", "-u cassandra", "-p cassandra", "-e describe keyspaces"]
        interval: 15s
        timeout:10s
        retries: 10

producer:
    image: spring-cloud-kafka-producer:latest
    links:
      - kafka
      - cassandra_db
    depends_on:
      cassandra_db:
         condition: service_healthy
      kafka:
         condition: service_started
    environment:
      - "CASSANDRA_HOST"=cassandra_db"
      - "CASSANDRA_USER="
      - "CASSANDRA_PW="
      - "KAFKA_BROKERS=kafka:9092
    ports:
      - '8081:8081'
    restart: always
    
