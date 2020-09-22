@echo off

cd %CD%/src/

echo Compiling Program...
javac ./*.java

echo Running program...
echo --------------------------------
cd ..
cd %CD%/bin/
java Main
cd ..