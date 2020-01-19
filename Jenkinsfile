pipeline{
 agent any
 stages {
   stage("SCM Checkout"){
   steps {
   		checkout scm
	}
   }
   stage("Build"){
   steps {
   		sh 'mvn clean install'
	}
   }
 }
}