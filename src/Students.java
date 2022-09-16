import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Students {
    static ArrayList<Student> students;

    public Students(){
        this.loadStudents();
    }

    static ArrayList<String> getWholeNameFromStudents(ArrayList<Student> students){
        ArrayList<String> names = new ArrayList<String>();
        for(Student s : students){
            names.add(s.getFirstName() + " " + s.getLastName());
        }
        return names;
    }

    public ArrayList<String> getWholeNameFromStudents(){
        return getWholeNameFromStudents(this.students);
    }

    public ArrayList<Student> getPresentStudents(){
        ArrayList<Student> present = new ArrayList<Student>();
        for(Student s : this.students){
            if(s.isPresent){
                present.add(s);
            }
        }
        return present;
    }

    public void markAllPresent(){
        for(Student s : this.students){
            s.isPresent = true;
        }
    }

    public void markALlAbsent(){
        for(Student s: this.students){
            s.isPresent = false;
        }
    }


    public void markALlNotCalled(){
        for(Student s: this.students){
            s.called = false;
        }
    }

    public void markCalledByFullName(String name){
        for(Student s: this.students){
            if((s.getFirstName() + " " + s.getLastName()).equals(name)) {
                s.called = true;
            }
        }

    }


    public void markAbsent(String name){
        for(Student s: this.students){
            if((s.getFirstName() + " " + s.getLastName()).equals(name)){
                s.isPresent = false;
            }
        }
    }


    public void markPresent(String name){
        for(Student s: this.students){
            if((s.getFirstName() + " " + s.getLastName()).equals(name)){
                s.isPresent = true;
            }
        }
    }

    @Override
    public String toString(){
        String text="";
        for(Student s : this.students){
            text += "\n" + s.getWholeName() + ":  isPresent = " + s.isPresent;
        }
        return text;
    }

    public ArrayList<Student> getAbsentStudents(){
        ArrayList<Student> absent = new ArrayList<Student>();
        for(Student s : this.students){
            if(!s.isPresent){
                absent.add(s);
            }
        }
        return absent;
    }

    private void loadStudents(){
        this.students = new ArrayList<Student>();
        try {
            File myObj = new File("students.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                students.add(new Student(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
