# Web2Day 2016

Slides, notebooks and source code of my talk "Big Data Viz (and much more!) with Apache Zeppelin"

Content:
* __slides__: pdf of the slides
* __notebooks__: json of the notes used for the demos
* __site__: basic web site to show how to pusblish results
* __interpreter__: source of an interpreter

About the interpter:
* Build (install Zeppelin first):
```bash
mvn clean package
```

* Deployment:
```bash
mkdir $ZEPPELIN_HOME/interpreter/demo
cp target/zeppelin-demo-0.0.1-SNAPSHOT.jar $ZEPPELIN_HOME/interpreter/demo
```

* Config: add the interperter class in $ZEPPELIN_HOME/conf/zeppelin-site.xml (property: zeppelin.interpreters)

* Run:
```bash
$ZEPPELIN_HOME/bin/zeppelin-daemon.sh start
```

* In UI, do not forget to select "demo" in the "interpreter binding" menu (a gear on the right of your note) in order to be able to use this interpreter

* In a paragraph:
```
%demo
clock
```



