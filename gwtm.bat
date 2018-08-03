set JAVA_HOME=C:\java\jdk8
set M2_HOME=c:\java\maven3.3.9

set path=%JAVA_HOME%\bin;%M2_HOME%\bin;%PATH%

mvn archetype:generate -DarchetypeGroupId=com.github.gwtmaterialdesign -DarchetypeArtifactId=gwt-material-archetype -DarchetypeVersion=2.0.1
