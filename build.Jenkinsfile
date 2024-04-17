pipeline {
    agent any
    environment {
        AWS_REGION= 'eu-north-1'
        ECR_REGISTRY_URL='211125740082.dkr.ecr.eu-north-1.amazonaws.com/libautomation'
    }
    stages {
        stage('Build') {
            steps {
                sh 'echo building prrentation pipeline'
            }
        }
        stage('Building app') {
            steps {
               sh '''
                    aws ecr get-login-password --region eu-north-1 | docker login --username AWS --password-stdin 211125740082.dkr.ecr.eu-north-1.amazonaws.com
                    docker build -t libautomation .
                    docker tag libautomation:latest 211125740082.dkr.ecr.eu-north-1.amazonaws.com/libautomation:$BUILD_NUMBER
                    docker push 211125740082.dkr.ecr.eu-north-1.amazonaws.com/libautomation:$BUILD_NUMBER 

               '''
           }
        }
        stage('Trigger Deploy') {
              steps {
                  build job: 'libBuild', wait: false, parameters: [
                      string(name: 'lib_IMAGE_URL', value: "211125740082.dkr.ecr.eu-north-1.amazonaws.com/libautomation:$BUILD_NUMBER ")
                  ]
              }
        }
    }
}