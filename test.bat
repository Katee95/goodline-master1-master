java -jar out/debugdemo.jar -login foo@example.com -pass qwerty
echo expected 0 actual %ERRORLEVEL%

java -jar out/debugdemo.jar -login bar.baz@gmail.com -pass 123456
echo expected 0 actual %ERRORLEVEL%

java -jar out/debugdemo.jar -h
echo expected 1 actual %ERRORLEVEL%

java -jar out/debugdemo.jar -login ***@example.com -pass qwerty
echo expected 2 actual %ERRORLEVEL%

java -jar out/debugdemo.jar -login bar.baz@gmail.com -pass 123456 -param
echo expected 1 actual %ERRORLEVEL%

java -jar out/debugdemo.jar
echo expected 1 actual %ERRORLEVEL%

java -jar out/debugdemo.jar -login bar.baz@gmail.com
echo expected 1 actual %ERRORLEVEL%

java -jar out/debugdemo.jar -pass qwerty
echo expected 1 actual %ERRORLEVEL%

java -jar out/debugdemo.jar -login *** -pass qwerty
echo expected 2 actual %ERRORLEVEL%

java -jar out/debugdemo.jar -login foo@example.com -pass qwe
echo expected 4 actual %ERRORLEVEL%

java -jar out/debugdemo.jar -pass qwerty -login foo@example.com
echo expected 0 actual %ERRORLEVEL%