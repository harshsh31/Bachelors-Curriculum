
package cn;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


 class cn73 {
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of frames");
        int n=sc.nextInt();
        String a[]=new String[n];
        boolean received[]=new boolean[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter "+(i+1)+" frame data");
            a[i]=sc.next();
            received[i]=false;
        }
        for(int i=0;i<n;)
        {
            System.out.println("Enter Reciever state for data "+(i%2)+":\n1]Data recieved properly\n2]Data Lost\n3]Acknowledgement lost\n4]Data error");
            int k=sc.nextInt();
            System.out.println("Sending data "+(i%2)+" from sender\t\ti.e. "+a[i]);
            for(int l=0;l<10;l++)
            {
                System.out.print("...  ");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(cn73.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println();
            switch(k)
            {
                case 1:
                    if(received[i]==false)
                    {
                        System.out.println("Data received at reciever end3"
                                + " now sending acknowledgement");
                        received[i]=true;
                    }
                    else
                    {
                        System.out.println("Data Already Received so this is copy data and now sending acknowledgement again for "+(i%2));
                    }
                    for(int l=0;l<10;l++)
                        {
                            System.out.print("...  ");
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(cn73.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    System.out.println();
                    System.out.println("Acknowledgement" + (i%2) + "Received");
                    i++;
                    break;
                case 2:System.out.println("Data lost, resend data");
                    break;
                case 3:System.out.println("Data received at reciever end now sending acknowledgement");
                    for(int l=0;l<10;l++)
                        {
                            System.out.print("...  ");
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(cn73.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    received[i]=true;
                    System.out.println("\nAcknowledgement"+(i%2)+" lost");
                    break;
                case 4:
                if(!received[i])
                { 
                    System.out.println("received data: ");
                    String r_string=sc.next();
                    if(r_string.equalsIgnoreCase(a[i]))
                    {
                         System.out.println("Data received at reciever end now sending acknowledgement");
                         received[i]=true;
                         i++;
                         for(int l=0;l<10;l++)
                            {
                                System.out.print("...  ");
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(cn73.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        System.out.println();
                        System.out.println("Acknowledgement "+ (i%2) + " Received");
                    }
                    else
                    {
                        System.out.println("Incorrect data sent resend again");
                    }
                   
                }
                else
                {
                    System.out.println("Data already received it cant have error");
                }
                break;
                default:
                    System.out.println("Invalid input please input reciever state again");
            }
        }
    }
    
}
