
/**
 Zeigt das Schreiben von von Objekten mittels Serialisierung.
 Mehr zum Thema Serialisierung und wie man es ganz einfach für eigene Klassen
 benutzen kann gibt es unter
 https://jaxenter.de/aus-der-java-trickkiste-java-serialisierung-wann-passt-sie-wann-nicht-35558
 oder
 https://www.javatpoint.com/serialization-in-java
 */

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Invoice implements Serializable {

    String empfaenger;
    private List<InvoiceDataItem> waren;

    public BigDecimal getSumme() {
        BigDecimal summe = new BigDecimal(0.0);
        for (InvoiceDataItem w:waren) {
            summe = summe.add(w.getPrice().multiply(new BigDecimal(w.getUnit())));
        }
        return summe;
    }

    public void addDataItem(InvoiceDataItem item) {
        int index = getIndexOfDesc(item.getDesc());
        if (index==-1) {
            waren.add(item);
        } else {
            assert waren.get(index).getPrice().equals(item.getPrice()) : "Preis ist nicht gleich";
            waren.get(index).setUnit(waren.get(index).getUnit()+item.getUnit());
        }
    }
    public void removeDataItem(int index) {
        waren.remove(index);
    }
    public void removeDataItem(InvoiceDataItem item) {
        int index = getIndexOfDesc(item.getDesc());
        if (index==-1) {
            return;
        }
        assert waren.get(index).getPrice().equals(item.getPrice()) : "Preis ist nicht gleich";
        if (waren.get(index).getUnit()>item.getUnit()) {
            waren.get(index).setUnit(waren.get(index).getUnit()-item.getUnit());
        } else {
            waren.remove(index);
        }
    }

    public int getIndexOfDesc(String desc) {
        for (InvoiceDataItem w : waren) {
            if (desc.compareTo(w.getDesc())==0) {
                return waren.indexOf(w);
            }
        }
        return -1;
    }
    public int getIndexOfDescFast(String desc) {
        for (int i = 0; i<waren.size();i++) {
            InvoiceDataItem w = waren.get(i);
            if (desc.compareTo(w.getDesc())==0) {
                return i;
            };
        }
        return -1;
    }
    public Invoice (String empfaenger) {
        this.empfaenger = empfaenger;
        waren = new ArrayList<>();
    }
    public Invoice (String empfaenger, InvoiceDataItem[] waren) {
        this.empfaenger = empfaenger;
        // ausführlich:
        //        this.waren = new ArrayList<>();
        //        this.waren.addAll(List.of(waren));
        // kurz:
        //        this.waren = new ArrayList<>(List.of(waren));
        // sicher:
        this.waren = new ArrayList<>();
        for (InvoiceDataItem w:waren) {
            addDataItem(w);
        }
    }

    public void prettyPrint(PrintStream out) {
        out.println(empfaenger);
        for (InvoiceDataItem w : waren) {
            out.format("%s %.2f %d %.2f%n", w.getDesc(), w.getPrice(), w.getUnit(), w.getPrice().multiply(new BigDecimal(w.getUnit())));
        }
        out.format("Zu zahlender Betrag: %.2f%n", getSumme());
    }
    @Override
    public String toString() {
        return "Invoice{" +
                "empfaenger='" + empfaenger + '\'' +
                ", waren=" + waren +
                ", summe=" + getSumme() +
                '}';
    }
}
