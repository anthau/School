
package school;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;



/**
 *
 * The result is printed  to absent.csv(contains all of away data), 
 * which is located in the root directory
 * after program is stopped  
 */
public class County {

    ArrayList<LocalSchool> schools = new ArrayList<>();

    public County() throws IOException {
        
        //destroys if file exists 
        File file = new File(Details.filename);
        /*
        *This check if the file allready exist
        *if exists, then delete it
        */
        if (file.exists()) {
            file.delete();
        }
        //Prints the header file of csv.
        try (FileWriter myWriter = new FileWriter(Details.filename)) {
            myWriter.append("Student;CLASS;School;Date;Reason\n");
        }
        
        LocalSchool school = new LocalSchool();
        school.setSchoolname("School 1");
        schools.add(school);
        LocalSchool school1 = new LocalSchool();
        school1.setSchoolname("School 2");
        schools.add(school1);

        //Sets the semester start and end time
        LocalDate SchoolStart = Details.startDay;
        LocalDate SchoolEnd = LocalDate.of(2018, Month.MAY, 31);

        while (SchoolStart.isBefore(SchoolEnd) || SchoolStart.equals(SchoolEnd)) {

            for (LocalSchool _school : schools) {
                String dayOfWeekSchool = SchoolStart.getDayOfWeek().toString();
                _school.SimulateOneDay(SchoolStart, dayOfWeekSchool);

            }

            SchoolStart = SchoolStart.plusDays(1);

        }

        schools.stream().forEach((_item) -> {
            _item.printAbsent(_item.getSchoolname());

        });

    }
}
