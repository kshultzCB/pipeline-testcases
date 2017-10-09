/*
This is one of my favorites from the Declarative 1.2 
release testing. This should exercise Declarative's 
parallel stage execution. 

NOTE: This will NOT WORK unless the Declarative plugins 
have been upgraded to 1.2.

*/ 

pipeline {

    agent any

    environment {
        SOMETHING_TO_INHERIT  = "This has been inherited!"
        SOMETHING_TO_OVERRIDE = "This should be overriden, if you see it, that's wrong."
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: '20')) 
    }

    stages {
        stage ('Parallel Wrapper') {  // start of parallel wrapper
            parallel {
                stage('parallel-1') {
                    steps {
                        echo "Let's check our environment variables"
                        echo SOMETHING_TO_INHERIT
                        echo SOMETHING_TO_OVERRIDE
                        sh 'for i in `seq 1 100`; do cat /dev/urandom | env LC_CTYPE=c tr -dc \\\'[:alpha:]\\\' | head -c 5000; done'
                    }
                }
                stage('parallel-2 OVERRIDES') {
                    environment {
                        SOMETHING_TO_OVERRIDE = "YES --> PARALLEL-2"
                    }
                    steps {
                        echo "Let's check our environment variables"
                        echo SOMETHING_TO_INHERIT
                        echo SOMETHING_TO_OVERRIDE
                        sh 'for i in `seq 1 100`; do cat /dev/urandom | env LC_CTYPE=c tr -dc \\\'[:alpha:]\\\' | head -c 5000; done'
                    }
                }
                stage('parallel-3 OVERRIDES') {
                    environment {
                        SOMETHING_TO_OVERRIDE = "YES --> PARALLEL-3"
                    }
                    steps {
                        echo "Let's check our environment variables"
                        echo SOMETHING_TO_INHERIT
                        echo SOMETHING_TO_OVERRIDE
                        sh 'for i in `seq 1 100`; do cat /dev/urandom | env LC_CTYPE=c tr -dc \\\'[:alpha:]\\\' | head -c 5000; done'
                    }
                }
                stage('parallel-4 OVERRIDES') {
                    environment {
                        SOMETHING_TO_OVERRIDE = "YES --> PARALLEL-4"
                    }
                    steps {
                        echo "Let's check our environment variables"
                        echo SOMETHING_TO_INHERIT
                        echo SOMETHING_TO_OVERRIDE
                        sh 'for i in `seq 1 100`; do cat /dev/urandom | env LC_CTYPE=c tr -dc \\\'[:alpha:]\\\' | head -c 5000; done'
                    }
                }
                stage('parallel-5 OVERRIDES') {
                    environment {
                        SOMETHING_TO_OVERRIDE = "YES --> PARALLEL-5"
                    }
                    steps {
                        echo "Let's check our environment variables"
                        echo SOMETHING_TO_INHERIT
                        echo SOMETHING_TO_OVERRIDE
                        sh 'for i in `seq 1 100`; do cat /dev/urandom | env LC_CTYPE=c tr -dc \\\'[:alpha:]\\\' | head -c 5000; done'
                    }
                }
                stage('parallel-6 OVERRIDES') {
                    environment {
                        SOMETHING_TO_OVERRIDE = "YES --> PARALLEL-6"
                    }
                    steps {
                        echo "Let's check our environment variables"
                        echo SOMETHING_TO_INHERIT
                        echo SOMETHING_TO_OVERRIDE
                        sh 'for i in `seq 1 100`; do cat /dev/urandom | env LC_CTYPE=c tr -dc \\\'[:alpha:]\\\' | head -c 5000; done'
                    }
                }
                stage('parallel-7 OVERRIDES') {
                    environment {
                        SOMETHING_TO_OVERRIDE = "YES --> PARALLEL-7"
                    }
                    steps {
                        echo "Let's check our environment variables"
                        echo SOMETHING_TO_INHERIT
                        echo SOMETHING_TO_OVERRIDE
                        sh 'for i in `seq 1 100`; do cat /dev/urandom | env LC_CTYPE=c tr -dc \\\'[:alpha:]\\\' | head -c 5000; done'
                    }
                }

                stage('parallel-8 OVERRIDES') {
                    environment {
                        SOMETHING_TO_OVERRIDE = "YES --> PARALLEL8"
                    }
                    steps {
                        echo "Let's check our environment variables"
                        echo SOMETHING_TO_INHERIT
                        echo SOMETHING_TO_OVERRIDE
                        sh 'for i in `seq 1 100`; do cat /dev/urandom | env LC_CTYPE=c tr -dc \\\'[:alpha:]\\\' | head -c 5000; done'
                    }
                }
                stage('parallel-9 OVERRIDES') {
                    environment {
                        SOMETHING_TO_OVERRIDE = "YES --> PARALLEL-9"
                    }
                    steps {
                        echo "Let's check our environment variables"
                        echo SOMETHING_TO_INHERIT
                        echo SOMETHING_TO_OVERRIDE
                        sh 'for i in `seq 1 100`; do cat /dev/urandom | env LC_CTYPE=c tr -dc \\\'[:alpha:]\\\' | head -c 5000; done'
                    }
                }
                stage('parallel-10 OVERRIDES') {
                    environment {
                        SOMETHING_TO_OVERRIDE = "YES --> PARALLEL-10"
                    }
                    steps {
                        echo "Let's check our environment variables"
                        echo SOMETHING_TO_INHERIT
                        echo SOMETHING_TO_OVERRIDE
                        sh 'for i in `seq 1 100`; do cat /dev/urandom | env LC_CTYPE=c tr -dc \\\'[:alpha:]\\\' | head -c 5000; done'
                    }
                }
            } // end of parallel
        } // end of wrapper stage
    } // end stages

    /* 
    This section is evaluated after the stages are all done.
    */
    post {
        always {
            echo "ALWAYS --> Runs all the time."
            // Delete our work directory to save on disk space.
            deleteDir()
        }
        success {
            echo "SUCCESS --> Whatever we did, it worked. Yay!"
        }
        failure {
            echo "FAILURE --> Failed. Womp womp."
        }
    }

 }
