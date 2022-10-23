/**
  Zeigt das Schreiben von von Objekten mittels Serialisierung.
  Mehr zum Thema Serialisierung und wie man es ganz einfach für eigene Klassen
  benutzen kann gibt es unter
  https://jaxenter.de/aus-der-java-trickkiste-java-serialisierung-wann-passt-sie-wann-nicht-35558
  oder 
  https://www.javatpoint.com/serialization-in-java
*/

import java.math.BigDecimal;
import java.io.Serializable;  

public class InvoiceDataItem implements Serializable {
    private BigDecimal price;
    private int unit;
    private String desc;
    
    public InvoiceDataItem (BigDecimal price, int unit, String desc) {
        this.price = price;
        this.unit = unit;
        this.desc = desc;
    }
    public InvoiceDataItem (String price, int unit, String desc) {
        this.price = new BigDecimal(price);
        this.unit = unit;
        this.desc = desc;
    }
    public BigDecimal getPrice () {
        return price;
    }
    public int getUnit () {
        return unit;
    }
    public void setUnit(int unit) {
        if (unit>0) {
            this.unit = unit;
        }
    }
    public String getDesc () {
        return desc;
    }
    
    public String toString () {
        return price + ";" + unit + ";" + desc;
    }
}
