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
        stage('Maven build&test'){ 
            agent {
                docker {
                    image 'maven:3.9.9-eclipse-temurin-17-alpine'
                    args  '-u=\"root\"'
                }
            }
            steps{
                sh 'mvn clean package -DskipTests'
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
        stage('Image build'){
            agent any
            steps{
                sh 'docker build -t denisdovgodko/javaapp:latest .'
            }
        }
        stage('Image push'){
            agent any
            steps{
                withCredentials([usernamePassword(credentialsId: 'dockerHubCreds', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
                    sh 'echo ${dockerHubPassword} | docker login -u ${dockerHubUser} --password-stdin'
                    sh 'docker push denisdovgodko/javaapp:latest'
                }
            }
        }
    }
}