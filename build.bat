SET JAVA_HOME=C:\Users\Public\wpilib\2023\jdk
rmdir /s/q build\distributions
call GRADLEW Build
call "C:\Program Files\7-Zip\7z.exe" x build/distributions/PiSoundSample-shadow.zip -obuild/distributions
