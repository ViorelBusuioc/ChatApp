function validateUsername() {
      const usernameInput = document.getElementById('name');
      const username = usernameInput.value.trim();

      const passwordInput = document.getElementById('password');
      const password = passwordInput.value.trim();

      // Regular expression for alphanumeric characters
      const regex = /^[a-zA-Z0-9]+$/;

      if (username === "") {
        alert("Username cannot be empty!");
        return false;
      } else if (!regex.test(username)) {
        alert("Username can only contain letters and numbers!");
        return false;
      }

      if (password === "") {
        alert("Password cannot be empty!");
        return false;
      }

      return true; // Allow form submission if validation passes
    }