node('docker-node') {
  def buildNumber = currentBuild.number
  def name_img = "${env.JOB_NAME}"
  def image
  def version = "${buildNumber}"
  stage('Checkout Repository') {
    deleteDir()
    checkout scm
  }
  stage('Build Image'){
      image = docker.build("$name_img")
    }
  stage('Push Image'){
    docker.withRegistry('http://20.231.125.187:8182', 'nexus') {
      image.push("$version")
      image.push("latest")
    }  
  }
  stage('Delete Image'){
    def imgrm
    imgrm = sh(script: "docker images $name_img:latest -q", returnStdout: true).trim()
    println imgrm
    sh("docker rmi -f $imgrm")
  }
  stage('Deploy Image'){
    withCredentials([file(credentialsId: 'kubeconfig', variable: 'SECRET_FILE')]) {
      sh 'KUBECONFIG=$SECRET_FILE kubectl apply -f ./kubernetes/deployment.yaml'
      sh 'KUBECONFIG=$SECRET_FILE kubectl set image deployment publish-event-billing ${name_img}:${version}'
    }
  }

}