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
   withMaven(maven : 'maven') {
   		sh 'mvn clean install'
		}
	}
   }
 }
}