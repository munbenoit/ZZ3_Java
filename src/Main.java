
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {
		System.out.println(args[0]);
		try {
			Class c = Class.forName(args [0]);
			CppConverter cppConverter = new CppConverter(c);

			
			Field  []  fields = c.getDeclaredFields ();
			for (int i=0;i<fields.length;i++){
				System.out.println( fields[i] );
			}
			
			cppConverter.convert(args[0]+".hpp");
			
		}
		
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

}
