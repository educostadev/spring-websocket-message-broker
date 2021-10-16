# Getting Started

This is an example project of how to use Spring WebSocket integrated with Message Broker Active MQ to deal with the scenario where you scale out your Microservice and keep the WebSocket communication working between different Clients connected to your backend service.

## Pre Requirements
- IntelliJ IDE
- Maven
- JDK 11
- Docker
- Docker Compose

## How to Run

1. Clone the project and open it with IntelliJ
2. Navigate to the project folder and run the Active MQ Artemis by executing the command `docker-compose -f broker-compose.ym up mq`
3. Run the class `WebSocketApplication`
4. Access the Client page at http://localhost:8181
5. On IntelliJ duplicate the Runner for `WebSocketApplication` and add the VM parameter `-Dserver.port=8282` to open a new instance in other port.

To see this code running watch my [YouTube video here](https://youtu.be/pj0zVBOUd58).


