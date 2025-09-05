let isPhoneRequired = false;

const phoneLabelSpan = document.querySelector('.phone-label-span');
const phoneField = document.getElementById('phone');
const successMessage = document.querySelector('.success');
const errorMessage = document.querySelector('.error');

// Controle do telefone obrigatório
document.querySelector('#phone-checkbox')
  .addEventListener('change', function() {
    if (this.checked) {
      phoneLabelSpan.style.display = 'inline';
      phoneField.required = true;
      isPhoneRequired = true;
    } else {
      phoneLabelSpan.style.display = 'none';
      phoneField.required = false;
      isPhoneRequired = false;
    }
  });

// Lógica do envio do formulário
document.querySelector('#cadastro-form')
  .addEventListener('submit', function(event) {
    event.preventDefault();

    const firstNameField = document.getElementById('firstName');
    const lastNameField = document.getElementById('lastName');
    const cpfField = document.getElementById('cpf');
    const dateField = document.getElementById('dtnasc');
    const emailField = document.getElementById('email');

    const fieldsToValidate = [firstNameField, lastNameField, cpfField, dateField, emailField];
    if (isPhoneRequired) fieldsToValidate.push(phoneField);

    // Checar se todos estão preenchidos
    let hasError = fieldsToValidate.some(field => !field.value.trim());

    // Checar e-mail válido
    if (!hasError && !emailField.value.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/)) {
      hasError = true;
    }

    if (hasError) {
      showAndHideErrorMessage(fieldsToValidate);
      return;
    }

    // Limpar campos
    this.reset();
    phoneLabelSpan.style.display = 'none';
    isPhoneRequired = false;

    // Mostrar sucesso
    successMessage.style.display = 'block';
    errorMessage.style.display = 'none';
    scroll(0, 0);
    hideMessageAfterTimeout(successMessage);
  });

// Função de erro com animação nos campos
function showAndHideErrorMessage(fields) {
  errorMessage.style.display = 'block';
  successMessage.style.display = 'none';
  scroll(0, 0);

  // Adicionar efeito de shake nos campos vazios
  fields.forEach(field => {
    if (!field.value.trim()) {
      field.classList.add('shake');
      setTimeout(() => field.classList.remove('shake'), 300);
    }
  });

  hideMessageAfterTimeout(errorMessage);
}

// Esconder mensagens após 3s
function hideMessageAfterTimeout(element) {
  setTimeout(() => {
    element.style.display = 'none';
  }, 5000);
}
