package de.ownclasses.exceptions;

public class IOErrorInFile extends Exception {
    public IOErrorInFile(){
    }
    public IOErrorInFile(String message){
        super(message);
    }
}
