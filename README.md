# HR-Management-App_BackEnd

This is a human resorces management web application, this is the part that handles 
the login to the platform and the employee management operations which are:
  - Add employee
  - Remove employee
  - Update An employee's informations
  - List all employees
  - Get a specific employee by id
  - Automatically update the remaining Leave days credit of the employees
  - Automatically update the salary of the employees based on the number of abseces
  out of the employee Leave Credit range
  
  

## Deployment: 
  Execute the following at the root-folder of the app:
    - mvn clean install
    - java -jar HR-Management-App-BE-"<version>".jar
  and do not forget to change the "<version>" with the version that you are trying to deploy
