@echo off
cd /d "%~dp0"

"C:\Program Files\Microsoft\jdk-17.0.19.10-hotspot\bin\javac" -d out -sourcepath src\main\java src\main\java\com\trabalho\Main.java
"C:\Program Files\Microsoft\jdk-17.0.19.10-hotspot\bin\java" -cp out com.trabalho.Main
