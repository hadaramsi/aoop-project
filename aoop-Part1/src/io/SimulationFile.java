package io;
import java.io.*;
import country.*;
import population.*;
import location.*;
import java.util.Random;

public class SimulationFile {
	
	
	public void createMap() {
		//Scanner sc =new Scanner(System.in);
		FileReader fr; 
		try {
			String line;
			fr = new FileReader("SimulationFile.text");
			BufferedReader bufferedReader = new BufferedReader(fr);
			while((line = bufferedReader.readLine()) != null) {
				String[] data = line.split(";");
				
				String name = data[1];
				Point cord  = new Point(Integer.parseInt(data[2]), Integer.parseInt(data[3]));
				Size sz = new Size(Integer.parseInt(data[4]), Integer.parseInt(data[5]));
				Location loc = new Location(cord, sz);
				int numPeople = Integer.parseInt(data[6]);
				switch(data[0])
				{
				case "City":
					City c= new City(name, loc, RamzorColor.GREEN, )
					
				case "Kibbutz":
					Kibbutz s= new Kibbutz(data[1],Location(Point((int)data[2],(int)data[3])),Size((int)data[4],(int)data[5])),rc,(long)data[6]);
					
				case "Moshav":
					Moshav s= new Moshav(data[1],Location(Point((int)data[2],(int)data[3])),Size((int)data[4],(int)data[5])),rc,(long)data[6]);
					
				 default:
					 System.out.println("settelment is undefined");
					 break;
				}
				
			
			}
			fr.close();
		}
		catch(IOException e1){
		
		}
	}
	
	
	public int intizializePersonAge()
	{
		int y;
		double x;
		Random rand = new Random();
		y = rand.nextInt(5);  
		Random r = new Random();
		x = r.nextGaussian()*deviation+mean;
		return (int)((5 * x) + y);
	}

	
	public void createPeopleArrey(Settlement s, int numOfPersons) {
		Healthy p;
		for(int i=0; i< numOfPersons; ++i) {
			p=new Healthy(intizializePersonAge(), s.randomLocation(), s );
			s.addPerson(p);
		}
	}
	
	// data members
	public static double deviation = 6;
	public static double mean = 9;
}
