# Technical Analysis - Onboarding Chatbot

## 🔍 Key rules and behaviors of the bot

- Flexible keyword search (the question does not need to be exact)
- If no match is found, return a clear message with code 404
- Console input with `exit` command recognition
- REST API to query and modify knowledge

## 📚 Knowledge base structure

Each entry follows the plain format:

```json

{
  "question": "¿Quién es mi manager/mentor asignado?",
  "answer": "Debes preguntar en RRHH, o ellos se comunicaran en la brevedad."
}

```
## 📚 Structure and Loading of the Knowledge Base

### Database FormatThe data is stored in an SQL table with the mandatory structure:

```sql
CREATE TABLE knowledge (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    question VARCHAR(500) NOT NULL,
    answer VARCHAR(1000) NOT NULL
);
```

###  Automatic Initialization

- SQL Script: The onboarding.sql file runs automatically when the application starts
- Sample Data: Contains at least 8 representative onboarding questions/answersH2 
- Persistence: In-memory data during execution, ideal for development and testing

## Architecture and Justification of Technical Decisions

###  🗃️ Why H2 Database

- Challenge requirement: Specified as recommended technologyDevelopment 
- Speed: Zero configuration and in-memory persistenceTesting 
- Transition: Simple migration to PostgreSQL/MySQL in production

### Why Layered Architecture (DDD)

- Clear separation of responsibilities
- Maintainability: Changes in one layer do not affect the others
- Scalability: New features are integrated in an organized way🔄 Why Separation of Query/Modification
- Learning: Learn DDD first and then move on to microservices

## Specific Implementation Decisions

### Flexible Search Algorithm

Search by word(s), if it recognizes one of the stored words in a sentence within a question, it can answer it.

### Exception Handling

- Custom exceptions: KnowledgeNotFoundException for 404 cases
- Global Exception Handler: Centralized handling for consistent HTTP responses

## Considerations for Future Maintenance

### Functionality Evolution

- Multi-language: Current structure prepared for internationalizationChannel 
- Integration: Architecture allows adding Slack, WhatsApp, etc.
- Semantic Search: Possibility to replace the current algorithm with NLP

### Technical Improvements  

- Real Persistence: Migration to PostgreSQL with minimal changes thanks to Spring Data JPA 
- Caching: Implementation of Redis for frequent responses
- Authentication: Add Spring Security for administrative endpoints