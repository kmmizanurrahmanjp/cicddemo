pipeline {
    agent any

    tools {
        // Install the Maven version configured.
        maven "MAVEN"
    }

    stages {
	stage('Pulling form Repository') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'main', url: 'https://github.com/kmmizanurrahmanjp/cicddemo.git'
            }
        }
        stage('Meven Build') {
            steps {
                // Run Maven on a Unix agent.
                //sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                success {
                    //archiveArtifacts 'target/*.jar'
                    echo 'Build Success'
                }
            }
        }
	stage('JUnit testing') {
            steps {
                junit allowEmptyResults: true, testResults: '**/target/test-reports/*.xml'
            }

            post {
                success {
                    echo 'Test Success'
                }
            }
        }
	stage('Deploy to tomcat server') {
	steps {
		//Deploy tomcat server
                deploy adapters: [tomcat8(credentialsId: '56f3da6e-db74-48da-af3b-d0c93d8d743e', path: '', url: 'http://localhost:8080')], contextPath: 'cicddemo', onFailure: false, war: '**/*.war'
            }

            post {
                success {
                    echo 'Deploy Success'
                }
            }
            
        }
    }
}
