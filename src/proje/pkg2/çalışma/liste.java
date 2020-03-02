/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje.pkg2.çalışma;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import static proje.pkg2.çalışma.Proje2Çalışma.bagli;

/**
 *
 * @author Rana
 */
public class liste {
    public dugum head;
    public dugum tail;
    
    
    public liste()
    {
     head=null;
     tail=null;
    }
    public void add(DVD d)
    {
      if (head==null){
          
       head=new dugum(null,d,null);
       tail=head;
         // System.out.println("if e girdi");
      }
      else{
           dugum temp=head;
           dugum n=new dugum(null,d,null);
           while(temp!=null)
           {
               int c=n.compareTo(temp);
               
               if(c==1)
               {
                if (temp.next!=null)
                {
                temp=temp.next;}
                else{break;}
               }
               else{break;}
                        
           
           }
           if(temp==tail)//son eleman olacak demektir.
           {
               
             n=new dugum(temp,d,null);
             temp.next=n;
             
             tail=n;
           }
           else if(temp.prev==null)//ilk eleman olacak demektir.
           {
           
             n=new dugum(null,d,temp);
             temp.prev=n;
             head=n;
           }
           else{
           n=new dugum(temp.prev,d,temp);
           temp.prev.next=n;
           temp.prev=n;
           
           
           
           }
           
          }
          
      }
      
      
              
        
    
    public boolean delete(String ad,String soyad,String albüm)//silineni döndürür
    {
               dugum temp=head;
        
		while (!(temp.dvd.ad.contains(ad) && temp.dvd.soyad.contains(soyad) && temp.dvd.albüm.contains(albüm))) // Eşleşme bulana kadar
		{
		        
                        temp=temp.next; // Döngü sürekli bir sonrakine aktarılıyor
			if (temp == null){
                             
				return false;
                            
                        } // eşleşme yok
		}
                if (temp == head){ 
			head = temp.next;
                }
                else{
				
			temp.prev.next = temp.next;
                        
                        
                }

		if (temp == tail){ 
			tail = temp.prev;}
		else {
			
			temp.next.prev = temp.prev;
                }
    
                return true;
    
    }
    public DVD DvdGörüntüle(String ad,String soyad,String albüm)
    {
      dugum temp=head;
        
		while (!(temp.dvd.ad.contains(ad) && temp.dvd.soyad.contains(soyad) && temp.dvd.albüm.contains(albüm))) // Eşleşme bulana kadar
		{
		        
                        temp=temp.next; // Döngü sürekli bir sonrakine aktarılıyor
			if (temp == null){
                             
				return null;
                            
                        } // eşleşme yok
		}
                return temp.dvd;
    }
    public void listele()
    {
        dugum temp=head;
        while(temp!=null)
        {
            System.out.println(temp);
            temp=temp.next;
        
        }
    
    
    }
    public String EnvanteriAl()
    {
       dugum temp=head;
       String a="";
        while(temp!=null)
        {
            a+=temp.dvd.ad+" "+temp.dvd.soyad+","+temp.dvd.albüm+","+temp.dvd.tarih+".";
            temp=temp.next;
        
        }
       return a;
    }
    public DVD DvdMaker(String dvdic)
    {
     DVD yenidvd=new DVD();
          StringTokenizer vbölücü=new StringTokenizer(dvdic,",");
          int ts=1;//token sayacı
          while(vbölücü.hasMoreTokens())
          {
              if(ts==1)
              {
               StringTokenizer bbölücü=new StringTokenizer(vbölücü.nextToken());
               yenidvd.ad=bbölücü.nextToken();
               yenidvd.soyad=bbölücü.nextToken();
              }
              else if(ts==2) 
              {
               yenidvd.albüm=vbölücü.nextToken();
              }
              else if(ts==3)
              {
                  String a=vbölücü.nextToken().replaceAll(" ","");
                  yenidvd.tarih=Integer.parseInt(a);
               
              }
              else if(ts==4)
              {
                  String a=vbölücü.nextToken().replaceAll(" ","");
                  yenidvd.fiyat=Integer.parseInt(a);
                  
               
              }
              else{
                  String a=vbölücü.nextToken();
                  yenidvd.sarkilar.add(a);
                
              }
            
              ts++;
          }
          return yenidvd;
    
    }
   public void DosyayaDvdEkle(String dvdic) throws IOException
   {
     FileWriter fw=null;
     BufferedWriter bw=null;
     DVD yenidvd=this.DvdMaker(dvdic);
     
         try {
             fw=new FileWriter("envanter.txt",true);
             bw=new BufferedWriter(fw);
             
             
                    String dosyaici="",sarki="";
                    for(int i=0;i<yenidvd.sarkilar.size();i++)
                    {
                        if(i==(yenidvd.sarkilar.size()-1))
                        {sarki+=yenidvd.sarkilar.get(i);}
                        else{sarki+=yenidvd.sarkilar.get(i)+",";}
                    }
                    dosyaici+=yenidvd.ad+" "+yenidvd.soyad+","+yenidvd.albüm+","+yenidvd.tarih+","+yenidvd.fiyat+","+sarki;
                    
                    bw.newLine();
                    bw.write(dosyaici);
                    
             
             
             
         } catch (IOException ex) {
             System.out.println("Dosyaya Yazılamadı!");
         }
         bw.close();
   }
   public void clean(){
     head=null;
   }
    public void Start() throws FileNotFoundException
    {
       this.clean();
       String dosyadaki="";
        Scanner fileIn=new Scanner(new FileInputStream("envanter.txt")); 
        while(fileIn.hasNext())
        {
            dosyadaki+=" "+fileIn.next();
           
        }
       StringTokenizer nbölücü=new StringTokenizer(dosyadaki,".");
       
        
       while(nbölücü.hasMoreTokens())
       {
          String dvdic=nbölücü.nextToken();
          
          DVD yenidvd=this.DvdMaker(dvdic);
          
          bagli.add(yenidvd);
        
       }//while sonu
    
    }
    public void DosyayaYaz()
    {
     FileWriter fw=null;
     BufferedWriter bw=null;
     
     
         try {
             fw=new FileWriter("keke.txt");
             bw=new BufferedWriter(fw);
             
             dugum temp=head;
             
             while(temp!=null)
             {      
                    String dosyaici="",sarki="";
                    for(int i=0;i<temp.dvd.sarkilar.size();i++)
                    {
                        sarki+=temp.dvd.sarkilar.get(i)+",";
                    }
                    dosyaici+=temp.dvd.ad+" "+temp.dvd.soyad+","+temp.dvd.albüm+","+temp.dvd.tarih+","+temp.dvd.fiyat+","+sarki+".";
                    
                    temp=temp.next;
                    bw.write(dosyaici);
                    bw.newLine();
             }
        
             bw.close();
             
         } catch (IOException ex) {
             System.out.println("Dosyaya Yazılamadı!");
         }
     
     
    
    
    }
}
/*int nextsay=0;
          dugum n=new dugum(null,d,null);
          dugum temp=head;//döngüde tüm nodeleri dönüp  node n için uygun yeri bulana kadar dönmesi için.ilk node muzu geçiçi (temp ) bir değişkene atıyoruz.
          while(temp!=null)
          {
              
              int c=n.compareTo(temp);
              if(c==1)//nexte ekler
              {     
                   if(temp.next==null)
                   {
                    n=new dugum(temp,d,null);
                    temp.next=n;
                    tail=n;
                    System.out.println("ifsdf e girdi");
                    
                       
                   }
                   else{
                    n=new dugum(temp,d,temp.next);
                    temp.next.prev=n;
                    temp.next=n;
                    nextsay++;
                    System.out.println("ifg e girdi");
                   } 
                    
              }
              else if(c==0)
              {
               break;
              }     
              else//preve ekler
              { 
                   if(temp.prev==null)
                   {
                     n=new dugum(null,d,temp);
                     temp.prev=n;
                     head=n;
                     System.out.println("ifh e girdi");
                     break;
                    
                   }
               
                   
                   else{
                    n=new dugum(temp.prev,d,temp);
                    temp.prev.next=n;
                    temp.prev=n;
                    System.out.println("ifj e girdi");
                    break;
                   
                   }
              
              }
              
             
               temp=temp.next;*/