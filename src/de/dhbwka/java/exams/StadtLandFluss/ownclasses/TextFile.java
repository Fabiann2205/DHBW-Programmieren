package de.dhbwka.java.exams.StadtLandFluss.ownclasses;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

public class TextFile {
    // file which is edited
    private final File file;

    // constructors, one input file directly, one just the filename; both create file
    // if not exists
    public TextFile(File file) {
        this.file = file;
        try {
            if (this.file.createNewFile()) {
                System.out.println("File " + this.file.getAbsolutePath() + "  was created successfully");
            } else {
                System.out.println("File " + this.file.getAbsolutePath() + " could not be created or already there");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TextFile(String fileName) {
        this.file = new File(fileName);
        try {
            if (this.file.createNewFile()) {
                System.out.println("File " + this.file.getAbsolutePath() + "  was created successfully");
            } else {
                System.out.println("File " + this.file.getAbsolutePath() + " could not be created or already there");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // getter for file
    public File getFile() {
        return file;
    }

    // get count of available lines
    public int availableLines() throws IOException {
        try {
            BufferedReader in = new BufferedReader(new FileReader(this.file));
            int count = 0;
            while (in.readLine() != null) {
                count++;
            }
            return count;
        } catch (Exception ex) {
            throw new IOException();
        }
    }

    // get one specific line as String
    public String getLine(int i) throws IndexOutOfBoundsException, IOException {
        String current;
        try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
            int count = 0;
            while (br.ready()) {
                current = br.readLine();
                if (count == i) {
                    return current;
                }
                count++;
            }
        } catch (IOException e) {
            throw new IOException();
        }
        throw new IndexOutOfBoundsException();
    }

    // overwrite one specific line
    public void setLine(int i, String s) throws IOException, IndexOutOfBoundsException {
        try {
            List<String> liste = this.getAllLines();
            liste.set(i, s);
            this.writeAllLines(liste);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException();
        }
    }

    public List<String> getAllLines() throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
            while (br.ready()) {
                String line = br.readLine();
                lines.add(line);
            }
        } catch (IOException e) {
            throw new IOException();
        }
        return lines;
    }

    public void writeAllLines(List<String> lines) throws IOException {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(this.file))) {
            for (String line : lines) {
                out.write(line + "\n");
            }
        } catch (IOException e) {
            throw new IOException();
        }
    }

    public void replaceAll(String regexp, String ersatz) {
        List<String> lines;
        try {
            lines = this.getAllLines();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Pattern p = Pattern.compile(regexp);
        lines.replaceAll(input -> p.matcher(input).replaceAll(ersatz));
        try {
            this.writeAllLines(lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addLine(String text) {
        List<String> lines;
        try {
            lines = this.getAllLines();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        lines.add(text);
        try {
            this.writeAllLines(lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeLine(int index) throws IndexOutOfBoundsException {
        List<String> lines;
        try {
            lines = this.getAllLines();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            lines.remove(index);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException();
        }
        try {
            this.writeAllLines(lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void clear() {
        PrintWriter pwOb;
        try {
            pwOb = new PrintWriter(new FileWriter(this.file, false), false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        pwOb.flush();
        pwOb.close();
    }

    public void deleteFile() {
        if (this.file.delete()) {
            System.out.println("Deleted successfully");
        } else {
            System.out.println("Something went wrong when deleting " + this.file.getAbsolutePath());
        }
    }

    public Boolean isInFile(String search) throws IOException {
        List<String> lines;
        try {
            lines = this.getAllLines();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        boolean gefunden = false;
        for (int i = 1; i <= lines.size(); i++) {
            try {
                if (this.getLine(i).equals(search)) {
                    gefunden = true;
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                return false;
            }
        }
        return gefunden;
    }

    // Test für File Class
    public static void main(String[] args) {

        TextFile neu = new TextFile("resources/tester.txt");
        List<String> listeZumBefuellen = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            listeZumBefuellen.add(UUID.randomUUID().toString());
        }
        listeZumBefuellen.add("TestSuche");
        try {
            neu.writeAllLines(listeZumBefuellen);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(neu.availableLines());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(neu.getAllLines());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(neu.getLine(1));
        } catch (IndexOutOfBoundsException | IOException e) {
            throw new RuntimeException(e);
        }
        try {
            neu.setLine(10, "HALLO");
        } catch (IOException | IndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }
        neu.replaceAll("HALLO", "TEST");
        try {
            neu.removeLine(10);
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(neu.isInFile("TestSuche"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        neu.clear();
        neu.deleteFile();
    }
}
