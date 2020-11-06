import java.util.ArrayList;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Collections;

public class Writer {
	private ArrayList<Product> productList;
	private ArrayList<Log> logList;
	private String file;
	
	// CONSTRUCTORS
	public Writer(ArrayList<Product> productList) {	
		this.productList = productList;
	}
	
	public Writer (ArrayList<Log> logList, String file) {
		this.logList = logList;
		this.file = file;
	}
	

	// WRITES TO Stock.txt
	public void addStock() {
		// Filter to sort by quantity
		Filter filter = new Filter();
		Collections.sort(productList,filter);
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("Stock.txt"));
			int max = productList.size();
			for(int i = 0; i < max; i++) {
				bw.write(productList.get(i).toString() + "\n");
			}	
		} catch(IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				if(bw != null) {
					bw.close();
				}
			} catch(IOException e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	// WRITES NEW LOG IN ActivityLog.txt
	public void addLog() {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file));
			int max = logList.size();
			for(Log log : logList) {
				bw.write(log.toString() + "\n");
			}
		} catch(IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				if(bw != null) {
					bw.close();
				}
			} catch(IOException e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}
}
