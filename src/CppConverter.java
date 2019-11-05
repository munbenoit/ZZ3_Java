import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;

public class CppConverter {
	
	private Class c;
	
	public CppConverter(Class c) {
		this.c = c;
	}
	
	public void convert(String filename) {
		Writer writer;
		try {
			writer = new  FileWriter(filename);
			BufferedWriter  br = new  BufferedWriter(writer);
			
			writer.append("#ifndef __"+c.getName()+"__\n#define __"+c.getName()+"__\n\n");
			
			writer.append("class " + c.getName()+": {");
			writer.append(convertFields(c.getDeclaredFields()));
			writer.append("};\n\n");
			writer.append("#endif");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public String convertFields(Field[] fields) {
		return "";
	}
}
