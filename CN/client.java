/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author DJSCE.Student
 */
public class client {
    public static void main(String args[]) throws IOException
    {
        Socket s= new Socket("localhost",4451);
        Scanner sc=new Scanner(System.in);
        String str="",a="";
        DataOutputStream d = new DataOutputStream(s.getOutputStream());
        DataInputStream d1=new DataInputStream(s.getInputStream());
        do
        {
       
        System.out.println("Enter string:");
        str=sc.nextLine();
        d.writeUTF(str);
        String str1=d1.readUTF();
        System.out.println("Server sent: "+str1);
        }while(!str.contains("bye"));
        
   
        d.close();
        s.close();
    }
}
