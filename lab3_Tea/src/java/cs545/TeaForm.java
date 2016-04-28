/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs545;

import java.io.IOException;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

/**
 *
 * @author 984881
 */
@Named("form")
@SessionScoped
public class TeaForm implements Serializable{

       //private static TeaType[] teaItems = {
     
          TeaType empty = new TeaType("Select to change...");  
          TeaType ut = new TeaType("Unfermented Tea");
          TeaType ht = new TeaType("Half-fermented Tea");
          TeaType ft = new TeaType("Full-fermented Tea");
          TeaType pt = new TeaType("Post-fermented Tea");
          TeaType st = new TeaType("Scented Tea");
        
    private  TeaType[] teaTypes = {
        empty,ut,ht,ft,pt,st
    };
    
    private TeaType recommenedType;

    public TeaType getRecommenedType() {
        return recommenedType;
    }

    public  TeaForm() {
       teaInit();
    }

    
    
    public TeaType[] getTeaTypes() {
        return teaTypes;
    }

    public void setTeaTypes(TeaType[] teaTypes) {
        this.teaTypes = teaTypes;
    }
     
     public void teaInit() {
        ut.addTea(new Tea("Longjing",200,"sometimes called by its literal translated name Dragon Well tea, is a variety of pan-roasted green tea from the area of Longjing Village near Hangzhou in Zhejiang Province, China. It is produced mostly by hand and renowned for its high quality, earning it the China Famous Tea title."));
        ut.addTea(new Tea("Biluochun",200,"Its original name is Xia Sha Ren Xiang (simplified Chinese: 吓煞人香; traditional Chinese: 嚇煞人香; pinyin: xiàshàrénxiāng; \"scary fragrance\"). Legend tells of its discovery by a tea picker who ran out of space in her basket and put the tea between her breasts instead. The tea, warmed by her body heat, emitted a strong aroma that surprised the girl."));
        ut.addTea(new Tea("White Hair Silver Needle",350," white tea produced in Fujian Province in China.[1] Amongst white teas, this is the most expensive variety and the most prized, as only top buds (leaf shoots) are used to produce the tea."));
        ut.addTea(new Tea("White Peony Tea",250,"a type of white tea made from plucks each with one leaf shoot and two immediate young leaves.[1] Bai Mudan is sometimes preferred by white tea drinkers for its fuller flavor and greater potency than the other major type of white tea, Bai Hao Yinzhen."));

        ht.addTea(new Tea("Da Hong Pao (Big Red Robe)",190," a Wuyi rock tea grown in the Wuyi Mountains. It is a heavily oxidized, dark oolong tea. According to legend, the mother of a Ming dynasty emperor was cured of an illness by a certain tea, and that emperor sent great red robes to clothe the four bushes from which that tea originated. "));
        ht.addTea(new Tea("Tieguanyin",290,"The tea is named after the Chinese Goddess of Mercy Guanyin,  \"Iron Goddess of Mercy\") is a premium variety of Chinese oolong tea originated in the 19th century in Anxi in Fujian province. Tieguanyin produced in different areas of Anxi have different gastronomic characteristics."));
        ht.addTea(new Tea("Dongfang Meiren (Oriental Beauty)",390,"This tea has natural fruity aromas and produces a sweet tasting bright-reddish orange tea liquor without some bitterness. Dried leaves of high quality should exhibit a pleasant aroma with leaf coloration of dark purple and brown tones with white hairs."));

        ft.addTea(new Tea("Keemun",90," Chinese black tea. First produced in late 19th century, it quickly became popular in the West and is still used for a number of classic blends. It is a light tea with characteristic stone fruit and slightly smoky notes in the aroma and a gentle, malty, non-astringent taste reminiscent of unsweetened cocoa. Top varieties have orchid-like fragrance and additional floral notes in the flavor."));
        ft.addTea(new Tea("Dianhong",60," The main difference between Dianhong and other Chinese black teas is the amount of fine leaf buds, or \"golden tips,\" present in the dried tea. Dianhong teas produces a brew that is brassy golden orange in colour with a sweet, gentle aroma and no astringency. Cheaper varieties of Dianhong produce a darker brownish brew that can be very bitter."));
        ft.addTea(new Tea("Yingdehong tea",50,"First produced mechanically in 1959. Much of the tea is exported. Some quality varieties are produced, which often look like leaf Oolong.\n" +"The tea should have a cocoa-like aroma and like most Chinese black teas a sweet aftertaste."));
        
        pt.addTea(new Tea("Lu'an Melon Seed tea",260,"also known as Lu'an Leaf, is a green tea from Lu'an City, Anhui Province, China. This is a famous green tea and is listed on virtually all lists of famous Chinese teas. The literal translation for Lu'an Guapian Tea is Lu'an Melon Seed Tea."));
        pt.addTea(new Tea("Pu-erh Tea",360," Fermentation in the context of tea production involves microbial fermentation and oxidation of the tea leaves, after they have been dried and rolled.[2] This process is a Chinese specialty and produces tea known as Hei Cha (黑茶), commonly translated as dark, or black tea (this type of tea is different from what in the West is known as \"black tea\", which in China is called \"red tea\" 红茶). The best known variety of this category of tea is Pu-erh from Yunnan Province, named after the trading post for dark tea during imperial China."));

        st.addTea(new Tea("Jasmine tea",460,"tea scented with aroma from jasmine blossoms to make a scented tea. Typically, jasmine tea has green tea as the tea base; however, white tea and black tea are also used. The resulting flavour of jasmine tea is subtly sweet and highly fragrant. It is the most famous scented tea in China."));

     }
     
     
     public TeaType findTea(String teaName)
     {
         for(int i=0;i<teaTypes.length;i++)
         {
             if(teaTypes[i].getName().equals(teaName))
                 return teaTypes[i];
         }
         return null;
     }
     
     public void valueChangeMethod(ValueChangeEvent event) throws IOException
     {
         //delete the empty one
         if(teaTypes[0].getTeas().isEmpty())
         {
            for(int i=1;i<teaTypes.length;i++)
                teaTypes[i-1] = teaTypes[i];
            teaTypes[teaTypes.length-1] = null;
         }
        TeaType cur = findTea((String)event.getNewValue());
        if(cur !=null)
        {
            recommenedType = cur;
            //return "shopping.xhtml";
             FacesContext.getCurrentInstance().getExternalContext().dispatch("shopping.xhtml");
        }
      //  return null;
     }
}
