package population;
import country.Settlement;
import location.Point;
import virus.IVirus;
import simulation.Clock;

/**
 * @author Hadar Amsalem
 * ID: 316129212 
 * @author Chen Ben Tolila
 * ID: 207278029
 */

public class Sick extends Person{
	
	/**
	 * ctor
	 * @param age - age of sick person
	 * @param location - location of sick person
	 * @param settlement - settlement of sick person
	 * @param contagiousTime - contagious time of sick person
	 * @param virus - type of virus of sick person
	 */
	public Sick(int age, Point location, Settlement settlement, long contagiousTime, IVirus virus) {
		super(age, location, settlement);
		m_contagiousTime=contagiousTime;   // second option get from current time in clock
		m_virus=virus;
	}
	
	/**
	 * return the type of the virus
	 */
	public IVirus getVirus() {
		return m_virus;
	}
	
	/**
	 * copy constructor
	 * @param s get copy object of sick
	 */
	public Sick(Sick s) {
		super(s.getAge(),s.getLocation(), s.getSettlement());
		m_contagiousTime=s.m_contagiousTime;
		m_virus=s.m_virus;
	}
	
	/**
	 * return the contagion probability of sick person
	 */
	public double contagionProbability() {
		return 1;
	}
	
	/**
	 * return true if the person in not infected in the virus
	 */
	public boolean checkIfHealthy(){
		return false;
	}
	
	/**
	 * 
	 * @return sickness duration of sick person
	 */
	public long getSicknessDuration(){
		return Clock.now() - m_contagiousTime;
	}
	
	/**
	 * 
	 * @return calculate and returns whether the person will die from the disease
	 */
	public boolean tryToDie() {
		if( m_virus.tryToKill(this)) {
			this.getSettlement().removePersonFromArr(this);
			return true;
		}
		return false;
	}
	
	/**
	 * make sick to healthy
	 * @return return healthy person
	 */
	public Person recover() {
		Convalescent con = new Convalescent(this.getAge(), this.getLocation(), this.getSettlement(),m_virus);
		this.getSettlement().addPerson(con);
		this.getSettlement().removePersonFromArr(this);
		return con;
	}
	
	 /**
	  * return the sick person in string form
	  */
	public String toString(){
		return "sick: " + super.toString() + " contagiousTime: "+ m_contagiousTime + " virus: "+ m_virus;
	}
	
	/**
	 * throws exception 
	 */
	public Person contagion(IVirus IV) {
		throw new RuntimeException();
	}
	
	 // data members
	private long m_contagiousTime; // The moment of infection
	private IVirus m_virus; // kind of virus
}
