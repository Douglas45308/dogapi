@random-image
Feature: Dog API - Imagem Aleatória
  Como um usuário da aplicação
  Eu quero obter uma imagem aleatória de cão
  Para que eu possa ver diferentes cães sem especificar uma raça

  Background:
    Given que a Dog API está disponível

  @smoke
  Scenario: Obter imagem aleatória com sucesso
    When eu faço uma requisição GET para obter uma imagem aleatória
    Then o status code da resposta deve ser 200
    And o status da resposta deve ser success
    And a resposta deve conter uma imagem aleatória

  @regression
  Scenario: Verificar formato da URL da imagem aleatória
    When eu faço uma requisição GET para obter uma imagem aleatória
    Then o status code da resposta deve ser 200
    And o status da resposta deve ser success
    And a resposta deve conter uma imagem aleatória

  @performance
  Scenario: Múltiplas requisições de imagem aleatória
    When eu faço uma requisição GET para obter uma imagem aleatória
    Then o status code da resposta deve ser 200
    When eu faço uma requisição GET para obter uma imagem aleatória
    Then o status code da resposta deve ser 200
    When eu faço uma requisição GET para obter uma imagem aleatória
    Then o status code da resposta deve ser 200