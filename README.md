# Account Manager 

### Clone 
* Run `git clone https://github.com/uniqueM12/AccountManager` to clone the project into your local.

-OR-

* Clone from the repo on Github at [Account manager Repo](https://github.com/uniqueM12/AccountManager).
### Build 
This project is packaged with maven; for simplicity.
* Open terminal and change directory into to the root of the project
* Run `mvn install` to run all tests and package the project as a typical .war file.
### Docker 
- In the root of the project, run `docker build -t accountmanager:1.0 .`to create a docker image
- run `docker run -it -p 4000:8080 accountmanager:1.0` to run the app on port 4000
### Validate the test
- In your browser, navigate to [http://localhost:4000/accountmanager/](http://localhost:4000/accountmanager/) to see a minimalist interface into the project

