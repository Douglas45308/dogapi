@breeds
Feature: Dog API - Listar Raças
  Como um usuário da aplicação
  Eu quero listar todas as raças de cães disponíveis
  Para que eu possa conhecer as opções disponíveis

  Background:
    Given que a Dog API está disponível

  @smoke
  Scenario: Listar todas as raças com sucesso
    When eu faço uma requisição GET para listar todas as raças
    Then o status code da resposta deve ser 200
    And o status da resposta deve ser success
    And a resposta deve conter a lista de raças

  @regression
  Scenario: Verificar se raças específicas estão presentes
    When eu faço uma requisição GET para listar todas as raças
    Then o status code da resposta deve ser 200
    And a raça "labrador" deve estar presente na lista
    And a raça "beagle" deve estar presente na lista
    And a raça "bulldog" deve estar presente na lista

  @performance
  Scenario: Verificar tempo de resposta da listagem de raças
    When eu faço uma requisição GET para listar todas as raças
    Then o status code da resposta deve ser 200
    And o status da resposta deve ser success