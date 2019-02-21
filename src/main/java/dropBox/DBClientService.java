package dropBox;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.ListFolderErrorException;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.users.FullAccount;

public class DBClientService {
	/*App key
	o0mo32olahy81c7
	App secret
	dqsltinq118p0ka*/
    private static final String token = "pg0aUInzQ7AAAAAAAAAAvbQZX4_ZpEHduyd6ZXzkoz9wSUFhlshXQtYRjOWyYNyo";
    public DbxClientV2 client;
    public FullAccount account ;
    public ListFolderResult result ;
    public void listFolder(String foldername) throws Exception {
        
      try {

        URL url = new URL("https://www.dropbox.com/home/amdocs");
        //https://www.dropbox.com/home/amdocs
        //https://api.dropboxapi.com/2/files/list_folder
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        String parameters = "{\"path\": \"" + foldername + "\",\"recursive\": false,\"include_media_info\": false,\"include_deleted\": false,\"include_has_explicit_shared_members\": false}";
        
        conn.setRequestProperty("Accept", "application/json");        
        conn.addRequestProperty ("Authorization", token);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        
        conn.setDoOutput(true);

        DataOutputStream writer = new DataOutputStream(conn.getOutputStream());
        writer.writeBytes(parameters);
        writer.flush();

        if (writer != null)
            writer.close();
        
        if (conn.getResponseCode() != 200) {
            System.out.println(conn.getResponseMessage());
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
            (conn.getInputStream())));

        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }

        conn.disconnect();

      } catch (MalformedURLException e) {

        e.printStackTrace();

      } catch (IOException e) {

        e.printStackTrace();

      }

    }
    
    public void delete(String path) throws Exception {
        
          try {

            URL url = new URL("https://api.dropboxapi.com/2/files/delete_v2");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            String parameters = "{\"path\": \"" + path + "\"}";
            
            conn.setRequestProperty("Accept", "application/json");        
            conn.addRequestProperty ("Authorization", token);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            
            conn.setDoOutput(true);

            DataOutputStream writer = new DataOutputStream(conn.getOutputStream());
            writer.writeBytes(parameters);
            writer.flush();

            if (writer != null)
                writer.close();
            
            if (conn.getResponseCode() != 200) {
                System.out.println(conn.getResponseMessage());
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

          } catch (MalformedURLException e) {

            e.printStackTrace();

          } catch (IOException e) {

            e.printStackTrace();

          }

        }
    
    public void createFolder(String path) throws Exception {
        
          try {

            URL url = new URL("https://api.dropboxapi.com/2/files/create_folder");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            String parameters = "{\"path\": \"" + path + "\"}";
            
            conn.setRequestProperty("Content-Type", "application/json");    
            conn.addRequestProperty ("Authorization", token);
            conn.setRequestMethod("POST");
            
            
            conn.setDoOutput(true);

            DataOutputStream writer = new DataOutputStream(conn.getOutputStream());
            writer.writeBytes(parameters);
            writer.flush();

            if (writer != null)
                writer.close();
            
            if (conn.getResponseCode() != 200) {
                System.out.println(conn.getResponseMessage());
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

          } catch (MalformedURLException e) {

            e.printStackTrace();

          } catch (IOException e) {

            e.printStackTrace();

          }

        }
    
    public void putFile(String foldername, String path) throws Exception {
        
          try {

            URL url = new URL("https://content.dropboxapi.com/2/files/upload");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            String parameters = "{\"path\": \"" + foldername + "\"}";
            
            conn.setRequestProperty("Content-Type", "application/octet-stream");    
            conn.addRequestProperty ("Authorization", token);
            conn.addRequestProperty ("Dropbox-API-Arg", parameters);
            conn.setRequestMethod("POST");
            
            
            conn.setDoOutput(true);

            Path pathFile = Paths.get(path);
            byte[] data = Files.readAllBytes(pathFile);

            DataOutputStream writer = new DataOutputStream(conn.getOutputStream());
            /*
            writer.writeBytes(parameters);
            writer.flush();
            */
            writer.write(data);
            writer.flush();
            
            if (writer != null)
                writer.close();
                        
            if (conn.getResponseCode() != 200) {
                System.out.println(conn.getResponseMessage());
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

          } catch (MalformedURLException e) {

            e.printStackTrace();

          } catch (IOException e) {

            e.printStackTrace();

          }

        }
    
    public void getFile(String foldername) throws Exception {
        
          try {

            URL url = new URL("https://content.dropboxapi.com/2/files/download");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            String parameters = "{\"path\": \"" + foldername + "\"}";
            
            conn.addRequestProperty ("Authorization", token);
            conn.addRequestProperty ("Dropbox-API-Arg", parameters);
            conn.setDoOutput(true);
                                    
            if (conn.getResponseCode() != 200) {
                System.out.println(conn.getResponseMessage());
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

          } catch (MalformedURLException e) {

            e.printStackTrace();

          } catch (IOException e) {

            e.printStackTrace();

          }

        }
    public DBClientService(){
    	  DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
	          client = new DbxClientV2(config, token);
	          System.out.println("DBClientService");
	          try {
				account = client.users().getCurrentAccount();
			} catch (DbxApiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DbxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	          try {
				result = client.files().listFolder("");
			} catch (ListFolderErrorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DbxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    public void redFile(Metadata metadata) {
    	  System.out.println(result.getEntries().size()+"shoo haath    "+metadata.getPathLower());
          String my_link = null;
          URL my_url = null;
          URLConnection conn = null;
          BufferedReader reader = null;
          try {
          	String line="";
              my_link = client.files().getTemporaryLink(metadata.getPathLower()).getLink();
              my_url = new URL (my_link);
              conn = my_url.openConnection();
              reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
             
              while( (line = reader.readLine()) != null ) {
              	System.out.println("read!!    "+line);
              }
          } catch (DbxException e) {
              e.printStackTrace();
          } catch (MalformedURLException e) {
              e.printStackTrace();
          } catch (IOException e) {
              e.printStackTrace();
          }
    }
   /* public static void main(String[] args) throws Exception {
        DBClientService dbcs = new DBClientService();
        String folderName = "/test_createFolder" + System.currentTimeMillis();
        String newFolderName = folderName + "/NewFolder";
        dbcs.createFolder(folderName);
        dbcs.listFolder("");        
        //dbcs.delete(folderName);
       // dbcs.putFile("/test_createFolder/skills.txt", "C:/Users/IBM_ADMIN/Desktop/skills.txt");
        dbcs.getFile("/test_createFolder/skills.txt");
    }*/

}