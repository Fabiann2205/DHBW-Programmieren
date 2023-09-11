package de.ownclasses;

import de.ownclasses.exceptions.IOErrorInFile;
import de.ownclasses.exceptions.LineNumberOutOfBoundsException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFile {
    private List<String> lines = new ArrayList<>();
    File z;
    public TextFile(File f) {
        z = f;
        try {
            z.createNewFile();
            System.out.println("created" + z.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Error creating file");
        }
        try ( BufferedReader br = new BufferedReader(new FileReader(f)) ) {
            while (br.ready()) {
                String line = br.readLine();
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
    public TextFile(String f) {
        z = new File(f);
        try {
            z.createNewFile();
        } 
        catch (Exception e) {
             System.err.println("Error creating File");
        }
        try ( BufferedReader br = new BufferedReader(new FileReader(f)) ) {
            while (br.ready()) {
                String line = br.readLine();
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Cannot read file!");
        }
    }

    public void read() throws IOErrorInFile {
        lines = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader(new FileReader(z)) ) {
            while (br.ready()) {
                String line = br.readLine();
                lines.add(line);
            }
        } catch (IOException e) {
            throw new IOErrorInFile();
        }
    }

    public void write() {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(z))){
            for(int i = 0; i < lines.size(); i++) {
                out.write(lines.get(i) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int availableLines() {
        return lines.size();
    }

    public String[] getLines() {
        return lines.toArray(new String[0]);
    }

    public String getLine(int i) throws LineNumberOutOfBoundsException {
        if (i<1 || i>lines.size()) {
            throw new LineNumberOutOfBoundsException();
        }
        return lines.get(i-1);
    }

    public void setLine(int i, String s) throws LineNumberOutOfBoundsException {
        if (i<1 || i>lines.size()) {
            throw new LineNumberOutOfBoundsException();
        }
        lines.set((i-1), s);
    }

    public void replaceAll(String regexp, String ersatz) {
        Pattern p = Pattern.compile(regexp);
        for (int loopIndex2 = 0; loopIndex2 < lines.size(); loopIndex2++) {
            Matcher matcher = p.matcher(lines.get(loopIndex2));
            lines.set(loopIndex2, matcher.replaceAll(ersatz));
        }
    }

    public void addLine(String text) {
        this.lines.add(text);
    }

    public void removeLine(int index) throws LineNumberOutOfBoundsException {
        if (index<1 || index>lines.size()) {
            throw new LineNumberOutOfBoundsException();
        }
        this.lines.remove(index-1);
    }

    public void clear() {
        this.lines.clear();
    }

    public void deleteFile() {
        this.z.delete();
        this.close();
    }
    
    public Boolean isInFile(String was) {
        Boolean gefunden = false;
        for(int i=1; i<=this.availableLines(); i++) {
            try {
                if(this.getLine(i).equals(was)) {
                    gefunden = true;
                    break;
                }
            } catch (LineNumberOutOfBoundsException e) {
                return false;
            }
        }
        if (gefunden) {
            return true;
        } else {
            return false;
        }
    }

    public void close() {
        // if because of delete method
        if (z != null ) {
            if (z.exists()) {
                this.write();
            } 
        }
        z = null;
        lines = null;
    }
}
