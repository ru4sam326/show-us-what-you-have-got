# Assignment - Online Library Management System

You have to design and implement a working online library management system. You have complete freedom to exercise your imagination and technical skills while adhering to the basic requirements laid out below.

Also note that though you obviously can take the easy route and search online for a solution, this assignment is really about showcasing your own analytical and technical skills, so the more individuality you show, the better shall be your prospects.

Also please note that it is not how much you cover but how you approach the solution which we are really interested in, hence make sure you commit code regularly as we would be closely monitoring the progress and can call you for an interview much before the stipulated due date if we feel that you are progressing really well.

Use this opportunity to show us what you have got and that you have what it takes to join us as we build a wonderful product together.

# Functional Requirements
Below are listed the functional requirements that the solution should support. Wherever in doubt, make reasonable assumptions and move forward but please do document those assumptions as well so that we know why you made them.

## Must have features
- Member registration
- User login and access based on role (Librarian / Member)
- Librarian access to register books and catalogue them
- Ability for any user to see book availability
- For physical books, ability for the member to raise a request for a book if it is available
- For e-books, ability for the member to download a book (the actual download functionality need not be implemented)
- Ability for the librarian to issue a physical book based on user requests

## Nice to have features
- Searching for desired books by ISBN, Title, Author, etc.
- Take member's requests for new books which are currently not in the library catalogue
- Ability for the librarian to view the list of defaulters who are not returning books within alloted due dates
- Restrictions on the number of books that can be taken / downloaded at a time by a member based on his subscription type (Gold / Silver / Bronze)

# Technical requirements
## Mandatory
- MySQL 5.7 database to store all the master and transactional data for the system
- JPA 2.0 with Hibernate as the provider to persist and retrieve data
- Spring 4.0 as the application development framework and IoC container
- JAX-RS to expose REST APIs for all the functionality mentioned above
- HTML / CSS / JavaScript based UI talking to the backend library system strictly through the exposed REST APIs
- Strictly no Servlet / JSP, etc. based UI. The UI should talk to the backend using the REST APIs only
- Maven to be used as the build system for building the solution
- The solution should result in two web applications, one for the UI and one for the backend
- The solution should be able to run within a Tomcat 7.0 container

## Desirable
- Responsive UI using Bootstrap
- AngularJS as the JavaScript framework
- Multi-module Maven project
- Single page web application
- Storage of session information in the browser's local storage
- Simple and smooth user experience
 
# How to submit the assignment
## Step 1
Fork this repository, and create a subdirectory titled with your name and any other optional text describing your solution
## Step 2
Complete coding for your solution. Make sure to also include any database scripts, etc. if required.
## Step 3
Submit a pull request to this repository before the stipulated due date for the assignment. Everything related to your solution should be within the subdirectory you created above
## Step 4
Include at a minimum one README file describing your solution along with detailed instructions on how to run it. You can have as many documentation files as you want. Use Markdown for the documentation

# Important
If you are not proactively called for an interview before the assignment due date, you would need to mandatorily submit a pull request, without which we cannot consider your assignment for evaluation. Also ensure that you submit only one pull request and that too only after you are fully ready to share your assignment with us.

We really look forward to getting some bright minds who can show us all their creativity and aptitude through this assignment.

## All the best and happy coding :-)


