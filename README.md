# 🥷 Cadastro de Ninjas

Uma API RESTful desenvolvida com Spring Boot para gerenciamento de cadastro de ninjas, criada como parte do curso Java10x.

## 📋 Sobre o Projeto

O Cadastro de Ninjas é uma aplicação backend que permite o gerenciamento completo de ninjas e missões através de uma API RESTful. O projeto foi desenvolvido utilizando as melhores práticas de desenvolvimento Java e Spring Boot, com **arquitetura modular organizada em domínios separados** (Ninjas e Missões), facilitando a manutenção e escalabilidade do código.

## 🚀 Tecnologias Utilizadas

- **Java 17+** - Linguagem de programação
- **Spring Boot 3.x** - Framework principal
- **Spring Data JPA** - Persistência de dados
- **Spring Web** - Criação de APIs REST
- **Hibernate** - ORM (Object-Relational Mapping)
- **Maven** - Gerenciamento de dependências
- **H2 Database** / **PostgreSQL** - Banco de dados
- **Lombok** - Redução de código boilerplate
- **Bean Validation** - Validação de dados
- **Swagger/OpenAPI** - Documentação interativa da API

## 📦 Pré-requisitos

Antes de começar, você precisará ter instalado em sua máquina:

- [Java 17+](https://www.oracle.com/java/technologies/downloads/)
- [Maven 3.6+](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/)

## 🔧 Instalação

1. Clone o repositório:
```bash
git clone https://github.com/devAdemarNeto/CadastroDeNinjas.git
```

2. Navegue até o diretório do projeto:
```bash
cd CadastroDeNinjas
```

3. Compile o projeto com Maven:
```bash
./mvnw clean install
```

4. Execute a aplicação:
```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`

## 📖 Documentação da API

A documentação interativa da API está disponível através do Swagger/OpenAPI:

- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **OpenAPI JSON**: `http://localhost:8080/v3/api-docs`

Através do Swagger UI você pode:
- Visualizar todos os endpoints disponíveis
- Testar as requisições diretamente pelo navegador
- Ver os modelos de dados (schemas)
- Consultar os códigos de resposta HTTP

## 🏗️ Arquitetura do Projeto

O projeto utiliza uma **arquitetura modular baseada em domínios (DDD - Domain-Driven Design)**, onde cada funcionalidade principal está organizada em seu próprio domínio independente:

### 🔷 Domínio: Ninjas
Responsável por todo o gerenciamento de ninjas, incluindo cadastro, atualização, listagem e remoção.

### 🔶 Domínio: Missões  
Responsável pelo gerenciamento completo de missões, com relacionamento aos ninjas responsáveis.

Cada domínio possui sua própria estrutura completa de camadas (Controller, Service, Repository, Model), garantindo:
- **Separação de responsabilidades**
- **Código mais limpo e organizado**
- **Facilidade de manutenção**
- **Escalabilidade** para novos domínios

### Ninjas
- ✅ Cadastrar novos ninjas
- ✅ Listar todos os ninjas cadastrados
- ✅ Buscar ninja por ID
- ✅ Atualizar informações de um ninja
- ✅ Remover ninja do cadastro
- ✅ Validação de dados

### Missões
- ✅ Criar novas missões
- ✅ Listar todas as missões
- ✅ Buscar missão por ID
- ✅ Atualizar status e informações das missões
- ✅ Remover missões
- ✅ Relacionamento entre ninjas e missões

## 📡 Endpoints da API

### Ninjas

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/ninjas` | Lista todos os ninjas |
| GET | `/ninjas/{id}` | Busca um ninja específico |
| POST | `/ninjas` | Cadastra um novo ninja |
| PUT | `/ninjas/{id}` | Atualiza um ninja existente |
| DELETE | `/ninjas/{id}` | Remove um ninja |

### Missões

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/missoes` | Lista todas as missões |
| GET | `/missoes/{id}` | Busca uma missão específica |
| POST | `/missoes` | Cria uma nova missão |
| PUT | `/missoes/{id}` | Atualiza uma missão existente |
| DELETE | `/missoes/{id}` | Remove uma missão |

### Exemplo de Request - Ninja (POST)

```json
{
  "nome": "Naruto Uzumaki",
  "idade": 17,
  "rank": "Genin",
  "aldeia": "Konoha",
  "email": "naruto@konoha.com"
}
```

### Exemplo de Request - Missão (POST)

```json
{
  "nome": "Resgate do Kazekage",
  "dificuldade": "S",
  "status": "EM_ANDAMENTO",
  "ninjaResponsavel": {
    "id": 1
  }
}
```

## 🗂️ Estrutura do Projeto

```
CadastroDeNinjas/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── dev/java10x/CadastroDeNinjas/
│   │   │       ├── Ninjas/                    # Domínio de Ninjas
│   │   │       │   ├── NinjaController.java
│   │   │       │   ├── NinjaService.java
│   │   │       │   ├── NinjaRepository.java
│   │   │       │   ├── NinjaModel.java
│   │   │       │   └── NinjaMapper.java
│   │   │       ├── Missoes/                   # Domínio de Missões
│   │   │       │   ├── MissaoController.java
│   │   │       │   ├── MissaoService.java
│   │   │       │   ├── MissaoRepository.java
│   │   │       │   ├── MissaoModel.java
│   │   │       │   └── MissaoMapper.java
│   │   │       └── CadastroDeNinjasApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── application.yml
│   └── test/
├── pom.xml
└── README.md
```

### 📁 Organização por Domínios

Cada domínio (Ninjas e Missões) possui sua estrutura completa e independente:
- **Controller**: Camada de apresentação (REST API)
- **Service**: Lógica de negócio
- **Repository**: Acesso a dados (JPA)
- **Model**: Entidades do banco de dados
- **Mapper**: Conversão entre DTOs e Entities

## 🔐 Configuração do Banco de Dados

Configure as propriedades de conexão no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
```

## 🧪 Executando os Testes

Para executar os testes automatizados:

```bash
./mvnw test
```

## 📝 Roadmap

- [x] Sistema de missões implementado
- [x] Relacionamento entre ninjas e missões
- [x] Arquitetura modular por domínios (DDD)
- [x] Documentação Swagger/OpenAPI
- [ ] Implementar autenticação JWT
- [ ] Sistema de equipes (times de ninjas)
- [ ] Adicionar testes de integração
- [ ] Sistema de notificações
- [ ] Deploy em cloud (Heroku/AWS)


## 🤝 Contribuindo

Contribuições são sempre bem-vindas! Para contribuir:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/MinhaFeature`)
3. Commit suas mudanças (`git commit -m 'Adiciona MinhaFeature'`)
4. Push para a branch (`git push origin feature/MinhaFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 👨‍💻 Autor

**Ademar Neto**

- GitHub: [@devAdemarNeto](https://github.com/devAdemarNeto)
- LinkedIn: [Seu LinkedIn](https://www.linkedin.com/in/ademar-neto-dev/)

## 🎓 Agradecimentos

Projeto desenvolvido durante o curso [Java10x](https://java10x.dev/), um curso completo de desenvolvimento backend com Java.

---

⭐ Se este projeto foi útil para você, considere dar uma estrela no repositório!
