pipeline {
    agent any

    environment {
        JAVA_HOME = "C:\\Program Files\\Java\\jdk-11" // Your JDK path
        PATH = "${env.JAVA_HOME}\\bin;${env.PATH}"
    }

    triggers {
        // Run every 30 minutes
        cron('H/30 * * * *')
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/yourusername/JobProfileAutoUpdater.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                // Run TestNG using your testng.xml
                bat 'mvn test -DsuiteXmlFile=testng.xml'
            }
        }
    }

    post {
        success {
            emailext(
                subject: "✅ JobProfileAutoUpdater Success - Build #${env.BUILD_NUMBER}",
                body: "Automation ran successfully. Check console: ${env.BUILD_URL}",
                recipientProviders: [[$class: 'DevelopersRecipientProvider']]
            )
        }

        failure {
            emailext(
                subject: "❌ JobProfileAutoUpdater Failed - Build #${env.BUILD_NUMBER}",
                body: "Automation failed! Check console: ${env.BUILD_URL}",
                recipientProviders: [[$class: 'DevelopersRecipientProvider']]
            )
        }
    }
}