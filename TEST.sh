./BUILD.sh

COUNT_ALL=0
COUNT_SUC=0

function test {
    MSG=$1; shift
    EXPECTED=$1
    shift

    echo
    echo $MSG
    ./RUN.sh "$@"
    RES=$?
    let COUNT_ALL++
    if [ $RES -eq $EXPECTED ]; then
        echo Test passed
        let "COUNT_SUC = $COUNT_SUC + 1"
    else
        echo est failed. Expected $EXPECTED Actual $RES
        fi
}


test 0 -login bar.baz@gmail.com -pass qwerty
test 1 -h
test 2 -login ***@example.com -pass 123456
test 1 -login bar.baz@gmail.com -pass qwerty -param
test 1
test 1 -login bar.baz@gmail.com
test 1 -pass qwerty
test 2 -login *** -pass qwerty
test 4 -login foo@example.com -pass qwe
test 0 -pass qwerty -login foo@example.com

echo ***
if [ $COUNT_ALL -eq $COUNT_SUC ]; then
    echo All tests passed
    exit 0
else
    echo $COUNT_SUC success tests out of $COUNT_ALL
exit 1
fi

echo Many args
./RUN.sh foo bar baz "1 2 3"