import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class sortGUI implements ActionListener,ItemListener{
	private JFrame frame;
	private JComboBox drag;
	private JButton button;
	boolean flag;
	private static int noElements=1000000;
	String choice="Integer";
   sortGUI()
   {
	   flag=false;
	   frame = new JFrame("Sorter");
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   String[] inputOptions= {"Integer","Float","Double"};
	   drag = new JComboBox(inputOptions);
	   button = new JButton("Sort");
	   
//	   button.setEnabled(false);
	   
	   frame.add(button);
	   frame.add(drag);
	   
	   drag.addItemListener(this);
	  
	   if(flag)
	   {
		   button.setEnabled(true);
	   }
	   button.addActionListener(this);
	   
	   button.setBounds(120,100,80,50);
	   drag.setBounds(100,40,100,50);
	   frame.setBounds(250,300,500,500);
	   frame.setLayout(null);
	   frame.setVisible(true);
	  
	   choice = new String();
   }
	
	public static void main(String[] args) {
		sortGUI g= new sortGUI();
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		 if(e.getSource() == drag) {
		     choice=(String) drag.getSelectedItem();
		 
		 }
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			switch(choice)
			{
			case "Integer":
				long t1 = System.currentTimeMillis();
						   sortInt();
						   long t2 = System.currentTimeMillis();
						   long time= t2-t1;
						   System.out.println("Time taken to sort "+ time+"milliseconds");
						   break;
			case "Float": t1 = System.currentTimeMillis();
						   sortFloat();
						    t2 = System.currentTimeMillis();
						   time= t2-t1;
						   System.out.println("Time taken to sort "+time+"milliseconds");
						   break;
			case "Double": t1 = System.currentTimeMillis();
			   sortDouble();
			    t2 = System.currentTimeMillis();
			   time= t2-t1;
			   System.out.println("Time taken to sort "+time+"milliseconds");
			   break;
			}
		}
		
	}
	void sortInt()
	{
		int[] arr = new int[noElements];
		Random random = new Random();
		
		for(int i=0;i<noElements;i++)
		{
			arr[i]=random.nextInt();
		}
		for(int i=0;i<noElements;i++)
		{
			for(int j=0;j<noElements-i-1;j++)
			{
				if(arr[j]<arr[j+1])
					swap(arr,j,j+1);
				
			}
		}
	}
	void sortFloat()
	{
		float[] arr = new float[noElements];
		Random random = new Random();
		
		for(int i=0;i<noElements;i++)
		{
			arr[i]=random.nextFloat();
		}
		for(int i=0;i<noElements;i++)
		{
			for(int j=0;j<noElements-i-1;j++)
			{
				if(arr[j]<arr[j+1])
					swap(arr,j,j+1);
				
			}
		}
	}
	void sortDouble()
	{
		double[] arr = new double[noElements];
		Random random = new Random();
		
		for(int i=0;i<noElements;i++)
		{
			arr[i]=random.nextFloat();
		}
		for(int i=0;i<noElements;i++)
		{
			for(int j=0;j<noElements-i-1;j++)
			{
				if(arr[j]<arr[j+1])
					swap(arr,j,j+1);
				
			}
		}
	}
	void swap(int[] arr,int index1,int index2)
	{
		int temp =arr[index1];
		arr[index1]=arr[index2];
		arr[index2]=temp;
	}
	void swap(float[] arr,int index1,int index2)
	{
		float temp =arr[index1];
		arr[index1]=arr[index2];
		arr[index2]=temp;
	}
	void swap(double[] arr,int index1,int index2)
	{
		double temp =arr[index1];
		arr[index1]=arr[index2];
		arr[index2]=temp;
	}
}
