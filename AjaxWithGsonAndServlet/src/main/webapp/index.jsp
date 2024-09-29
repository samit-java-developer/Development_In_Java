<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Submission Example</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        function submitForm() {   
            // Gather form data
            var formData = {
                name: $('#name').val(),
                gender: $('input[name="gender"]:checked').val(),
                country: $('#country').val(),
                skills: $('input[name="skills"]:checked').map(function() {
                    return this.value;
                }).get() // Get all checked checkbox values
            };

            // AJAX request to send form data to the servlet
            $.ajax({
                url: 'AjaxServlet',
                type: 'POST',
                data: JSON.stringify(formData),
                dataType: 'json', // Expecting JSON response
                success: function(response) {
                    // Display response data
                    $('#message').text(response.message);
                    $('#responseName').text("Name: " + response.name);
                    $('#responseGender').text("Gender: " + response.gender);
                    $('#responseCountry').text("Country: " + response.country);
                    $('#responseSkills').text("Skills: " + response.skills);
                },
                error: function(xhr, status, error) {
                    console.error('Error: ' + error);
                }
            });
        }
    </script>
</head>
<body>
<h1>Form Submission with Various Input Types</h1>

    <form id="userForm" onsubmit="event.preventDefault(); submitForm();">
        <!-- Text Input -->
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>

        <!-- Radio Button -->
        <label>Gender:</label>
        <input type="radio" id="male" name="gender" value="Male" required>
        <label for="male">Male</label>
        <input type="radio" id="female" name="gender" value="Female">
        <label for="female">Female</label><br><br>

        <!-- Drop-Down List -->
        <label for="country">Country:</label>
        <select id="country" name="country" required>
            <option value="India">India</option>
            <option value="USA">USA</option>
            <option value="UK">UK</option>
            <option value="Canada">Canada</option>
        </select><br><br>

        <!-- Checkboxes -->
        <label>Skills:</label><br>
        <input type="checkbox" id="java" name="skills" value="Java">
        <label for="java">Java</label><br>
        <input type="checkbox" id="python" name="skills" value="Python">
        <label for="python">Python</label><br>
        <input type="checkbox" id="js" name="skills" value="JavaScript">
        <label for="js">JavaScript</label><br><br>

        <!-- Submit Button -->
        <button type="submit">Submit</button>
    </form>

    <!-- Display JSON Response -->
    <div id="result">
        <p id="message"></p>
        <p id="responseName"></p>
        <p id="responseGender"></p>
        <p id="responseCountry"></p>
        <p id="responseSkills"></p>
    </div>

</body>
</html>