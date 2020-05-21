# Log Processor
![Java CI](https://github.com/rupinr/log-processor/workflows/Java%20CI/badge.svg)

Log Processor is available as a docker image. To process the log files, invoke the docker container as follows.

### Usage


#### Sample Input

```sh

2015-10-28T12:24:33,903 TRACE [OperImpl] entry with (addClient:97900)
2015-10-28T12:24:34,002 TRACE [OperImpl] exit with (addClient:97900)
2015-10-28T12:24:33,903 TRACE [OperImpl] entry with (addClient:97901)
2015-10-28T14:24:35,002 TRACE [OperImpl] exit with (addClient:97901)
2015-10-28T12:24:33,903 TRACE [OperImpl] entry with (addClient:97902)
2015-10-28T12:24:36,002 TRACE [OperImpl] exit with (addClient:97902)
2015-10-28T12:24:33,903 TRACE [OperImpl] entry with (clearClient:97909)
2015-10-28T12:24:36,002 TRACE [OperImpl] exit with (clearClient:97909)
2015-10-28T12:24:33,903 TRACE [OperImpl] entry with (funClient:979011)
2015-10-28T12:24:36,002 TRACE [OperImpl] exit with (funClient:979011)

```

#### Command

```sh

docker run -v ~/path/to/test.log:/test.log  rupinrnath/log-processor test.log

```

#### Console Output

```sh

clearClient has been called 1 times
Max Execution Time is 2.099

addClient has been called 3 times
Max Execution Time is 7201.099

funClient has been called 1 times
Max Execution Time is 2.099

```

