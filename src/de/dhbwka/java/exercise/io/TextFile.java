package de.dhbwka.java.exercise.io;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class TextFile {
    private ArrayList<String> lines = new ArrayList<>();
    File z;

    public TextFile(File f) throws IOErrorInFile {
        z = f;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
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
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
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
        try (BufferedReader br = new BufferedReader(new FileReader(z))) {
            while (br.ready()) {
                String line = br.readLine();
                lines.add(line);
            }
        } catch (IOException e) {
            throw new IOErrorInFile();
        }
    }

    public void write() {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(z))) {
            for (String line : lines) {
                out.write(line + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error" + e);
        }
    }

    public int availableLines() {
        return lines.size();
    }

    public ArrayList<String> getLines() {
        return lines;
    }

    public String getLine(int i) throws LineNumberOutOfBoundsException {
        if (i < 1 || i > lines.size()) {
            throw new LineNumberOutOfBoundsException();
        }
        return lines.get(i - 1);
    }

    public void setLine(int i, String s) throws LineNumberOutOfBoundsException {
        if (i < 1 || i > lines.size()) {
            throw new LineNumberOutOfBoundsException();
        }
        lines.set((i - 1), s);
    }

    public void replaceAll(String regexp, String ersatz) {
        Pattern p = Pattern.compile(regexp);
        lines.replaceAll(input -> p.matcher(input).replaceAll(ersatz));
    }

    public Boolean isInFile(String was) {
        boolean gefunden = false;
        for (int i = 1; i <= this.availableLines(); i++) {
            try {
                if (this.getLine(i).equals(was)) {
                    gefunden = true;
                    break;
                }
            } catch (LineNumberOutOfBoundsException e) {
                return false;
            }
        }
        return gefunden;
    }

    public void close() {
        this.write();
        z = null;
        lines = null;
    }
}
