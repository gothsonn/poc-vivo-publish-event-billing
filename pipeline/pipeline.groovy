node('docker-node') {
  def buildNumber = currentBuild.number
  def name_img = "${env.JOB_NAME}:${buildNumber}"
  stage('Prepare') {
    checkout scm
  }
  stage('build'){
    docker.withRegistry('http://20.231.125.187:8182', 'nexus') {
      def dockerImage = docker.build("$name_img")
      dockerImage.push()
    }
  }
  stage('deploy'){
    withCredentials([file(credentialsId: 'kubeconfig', variable: 'SECRET_FILE')]) {
      sh 'KUBECONFIG=$SECRET_FILE kubectl apply -f ./kubernetes/deployment.yaml'
      sh 'KUBECONFIG=$SECRET_FILE kubectl set image deployment publish-event-billing ${name_img}'
    }
  }

}