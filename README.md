# campstone-kafka-docker

Create topic

```bash
docker exec -it -w /opt/kafka/bin kafka \
  ./kafka-topics.sh --create \
    --topic reservation-event \
    --bootstrap-server localhost:9092 \
    --partitions 3 \
    --replication-factor 1
```

Show messages

```bash
docker exec -it -w /opt/kafka/bin kafka \
  ./kafka-console-consumer.sh \
    --bootstrap-server localhost:9092 \
    --topic reservation-event \
    --group consumer-reservation \
    --from-beginning
```


