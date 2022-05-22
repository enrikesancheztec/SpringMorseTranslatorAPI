pipeline {
    agent {
        docker {
            image 'maven:3.8.1-adoptopenjdk-11'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Prepare Heroku') {
            steps {
                sh 'npm install -g heroku'
                sh 'heroku --version'
            }
        }    
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Sonar') {
            steps {
                withSonarQubeEnv(installationName: 'SonarQube Docker', credentialsId: 'SonarQubeDocker') {
                    sh 'mvn -B -DskipTests verify sonar:sonar -Dsonar.qualitygate.wait=true'
                }
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
        stage('Javadoc') {
            steps {
                sh 'mvn -B -DskipTests javadoc:javadoc'
            }
        }
        stage('Deploy') {
            steps {
                sh 'mvn -e heroku:deploy -Dheroku.appName=spring-morse-translator-api -DskipTests'
            }
        }  
    }
}
