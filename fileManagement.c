#include <stdio.h>

char* getString();

int main() {

	FILE* fp = fopen("test.txt", "r"); // to create a stream

	if (fp == NULL) {
		printf("Unable to create the file...\n");
		return 0;
	}
	else {
		printf("File was opened successfully...\n");
	}

	char* s;

	// write the string to the file char by char. (putc)
	s= getString(); 						    
	while (*s)								   
		putc(*(s++), fp);					    
	
	// write whole string to the file at a time. (fputs)
	s = getString();  
	fputs(s, fp);

	putc('\n', fp); // carriage return and line feeds.

	// write the data with format specifications to the file. (fprintf)
	char* name = "Thomas";
	int age = 23;
	fprintf(fp,"%s %d", name, age);
	
	// we use write and read functions when our priority is speed!
	size_t fwrite(&x, sizeof(x), y, FILE* stream);
	int fread(&x, sizeof(x), y, FILE* stream);

	// get the data from the file with format specifications. (fscanf)
	char test[10];
	int num;
	fscanf(fp,"%s %d", test, &num);
	printf("%s %d\n", test, num);


	// feof() only returns true when we reach the end character of the file! (feof)
	while (!feof(fp))
		printf("%c", fgetc(fp));

	// fgets() 
	char data[5];
	fgets(data, 5, fp);

	// rename a file
	if (rename("test.txt", "new.txt"))
		puts("An error occurred while renaming the file!");

	// delete a file
	if (remove("example.txt"))
		puts("An error occurred while deleting the file!");

	// to check the reading and writing errors. Error flag sets true when an error occurred.
		///int ferror(FILE* fp);
		///void clearerr(FILE* fp);	

	// rewind function and more.
	// to reset file position indicator. 
	// fopen function returns an address of a structure of type file, 
	// this structure contains all the details about a file, for example, 
	// it contains the name of the file, the size of the file, the location of the file, 
	// and also the file position indicator etc. File position indicator tells us where exactly 
	// we are in the file so when we open a file in read or write mode using the F open function 
	// the file position indicator will be at the beginning so if we are opening 
	// the file in a appending mode which is a or a plus then now you know the file position indicator will be at the end of the file.
		///rewind(FILE* fp);

	// FILE* tmpfile();
	// creates a temporary binary file and opens it in w+b mode.
	// The advantage of the using of tmpfile().
	// If you want to process a lot of data in your program where the variables are not convinent option.
	// You should use it.Tempfile is deleted when the terminal is ended.

	// char* tmpnam(char* name);
	// to change temp file name.



	printf("Data has written successfully...");
	fclose(fp);


	scanf("\n");
	return 0;
}

char* getString() {
	char bufferString[100];

	printf("Write a text you want to see in test.txt!\n");
	scanf("%s", bufferString);

	char* s = (char*)malloc((strlen(bufferString) + 1) * sizeof(char));
	strcpy(s, bufferString);
	
	return s;
}
