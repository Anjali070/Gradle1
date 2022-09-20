package com.ui.w3s.common;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;



public class FilePropertyReader {


private Properties prop;
private final String propertyFilePath= "application.properties";




public FilePropertyReader() {
BufferedReader reader;
try {
reader = new BufferedReader(new FileReader(propertyFilePath));
prop = new Properties();
try {
prop.load(reader);
reader.close();

}
catch (IOException e) {
e.printStackTrace();
}
}
catch(FileNotFoundException e){



e.printStackTrace();
throw new RuntimeException("configaration failed" + propertyFilePath);
}
}





public String getMail() {
String mail=prop.getProperty("mail");
return mail;}
/*byte[] encodeBytes=Base64.getEncoder().encode(mail.getBytes());
if (mail != null)

return new String(encodeBytes);
else
	throw new RuntimeException("username not found");
}
*/
public String getPassword() {
String password=prop.getProperty("password");
/*byte[] encodeBytes1=Base64.getEncoder().encode(password.getBytes());
if(password != null)
	return new String(encodeBytes1);
else throw new RuntimeException("password not found");*/
return password;

}
}