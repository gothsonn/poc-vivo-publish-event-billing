node('docker-node') {
  def buildNumber = currentBuild.number
  def name_img = "${env.JOB_NAME}:${buildNumber}"
  def image
  stage('Prepare') {
    deleteDir()
    checkout scm
  }
  stage('Build'){
      image = docker.build("$name_img")
    }
  stage('Push'){
    docker.withRegistry('http://20.231.125.187:8182', 'nexus') {
      image.push()
  }  
  }
  stage('Deploy'){
    withCredentials([file(credentialsId: 'kubeconfig', variable: 'SECRET_FILE')]) {
      sh 'KUBECONFIG=$SECRET_FILE kubectl apply -f ./kubernetes/deployment.yaml'
      sh 'KUBECONFIG=$SECRET_FILE kubectl set image deployment publish-event-billing ${name_img}'
    }
  }

}