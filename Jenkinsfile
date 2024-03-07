pipeline {
    agent any
    
    stages {
        stage ('Fetch repo') {
            steps {
                script {
                    // Get the current build number
                    def buildNumber = currentBuild.number
                    // Get the current branch name
                    //def branchName = params.BRANCH
                    // Set the custom display name
                    //currentBuild.displayName = "#${buildNumber} - ${branchName}"
                    
                    // Construct the dynamic stage title
                    // def dynamicTitle = "Stage for branch ${branchName} - Build ${buildNumber}"
                    // currentBuild.displayName = dynamicTitle
                }
                
                git url: 'file:///D:/Java%20Projects/Todocial_E2E_Tests'
                
            }
        }
        
        stage ('Install'){
            steps {
                echo "installing dependencies"
            }
        }
        
        stage ('Lint') {
            steps {
                echo "Linting..."
            }
        }
        
        stage ('Test') {
            steps {
                echo "Testing"
                bat "mvn clean test"
            }
        }
        
    }
    
    post {
        
          always {
            cucumber buildStatus: 'UNSTABLE',
                    failedFeaturesNumber: 1,
                    failedScenariosNumber: 1,
                    skippedStepsNumber: 1,
                    failedStepsNumber: 1,
                    classifications: [
                            [key: 'Commit', value: '<a href="${GERRIT_CHANGE_URL}">${GERRIT_PATCHSET_REVISION}</a>'],
                            [key: 'Submitter', value: '${GERRIT_PATCHSET_UPLOADER_NAME}']
                    ],
                    reportTitle: 'My report',
                    fileIncludePattern: '**/*.json',
                    sortingMethod: 'ALPHABETICAL',
                    trendsLimit: 100
        }
    
    }
}