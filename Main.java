import java.io.*;

public class Main {
		public static void main(String[] args) throws Exception {
				File file = new File("test.txt");
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = "";
				int lineCounter = 0;
				while ((line = br.readLine()) != null) {
						System.out.printf("%d: %s\n", lineCounter++, line);
				}
		}
}
