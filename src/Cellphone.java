import java.util.Scanner;
//Huzaifah Mirza 40136913
//COMP249 
//Assignment #4 part #1
//April 15, 2022

/**
* @author Huzaifah Mirza
*
*/
public class Cellphone {
	private long serialNum;
	private String brand;
	private int year;
	private double price;

	/**parameterized constructor
	 * @param serialNum
	 * @param brand
	 * @param year
	 * @param price
	 */
	public Cellphone(long serialNum, String brand, int year, double price) {

		this.serialNum = serialNum;
		this.brand = brand;
		this.year = year;
		this.price = price;
	}

	/**copy constructor
	 * @param cell
	 * @param serial
	 */
	public Cellphone(Cellphone cell, long serial) {
		this.serialNum = serial;
		this.brand = cell.brand;
		this.year = cell.year;
		this.price = cell.price;
	}

	/**
	 *clone method
	 *	 
	 **/
	public Cellphone clone() {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a serial number:");
		long serial = in.nextLong();
		in.close();
		return new Cellphone(this, serial);
	}

	/**gets serial parameter
	 * @return
	 */
	public long getSerialNum() {
		return serialNum;
	}

	/**sets serial parameter
	 * @param serialNum
	 */
	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}

	/**gets brand parameter
	 * @return
	 */
	public String getBrand() {
		return brand;
	}

	/**sets brand parameter
	 * @param brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**gets year parameter
	 * @return
	 */
	public int getYear() {
		return year;
	}

	/**sets year parameter
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**gets price parameter
	 * @return
	 */
	public double getPrice() {
		return price;
	}

	/**sets price parameter
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**tostring method
	 *
	 */
	@Override
	public String toString() {
		return "[" + serialNum + ": " + brand + " $" + price +  " " + year + "] ---> ";
	}

	/**equals method
	 *
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Cellphone obj2 = (Cellphone) obj;
		return obj2.brand.equals(this.brand) && obj2.year == this.year && obj2.price == this.price;

	}

}
