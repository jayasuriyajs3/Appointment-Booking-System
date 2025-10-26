// script.js (for Doctor Module)

document.addEventListener('DOMContentLoaded', function() {
    console.log('Doctor module scripts initialized.');

    // Example of a minimal client-side validation for experience years
    const experienceInput = document.getElementById('experienceYears');
    if (experienceInput) {
        experienceInput.addEventListener('input', function() {
            if (this.value < 0) {
                this.value = 0; // Prevent negative values
            }
        });
    }

    // Additional interactive logic goes here...
});