package src.clr; // Initializing package
import java.io.*; // Importing package

// function to clear the screen
public class Cls
{
    public void screen() throws IOException, InterruptedException      
    {
        new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
    }
}
