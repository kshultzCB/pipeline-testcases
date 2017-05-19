timestamps {
// Do we actually need to wrap the entire thing 
// in a node block?
node {

    if (isUnix()) {
        echo "---->>>> Unix"
        for (int i=0; i<15; i++) {
            stage ("Unix Looping Stages $i") {
                echo "My stage number is $i"        
                node {
                    sh 'vmstat'
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
    } // end ifUnix block

    else { // windows stuff
        echo "---->>>> Windows"
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
    } // end windows 
} // end node 

} // end timestamps