echo "Compiling Maven Project"
CALL mvn compile
echo "Pacakging Project"
CALL mvn package
echo "Running App.java in Project"
CALL java -cp .\target\FirstUiApp-1.0-SNAPSHOT.jar com.verma.rishabh.App
@pause