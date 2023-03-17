package de.dhbwka.java.exercise.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFile {
    private List<String> lines = new ArrayList<>();
    File z;
    public TextFile(File f) throws IOErrorInFile {
        z = f;
        try ( BufferedReader br = new BufferedReader(new FileReader(f)) ) {
            while (br.ready()) {
                String line = br.readLine();
                lines.add(line);
            }
        } catch (IOException e) {
            throw new IOErrorInFile();
        }
    }
    public TextFile(String f) throws IOErrorInFile {
        z = new File(f);
        try ( BufferedReader br = new BufferedReader(new FileReader(f)) ) {
            while (br.ready()) {
                String line = br.readLine();
                lines.add(line);
            }
        } catch (IOException e) {
            throw new IOErrorInFile();
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
        return (String[]) lines.toArray();
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

    public void close() {
        this.write();
        z = null;
        lines = null;
    }
}
