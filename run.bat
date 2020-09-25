@echo off

cd %CD%/src/

echo Compiling Program...
javac -d ../bin ./*.java

echo Running program...
echo --------------------------------
cd ..
cd %CD%/bin
java Main
echo --------------------------------
cd ..
PAUSE