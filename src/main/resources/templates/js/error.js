const form = document.querySelector('form');

form.addEventListener('submit', (event) => {
    event.preventDefault(); // prevent form submission

    const bookName = document.getElementById('bookName').value.trim();
    const genre = document.getElementById('inputGroupSelect01').value;
    const category = document.getElementById('inputGroupSelect02').value;
    const email = document.getElementById('email').value.trim();
    const reason = document.getElementById('comment').value.trim();

    let errors = [];

    if (bookName === '') {
        errors.push('Please enter a book title.');
    }

    if (genre === 'Choose...') {
        errors.push('Please select a genre.');
    }

    if (category === 'Choose...') {
        errors.push('Please select a category.');
    }

    if (email === '') {
        errors.push('Please enter an email address.');
    } else if (!isValidEmail(email)) {
        errors.push('Please enter a valid email address.');
    }

    if (reason === '') {
        errors.push('Please enter a reason for your request.');
    }

    if (errors.length > 0) {
        displayErrors(errors);
    } else {
        form.submit();
    }
});

function isValidEmail(email) {
    // Regular expression for email validation
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
}

function displayErrors(errors) {
    // Clear any existing error messages
    clearErrors();

    const errorList = document.createElement('ul');
    errors.forEach(error => {
        const errorItem = document.createElement('li');
        errorItem.textContent = error;
        errorList.appendChild(errorItem);
    });
    const errorMessage = document.createElement('div');
    errorMessage.classList.add('alert', 'alert-danger');
    errorMessage.appendChild(errorList);
    form.insertBefore(errorMessage, form.firstChild);
}

function clearErrors() {
    const existingErrors = form.querySelectorAll('.alert-danger');
    existingErrors.forEach(error => {
        error.remove();
    });
}

