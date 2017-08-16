# Romwell Alpha

A little game created by MichaelP59024 and AlexPJP (and tidied by Erj4)

### Prerequisites

[Java SE SDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)

[LWJGL 2](http://legacy.lwjgl.org/download.php.html)

### Running
The following instructions allow you to compile and run Romwell Alpha from the command line.
All commands should be issued from the root directory of Romwell Alpha.
#### Linux
Compile, specifying output directory (bin)
```
javac -cp lib/lwjgl.jar:lib/lwjgl_util.jar:lib/slick-util.jar:src -d bin src/gameStart/boot.java
```
Then run, specifying natives location
```
java -cp bin:lib/lwjgl.jar:lib/lwjgl_util.jar:lib/slick-util.jar -Djava.library.path="natives" gameStart.boot
```
#### Windows
Compile, specifying output directory (bin)
```
javac -cp lib/lwjgl.jar;lib/lwjgl_util.jar;lib/slick-util.jar;src -d bin src/gameStart/boot.java
```
Then run, specifying natives location
```
java -cp bin;lib/lwjgl.jar;lib/lwjgl_util.jar;lib/slick-util.jar -Djava.library.path="natives" gamestart.boot
```
