# Microservice-based E-commerce Application with Spring Cloud

This project is a comprehensive microservice-based e-commerce application built using Spring Cloud, providing a scalable and resilient architecture for online retail operations.

The application consists of several microservices that work together to handle various aspects of an e-commerce platform. These services include a store service, supplier service, delivery service, authentication server, configuration server, service discovery, and an API gateway.

## Repository Structure

- `auth-server/`: OAuth2 authentication server
- `config-server/`: Spring Cloud Config server for centralized configuration management
- `eureka-server/`: Service discovery server using Netflix Eureka
- `gateway-zuul/`: API Gateway using Netflix Zuul
- `loja/`: Store microservice handling purchase operations
- `fornecedor/`: Supplier microservice managing product inventory and orders
- `transportador/`: Delivery microservice for handling shipping
- `microservice-config/`: Configuration files for different microservices and environments
- `postman/`: Postman collection for API testing

Key Files:
- `pom.xml`: Parent Maven configuration file
- `new_release.sh`: Script for creating new releases
- `set-pom-version.js`: Script for updating version numbers in POM files

## Usage Instructions

### Installation

Prerequisites:
- Java 11
- Maven 3.6+
- MariaDB 10.5+

Steps:
1. Clone the repository:
   ```
   git clone <repository-url>
   ```
2. Navigate to the project root:
   ```
   cd microservice-project
   ```
3. Build the project:
   ```
   mvn clean install
   ```

### Getting Started

1. Start the Config Server:
   ```
   java -jar config-server/target/config-server-<version>.jar
   ```
2. Start the Eureka Server:
   ```
   java -jar eureka-server/target/eureka-server-<version>.jar
   ```
3. Start the Auth Server:
   ```
   java -jar auth-server/target/auth-server-<version>.jar
   ```
4. Start other microservices (loja, fornecedor, transportador) in any order.
5. Start the Gateway:
   ```
   java -jar gateway-zuul/target/gateway-zuul-<version>.jar
   ```

### Configuration

Each microservice can be configured using the `application.yml` file in its `src/main/resources` directory. Global configurations are managed in the `microservice-config/` directory.

### Common Use Cases

1. Creating a new purchase:
   ```
   POST http://localhost:8080/api/v1/compras
   {
     "endereco": {
       "rua": "Example Street",
       "numero": 123,
       "estado": "EX"
     },
     "itens": [
       {
         "id": 1,
         "quantidade": 5
       }
     ]
   }
   ```

2. Retrieving purchase information:
   ```
   GET http://localhost:8080/api/v1/compras/{id}
   ```

3. Retrieving supplier information:
   ```
   GET http://localhost:8081/api/v1/info/{estado}
   ```

### Testing & Quality

Run tests for all modules:
```
mvn test
```

### Troubleshooting

1. Issue: Microservice fails to start
   - Check if the Config Server is running and accessible
   - Verify database connection details in the configuration
   - Enable debug logging by setting `debug: true` in the application.yml

2. Issue: Authentication fails
   - Ensure the Auth Server is running
   - Verify client credentials in the Auth Server configuration
   - Check if the token is being properly passed in the request header

3. Issue: Service discovery problems
   - Confirm that the Eureka Server is running
   - Check if the microservice has properly registered with Eureka
   - Verify Eureka client configuration in the microservice's application.yml

For debugging, enable verbose logging by setting `logging.level.root=DEBUG` in the application.yml of the affected service.

## Data Flow

1. Client sends a request to the Gateway (Zuul)
2. Gateway authenticates the request using the Auth Server
3. Gateway routes the request to the appropriate microservice
4. Microservice processes the request, potentially communicating with other services
5. Response is sent back through the Gateway to the client

```
Client -> Gateway -> Auth Server
       -> Microservice A <-> Microservice B
       -> Microservice C -> Database
```

## Deployment

Prerequisites:
- Docker
- Kubernetes cluster

Steps:
1. Build Docker images for each microservice
2. Push images to a container registry
3. Apply Kubernetes manifests to deploy services
4. Configure ingress for external access

## Infrastructure

The project uses the following key infrastructure components:

- Spring Boot (version 2.3.0.RELEASE)
- Spring Cloud (version Hoxton.SR5)
- Netflix Eureka for service discovery
- Netflix Zuul for API gateway
- Spring Cloud Config for centralized configuration
- Spring Cloud OAuth2 for authentication
- MariaDB for data persistence
- Undertow as the web server

Each microservice is configured with its own database connection, Eureka client settings, and security configurations.