# Kafka Beispiel

Ein Teil der Implementierung stammt von https://memorynotfound.com/spring-kafka-consume-producer-example/

## Voraussetzungen

* Maven
* JDK 8

Beim Bauen ist eine Intenetverbindung erforderling, weil Maven die notwendigen Dependencies lädt.

## Start

Wenn ein lokaler Kafka Server installiert ist kann man auch diesen verwenden statt mit mvn docker:run den Docker container zu starten.

sudo service kafka start

## Test Kafka Server

1. Topic anlegen
/home/kafka/kafka/bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic TutorialTopic

2. Nachricht einstellen
echo "Hello, World" | /home/kafka/kafka/bin/kafka-console-producer.sh --broker-list localhost:9092 --topic TutorialTopic > /dev/null

3. Nachricht abholen
/home/kafka/kafka/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic TutorialTopic --from-beginning

## Beispiel starten

Überall wo "&" steht muss der Prozess im Hintergrund ausgeführt werden oder in einem eigenen Terminal.

* mvn clean install
* mvn docker:run &
* cd kafkaProducer
* mvn spring-boot:run &
* cd ../kafkaConsumer
* mvn spring-boot:run &
* curl http://localhost:8080/sendMessage?message=Hallo_Welt

