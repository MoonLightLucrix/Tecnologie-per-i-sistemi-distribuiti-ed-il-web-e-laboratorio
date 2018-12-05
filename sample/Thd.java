package sample;
import java.io.*;
import java.util.*;
import sample.*;

public class Thd extends Thread
{
    private Random rand;
    private Sample sample;
    private int thread;
    public Thd(Sample sample,int thread)
    {
        this.sample=sample;
        this.thread=thread;
        rand=new Random();
        this.start();
    }
    public void run()
    {
        while(sample.isSame(thread,rand.nextInt(90)+10)){}
        System.out.println(thread + " ho terminato");
    }
}
