# Use uma imagem base com o JDK do Java e o Maven instalados
FROM maven:3.8.4-openjdk-17 AS builder

# Defina o diretório de trabalho no contêiner
WORKDIR /app

# Copie o arquivo pom.xml e faça o download das dependências
COPY pom.xml .
RUN mvn -B dependency:go-offline

# Copie todo o código fonte
COPY src ./src

# Compile o projeto e crie o arquivo JAR
RUN mvn clean package -DskipTests

# Use uma imagem menor para a execução do JAR
FROM openjdk:17-oracle

# Defina o diretório de trabalho no contêiner
WORKDIR /app

# Copie o arquivo JAR do estágio de construção
COPY --from=builder /app/target/*.jar ./app.jar

EXPOSE 8080

# Comando para executar o JAR
CMD ["java", "-jar", "app.jar"]
