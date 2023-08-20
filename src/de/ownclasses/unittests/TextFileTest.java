package de.ownclasses.unittests;

import org.junit.Test;

import de.ownclasses.TextFile;

public class TextFileTest {
    
    @Test
    public void TextFileTester() {
        TextFile filee = new TextFile("test.txt");
        filee.addLine("texst");
        filee.write();
        filee.addLine("tesxtzeile2");
        try {
            filee.removeLine(1);
        } catch (Exception a) {
            System.out.println("RemoveLine error");
        }
        filee.clear();
        filee.deleteFile();
        filee.close();
    }
}
