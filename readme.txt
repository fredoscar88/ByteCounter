Byte Counter
Place the byte counter compiled jar in a directory, with the ByteCountRun.bat file.
Double click ByteCountRun.bat.


What this does
Byte Counter will calculate the total amount of memory used inside of the input directory,
by using a recusive loop to find the bytes stored in every file and the files in subdirectories.


Usage
Upon reaching the command line byte counter will ask if you want to use the parent directory
(the directory that the jar is in itself) in calculating. It will also ask you if you want to
have the directory tree displayed during run time- it looks cooler but takes a lot longer
especially for directories that have a lot of subdirectories and files.

If you chose not to use parent it will ask you to input the name of a directory in the same
location as the jar. There is no exception catching here so if you don't feed it the correct
directory expect the program to terminate.


Results
At the end of calculating ByteCounter will display the total bytes, kilobytes (1024 bytes),
megabytes (1024 kilobytes), and gigabytes (1024), along with the elapsed time, in seconds. 
There's a good chance you probably won't be using this to find out how many terabytes are 
stored inside of a directory so I made the prudent decision not to include that figure.


In use
ByteCounter was able to tell me, in less than three minutes (without displaying the file
hierarchy, or tree) that my steam library had around 300 gigabytes stored.