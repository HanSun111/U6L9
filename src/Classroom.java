public class Classroom
{
    private Student[] classRoster;

    public Classroom(int numStudents)
    {
        classRoster = new Student[numStudents];
    }

    // getter method: returns a reference to classRoster array
    public Student[] getClassRoster()
    {
        return classRoster;
    }

    /** Adds student to the next available index in classRoster array
     (when iterating left to right) and return true to indicate
     student was successfully added.
     If the array is already maxed out (i.e. the class roster is full),
     do not add the Student and return false.
     */
    public boolean addStudent(Student student)
    {
        for(int i = 0; i < classRoster.length; i++){
            if(classRoster[i] == null){
                classRoster[i] = student;
                return true;
            }
        }
        return false;
    }

    /** Returns the class exam average determined by adding
     adding up all exams taken by all students and dividing
     by total number of exam scores
     */
    public double classExamAverage()
    {
        int average = 0;
        int totalTest = 0;
        for(Student s : classRoster){
            if(s != null){
                int[] numOfExams = s.getExamScores();
                totalTest += numOfExams.length;
                for(int j : numOfExams){
                    average += j;
                }
            }
        }
        if(totalTest == 0){
            return 0.0;
        }
        return (double) average / totalTest;
    }

    /** Prints class roster by printing all non-null students
     in the order they appear in classRoster, one per line,
     in the format; last name, first name;
     any null values in classRoster are not printed
     */
    public void printRoster()
    {
        for(Student s : classRoster){
            if(s != null){
                System.out.println(s.getLast() + ", " + s.getFirst());
            }
        }
    }
}
