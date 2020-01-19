pipeline{
 agent any
 stages {
   stage("SCM Checkout"){
   		checkout scm
   }
   stage("Build"){
   		sh 'mvn clean install'
   }
 }
}