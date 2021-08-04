# Devops-SpringBoot-BackEnd
Devops Project SpringBoot BackEnd



####Dockerfile :　

```javascript
FROM openjdk:8-jdk-alpine
ADD  /target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]
```

####Jenkinsfile (pipeline)

```javascript
pipeline {
    agent any
 tools{
     maven 'maven-3.8.1'
    }
    stages {
        stage('Git Checkout') {
            steps {
                git branch: 'main', credentialsId: 'rachiddev', url: 'https://github.com/rachidoubahmane99/Devops-SpringBoot-BackEnd.git'
                }
        }
        stage('build Maven') {
            steps {
               bat 'mvn compile'
            }
        }
        stage('Test Unitaire') {
            steps {
               bat 'mvn clean test'
            }
        }
          stage('App Package') {
            steps {
               bat 'mvn clean package'
            }
        }
         stage('Build Docker Image'){
            steps{
                bat "docker build --tag rachiddocker1/springbootbackend:1.0.0 ."
            }
        }
        stage('Push Docker Image'){
            steps{
                withCredentials([string(credentialsId: 'dockerhubinfo', variable: 'dockerinfo')]) {
                bat "docker login -u rachiddocker1 -p ${dockerinfo}"
            }   
                bat 'docker push rachiddocker1/springbootbackend:1.0.0'
        }
        } 
    }
    post{
        failure{
            echo "Buid $BUILD_NUMBER echec"
           
        }
        success{
            echo "Build $BUILD_NUMBER success "
        }
    }
}

```
