#!/bin/sh

JAVA_DEFAULT_OPTS="-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap"

if [ -n "$MEMTOTAL_MB" ]
then
    JAVA_MEM_OPTS="-Xms${MEMTOTAL_MB}m -Xmx${MEMTOTAL_MB}m"
else
    JAVA_MEM_OPTS=""
fi

exec java $JAVA_DEFAULT_OPTS $JAVA_MEM_OPTS -jar /home/bin/akka-starter-shadow.jar