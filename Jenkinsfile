pipeline {
    agent any

    options {
        // Guarda un historial limpio y añade colores a la consola
      timeout(time: 10, unit: 'MINUTES')
    }

    stages {
        stage('🚚 Checkout') {
            steps {
                echo '📥 Simulando la descarga de código desde GitHub...'
                script {
                    // Creamos un archivo ficticio para la demo
                    writeFile file: 'version.txt', text: 'v1.0.0-demo'
                }
                echo '✅ Código descargado con éxito.'
            }
        }

        stage('🛠️ Compilación (Build)') {
            steps {
                echo '🏗️ Compilando la aplicación...'
                // Simulamos un proceso que tarda un par de segundos
                sleep time: 2, unit: 'SECONDS'
                echo '📦 Artefacto generado: app-demo.war'
            }
        }

        stage('🧪 Pruebas Unitarias') {
            steps {
                echo '🧪 Ejecutando tests automatizados...'
                script {
                    // Un toque de realismo: simula que a veces falla
                    def exito = true // Cambiar a false si quieres ver cómo falla el pipeline
                    if (exito) {
                        echo '🎉 ¡Todos los tests pasaron (100% exitoso)!'
                    } else {
                        error '❌ Oh no, un test ha fallado.'
                    }
                }
            }
        }

        stage('🚀 Despliegue (Deploy)') {
            // Este stage solo se ejecuta si los anteriores funcionaron
            steps {
                
                echo '🌐 Desplegando en el entorno de STAGING...'
                echo 'cat version.txt'
                sleep time: 3, unit: 'SECONDS'
                echo '🚀 ¡Despliegue completado con éxito! La app está en línea.'
            }
        }

        stage("Email Build Status"){
            steps{
                input("Do you want to procedure?")
                mail body:"${env.JOB_NAME} - Build # ${env.BUILD_NUMBER} -${currentBuild.currentResult}\n\nCheck Console output at ${env.BUILD_URL} to review results.", subject:"${env.JOB_NAME} -Build# ${env.BUILD_NUMBER} -${currentBuild.currentResult}!!", to:'mpenag1121@gmail.com'
            }
        }
    }

    post {
        always {
            echo '🧹 Limpiando el espacio de trabajo...'
        }
        success {
            echo '💚 ¡Felicidades! El Pipeline terminó con éxito.'
        }
        failure {
            echo '🚨 Algo salió mal en el proceso. Revisar los logs de arriba.'
        }
    }
}
