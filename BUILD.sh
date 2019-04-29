echo Begin Build
mkdir out
kotlinc -d out/katee.jar -include-runtime src
echo End Build