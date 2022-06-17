package src.clr;
import java.io.*;

public class Cls
{
    public void screen() throws IOException, InterruptedException        //function to clear the screen
    {
        new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
    }
}
