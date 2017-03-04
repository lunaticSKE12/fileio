# fileio

Tasks by Napong Dungduangsasitorn (5710546216)

Task                                    | Time 
----------------------------------------|-------:
Copy the file one byte at a time.           |  4.106075 sec 
Copy the file using a byte array of size 1KB         |  0.067005 sec 
Copy the file using a byte array of size 4KB    |  0.071876 sec 
Copy the file using a byte array of size 64KB        | 0.061769 sec 
Copy the file using BufferedReader and PrintWriter to copy lines of text  | 0.126750 sec 

From table if use more size of byte array to copy file it will faster than use less size of byte but BufferedReader read a buffer of bytes from the file (1024 bytes for instance). It will look for a line separator ("\n") in the buffer. If not found, the bytes will be appended in a  StringBuilder object and the next buffer will be fetched.
