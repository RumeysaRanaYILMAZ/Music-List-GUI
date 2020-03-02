/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje.pkg2.çalışma;

/**
 *
 * @author Rana
 */
public class dugum implements Comparable<dugum> {
    public DVD dvd;
    public dugum next;//sonraki
    public dugum prev;//önceki
    
    
    public dugum(dugum prev,DVD dvd,dugum next)
    {
     this.dvd=dvd;
     this.next=next;
     this.prev=prev;
    
    }
    public dugum()
    {
     dvd=null;
     next=null;
     prev=null;
    
    }
    public void listele()
    {
        System.out.println(dvd +" ");
    }

    @Override
    public int compareTo(dugum o) {
        if(this.dvd.ad.compareToIgnoreCase(o.dvd.ad)>0)
        {
         return 1;//isimden dolayı nexte ekle
        }
        else if(this.dvd.ad.compareToIgnoreCase(o.dvd.ad)==0)
        {
            if(this.dvd.soyad.compareToIgnoreCase(o.dvd.soyad)>0)
            {
               return 1;// isim aynı soyisimden dolayı nexte ekle
            }
            else if (this.dvd.soyad.compareToIgnoreCase(o.dvd.soyad)==0)
            {
             
                if(this.dvd.tarih>o.dvd.tarih){
                   return 1;//ad, soyad aynı tarihden dolayı nexte ekle
                  }
                else if(this.dvd.tarih==o.dvd.tarih)
                {
                   return 0;// ad,soyad,tarih aynı preve ekle
                }
                else{
                   return -1;//ad,soyadı aynı tarihden dolayı dur.
                }
            }
            else
            {
               return -1;//ad aynı soyadından dolayı dur
            }
         
        }
        else{
         return -1 ;// adından dolayı dur
        }
    }
    @Override
    public String toString()
    {
      return dvd.toString();
    }
}
