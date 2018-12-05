package sample;
import java.io.*;
import java.util.*;
import sample.*;

public class Sample
{
	private int sample;
	public Sample()
	{
		sample=50;
	}
	public synchronized void setSample(int sample)
	{
		this.sample=sample;
	}
	public synchronized int getSample()
	{
		return sample;
	}
    public synchronized boolean isSame(int thread, int value)
    {
        if(value==sample)
        {
            return false;
        }
        System.out.println("Sono il thread " + thread + ": sample valeva " + sample + " adesso vale " + value);
        sample=value;
        return true;
    }
}
