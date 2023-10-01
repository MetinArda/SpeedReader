import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class paragraphGetter {
    String data = "";
    String dataEdited[];

    public paragraphGetter(){

        try {
            File myObj = new File("paragraph.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                this.data += " "+myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void editdata(){
        //data.replace(".",". ");
        //data.replace(",",", ");
        dataEdited = data.split(" ");
    }

    public String[] getData(){
        editdata();
        return dataEdited;
    }


    
}
