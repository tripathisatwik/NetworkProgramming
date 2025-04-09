package chapter7;

import java.io.*;
import java.net.*;

public class SingleFileServer {
    private byte[] content;
    private byte[] header;
    private int port = 80;

    public SingleFileServer(String data, String encoding, String MIMEType, int port) throws UnsupportedEncodingException {
        this(data.getBytes(encoding), encoding, MIMEType, port);
    }

    public SingleFileServer(byte[] data, String encoding, String MIMEType, int port) throws UnsupportedEncodingException {
        this.content = data;
        this.port = port;
        String header = "HTTP/1.0 200 OK\r\n" + "Server: OneFile 1.0\r\n" + "Content-length: " + this.content.length + "\r\n"
                + "Content-type: " + MIMEType + "\r\n\r\n";
        this.header = header.getBytes("ASCII");
    }

    public void run() {
        try {
            ServerSocket server = new ServerSocket(this.port);
            System.out.println("Accepting connecting on port " + server.getLocalPort());
            System.out.println("Data to be sent: ");
            System.out.write(this.content);
            while (true) {
                Socket connection = null;
                try {
                    connection = server.accept();
                    OutputStream out = new BufferedOutputStream(connection.getOutputStream());
                    InputStream in = new BufferedInputStream(connection.getInputStream());
                    // Read the first line only as its all we need
                    StringBuffer request = new StringBuffer(80);
                    while (true) {
                        int c = in.read();
                        if (c == '\r' || c == '\n' || c == -1)
                            break;
                        request.append((char) c);
                    }
                    // If this is HTTP 1.0 or later send a MIME header
                    if (request.toString().indexOf("HTTP/") != -1) {
                        out.write(this.header);
                    }
                    out.write(this.content);
                    out.flush();
                } catch (IOException e) {
                } finally {
                    if (connection != null)
                        connection.close();
                }
            }
        } catch (IOException e) {
            System.err.println("Could not start server. Port Occupied");
        }
    }

    public static void main(String[] args) {
        try {
            String contentType = "text/plain";
            if (args[0].endsWith(".html") || args[0].endsWith(".htm")) {
                contentType = "text/html";
            }
            InputStream in = new FileInputStream(args[0]);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int b;
            while ((b = in.read()) != -1)
                out.write(b);
            byte[] data = out.toByteArray();
            // set the poet to listen on
            int port;

            try {
                port = Integer.parseInt(args[1]);
                if (port < 1 || port > 65535)
                    port = 80;
            } catch (Exception e) {
                port = 80;
            }

            String encoding = "ASCII";
            if (args.length >= 3)
                encoding = args[2];
            SingleFileServer serverInstance = new SingleFileServer(data, encoding, contentType, port);
            Thread t = new Thread(serverInstance::run);
            t.start();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Usage: java SingleFileHTTPServer filename port encoding");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}