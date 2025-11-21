## NeoWork Upskilling System

API **RESTful** em **Java + Spring Boot** para apoiar a **requalificação profissional** diante da transformação tecnológica do futuro do trabalho.

---

### 1. Problema

O mercado de trabalho está passando por uma **transformação acelerada**, impulsionada pela digitalização, inteligência artificial, automação e novas formas de organização do trabalho.

Essa mudança constante gera desafios como:

* **Profissões evoluindo rapidamente**
* **Novas habilidades** exigidas em ciclos curtos
* Trabalhadores que precisam se **atualizar continuamente** para manter sua empregabilidade
* Empresas que têm dificuldade em **identificar lacunas de competência**
* Ausência de sistemas estruturados que organizem **trilhas de aprendizado**, registrem evolução e conectem pessoas às **habilidades do futuro**

O ambiente corporativo, portanto, precisa de plataformas que facilitem o **desenvolvimento contínuo**, permitindo que profissionais se requalifiquem e evoluam junto às transformações tecnológicas.

---

### 2. Solução

O **NeoWork Upskilling System** é uma **API RESTful** que:

* Gerencia **Usuários** da plataforma
* Organiza **Trilhas de Aprendizagem**
* Cadastra **Competências** essenciais para o futuro
* Permite que pessoas façam **Matrículas** para desenvolver novas habilidades
* Garante **regras de negócio**, validações e registros estruturados
* Oferece **dados iniciais (seeds)** para facilitar testes e demonstrações

A API segue **arquitetura limpa** (`Controller` → `Service` → `Repository`), utiliza **Bean Validation** e possui **tratamento global de exceções**.

---

### 3. Tecnologias Utilizadas

* **Java 17+**
* **Spring Boot 3.x**
* Spring Web
* Spring Data JPA
* Lombok
* H2 Database (dev)
* Bean Validation (Jakarta Validation)

---

### 4. Estrutura do Projeto
```
src
└── main
└── java
└── com.NeoWork.NeoWork_Upskilling
├── config
│   └── DataLoader
├── controller
│   ├── CompetenciaController
│   ├── MatriculaController
│   ├── TrilhaController
│   └── UsuarioController
├── dto
│   ├── CompetenciaDTO
│   ├── MatriculaDTO
│   ├── TrilhaDTO
│   └── UsuarioDTO
├── exception
│   ├── CompetenciaNaoEncontradaException
│   ├── MatriculaNaoEncontradaException
│   ├── TrilhaNaoEncontradoException
│   ├── UsuarioNaoEncontradoException
│   └── GlobalExceptionHandler
├── model
│   ├── Competencia
│   ├── Matricula
│   ├── Trilha
│   └── Usuario
├── repository
│   ├── CompetenciaRepository
│   ├── MatriculaRepository
│   ├── TrilhaRepository
│   └── UsuarioRepository
├── service
│   ├── CompetenciaService
│   ├── MatriculaService
│   ├── TrilhaService
│   └── UsuarioService
└── NeoWorkUpskillingApplication
```
---

---

### 5. Como Executar

1.  **Clonar o repositório**

    ```bash
    git clone [https://github.com/ViniMata/NeoWorkUpskillingSystem.git](https://github.com/ViniMata/NeoWorkUpskillingSystem.git)
    ```
2.  **Entrar no projeto**

    ```bash
    cd NeoWorkUpskillingSystem
    ```
3.  **Rodar com Maven**

    ```bash
    mvn spring-boot:run
    ```
4.  **Acessar**

    A API roda em:

     **`http://localhost:8080`**

---

### 6. Testando via Postman ou Insomnia

#### EXEMPLOS DE REQUISIÇÕES

| Ação | Método | URI | Body (JSON) |
| :--- | :--- | :--- | :--- |
| **Criar Usuário** | `POST` | `/usuarios` | ```json
{
  "nome": "Ana Souza",
  "email": "ana@exemplo.com",
  "areaAtuacao": "Tecnologia",
  "nivelCarreira": "Junior"
}``` |
| **Criar Trilha** | `POST` | `/trilhas` | ```json 
{
  "nome": "Fundamentos de IA",
  "descricao": "Trilha voltada ao entendimento prático de IA.",
  "nivel": "Intermediario",
  "cargaHoraria": 40,
  "focoPrincipal": "Inteligência Artificial"
}``` |
| **Criar Competência** | `POST` | `/competencias` | ```json 
{
  "nome": "Machine Learning",
  "categoria": "IA",
  "descricao": "Capacidade de criar e treinar modelos inteligentes."
}``` |
| **Criar Matrícula** | `POST` | `/matriculas` | ```json
{
  "usuarioId": 1,
  "trilhaId": 1,
  "status": "INSCRITO"
}``` |

---

### 7. Seeds (Dados Iniciais)

O arquivo **`DataLoader.java`** insere automaticamente:

* **3 usuários**
* **3 trilhas**
* **5 competências**
* matrículas de exemplo

Esses dados facilitam testes sem precisar criar tudo manualmente.

---

### 8. Validações e Exceções

A API utiliza **Bean Validation**, incluindo:

* `@NotBlank`
* `@Email`
* `@Size`
* `@Min` / `@Max`

Exceções personalizadas:

* `UsuarioNaoEncontradoException`
* `TrilhaNaoEncontradoException`
* `CompetenciaNaoEncontradaException`
* `MatriculaNaoEncontradaException`

E um **`GlobalExceptionHandler`** que retorna:

* status **HTTP correto**
* **mensagem clara**
* corpo **JSON padronizado**

---

### 9. Conexão com o Futuro do Trabalho e ODS

A solução atende diretamente aos **Objetivos de Desenvolvimento Sustentável** (ODS):

* **ODS 4** – Educação de Qualidade
* **ODS 8** – Trabalho Decente e Crescimento Econômico
* **ODS 9** – Indústria, Inovação e Infraestrutura
* **ODS 10** – Redução das Desigualdades

A plataforma fortalece o **desenvolvimento de talentos**, traz oportunidades de **requalificação** e apoia a **inclusão digital**.


