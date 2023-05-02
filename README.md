# kafka-example
Simple Kafka example

## How to launch?
- Run ```docker-compose up``` command from project's root directory ```~/kafka-example```
- Run the project using your favorite IDE or run ```mvn spring-boot:run``` command
- Send a request to ```http://localhost:8181/orders```

Sample:
```bash
curl --location --request POST 'http://localhost:8181/orders' \
--header 'Content-Type: application/json' \
--data-raw '{
    "item": "some",
    "userId": 1
}'
```
- Check logs. You'll see something like this:
```bash [1] Received record on 0-0: 242e1144-43fa-4dfd-b0cd-f616740d54f0=Order[id=242e1144-43fa-4dfd-b0cd-f616740d54f0, itemName=some, userId=1]```
