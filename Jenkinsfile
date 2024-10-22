pipeline {
    options { timestamps() }
    agent none
    triggers {
        pollSCM('H/2 * * * *')
    }
    stages{
        stage('Fetch project from Git'){
            agent any
            steps {
                checkout scm
            }
        }
        stage('Maven'){ 
            agent {
                docker {
                    image 'maven:3.9.9-eclipse-temurin-17-alpine'
                    args  '-u=\"root\"'
                }
            }
            stage('Build'){
                steps{
                    sh 'mvn clean package -DskipTests'
                }
            }
            stage('Test'){
                steps{
                    sh 'mvn test'
                }
                post{
                    always {
                        junit 'target/surefire-reports/TEST-*.xml'
                    }
                    success {
                        echo "Tests have passed"
                    }
                    failure {
                        echo "Tests haven't passed"
                    }
                }
            }
        }
        stage('Image build'){
            agent any
            steps{
                sh 'docker build -t denis-dovgodko/javaapp:latest .'
            }
        }
        stage('Image push'){
            agent any
            steps{
                withCredentials([usernamePassword(credentialsId: 'dockerHubCreds', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
                    sh 'docker login -u ${dockerHubUser} -p ${dockerHubPassword}'
                    sh 'docker push denis-dovgodko/javaapp:latest'
                }
            }
        }
    }
}