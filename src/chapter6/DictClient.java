// English to latin translator
package chapter6;

import java.io.*;
import java.net.*;

public class DictClient {
    public static final String SERVER = "dict.org";
    public static final int PORT = 2628;
    public static final int TIMEOUT = 15000;
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket(SERVER,PORT);
            socket.setSoTimeout(TIMEOUT);
            OutputStream out = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(out, "UTF-8");
            writer = new BufferedWriter(writer);
            InputStream in = socket.getInputStream();
            BufferedReader reader  = new BufferedReader(
                new InputStreamReader(in,"UTF-8"));
            for(String word: args){
                define(word, writer,reader);
            }
            writer.write("quit\r\n");
            writer.flush();
        } catch (IOException e) {
            System.err.println(e);
        }finally{
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    //ignore
                }
            }
        }
    }

}
