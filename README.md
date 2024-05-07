# bl-demo

Clone the repository on your local machine.



## Database Setup (MySql)
1. Download MySql Workbench
2. Under MySQL Connection add a new connection (plus icon)
  ![image](https://github.com/nomss/bl-demo/assets/93707322/c69735cd-af39-4154-a4ca-c597ad2719d6)
3. Connection Name: **bl-db**
   Add password by clicking "Store in Vault..." and type in: **root**

## Frontend Setup (Angular)
1. Download node v20 - this will download and setup node(v20) and npm(v10)
2. (Optional) for easer switch of the versions for node you can download nvm (Node Version Manager)
  - with nvm you can just download node from the CMD with **nvm install v20** command
  - After that you just use **nvm use v20** command 
3. Open bl-ui folder with VSCode
4. Run npm install - this will install all the dependencies and create node_modules fodler
5. Start the application with **ng serve**

## Backend Setup (Spring)
1. Open bl-service folder with IntelliJ
2. Right click the pom.xml file and select **Maven -> Download Sources & Documentation** and then again **Maven -> Reload project**
3. Run the application from the BlServiceApplication main class
