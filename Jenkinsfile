pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Vandna-Pandey/JobProfileAutoUpdater.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }
}