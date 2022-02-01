node{
  stage('SCM checkout'){
    git branch: 'main', url: 'https://github.com/kmmizanurrahmanjp/cicddemo.git'
  }
  stage('Build'){
    sh 'mvn clean install'
  }
}
