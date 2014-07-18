import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException {
		
		for(int i = 1; i <= 400; i++) {
			File f = new File("fantasmas_do_medo/stage"+i+".html");
			
			if(!f.exists()) {
				f.createNewFile();
				BufferedWriter bw = new BufferedWriter(new FileWriter(f));
				
				bw.write("" +
						"<html>\n\n<head>\n" +
						"\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
						"\n"+
						"</head>\n" +
						"\n<body>\n" +
						"\n<h1>STAGE NUMBER</h1>\n" +
						"\n<p></p>\n" +
						"\n<a href=\"stage_.html\" ></a>\n" +
						"\n</body>\n" +
						"\n</html>");
				
				bw.flush();
				bw.close();
			}
			
		}
		
	}
}
