# BackEndSpringCloud

## Visão Geral

&emsp;Este projeto é um backend construído com Spring Boot e Spring Cloud. Ele serve como a aplicação principal para fornecer APIs REST, integrar serviços e configurar dependências comuns de microserviços.


## Microserviços Vs. Monólitos

![Imagem](assets/MicroVsMono.png)

&emsp;Uma **Arquitetura Monolítica** reúne todos os componentes de uma aplicação em uma única unidade de implantação. Código, lógica de negócio, interface e acesso a dados são executados juntos, em um único processo e geralmente em um único aplicativo.

&emsp;Uma **Arquitetura de Microserviços** divide a aplicação em serviços menores, cada um com responsabilidade específica. Esses serviços funcionam de forma independente, comunicam-se por APIs ou mensagens e podem ser executados em processos separados.

&emsp;A principal diferença está na organização e no ciclo de vida: no **monólito**, *todas as partes da aplicação compartilham o mesmo ambiente e a mesma implantação*; nos **microserviços**, *cada serviço tem fronteiras claras e é tratado como uma peça independente dentro do conjunto.*

#### Vantagens e Desvantagens da Arquitetura de Monólitica

![imagem](assets/mono.png)

&emsp;A arquitetura monolítica reúne todos os componentes da aplicação em um único código e processo. Isso traz algumas vantagens e desvantagens importantes a considerar.

- ***Vantagens***:
  - **Simplicidade de desenvolvimento:** mais fácil iniciar e testar localmente com um único projeto.
  - **Deploy único:** toda a aplicação é empacotada e implantada como uma unidade, reduzindo a complexidade de lançamento.
  - **Menos sobrecarga operacional:** sem necessidade de orquestração de múltiplos serviços, discovery ou comunicação entre processos.
  - **Consistência transacional:** transações e acessos a dados são mais diretos quando tudo está no mesmo contexto.

- ***Desvantagens***:
  - **Escalabilidade limitada:** não é possível escalar apenas partes específicas; toda a aplicação precisa ser aumentada junta.
  - **Ciclo de implantação mais pesado:** uma mudança pequena exige recriar e redeployar todo o monólito.
  - **Acoplamento elevado:** componentes internos podem ficar fortemente dependentes uns dos outros, dificultando a manutenção.
  - **Risco de falha ampla:** uma falha em um módulo pode afetar toda a aplicação e impactar todos os usuários.

#### Vantagens e Desvantagens da Arquitetura de Microserviços

![imagens](assets/microservice.png)

&emsp;A arquitetura de microserviços traz benefícios claros, mas também desafios importantes a serem considerados.

- ***Vantagens***:
  - **Escalabilidade** independente: cada serviço pode ser dimensionado conforme a demanda sem precisar escalar toda a aplicação.
  - **Evolução isolada:** equipes podem desenvolver, testar e implantar serviços separadamente.
  - Resiliência: falhas em um serviço têm menor impacto no sistema como um todo, desde que existam mecanismos de tolerância a falhas.
  - **Flexibilidade tecnológica**: diferentes serviços podem usar stacks e linguagens diferentes quando necessário.
- ***Desvantagens***:
  - **Complexidade operacional**: orquestração, monitoramento e implantação de múltiplos serviços exigem ferramentas adicionais e boas práticas.
  - **Comunicação entre serviços**: a troca de dados por rede introduz latência e pode exigir padrões como API Gateway, circuit breaker e retry.
  - **Testes mais difíceis**: testar integrações entre serviços exige cenários distribuídos e ambientes mais complexos.
  - **Gestão de dados**: manter consistência e transações entre serviços independentes é mais complexo que em um monólito.

## Arquitetura do Sistema(Microsserviços)

![ImagensDaArqt](assets/EstruturaBasicaDoProjeto.png)

&emsp;A imagem mostra a arquitetura básica do projeto com serviços organizados em camadas e *comunicando-se de forma independente*. <br>
&emsp;O backend principal expõe APIs **REST**, centraliza regras de negócio e orquestra a execução entre microserviços. Serviços auxiliares, como **notificações** e **tarefas**, ficam isolados em suas próprias instâncias e dependem de um *servidor de descoberta ou gateway para serem localizados*. Essa estrutura facilita escalar e implantar cada serviço separadamente, mantendo o fluxo de dados coerente entre as **diferentes partes do sistema**.
- Para mais detalhes você pode checar em [Cloud](https://spring.io/cloud)

- Para documentação Spring Claud Config [Doc](https://docs.spring.io/spring-cloud-config/docs/4.0.5/reference/html/#_quick_start)


## Instances of Services(Service-notification and Tasks)

![ImagensDasInstancias](assets/instances-currently.png)

&emsp;Cada serviço rodando em uma instancia e porta diferente sem interfiri diretamente no funcionamento da outra como pode ser visto na porta:8888 do local host e cada serviço rodando de forma independente e em portas separadadas: service-notification:8082 and service-task:8081

## Tecnologias

- Java 17+ (ou versão compatível definida pelo projeto)
- Spring Boot
- Spring Cloud
- Maven
- Docker (opcional)

## Pré-requisitos

Antes de usar o software, certifique-se de ter instalado:

- Java JDK 17 ou superior
- Maven 3.6+ ou superior
- Git
- Docker e Docker Compose (se desejar rodar em contêineres)
- Caso deseje usar localmente troque no properties de cada service o "service-main" pelo localhost

## Como usar

### Passo 1: Clonar o repositório

Abra o terminal e execute:

```bash
git clone <URL_DO_REPOSITORIO>
cd BackEndSpringCloud
```

> Substitua `<URL_DO_REPOSITORIO>` pela URL do repositório remoto.

### Passo 2: Construir o projeto

No diretório raiz do projeto, execute:

```bash
mvn clean install
```

Esse comando compila o código, executa os testes e gera o artefato do backend.

### Passo 3: Configurar variáveis de ambiente

Algumas aplicações Spring Cloud usam variáveis de ambiente ou arquivos `application.yml`/`application.properties` para configuração.

Exemplo de variáveis comuns:

```bash
export SPRING_PROFILES_ACTIVE=local
export SERVER_PORT=8080
export SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/nome_do_banco
export SPRING_DATASOURCE_USERNAME=usuario
export SPRING_DATASOURCE_PASSWORD=senha
```

Ajuste os valores conforme a sua configuração local.

### Passo 4: Executar a aplicação

Para iniciar a aplicação diretamente, use:

```bash
mvn spring-boot:run
```

Ou execute o jar gerado:

```bash
java -jar target/*.jar
```

&emsp;A aplicação ficará disponível em `http://localhost:8080` por padrão, salvo se a porta for alterada.

## Estrutura recomendada do README

### Endpoints básicos

&emsp;Para saber quais endpoints estão disponíveis, consulte os controladores do projeto. Em geral, serviços Spring Boot expõem rotas como:

- `GET /api/usuarios`
- `POST /api/usuarios`
- `GET /api/produtos`

A documentação pode estar disponível em `http://localhost:8080/swagger-ui.html` se o Swagger estiver configurado.

### Health check

Em muitos projetos Spring Boot, existe um endpoint de health:

- `GET /actuator/health`

### Configuração do Spring Cloud

Se o projeto usa Spring Cloud Config ou Eureka, verifique:

- `application.yml` para configurações de `spring.cloud.config` ou `eureka.client`
- se há um servidor de configuração remoto ou servidor de descoberta necessário

## Uso com Docker (opcional)

Se o projeto tiver um `Dockerfile`, você pode criar uma imagem com:

```bash
docker build -t backend-spring-cloud .
```

E executar com:

```bash
docker run -p 8080:8080 backend-spring-cloud
```

Se existir `docker-compose.yml`, use:

```bash
docker-compose up --build
```

## Testes

Para rodar os testes automatizados:

```bash
mvn test
```

## Dicas de uso

- Verifique o arquivo `pom.xml` para dependências específicas do Spring Cloud.
- Ajuste perfis de ambiente em `application-{perfil}.yml` para desenvolvimento, homologação e produção.
- Use `mvn spring-boot:run -Dspring-boot.run.profiles=local` para iniciar com perfil local.
- Monitore logs no terminal para detectar erros de inicialização ou de conexão com bancos de dados.

## Observações finais

Este README descreve o uso geral de um backend Spring Cloud. Para informações específicas do projeto, consulte os arquivos de configuração e a documentação existente no código-fonte.
