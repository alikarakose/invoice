import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Invoice invoice =  new Invoice("Menate Link",
//                new InvoiceDataItem[]{
//                        new InvoiceDataItem("19.99", 1, "Weiterbildung T-Shirt rot"),
//                        new InvoiceDataItem("9.80", 6, "Weiterbildung Espressotasse schwaz")
//                });
        // Invoice invoice = new Invoice("Ali");
        Invoice invoice = new Invoice("Ali",new InvoiceDataItem[]{});
        invoice.addDataItem(new InvoiceDataItem("1.99", 10, "Weiterbildung Eis"));
        invoice.addDataItem(new InvoiceDataItem("1.99", 10, "Weiterbildung Eis"));


        System.out.println(invoice );
        System.out.println("Summe: " + invoice.getSumme());
//        ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(
//                new FileOutputStream("RechnungMenate.inv")));
//        out.writeObject(invoice);
//        out.close();
        //invoice.removeDataItem(1);
        invoice.removeDataItem(new InvoiceDataItem("1.99", 6, "Weiterbildung Eis"));
        invoice.prettyPrint(System.out);
        invoice.removeDataItem(new InvoiceDataItem("1.99", 16, "Weiterbildung Eis"));
        invoice.prettyPrint(System.out);
//        ObjectInputStream in = new ObjectInputStream(new
//                BufferedInputStream(new FileInputStream("RechnungMenate.inv")));
//        Invoice menate = (Invoice)in.readObject();
//        in.close();
//        menate.prettyPrint(System.out);
    }
}
