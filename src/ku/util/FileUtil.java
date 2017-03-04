package ku.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * FileUtil is for copy InputStream to OutputStream.
 * 
 * @author Napong Dungduangsasitorn
 *
 */
public class FileUtil {

	/**
	 * copy InputStream to OutputStream byte by byte.
	 * @param in is file that want to copy.
	 * @param out is file that finish copy.
	 */
	static void copy(InputStream in, OutputStream out) {
		copy(in, out, 1);
	}

	/**
	 * copy InputStream to OutputStream by array byte which blocksize.
	 * @param in is file that want to copy.
	 * @param out is file that finish copy.
	 * @param blocksize is size of array;
	 */
	static void copy(InputStream in, OutputStream out, int blocksize) {
		try {
			byte[] buffer = new byte[blocksize];
			int count;
			while ((count = in.read(buffer)) > -1) {
				out.write(buffer, 0, count);
			}
			in.close();
			out.close();
		} catch (RuntimeException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * copy InputStream to OutputStream by BufferedReader and PrintWriter.
	 * @param in is file that want to copy.
	 * @param out is file that finish copy.
	 */
	static void bcopy(InputStream in, OutputStream out) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			String string;
			while ((string = br.readLine()) != null) {
				pw.write(string + "\n");
			}
			br.close();
			pw.close();
		} catch (RuntimeException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}