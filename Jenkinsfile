pipeline {
    agent {
        docker {
            image 'maven:3.8.1-adoptopenjdk-11'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') { 
            steps {
                sh 'mvn test' 
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml' 
                }
            }
        }
        stage('Sonar') {
            steps {
                withSonarQubeEnv(installationName: 'SonarQube Docker', credentialsId: 'SonarQubeDocker') {
                    sh 'mvn -B -DskipTests verify sonar:sonar -Dsonar.qualitygate.wait=true'
                }
            }
        }        
        stage('Javadoc') {
            steps {
                sh 'mvn -B -DskipTests javadoc:javadoc'
            }
        }        
    }
}
