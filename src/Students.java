import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Students {
    private static ArrayList<Student> studentObjs = new ArrayList<Student>();

    public ArrayList<String> loadStudents(){
        try{
            ArrayList<String> s = new ArrayList<String>();
            File myObj = new File("students.txt");
            Scanner myReader = new Scanner(myObj);
            studentObjs = new ArrayList<Student>();
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                s.add(data);
                this.studentObjs.add(new Student(data));
            }
            myReader.close();
            return s;
        } catch (FileNotFoundException e){
            return  new ArrayList<String>();
        }
    }

    private ArrayList<String> getnames() {
        ArrayList<String> s = new ArrayList<String>();
        if (this.studentObjs.size()>0) {
            for (Student student : this.studentObjs) {
                s.add(student.getFirstName() + " " + student.getLastName());
            }
        }
        return s;

    }


    public ArrayList<String> getnames(ArrayList<Student> students) {
        ArrayList<String> s = new ArrayList<String>();
        if (students.size()>0) {
            for (Student student : students) {
                s.add(student.getFirstName() + " " + student.getLastName());
            }
        }
        return s;

    }

    public void saveStudents(){
        try{
            ArrayList<String> tempStudents = this.getnames();
            FileWriter myWriter = new FileWriter("students.txt");
            for (String s : tempStudents){
                myWriter.write(s);
                myWriter.close();
            }
        } catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public ArrayList<Student> getPresent(){
        ArrayList<Student> present = new ArrayList<Student>();
        for(Student s : this.studentObjs){
            if(s.isPresent){
                present.add(s);
            }
        }
        return present;
    }

    public ArrayList<Student> getAbsent(){
        ArrayList<Student> absent = new ArrayList<Student>();
        for(Student s : this.studentObjs){
            if(s.isPresent){

            } else {
                absent.add(s);
            }
        }
        return absent;
    }
}
