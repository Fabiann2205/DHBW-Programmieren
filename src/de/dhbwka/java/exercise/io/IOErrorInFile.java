package de.dhbwka.java.exercise.io;

public class IOErrorInFile extends Exception{
    public IOErrorInFile(){
    }
    public IOErrorInFile(String message){
        super(message);
    }
}