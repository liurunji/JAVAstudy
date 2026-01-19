package file;

import javafx.scene.input.DataFormat;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Demo1 {
    public static void main(String[] args) {
        File f1 = new File("src\\file\\a.txt");
        System.out.println(f1.exists());
        System.out.println(f1.getName());
        System.out.println(f1.getAbsolutePath());
        System.out.println(f1.lastModified());

        long time = f1.lastModified();
        Date d = new Date(time);
        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = slf.format(d);
        System.out.println(date);



        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String result = LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault()).format(dtf);
        System.out.println(result);


    }
}
