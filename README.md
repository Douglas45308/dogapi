# Dog API Test Automation 🐕

Este projeto contém testes automatizados para a Dog API utilizando BDD (Behavior Driven Development) com Cucumber e arquitetura Page Objects.

## 🎯 Objetivo

Validar os endpoints da Dog API garantindo que:
- A API responda corretamente
- Os dados retornados estejam no formato esperado
- A aplicação se comporte conforme esperado em diferentes cenários

## 🛠️ Tecnologias Utilizadas

- **Java 17** - Linguagem de programação
- **Maven** - Gerenciador de dependências
- **Cucumber** - Framework BDD
- **JUnit 5** - Framework de testes
- **Rest Assured** - Biblioteca para testes de API
- **Allure** - Geração de relatórios
- **Jackson** - Serialização/Deserialização JSON
- **Page Objects** - Padrão de design para organização dos testes

## 📋 Endpoints Testados

1. `GET /breeds/list/all` - Lista todas as raças de cães
2. `GET /breed/{breed}/images` - Obtém imagens de uma raça específica
3. `GET /breeds/image/random` - Obtém uma imagem aleatória de cão

## 🏗️ Estrutura do Projeto
