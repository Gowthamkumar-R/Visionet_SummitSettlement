package datadriven;

public class TestAcademy {

	public static void main(String[] args) {
		char c ='\u263A';
		float f = -1f;
		double g = 0.987656789;
		char c1= '\t';
		int octal = 0101; 
		int hexadecimal = 0xface;
		int a = 90;
		int b = 10;
		System.out.println((a+b) + (b-a) +(a/b) + (a%b));
		System.out.println(b-a);
		System.out.println(b/a);
		System.out.println(a%b);
		System.out.println(octal);
		System.out.println(hexadecimal);
	    System.out.println("\"qwerty\"");
		System.out.println(c1 + "qwertyui");
		System.out.println(g);
		System.out.println(f);
		System.out.println(c);
	}
}
