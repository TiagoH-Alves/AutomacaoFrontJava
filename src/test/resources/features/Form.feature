Feature: Preencher formulário

  Scenario: Usuário preenche o formulário
    Given que o usuário está na página do formulário
    When ele preenche o campo nome com "Tiago Henrique"
    And ele preenche o campo sobrenome com "Alves"
    And ele preenche o campo CPF
    Then o campo deve conter "Tiago Henrique"
