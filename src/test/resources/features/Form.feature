Feature: Preencher formulário

  Scenario: Usuário preenche o campo nome no formulário
    Given que o usuário está na página do formulário
    When ele preenche o campo nome com "Tiago Henrique"
    Then o campo deve conter "Tiago Henrique"
