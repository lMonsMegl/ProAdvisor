# ProAdvisor

## Conventions

### Branch name convention

`PA-<ticket number>-<ticket title in lowwer case>`

Example: PA-000-test-ticket-title

### Commit name convention

`[PA-<ticket number>] <ticket title>`

Example: [PA-000] Test ticket title

## Install instructions

### Backend

1. Download and install postgresql dbms  
    https://www.enterprisedb.com/thank-you-downloading-postgresql?anid=1256619  
    Choose any secure and complex password and store it somewhere.
2. Download and install java 8 jdk 
    - with
    https://download.oracle.com/otn/java/jdk/8u211-b12/478a62b7d4e34b78b671c754eaaf38ab/jdk-8u211-windows-x64.exe
    - or https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
3. Type `psql` to windows search, press enter. You will get to postgresql console. 
    Press enter until you will be prompted to enter the password. Enter the password you chose during postgresql installation.
    
    Execute the following commands:  
    `CREATE DATABASE proadvisor;`  
    `CREATE USER proadvisormain WITH PASSWORD '12345';`  
    `GRANT ALL PRIVILEGES ON DATABASE "proadvisor" to proadvisormain;`  
    
### Frontend

1. Download and install Node.js to use npm package manager
https://nodejs.org/uk/

2. Run in terminal npm install

3. npm run start

4. Go to web browser to localhost: 3000


     
## Run instructions

1. Make sure postgresql server is running or application wont start due to absence of database.
2. Make sure default port 9000 is not used
3. Build project with command `gradlew.bat build` (optional with idea)
3. Run main method in class com.proadvisor.Application
4. Go to browser to url `localhost:9000`

### 
## Guides

### psql

`\l` list databases  
`\conninfo` display information about current connection  
`\c [DBNAME]` connect to new database, e.g., `\c proadvisor`  
`\dt` list tables of the public schema  
`\du` list users
`\q` quit psql  
