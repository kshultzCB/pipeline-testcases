timestamps {
    node {
        if (isUnix()) {
            echo "--> UNIX-y system deteted."
            for (int i=0; i<15; i++) {
                stage ("Unix Looping Stages $i") {
                    echo "My stage number is $i"        
                    node {
                        sh 'vmstat || exit 1'
                    }
                }
            }
            stage ('Unix shell script') {
                node {
                        sh 'vmstat'
                    }
                }
            stage ('Label-based') {
                node {
                    stage ('Things using node') {
                        for (int i=0; i<20; i++) {
                            echo "We have done this $i times."    
                        }
                    }
                }
            }
        } // end isUnix block

        else { // Must be Windows.
            echo "--> Windows system detected."
            for (int i=0; i<15; i++) {
                stage ("Windows Looping Stages $i") {
                    echo "My stage number is $i"        
                    node {
                        echo "dir on windows directory"
                        bat 'dir C:\\windows'
                    }
                }
            }

            stage ('Windows shell script') {
                node {
                    bat 'dir'
                }
            }

            stage ('Label-based') {
                node {
                    for (int i=0; i<20; i++) {
                        echo "We have done this $i times."    
                    }
                }
            }
        } // ends our windows stuff
    } // ends node 
} // end timestamps