package Service;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class File_handling {

	public void Create_file(String File_name) {

		try {

			File File_obj = new File(File_name);
			if (File_obj.createNewFile()) {
				System.out.println("File Created successfully at location " + File_obj.getAbsolutePath());
			} else

			{
				System.out.println("File already exsits at location " + File_obj.getAbsolutePath());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void Write_to_file(String File_name) {
		try {
			File file = new File(File_name);

			if (file.exists()) {
				try {
					FileWriter writer = new FileWriter(File_name);
					Scanner sc = new Scanner(System.in);
					System.out.println("Enter the text you want save into notes");
					String notes = sc.nextLine();
					writer.append(notes);
					writer.close();
					System.out.println("Notes added Successfully !!!!!!");
				} catch (IOException e) {

					System.out.println("Error writing to file");
					e.printStackTrace();
				}
			} else {
				System.out.println("File Does not exsits");
			}
		} catch (Exception q) {
			System.out.println("Some error writing into file");
			q.printStackTrace();
		}
	}

	public void Read_from_file(String File_name) {
		try {
			File file = new File(File_name);
			if (file.exists() && file.canRead()) {
				try {
					FileReader fr = new FileReader(File_name);
					int r ;
					while((r=fr.read())!=-1)
					{
						System.out.print((char)r);
					}
                       fr.close();
				} catch (Exception e) {
                  System.out.println("error");
                  e.printStackTrace();
				}
			}
		} catch (Exception e) {
              System.out.println("Some unexpected  error occured");
              e.printStackTrace();
		}
	}
}
