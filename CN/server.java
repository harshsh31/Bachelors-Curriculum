/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author DJSCE.Student
 */
public class server {
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner(System.in);
        ServerSocket ss=new ServerSocket(4451);
        Socket s=ss.accept();
        String a="",str1="",str="";
        DataInputStream d=new DataInputStream(s.getInputStream());
        DataOutputStream d1 = new DataOutputStream(s.getOutputStream());
        do
        {
        str=d.readUTF();
        System.out.println("Server recieved: "+str);
        System.out.println("Enter string:");
        str1=sc.nextLine();
        d1.writeUTF(str1);
         }while(!str.contains("bye"));
        d1.close();
        d.close();
        ss.close();
    }
    
}
