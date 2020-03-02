/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje.pkg2.çalışma;

import java.util.ArrayList;

/**
 *
 * @author Rana
 */
public class DVD {
    String ad,soyad,albüm;
    int tarih,fiyat;
    ArrayList<String> sarkilar=new ArrayList<String>();
    
  
    public DVD()
    {
      ad="İsim yok";
      albüm="isim yok";
      soyad="Soyisim yok";
      fiyat=0;
      tarih=0;
       ArrayList<String> sarkilar=new ArrayList<String>();
      
      
    }
    public DVD(String ad,String soyad,String albüm,int tarih,int fiyat,ArrayList<String> sarkilar)
    {
      this.ad=ad;
      this.sarkilar=sarkilar;
      this.tarih=tarih;
      this.soyad=soyad;
      this.albüm=albüm;
      this.fiyat=fiyat;
    }
    @Override
    public String toString()
    {
        String music="";
     for (int i=0;i<sarkilar.size();i++)
     {
        music +="   "+(i+1)+"-  "+sarkilar.get(i)+"\n";//Sarkilari listeli bir biçimde göstermek içindir
     }
         
        
        return "Şarkıcının adı, soyadı : "+ad+"  "+soyad+
               "\n Albümün Adı :  "+albüm+"    Albümün Çıkış Tarihi : "+tarih+" Albümün Fiyatı : "+fiyat+
               "\n Albümde ki şarkılar :\n"+music;
             
    }
      
            
    
}
