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
	static void copy(InputStream in, OutputStream out){
		try{
			int count = in.read();
			while(count >= 0){
				out.write(count);
			}
		} 
		catch (IOException e){
			throw new RuntimeException();
		} 
		finally{
			try{
				in.close();
				out.close();
			} 
			catch (IOException e){

			}
		}
	}

	/**
	 * copy InputStream to OutputStream by array byte which blocksize.
	 * @param in is file that want to copy.
	 * @param out is file that finish copy.
	 * @param blocksize is size of array;
	 */
	static void copy(InputStream in, OutputStream out, int blocksize){
		byte[] buffer = new byte[blocksize];
		try{
			int count = in.read(buffer);
			while(count >= 0){
				out.write(buffer);
			}
		}
		catch (IOException e){
			throw new RuntimeException();
		}
		finally{
			try{
				in.close();
				out.close();
			}
			catch (IOException e){
				e.printStackTrace();
			}
		}
	}

	/**
	 * copy InputStream to OutputStream by BufferedReader and PrintWriter.
	 * @param in is file that want to copy.
	 * @param out is file that finish copy.
	 */
	static void bcopy(InputStream in, OutputStream out){
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
		try {
			String string = br.readLine();
			while(string != null){
				pw.println(string);
			}
		} 
		catch (IOException e) {
			throw new RuntimeException(e);
		}
		finally{
			try{
				br.close();
				pw.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
}
