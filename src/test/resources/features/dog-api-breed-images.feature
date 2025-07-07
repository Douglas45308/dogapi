@breed-images
Feature: Dog API - Imagens por Raça
  Como um usuário da aplicação
  Eu quero obter imagens de uma raça específica
  Para que eu possa visualizar cães dessa raça

  Background:
    Given que a Dog API está disponível

  @smoke
  Scenario Outline: Obter imagens de raças válidas
    When eu faço uma requisição GET para obter imagens da raça "<breed>"
    Then o status code da resposta deve ser 200
    And o status da resposta deve ser success
    And a resposta deve conter as imagens da raça

    Examples:
      | breed     |
      | labrador  |
      | beagle    |
      | bulldog   |
      | poodle    |

  @negative
  Scenario: Tentar obter imagens de raça inválida
    When eu faço uma requisição GET para obter imagens da raça "racainexistente"
    Then o status code da resposta deve ser 404
    And o status da resposta deve ser error

  @regression
  Scenario: Verificar formato das URLs das imagens
    When eu faço uma requisição GET para obter imagens da raça "labrador"
    Then o status code da resposta deve ser 200
    And o status da resposta deve ser success
    And a resposta deve conter as imagens da raça