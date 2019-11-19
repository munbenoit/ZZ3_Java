import java.util.ArrayList;

public class Main {
	
	
	public static void main(String[] args) throws InterruptedException {
		ArrayList<Etudiant> arr = new ArrayList<Etudiant>();
		/*for(int i=0;i<150000;i++) {
			arr.add(new Etudiant());
		}*/
		Runnable r = new EtudiantRunnable(50000, arr);
		Thread t = new Thread(r);
		Runnable r2 = new EtudiantRunnable(50000, arr);
		Thread t2 = new Thread(r2);
		Runnable r3 = new EtudiantRunnable(50000, arr);
		Thread t3 = new Thread(r3);
		t.start();
		t2.start();
		t3.start();
		t.join();
		t2.join();
		t3.join();
		
		System.out.println("ok "+ arr.get(125000));
	}

}
