# API de Produtos

API REST para gerenciamento de produtos.

## 📋 Sobre o Projeto

Esta API foi desenvolvida para gerenciar um catálogo de produtos, permitindo operações completas de CRUD (Create, Read, Update, Delete). O sistema possibilita o cadastro, consulta, atualização e remoção de produtos, facilitando o controle de estoque e informações de produtos.

## 🚀 Tecnologias Utilizadas

- **Java** - Linguagem de programação
- **Spring Boot** - Framework para desenvolvimento de aplicações
- **Spring Web** - Para criação da API REST
- **Maven/Gradle** - Gerenciador de dependências
- **H2/MySQL/PostgreSQL** - Banco de dados (ajuste conforme seu projeto)

## Base URL

```
http://localhost:8080/api/v1
```

## Endpoints

### Listar todos os produtos

Retorna a lista de todos os produtos cadastrados.

**Método:** `GET`

**Endpoint:** `/produtos`

```http
GET http://localhost:8080/api/v1/produtos
```

---

### Criar novo produto

Cria um novo produto no sistema.

**Método:** `POST`

**Endpoint:** `/produtos`

```http
POST http://localhost:8080/api/v1/produtos
```

**Body (JSON):**

```json
{
  "nome": "Mouse Gamer",
  "descricao": "Mouse RGB 12000 DPI",
  "preco": 199.90,
  "estoque": 25,
  "ativo": true,
  "categoria": "Periféricos"
}
```

---

### Atualizar produto

Atualiza as informações de um produto existente.

**Método:** `PUT`

**Endpoint:** `/produtos/{id}`

```http
PUT http://localhost:8080/api/v1/produtos/3
```

**Body (JSON):**

```json
{
  "nome": "Mouse Gamer",
  "descricao": "Mouse RGB 12000 DPI",
  "preco": 199.90,
  "estoque": 25,
  "ativo": true,
  "categoria": "Periféricos"
}
```

---

### Deletar produto

Remove um produto do sistema.

**Método:** `DELETE`

**Endpoint:** `/produtos/{id}`

```http
DELETE http://localhost:8080/api/v1/produtos/2
```

---

## Modelo de Dados

| Campo | Tipo | Descrição |
|-------|------|-----------|
| nome | String | Nome do produto |
| descricao | String | Descrição detalhada do produto |
| preco | Double | Preço do produto |
| estoque | Integer | Quantidade em estoque |
| ativo | Boolean | Status do produto (ativo/inativo) |
| categoria | String | Categoria do produto |

---

## Como usar

1. Certifique-se de que a aplicação está rodando na porta 8080
2. Utilize um cliente HTTP (Postman, Insomnia, curl, etc.)
3. Faça as requisições conforme os endpoints documentados acima
