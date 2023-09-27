package demo.credentials;

import demo.utils.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Credentials {

    public static String readPass(){

        try{
            return Files.readString(Path.of(Constants.PATH_TO_PASS));
        }catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
