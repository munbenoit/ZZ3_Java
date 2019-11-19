import java.util.ArrayList;
import java.util.Date;

public class EtudiantRunnable implements Runnable{


	int to;
	ArrayList<Etudiant> arr;
	public EtudiantRunnable(int t, ArrayList<Etudiant> a) {

		to = t;
		arr = a;
	}
	
	@Override
	public void run() {
		for(int i = 0;i<to;i++) {
			Etudiant.addToList(arr);
		}
	}

}
