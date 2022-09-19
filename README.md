# goodreads-se 
Web application automation using selenium 4 :computer:
---
### Stack involved:

1. Selenium 4
3. core java
4. testNG
5. Extent reports 5
6. bonigarcia WebDriverManager to handle browser drivers automatically
7. Build tool: Maven
8. Test runner: Maven surefire plugin
9. json files for data management
---
### Browser support:

1. Chrome
2. Firefox

---
### Steps to run:

**Pre-requisites**:

1. Java 1.8 should be installed locally
2. Chrome and firefox on the system 
3. Any preferred IDE

**Steps**:

1. clone this repo
2. import as a project by selecting pom.xml
3. either run testng.xml manually OR
4. run mvn ```mvn -q clean test```
---

### Highlights:
1. Selenium 4 is used
2. Detailed screenshot handling mechanism
3. Automatic capture of failed screenshots. Implimented with the help of testNG Listeners
4. Extent reports
5. Cross browser testing using testNG Parameterization
6. Headless execution


### Reports:

1. Extent report html

<img width="1440" alt="image" src="https://user-images.githubusercontent.com/30006440/168386523-d8aee06a-cdfd-4d7d-8793-e413223cca02.png">

2. testNG default report

<img width="1281" alt="image" src="https://user-images.githubusercontent.com/30006440/168386798-da2d61db-69c9-459e-831a-7589c4dea38d.png">

---

CI(WIP):
